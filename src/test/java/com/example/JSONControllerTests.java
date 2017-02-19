package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by stephaniepaigeogburn on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(JSONController.class)

public class JSONControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void stringTest() throws Exception {
        String json = ("{\"first_name\": \"Nina\", \"last_name\": \"Totenburg\"}");

        MockHttpServletRequestBuilder request = post ("/json/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Nina Totenburg"));
    }

    @Test
    public void builderTest() throws Exception {

        JsonObject person = new JsonObject();                       // 1

        person.addProperty("first_name", "Tamara");
        person.addProperty("last_name", "Keith");  // 2

        Gson builder = new GsonBuilder().create();                  // 3

        String jsonString = builder.toJson(person);                 // 4

        MockHttpServletRequestBuilder request = post("/json/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);                               // 5

        this.mvc.perform(request).andExpect(status().isOk());

    }

    @Test
    public void fileFixtureTest() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/json/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Nina Totenburg"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}
