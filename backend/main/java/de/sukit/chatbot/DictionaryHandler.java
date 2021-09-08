/* Copyright (C) 2021  SUK-IT
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package de.sukit.chatbot;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * DictionaryHandler reads the <code>data/dictionary.json</code>-file into a String,String HashMap.
 * @author Griefed
 */
@Component
public class DictionaryHandler {

    private static final Logger LOG = LogManager.getLogger(DictionaryHandler.class);

    private final File DIRECTORY_WATCH = new File("./data");
    private final File FILE_DICTIONARY = new File("./data/dictionary.json");

    private HashMap<String, String> dictionary;
    private List<DictionaryModel> dictionaryModelList;

    /**
     * Constructor for our Dictionary-class. This makes a call to {@link #setDictionary()}, thus ensuring we have a hashmap
     * of our dictionary available immediately after class-instantiation.
     * @author Griefed
     */
    @Autowired
    public DictionaryHandler() {
        setDictionary();
        setDictionaryList();
    }

    /**
     * Getter for the dictionary-file.
     * @author Griefed
     * @return File. Returns the dictionary-file.
     */
    public File getFILE_DICTIONARY() {
        return FILE_DICTIONARY;
    }

    /**
     * Getter for the directory which the FileWatcher is supposed to monitor.
     * @author Griefed
     * @return File. Returns the directory which the FileWatcher is supposed to watch.
     */
    public File getDIRECTORY_WATCH() {
        return DIRECTORY_WATCH;
    }

    /**
     * Getter for the object-mapper used for working with JSON-data.
     * @author Griefed
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
     * @author Griefed
     * @param file The file to read into the byte array.
     * @return JsonNode. Returns the JsonNode of the passed manifest-file.
     * @throws IOException Throws an exception when the passed file could not be found/read/parsed etc.
     */
    private JsonNode getJson(File file) throws IOException {
        byte[] jsonData = Files.readAllBytes(file.toPath());
        return getObjectMapper().readTree(jsonData);
    }

    /**
     * Sets the dictionary-hashmap for this class by reading the <code>data/dictionary.json</code>-file into a JsonNode.
     * Iterates through each JsonNode and writes the values of <code>keyword</code> and <code>response</code> into a new
     * key-value-pair in the dictionary-hashmap. Said hashmap is then available via {@link #getDictionary()}.
     * @author Griefed
     */
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

    /**
     * Creates a list of {@link DictionaryModel} with priority, keyword and response for each object in the dictionary.
     * @author Griefed
     */
    public void setDictionaryList() {

        dictionaryModelList = new ArrayList<>();

        try {

            JsonNode dictionaryJson = getJson(getFILE_DICTIONARY());

            JsonNode keywords = dictionaryJson.get("keywords");

            for (JsonNode pair : keywords) {
                if (pair.get("priority").asInt() == 1) {
                    dictionaryModelList.add(new DictionaryModel(pair.get("priority").asInt(), pair.get("keyword").asText(), pair.get("response").asText()));
                }
            }
            for (JsonNode pair : keywords) {
                if (pair.get("priority").asInt() == 2) {
                    dictionaryModelList.add(new DictionaryModel(pair.get("priority").asInt(), pair.get("keyword").asText(), pair.get("response").asText()));
                }
            }
            for (JsonNode pair : keywords) {
                if (pair.get("priority").asInt() == 3) {
                    dictionaryModelList.add(new DictionaryModel(pair.get("priority").asInt(), pair.get("keyword").asText(), pair.get("response").asText()));
                }
            }

        } catch (NullPointerException | IOException ex) {
            LOG.error("Error reading json.", ex);
        }
    }

    /**
     * Getter for the {@link DictionaryModel} list.
     * @author Griefed
     * @return List DictionaryMode. Returns the list containing our dictionary.
     */
    public List<DictionaryModel> getDictionaryList() {
        return dictionaryModelList;
    }

    /**
     * Getter for the dictionary used for keyword-recognition.
     * @author Griefed
     * @return HashMap String, String. Returns the dictionary used for keyword-recognition.
     */
    public HashMap<String, String> getDictionary() {
        return dictionary;
    }
}
