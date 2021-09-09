package de.sukit.chatbot;

/**
 * Represents an entry in the dictionary list. Each entry in the dictionary-list contains one of:<br>
 * {@link #priority}<br>
 * {@link #keyword}<br>
 * {@link #response}<br>
 * which will then be able by iterating through the list and using either<br>
 * {@link #getPriority()}<br>
 * {@link #getKeyword()} and<br>
 * {@link #getResponse()}
 * @author Griefed
 */
public class DictionaryModel {

    /**
     * Constructor. In order to create a new entry in the dictionary list, you need to pass the priority as int, keyword
     * as string and reponse as string.
     * @author Griefed
     * @param priority Int. The priority of the dictionary keyword/response.
     * @param keyword String. The keyword for the response.
     * @param response String. The response.
     */
    public DictionaryModel(int priority, String keyword, String response) {
        setPriority(priority);
        setKeyword(keyword);
        setResponse(response);
    }

    private int priority;
    private String keyword;
    private String response;

    /**
     * Getter for the priority of the keyword/response-pair.
     * @author Griefed
     * @return Int. Returns the priority of the keyword/response-pair.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Setter for the priority of the keyword/response-pair.
     * @author Griefed
     * @param priority Int. The priority of the keyword/response-pair. Must be 1, 2 or 3.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Getter for the keyword of the keyword/response-pair.
     * @author Griefed
     * @return String. Returns the keyword of the keyword/response-pair.
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Setter for the keyword of the keyword/response-pair.
     * @author Griefed
     * @param keyword String. The keyword in the keyword/response-pair.
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Getter for the response of the keyword/response-pair.
     * @author Griefed
     * @return String. Returns the response of the keyword/response-pair.
     */
    public String getResponse() {
        return response;
    }

    /**
     * Setter for the response of the keyword/response-pair.
     * @author Griefed
     * @param response String. The reponse in the keyword/response-pair.
     */
    public void setResponse(String response) {
        this.response = response;
    }
}
