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
package de.sukit.chatbot.rest.handlers;

import de.sukit.chatbot.DictionaryHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ResponseHandler handles the input from our frontend and returns a response based on the input from the frontend.
 * @author Griefed
 */
@Component
public class ResponseHandler {

    private static final Logger LOG = LogManager.getLogger(ResponseHandler.class);

    private final DictionaryHandler DICTIONARYHANDLER;

    /**
     * Constructor for the ResponseHandler which makes an instance of {@link DictionaryHandler} available to us, so we
     * have access to our dictionary-hashmap.
     * @author Griefed
     * @param injectedDictionaryHandler Instance of {@link DictionaryHandler}.
     */
    @Autowired
    public ResponseHandler(DictionaryHandler injectedDictionaryHandler) {
        this.DICTIONARYHANDLER = injectedDictionaryHandler;
    }

    /**
     * Get a response based on the input recieved from the user-input in the frontend.
     * @author Griefed
     * @param input String. The input recieved from the user-input in the frontend.
     * @return String. Returns the response matching the input to the dictionary. If no match is found <code>No match found!</code>
     * is returned.
     */
    public String getReponse(String input) {

        for (String keyword : DICTIONARYHANDLER.getDictionary().keySet()) {
            if (input.contains(keyword)) {

                LOG.info("Match found for " + keyword);
                return DICTIONARYHANDLER.getDictionary().get(keyword);
            }
        }
        return "No match found!";
    }
}
