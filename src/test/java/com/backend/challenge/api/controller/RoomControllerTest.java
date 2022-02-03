package com.backend.challenge.api.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.backend.challenge.api.RoomController;
import com.backend.challenge.service.RoomService;
import com.backend.challenge.util.FileTestUtil;
import com.backend.challenge.util.RoomTestMockUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RoomController.class)
public class RoomControllerTest {
	
	private static final String ENDPOINT = "/api/v1/room";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RoomService roomService;
	
	@Test
	public void givenBuildingCode_whenGetAvailableRooms_thenReturnResourceOk() throws Exception {
        String jsonExpected = FileTestUtil.readFile("/json/findAvailableRooms.json");
		String buildingCode = "B2023";
		
        given(roomService.getAvailableRooms(buildingCode))
        	.willReturn(RoomTestMockUtil.getAvailableRoomsResourceMock());

		mockMvc.perform(get(ENDPOINT)
				.param("buildingCode", buildingCode)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonExpected))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenNoBuildingCode_thenReturnResourceOk() throws Exception {
		String jsonExpected = FileTestUtil.readFile("/json/findAvailableRooms.json");
		String buildingCode = null;
		
		given(roomService.getAvailableRooms(buildingCode))
    		.willReturn(RoomTestMockUtil.getAvailableRoomsResourceMock());
		
		mockMvc.perform(get(ENDPOINT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonExpected))
				.andExpect(status().isOk());
	}
	
}
