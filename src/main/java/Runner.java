import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import handlers.BaseHandler;
import handlers.HandlerFactory;
import utils.PropertiesUtils;
import utils.TreeUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Runner {

    private static final String SOURCE_DIR_KEY = "SOURCE_DIR";
    private static final String OUTPUT_DIR_KEY = "OUTPUT_DIR";

    public static void main(String[] args) throws IOException{

        Properties prop = PropertiesUtils.getProperties();
        String sourceDir = prop.getProperty(SOURCE_DIR_KEY);
        String outDir = prop.getProperty(OUTPUT_DIR_KEY);
        List<String> files = DirectoryScanner.scan(sourceDir);

        for(String file : files) {
            System.out.println(file);
            String javaContent = readFile(file);
            CompilationUnit compilationUnit;
            try {
                compilationUnit = StaticJavaParser.parse(javaContent);
            } catch(Exception e){
                e.printStackTrace();
                continue;
            }
            List<Node> roots = compilationUnit.getChildNodes();
            for(Node root : roots) {
                List<Node> methodDeclarations = TreeUtils.extractNodes(root, MethodDeclaration.class);
                for(Node dec : methodDeclarations) {
                    String method_name = ((MethodDeclaration) dec).getName().getIdentifier();

                    if (method_name.startsWith("set") || method_name.startsWith("get") || method_name.startsWith("is")) {
                        continue;
                    }

                    BaseHandler handler = HandlerFactory.getHandler(dec);
                    if (handler != null) {
                        List<String> tokens = new ArrayList<>(handler.handle(dec));

                        int start = file.lastIndexOf("\\");
                        int end = file.lastIndexOf(".");
                        String file_name = file.substring(start + 1, end);

                        FileWriter fw = new FileWriter(outDir + file_name + "-" + method_name + ".token");
                        for (String token : tokens) {
                            fw.write(token);
                            fw.write("\n");
                        }
                        fw.close();

                    } else {
                        System.err.println("Unknown node type");
                        System.exit(-1);
                    }
                }
            }
        }
    }

    private static String readFile(String filename) throws IOException {
        InputStream is = new FileInputStream(filename);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            if(!line.startsWith("import") && !line.startsWith("package")) {
                sb.append(line).append("\n");
            }
            line = buf.readLine();
        }

        return sb.toString();
    }
}