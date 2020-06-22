package net.ziyoung.lox.symbol;

import net.ziyoung.lox.type.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

public class GlobalSymbolTableTests {

    @Test
    @DisplayName("test primitive types in GlobalSymbolTable")
    void registerPrimitiveTypes() {
        Map<String, Integer> map = Map.of(
                "bool", 1,
                "int", 1,
                "long", 2,
                "float", 1,
                "double", 2,
                "string", 1);

        GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable();
        Set<Map.Entry<String, Type>> entrySet = globalSymbolTable.getTypeMap().entrySet();
        Assertions.assertEquals(entrySet.size(), map.size());

        entrySet.forEach(stringTypeEntry -> {
            String key = stringTypeEntry.getKey();
            int slotSize = stringTypeEntry.getValue().getSlotSize();
            Assertions.assertTrue(map.containsKey(key));
            Assertions.assertEquals(slotSize, map.get(key));
        });
    }
}
