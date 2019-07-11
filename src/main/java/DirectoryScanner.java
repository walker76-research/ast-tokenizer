import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class DirectoryScanner {
    static List<String> scan(String dir){
        String directory = new File(dir).getAbsolutePath();
        Path start = Paths.get(directory);
        int maxDepth = 15;
        List<String> fileNames = new ArrayList<>();
        try {
            fileNames = Files.find(start, maxDepth,
                    (path, attr) ->
                            String.valueOf(path).toLowerCase().endsWith(".java"))
                    .sorted()
                    .map(String::valueOf)
                    .filter((path) -> {
                        return (String.valueOf(path).toLowerCase().endsWith(".java"));
                    })
                    .collect(Collectors.toList());
        } catch(Exception e){
            e.printStackTrace();
        }
        return fileNames;
    }
}
