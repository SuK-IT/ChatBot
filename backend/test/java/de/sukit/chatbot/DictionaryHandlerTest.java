package de.sukit.chatbot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DictionaryHandlerTest {

    private final DictionaryHandler DICTIONARYHANDLER;

    DictionaryHandlerTest() {
        try {
            Files.createDirectories(Paths.get("./data"));
        } catch (IOException ignored) {}
        Main.createFile(new File("dictionary.json"), new File ("./data"));
        this.DICTIONARYHANDLER = new DictionaryHandler();
    }

    @Test
    void dictionaryTest() {
        Assertions.assertNotNull(DICTIONARYHANDLER.getDictionary());
        Assertions.assertEquals("1 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort0"));
        Assertions.assertEquals("2 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort1"));
        Assertions.assertEquals("3 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort2"));
        Assertions.assertEquals("4 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort3"));
        Assertions.assertEquals("5 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort4"));
        Assertions.assertEquals("6 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort5"));
        Assertions.assertEquals("7 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort6"));
        Assertions.assertEquals("8 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort7"));
        Assertions.assertEquals("9 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort8"));
        Assertions.assertEquals("10 - Hallo Welt!", DICTIONARYHANDLER.getDictionary().get("wort9"));
    }

    @Test
    void objectMapperTest() {
        Assertions.assertNotNull(DICTIONARYHANDLER.getObjectMapper());
    }

    @Test
    void dictionaryFileTest() {
        Assertions.assertNotNull(DICTIONARYHANDLER.getFILE_DICTIONARY());
        Assertions.assertEquals(new File("./data/dictionary.json"), DICTIONARYHANDLER.getFILE_DICTIONARY());
    }
}
