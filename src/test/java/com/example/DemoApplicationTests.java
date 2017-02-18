package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

	@Test
	public void nameTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/cats?name=Cuddles&breed=Siamese");
		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void hashTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dogs?name=Maggie&breed=Collie");
		this.mvc.perform(request).andExpect(status().isOk())
		.andExpect(content().string("{name=Maggie, breed=Collie}"));
	}

	@Test
	public void objTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/shows?name=Veep&genre=Comedy");
		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void articleTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/articles/32/topic/politics");
		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void flowersTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/flowers/rose/red/12");
		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void candyTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/candy/gummiworms/assorted/2");
		this.mvc.perform(request).andExpect(status().isOk())
		.andExpect(content().string("Candy type is gummiworms; flavor is assorted; quantity is 2"));
	}

	@Test
	public void booksTest() throws Exception {

		MockHttpServletRequestBuilder request1 = post("/books")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title", "Harry Potter and the Prisoner of Azkaban")
				.param("author", "J.K. Rowling");

		this.mvc.perform(request1)
				.andExpect(status().isOk())
				.andExpect(content().string("title=Harry+Potter+and+the+Prisoner+of+Azkaban&author=J.K.+Rowling"));
	}

	@Test
	public void cookiesMapTest() throws Exception {

		MockHttpServletRequestBuilder request1 = post("/cookies")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("type", "chocolate-chip")
				.param("quantity", "3");

		this.mvc.perform(request1)
				.andExpect(status().isOk())
				.andExpect(content().string("{type=chocolate-chip, quantity=3}"));
	}

	@Test
	public void tomatoesObjTest() throws Exception {

		MockHttpServletRequestBuilder request1 = post("/tomatoes")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("variety", "Early Girl")
				.param("isHeirloom", "false");

		this.mvc.perform(request1)
				.andExpect(status().isOk())
				.andExpect(content().string("Variety is Early Girl; Heirloom is false"));
	}

}
