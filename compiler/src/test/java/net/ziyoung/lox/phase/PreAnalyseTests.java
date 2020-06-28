package net.ziyoung.lox.phase;

import net.ziyoung.lox.ast.CompilationUnit;
import net.ziyoung.lox.compiler.Compiler;
import net.ziyoung.lox.phase.context.AnalyseContext;
import net.ziyoung.lox.semantic.SemanticErrorList;
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
        Compiler compiler = new Compiler("src/test/resources/pre-analyse-parameter.lox");
        CompilationUnit compilationUnit = Assertions.assertDoesNotThrow(compiler::parse);
        GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable();
        SemanticErrorList semanticErrorList = new SemanticErrorList();
        AnalyseContext analyseContext = new AnalyseContext(globalSymbolTable, semanticErrorList);
        PreAnalyse preAnalyse = new PreAnalyse(analyseContext);
        preAnalyse.visitCompilationUnit(compilationUnit);

        String[] names = new String[]{
                "X", "Y", "Z", // fun main
                "i", "j" // fun dup
        };
        List<String> errorList = semanticErrorList.stream().collect(Collectors.toList());
        Assertions.assertEquals(names.length, errorList.size());

        for (ListIterator<String> iterator = errorList.listIterator(); iterator.hasNext(); ) {
            String error = iterator.next();
            String msg;
            if (iterator.previousIndex() >= 3) {
                msg = String.format("Duplicated parameter '%s'", names[iterator.previousIndex()]);
            } else {
                msg = String.format("Unknown type '%s'", names[iterator.previousIndex()]);
            }
            Assertions.assertTrue(error.contains(msg));
        }
    }
}
