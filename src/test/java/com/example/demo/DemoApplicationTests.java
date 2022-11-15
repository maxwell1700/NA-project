package com.example.demo;

import com.example.demo.controller.CSVFileController;
import com.example.demo.model.CSVREADWRITE;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;


@WebMvcTest (controllers = CSVFileController.class)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@MockBean
	private CSVFileService csvFileService;
	@Autowired
	private MockMvc mockMvc;
	CSVREADWRITE csv1 = new CSVREADWRITE(001, "test1","leeds", "this is a test", "34567890-ygbi45yu90p");
	CSVREADWRITE csv2 = new CSVREADWRITE(002, "test2","leeds", "this is also a test", "34567890-ygbi45yu90p");
	CSVREADWRITE csv3 = new CSVREADWRITE(003, "test3","leeds", "this is another test", "34567890-ygbi45yu90p");


	@Test
	@DisplayName("Should list all csv records when making GET request to endpoint - /csv/files")
	public void shouldListAllRecords() throws Exception{


		Mockito.when(csvFileService.getAllRecords()).thenReturn(Arrays.asList(csv1,csv2,csv3));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/csvrecords"))
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].filename",Matchers.is("test3")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].id",Matchers.is(003)));
	}


	@Test
	@DisplayName("Should update/save record when making POST request to endpoint - /api/csvrecords/{id}")
	public void shouldUpdateRecordById() throws Exception{
		CSVREADWRITE updatedCsv = CSVREADWRITE.builder().id(001).filename("test1").origin("Manchester").metadata("this is a test").hash("34567890-ygbi45yu90p").build();

		Mockito.when(csvFileService.updateRecord(updatedCsv,001)).thenReturn(updatedCsv);

	}


}
