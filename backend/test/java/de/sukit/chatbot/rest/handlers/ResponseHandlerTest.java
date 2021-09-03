package de.sukit.chatbot.rest.handlers;

import de.sukit.chatbot.DictionaryHandler;
import de.sukit.chatbot.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ResponseHandlerTest {

    private final DictionaryHandler DICTIONARYHANDLER;
    private final ResponseHandler RESPONSEHANDLER;
    private final HashMap<String, String> DICTIONARY;

    ResponseHandlerTest() {
        try {
            Files.createDirectories(Paths.get("./data"));
        } catch (IOException ignored) {}
        Main.createFile(new File("dictionary.json"), new File ("./data"));
        this.DICTIONARYHANDLER = new DictionaryHandler();
        this.DICTIONARY = DICTIONARYHANDLER.getDictionary();
        this.RESPONSEHANDLER = new ResponseHandler(DICTIONARYHANDLER);
    }

    @Test
    void responseTest() {
        Assertions.assertEquals(DICTIONARY.get("wort0"), RESPONSEHANDLER.getReponse("wort0"));
        Assertions.assertEquals(DICTIONARY.get("wort1"), RESPONSEHANDLER.getReponse("wort1"));
        Assertions.assertEquals(DICTIONARY.get("wort2"), RESPONSEHANDLER.getReponse("wort2"));
        Assertions.assertEquals(DICTIONARY.get("wort3"), RESPONSEHANDLER.getReponse("wort3"));
        Assertions.assertEquals(DICTIONARY.get("wort4"), RESPONSEHANDLER.getReponse("wort4"));
        Assertions.assertEquals(DICTIONARY.get("wort5"), RESPONSEHANDLER.getReponse("wort5"));
        Assertions.assertEquals(DICTIONARY.get("wort6"), RESPONSEHANDLER.getReponse("wort6"));
        Assertions.assertEquals(DICTIONARY.get("wort7"), RESPONSEHANDLER.getReponse("wort7"));
        Assertions.assertEquals(DICTIONARY.get("wort8"), RESPONSEHANDLER.getReponse("wort8"));
        Assertions.assertEquals(DICTIONARY.get("wort9"), RESPONSEHANDLER.getReponse("wort9"));
        Assertions.assertEquals("1 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort0"));
        Assertions.assertEquals("2 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort1"));
        Assertions.assertEquals("3 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort2"));
        Assertions.assertEquals("4 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort3"));
        Assertions.assertEquals("5 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort4"));
        Assertions.assertEquals("6 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort5"));
        Assertions.assertEquals("7 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort6"));
        Assertions.assertEquals("8 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort7"));
        Assertions.assertEquals("9 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort8"));
        Assertions.assertEquals("10 - Hallo Welt!", RESPONSEHANDLER.getReponse("wort9"));
        Assertions.assertEquals("No match found!", RESPONSEHANDLER.getReponse("890uta4m3cgva3zn849"));
    }

}