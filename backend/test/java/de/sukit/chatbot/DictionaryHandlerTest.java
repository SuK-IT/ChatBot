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

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class DictionaryHandlerTest {

    private final DictionaryHandler DICTIONARYHANDLER;

    DictionaryHandlerTest() {
        try {
            FileUtils.copyFile(new File("backend/test/resources/dictionary.json"),new File("./data/dictionary.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
