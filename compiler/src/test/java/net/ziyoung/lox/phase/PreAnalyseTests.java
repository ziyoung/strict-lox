package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.compiler.Compiler;
import net.ziyoung.lox.symbol.GlobalSymbolTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class PreAnalyseTests {

    @Test
    @DisplayName("check parameters")
    void checkParameters() {
        Compiler compiler = new Compiler("src/test/resources/unknown-type.lox");
        CompilationUnit compilationUnit = Assertions.assertDoesNotThrow(compiler::parse);
        System.out.println(compilationUnit);
        GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable();
        SemanticErrorList semanticErrorList = new SemanticErrorList();
        PreAnalyse preAnalyse = new PreAnalyse(globalSymbolTable, semanticErrorList);
        preAnalyse.visitCompilationUnit(compilationUnit);

        String[] unknownTypes = new String[]{"X", "Y", "Z"};
        List<String> errorList = semanticErrorList.stream().collect(Collectors.toList());
        Assertions.assertEquals(unknownTypes.length, errorList.size());

        for (ListIterator<String> iterator = errorList.listIterator(); iterator.hasNext(); ) {
            String error = iterator.next();
            String msg = String.format("Unknown type '%s'", unknownTypes[iterator.previousIndex()]);
            Assertions.assertTrue(error.contains(msg));
        }
    }
}
