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
package de.sukit.chatbot.rest.controllers;

import de.sukit.chatbot.DictionaryHandler;
import de.sukit.chatbot.FileWatcher;
import de.sukit.chatbot.rest.handlers.ResponseHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RestController for responses from the dictionary based on the user-input recieved from the frontend.
 * @author Griefed
 */
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/talk")
public class ResponseController {

    private static final Logger LOG = LogManager.getLogger(ResponseController.class);

    private final ResponseHandler RESPONSEHANDLER;
    private final DictionaryHandler DICTIONARYHANDLER;
    private final FileWatcher FILEWATCHER;

    /**
     * Constructor for our RestController. Ensures our dictionary is always up-to-date and filewatchers are present.
     * @author Griefed
     * @param injectedResponseHandler Instance of {@link ResponseHandler}.
     * @param injectedDictionaryHandler Instance of {@link DictionaryHandler}.
     * @param injectedFileWatcher Instance of {@link FileWatcher}:
     */
    @Autowired
    public ResponseController(ResponseHandler injectedResponseHandler, DictionaryHandler injectedDictionaryHandler, FileWatcher injectedFileWatcher) {
        this.RESPONSEHANDLER = injectedResponseHandler;
        this.DICTIONARYHANDLER = injectedDictionaryHandler;
        this.FILEWATCHER = injectedFileWatcher;
    }

    /**
     * Getter the response from the dictionary based on the user-input recieved from the frontend.
     * @author Griefed
     * @param input User-input recieved from the frontend.
     * @return String. Returns the response from the dictionary based on the user-input recieved from the frontend.
     */
    @CrossOrigin(origins = {"*"})
    @GetMapping("/getResponse") // /api/talk/getResponse?input=wort0
    public String getResponse(@RequestParam(value = "input", defaultValue = "hello") String input) {
        LOG.info("Requested " + input);
        return RESPONSEHANDLER.getReponse(input);
    }

    /**
     * Alternative to {@link #getResponse(String)}. Returns the reponse as json.
     * @author Griefed
     * @param input User-input recieved from the frontend.
     * @return String. Returns the response from the dictionary based on the user-input recieved from the frontend.
     */
    @CrossOrigin(origins = {"*"})
    @GetMapping("/get") // /api/talk/get?input=wort0
    public String get(@RequestParam(value = "input", defaultValue = "hello") String input) {
        LOG.info("Requested " + input);
        return "{\"response\":\"" + RESPONSEHANDLER.getReponse(input) + "\"}";
    }

    /**
     * Alternative to {@link #getResponse(String)}. Returns the input and response as json.
     * @author Griefed
     * @param input User-input recieved from the frontend.
     * @return String. Returns the response from the dictionary based on the user-input recieved from the frontend as well
     * as the input.
     */
    @CrossOrigin(origins = {"*"})
    @GetMapping("/talk") // /api/talk/talk?input=wort0
    public String talk(@RequestParam(value = "input", defaultValue = "hello") String input) {
        LOG.info("Requested " + input);
        return "{\"keyword\":\"" + input.replace("%20"," ") + "\",\"response\":\"" + RESPONSEHANDLER.getReponse(input) + "\"}";
    }

}
