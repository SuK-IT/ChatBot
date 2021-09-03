package de.sukit.chatbot;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * The FileWatcher class creates a FileWatcher which solely monitors the <code>data</code>-directory in which our
 * <code>dictionary.json</code>-file resides in. The purpose of said filewatcher is to reload the dictionary should any
 * changes to said dictionary be detected, thus allowing additions or removals to/from the dictionary at runtime.
 * @author Griefed
 */
public class FileWatcher {

    private static final Logger LOG = LogManager.getLogger(FileWatcher.class);

    private final DictionaryHandler DICTIONARYHANDLER;

    private final File DIRECTORY_WATCH = new File("./data");
    private final File FILE_DICTIONARY = new File("./data/dictionary.json");

    /**
     * Constructor for the FileWatcher class. Used for dependency injection, should we ever need it.
     * @author Griefed
     */
    public FileWatcher(DictionaryHandler injectedDictionaryHandler) {
        if (injectedDictionaryHandler == null) {
            this.DICTIONARYHANDLER = new DictionaryHandler();
        } else {
            this.DICTIONARYHANDLER = injectedDictionaryHandler;
        }
        listener();
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
     * Setup our FileAlterationObserver.
     * @author Griefed
     */
    public void listener() {

        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(getDIRECTORY_WATCH());

        fileAlterationObserver.addListener(new FileAlterationListener() {
            @Override
            public void onStart(FileAlterationObserver observer) {
            }

            @Override
            public void onDirectoryCreate(File directory) {

            }

            @Override
            public void onDirectoryChange(File directory) {

            }

            @Override
            public void onDirectoryDelete(File directory) {

            }

            @Override
            public void onFileCreate(File file) {

            }

            @Override
            public void onFileChange(File file) {
                LOG.info("Dictionary changed!");
                DICTIONARYHANDLER.setDictionary();

                DICTIONARYHANDLER.getDictionary().entrySet().stream().
                        forEach(
                                input ->
                                        LOG.info(input.getKey() + " : " + input.getValue()));
            }

            @Override
            public void onFileDelete(File file) {

            }

            @Override
            public void onStop(FileAlterationObserver observer) {

            }
        });

        FileAlterationMonitor monitor = new FileAlterationMonitor(5000);
        monitor.addObserver(fileAlterationObserver);

        try {
            monitor.start();
        } catch (Exception ex) {
            LOG.error("Error starting the FileWatcher Monitor.", ex);
        }

    }

}
