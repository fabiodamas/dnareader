package br.com.fabio.dnareader.resource;

import java.net.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DnaResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveriaDevolver200CasoJsonEstejaCorreto() throws Exception {
		URI uri = new URI("/api/simian");
		// String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
    String json = "{ \"dna\": [ \"FABIO\", \"HENRIQUE\", \"TTATGT\", \"AGAAGG\", \"CCCCTA\", \"GGGGGG\" ]}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}  
}
