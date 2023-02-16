package com.mbdev.gitstats;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GithubTaskApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetRepositoryDetails() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/repositories/{owner}/{repositoryName}", "master7dok", "SpringBank")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.full_name").value("master7dok/SpringBank"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Application Bank witch use Spring, Hibernate, Postgres. It can add users, add bills for them, make transfer between them, make payment, make deposit"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.fork").value(false))
				.andExpect(MockMvcResultMatchers.jsonPath("$.forks_count").value(0))
				.andExpect(MockMvcResultMatchers.jsonPath("$.clone_url").value("https://github.com/master7dok/SpringBank.git"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.created_at").value("2023-02-07T19:48:45Z"))
				.andDo(MockMvcResultHandlers.print());
	}

}
