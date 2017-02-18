package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void putTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.put("/put");
		this.mvc.perform(request).andExpect(status().isOk());
	}


	@Test
	public void deleteTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.delete("/delete");
		this.mvc.perform(request).andExpect(status().isOk());
	}

}
