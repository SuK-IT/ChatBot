package de.sukit.chatbot;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

public class DictionaryHandler {

    private static final Logger LOG = LogManager.getLogger(DictionaryHandler.class);

    private final File DIRECTORY_WATCH = new File("./data");
    private final File FILE_DICTIONARY = new File("./data/dictionary.json");

    private HashMap<String, String> dictionary;

    public DictionaryHandler() {
        setDictionary();
    }

    /**
     * Getter for the dictionary-file.
     * @author DHengstmann
     * @return File. Returns the dictionary-file.
     */
    public File getFILE_DICTIONARY() {
        return FILE_DICTIONARY;
    }

    /**
     * Getter for the directory which the FileWatcher is supposed to monitor.
     * @author DHengstmann
     * @return File. Returns the directory which the FileWatcher is supposed to watch.
     */
    public File getDIRECTORY_WATCH() {
        return DIRECTORY_WATCH;
    }

    /**
     * Getter for the object-mapper used for working with JSON-data.
     * @author DHengstmann
     * @return ObjectMapper. Returns the object-mapper used for working with JSON-data.
     */
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return objectMapper;
    }

    /**
     * Helper method.<br>
     * Reads the passed manifest-file into a byte array and returns a JsonNode containing said byte array.
     * @author DHengstmann
     * @param file The file to read into the byte array.
     * @return JsonNode. Returns the JsonNode of the passed manifest-file.
     * @throws IOException Throws an exception when the passed file could not be found/read/parsed etc.
     */
    private JsonNode getJson(File file) throws IOException {
        byte[] jsonData = Files.readAllBytes(file.toPath());
        return getObjectMapper().readTree(jsonData);
    }

    public void setDictionary() {

        HashMap<String, String> dic = new HashMap<>();

        try {

            JsonNode dictionaryJson = getJson(getFILE_DICTIONARY());

            JsonNode keywords = dictionaryJson.get("keywords");

            for (JsonNode pair : keywords) {
                dic.put(pair.get("keyword").asText(), pair.get("response").asText());
            }

        } catch (NullPointerException | IOException ex) {
            LOG.error("Error reading json.", ex);
        }

        this.dictionary = dic;
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }
}