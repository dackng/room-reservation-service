package com.backend.challenge.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.backend.challenge.api.ReservationController;
import com.backend.challenge.api.resource.ReservationRequest;
import com.backend.challenge.service.ReservationService;
import com.backend.challenge.util.FileTestUtil;
import com.backend.challenge.util.ReservationTestMockUtil;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ReservationController.class)
public class ReservationControllerTest {
	
	private static final String ENDPOINT = "/api/v1/reservation";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReservationService reservationService;
	
    private ObjectMapper objectMapper;
    
    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
    }
	
	@Test
	public void givenReservationRequest_whenCreateReservation_thenReturnReservationCreated() throws Exception {
		ReservationRequest request = ReservationTestMockUtil.getReservationRequestMock();
		String jsonExpected = FileTestUtil.readFile("/json/createdReservationResource.json");

        given(reservationService.create(any(ReservationRequest.class)))
        	.willReturn(ReservationTestMockUtil.getReservationCreatedResourceMock());

		mockMvc.perform(post(ENDPOINT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated())
				.andExpect(content().json(jsonExpected));
	}

	@Test
	public void givenDate_whenGetReservations_thenReturnResourceOk() throws Exception {
		String jsonExpected = FileTestUtil.readFile("/json/findReservations.json");
		LocalDate date = LocalDate.of(2022, 2, 2);
		
        given(reservationService.getReservations(date))
        	.willReturn(ReservationTestMockUtil.getReservationsResourceMock());
		
		mockMvc.perform(get(ENDPOINT)
				.param("date", date.toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonExpected))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenNoDate_thenReturnBadRequest() throws Exception {
		String date = "";
		String jsonExpected = FileTestUtil.readFile("/json/findReservations.json");
       
		mockMvc.perform(get(ENDPOINT)
				.param("date", date)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonExpected))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message", Matchers.is("A general error has ocurred")));
	}
}
