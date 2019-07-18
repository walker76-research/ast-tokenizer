package handlers;

import com.github.javaparser.ast.Node;
import handlers.comment.BlockCommentHandler;
import handlers.comment.LineCommentHandler;
import handlers.declaration.*;
import handlers.expr.*;
import handlers.literal.*;
import handlers.misc.ArrayCreationLevelHandler;
import handlers.misc.CatchClauseHandler;
import handlers.misc.ModifierHandler;
import handlers.misc.SwitchEntryHandler;
import handlers.name.NameHandler;
import handlers.name.SimpleNameHandler;
import handlers.parameter.ParameterHandler;
import handlers.parameter.TypeParameterHandler;
import handlers.stmt.*;
import handlers.type.ArrayTypeHandler;
import handlers.type.ClassOrInterfaceTypeHandler;
import handlers.type.PrimitiveTypeHandler;
import handlers.type.VoidTypeHandler;

public class HandlerFactory {
    public static BaseHandler getHandler(Node n){
        switch (n.getClass().getSimpleName()){
            case "ClassOrInterfaceDeclaration": return new ClassOrInterfaceDeclarationHandler();
            case "MarkerAnnotationExpr": return new MarkerAnnotationExprHandler();
            case "Modifier": return new ModifierHandler();
            case "SimpleName": return new SimpleNameHandler();
            case "FieldDeclaration": return new FieldDeclarationHandler();
            case "ConstructorDeclaration": return new ConstructorDeclarationHandler();
            case "Name": return new NameHandler();
            case "VariableDeclarator": return new VariableDeclaratorHandler();
            case "ClassOrInterfaceType": return new ClassOrInterfaceTypeHandler();
            case "Parameter": return new ParameterHandler();
            case "BlockStmt": return new BlockStmtHandler();
            case "ExpressionStmt": return new ExpressionStmtHandler();
            case "AssignExpr": return new AssignExprHandler();
            case "FieldAccessExpr": return new FieldAccessExprHandler();
            case "NameExpr": return new NameExprHandler();
            case "ThisExpr": return new ThisExprHandler();
            case "ObjectCreationExpr": return new ObjectCreationExprHandler();
            case "MethodCallExpr": return new MethodCallExprHandler();
            case "EnumDeclaration": return new EnumDeclarationHandler();
            case "EnumConstantDeclaration": return new EnumConstantDeclarationHandler();
            case "IntegerLiteralExpr": return new IntegerLiteralExprHandler();
            case "PrimitiveType": return new PrimitiveTypeHandler();
            case "BooleanLiteralExpr": return new BooleanLiteralExprHandler();
            case "MethodDeclaration": return new MethodDeclarationHandler();
            case "VariableDeclarationExpr": return new VariableDeclarationExprHandler();
            case "CharLiteralExpr": return new CharLiteralExprHandler();
            case "ReturnStmt": return new ReturnStmtHandler();
            case "ConditionalExpr": return new ConditionalExprHandler();
            case "EnclosedExpr": return new EnclosedExprHandler();
            case "BinaryExpr": return new BinaryExprHandler();
            case "VoidType": return new VoidTypeHandler();
            case "NullLiteralExpr": return new NullLiteralExprHandler();
            case "NormalAnnotationExpr": return new NormalAnnotationExprHandler();
            case "StringLiteralExpr": return new StringLiteralExprHandler();
            case "IfStmt": return new IfStmtHandler();
            case "LineComment": return new LineCommentHandler();
            case "TypeParameter": return new TypeParameterHandler();
            case "UnaryExpr": return new UnaryExprHandler();
            case "ForEachStmt": return new ForEachStmtHandler();
            case "TryStmt": return new TryStmtHandler();
            case "CatchClause": return new CatchClauseHandler();
            case "ThrowStmt": return new ThrowStmtHandler();
            case "ArrayType": return new ArrayTypeHandler();
            case "DoubleLiteralExpr": return new DoubleLiteralExprHandler();
            case "WhileStmt": return new WhileStmtHandler();
            case "ArrayCreationExpr": return new ArrayCreationExprHandler();
            case "ArrayCreationLevel": return new ArrayCreationLevelHandler();
            case "ArrayAccessExpr": return new ArrayAccessExprHandler();
            case "ForStmt": return new ForStmtHandler();
            case "CastExpr": return new CastExprHandler();
            case "SwitchStmt": return new SwitchStmtHandler();
            case "SwitchEntry": return new SwitchEntryHandler();
            case "BreakStmt": return new BreakStmtHandler();
            case "ArrayInitializerExpr": return new ArrayInitializerExprHandler();
            case "InstanceOfExpr": return new InstanceOfExprHandler();
            case "DoStmt": return new DoStmtHandler();
            case "ClassExpr": return new ClassExprHandler();
            case "SynchronizedStmt": return new SynchronizedStmtHandler();
            case "SuperExpr": return new SuperExprHandler();
            case "EmptyStmt": return new EmptyStmtHandler();
            case "SingleMemberAnnotationExpr": return new SingleMemberAnnotationExprHandler();
            case "ContinueStmt": return new ContinueStmtHandler();
            case "AssertStmt": return new AssertStmtHandler();
            case "LongLiteralExpr": return new LongLiteralExprHandler();
            case "LabeledStmt": return new LabeledStmtHandler();
            case "InitializerDeclaration": return new InitializerDeclarationHandler();
            case "LocalClassDeclarationStmt": return new LocalClassDeclarationStmtHandler();
            case "ExplicitConstructorInvocationStmt": return new ExplicitConstructorInvocationStmtHandler();
            case "BlockComment": return new BlockCommentHandler();
            default:
                System.err.println(n.getClass().getSimpleName());
                System.exit(-1);
        }

        return null;
    }
}
