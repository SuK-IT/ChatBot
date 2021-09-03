package de.sukit.chatbot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Main class used for setting up default files and ensuring our dictionary is loaded and monitored by a filewatcher.
 * @author Griefed
 */
public class Main {

    private static final Logger LOG = LogManager.getLogger(ChatBotApplication.class);

    /**
     * Setup default-files. Load the default dictionary. Start filewatcher for dictionary. Start Spring Application.
     * @author Griefed
     * @param args String Array. Arguments with which the application was executed.
     */
    public static void main(String[] args) {
        try {
            Files.createDirectories(Paths.get("./data"));
        } catch (IOException ex) {
            LOG.error("Couldn't create data-directory.", ex);
        }

        createFile(new File("log4j2.xml"), new File ("."));
        createFile(new File("dictionary.json"), new File ("./data"));

        DictionaryHandler DICTIONARYHANDLER = new DictionaryHandler();
        FileWatcher FILEWATCHER = new FileWatcher(DICTIONARYHANDLER);

        ChatBotApplication.main(args);
    }

    /**
     * Copies the passed file from the resources inside the JAR-file to the passed directory.
     * @author Griefed
     * @param fileToCreate File. The file to create.
     * @param destination File/Directory. The directory in which the passed file is to be copied to.
     */
    private static void createFile(File fileToCreate, File destination) {
        if (!fileToCreate.exists()) {
            try {
                InputStream link = (ChatBotApplication.class.getResourceAsStream(String.format("/%s", fileToCreate.getName())));
                if (link != null) {
                    Files.copy(link, Paths.get(String.format("%s/%s", destination, fileToCreate)));
                    link.close();
                }
            } catch (IOException ex) {
                LOG.error("Error creating file: " + fileToCreate, ex);
            }
        }
    }
}
