package com.backend.challenge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backend.challenge.api.resource.ReservationCreatedResource;
import com.backend.challenge.api.resource.ReservationRequest;
import com.backend.challenge.entity.Reservation;
import com.backend.challenge.exception.RoomNotAvailableException;
import com.backend.challenge.repository.ReservationRepository;
import com.backend.challenge.repository.RoomRepository;
import com.backend.challenge.service.impl.ReservationServiceImpl;
import com.backend.challenge.util.AuditStatus;
import com.backend.challenge.util.ReservationTestMockUtil;
import com.backend.challenge.util.RoomStatus;
import com.backend.challenge.util.RoomTestMockUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReservationServiceTest {

	@MockBean
	private ReservationRepository reservationRepository;
	
	@MockBean
	private RoomRepository roomRepository;
	
	private ReservationService reservationService;
	
	private ReservationCreatedResource resourceExpected;
	
	@Before
    public void setup() {
		reservationService = new ReservationServiceImpl(reservationRepository, roomRepository);
		resourceExpected = ReservationTestMockUtil.getReservationCreatedResourceMock();
    }
	
	@Test
	public void givenReservation_whenCreateReservation_thenReturnReservationCreated() {
		ReservationRequest request = ReservationTestMockUtil.getReservationRequestMock();
		
		given(roomRepository.findRoom( eq(RoomStatus.AVAILABLE)
				, eq(request.getRoomCode()),eq(request.getHasMultimedia()), eq(AuditStatus.ACTIVE.getValue())))
			.willReturn(Optional.ofNullable(RoomTestMockUtil.getRoomMock()));

        given(reservationRepository.save(any(Reservation.class)))
        	.willReturn(ReservationTestMockUtil.getReservationMock());

		
        ReservationCreatedResource resource = reservationService.create(request);
		
        assertThat(resource).usingRecursiveComparison().ignoringFields("id").isEqualTo(resourceExpected);
	}
	
	@Test
	public void givenNoRoomAvailable_whenCreateReservation_thenReturnUnprocessableException() {
		ReservationRequest request = ReservationTestMockUtil.getReservationRequestMock();
		
		given(roomRepository.findRoom( eq(RoomStatus.AVAILABLE)
				, eq(request.getRoomCode()),eq(request.getHasMultimedia()), eq(AuditStatus.ACTIVE.getValue())))
			.willReturn(Optional.empty());

		assertThatThrownBy(() -> reservationService.create(request))
        	.isInstanceOf(RoomNotAvailableException.class).hasMessage("No room available");
	}
}
