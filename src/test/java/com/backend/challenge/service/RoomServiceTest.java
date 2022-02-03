package com.backend.challenge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.eq;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backend.challenge.api.resource.AvailableRoomResource;
import com.backend.challenge.repository.RoomRepository;
import com.backend.challenge.service.impl.RoomServiceImpl;
import com.backend.challenge.util.RoomStatus;
import com.backend.challenge.util.RoomTestMockUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoomServiceTest {

	@MockBean
	private RoomRepository roomRepository;
	
	
	private RoomService roomService;
	
	@Before
    public void setup() {
		roomService = new RoomServiceImpl(roomRepository);
    }
	
	@Test
	public void givenBuildingCode_whenGetAvailableRooms_thenReturnRooms() {
		List<AvailableRoomResource> roomsExpected = RoomTestMockUtil.getAvailableRoomsResourceMock();
		List<AvailableRoomResource> roomsResource;
		String buildingCode = "B1TEST";
		
		given(roomRepository.findAllAvailableRooms(eq(RoomStatus.AVAILABLE), eq(buildingCode)))
			.willReturn(RoomTestMockUtil.getAvailableRoomsMock());

		roomsResource = roomService.getAvailableRooms(buildingCode);
		
        assertThat(roomsResource).usingFieldByFieldElementComparator().isEqualTo(roomsExpected);

	}
}
