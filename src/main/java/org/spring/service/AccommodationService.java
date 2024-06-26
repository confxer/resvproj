package org.spring.service;

import java.util.List;

import org.spring.domain.AccommodationVO;
import org.spring.domain.Criteria;
import org.spring.domain.RoomVO;
import org.spring.mapper.AccommodationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AccommodationService {
	@Autowired
	private AccommodationMapper mapper;
	
	public int getAccommodationsCount(Criteria cri) {
		int count = mapper.getTotalCount(cri);
		System.out.println("total:"+count);
		return count;
	}
	
	public List<AccommodationVO> getAccommodations(Criteria cri){
		System.out.println("service"+cri);
		List<AccommodationVO> accommodations = mapper.getListWithPaging(cri);
		System.out.println("pageNum:"+accommodations);
		return accommodations;
	}

	public List<RoomVO> getRoomDetails(int no) {
		System.out.println("Service_accommodation_no"+no);
		List<RoomVO> room = mapper.getRoomDetails(no);
		return room;
	}

	public List<AccommodationVO> getAccommodationDetails(int no) {
		return mapper.getAccommodationDetails(no);
	}
}
