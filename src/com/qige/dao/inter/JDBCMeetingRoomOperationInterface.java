package com.qige.dao.inter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qige.entity.MeetingRoom;
import com.qige.entity.User;

public interface JDBCMeetingRoomOperationInterface {
	List<Map<String, Object>> findAllMeetingRoom();
	MeetingRoom findMeetingRoomById(int id);
	int insertReservation(User user,int mr_id,String reservedate,String reservetime);
	List<Map<String, Object>> findReservationsByUserId(int userId);
	int deleteReservationById(int id);
}
