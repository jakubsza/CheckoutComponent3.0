package integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import main.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class IntegrationTests {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void WrongUnitTest() throws Exception{
		this.mockMvc.perform(get("/checkout/c=a"))
	       .andExpect(status().is4xxClientError());

	}
	
	@Test
	public void MissingCheckoutTest() throws Exception{
		this.mockMvc.perform(get("/dnakjdhak"))
	       .andExpect(status().is4xxClientError());

	}
	@Test
	public void WrongItemNameTest() throws Exception{
		this.mockMvc.perform(get("/checkout/c=5"))
	       .andExpect(status().isOk())
	       .andExpect(content().string("Wrong item(s) name(s). You didn't receive bill."));

	}
	
}
