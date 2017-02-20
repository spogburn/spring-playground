package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by stephaniepaigeogburn on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(JSONRenderController.class)
public class JSONRenderTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void JsonRenderTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/data");
        this.mvc.perform(request).andExpect(status().isOk())
        .andExpect(content().string("{\"first_name\":\"Ari\",\"last_name\":\"Shapiro\"}"));
    }

    @Test
    public void JsonNestedTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/data/nested");
        this.mvc.perform(request).andExpect(status().isOk())
        .andExpect(content().string("{\"name\":\"All Things Considered\",\"hosts\":[{\"name\":\"Rachel Martin\",\"id\":1},{\"name\":\"Ari Shapiro\",\"id\":2}]}"));
    }
}
