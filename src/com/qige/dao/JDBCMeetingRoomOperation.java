package com.qige.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.qige.dao.inter.JDBCMeetingRoomOperationInterface;
import com.qige.entity.MeetingRoom;
import com.qige.entity.MeetingRoomRowMapper;
import com.qige.entity.Reservation;
import com.qige.entity.ReservationRowMapper;
import com.qige.entity.User;
import com.qige.entity.UserRowMapper;
@Service
public class JDBCMeetingRoomOperation implements JDBCMeetingRoomOperationInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public List<Map<String, Object>> findAllMeetingRoom() {
		List<Map<String, Object>> mrlist = null;
		String sql = "SELECT * FROM meetingroom";
		
		try{
			mrlist = jdbcTemplate.queryForList(sql);
			System.out.println("MeetingRoom list:"+mrlist);
		}catch(Exception e){
			System.out.println("δ�ܻ�ȡ��MeetingRoom��������");
		}
		return mrlist;
	}


	@Override
	public MeetingRoom findMeetingRoomById(int id) {
		MeetingRoom mr = null;
		String sql = "SELECT * FROM meetingroom where id="+id;
		
		try{
			mr = jdbcTemplate.queryForObject(sql, new MeetingRoomRowMapper());
			System.out.println("MeetingRoom object:"+mr);
		}catch(Exception e){
			System.out.println("����idδ�ܻ�ȡ��MeetingRoom����");
		}
		return mr;
	}


	@Override
	public int insertReservation(User user,int mr_id,String reservedate,String reservetime) {
		int affetResult = 0;
		String sql = "insert reservation(user_id,mr_id,user_name,start_booktime,time) values('"+user.getId()+"','"+mr_id+"','"+user.getName()+"','"+reservedate+"','"+reservetime+"')";
		//����Ԥ������ǰ��Ҫ�����¸�ʱ�θû������Ƿ��Ѿ���Ԥ����
		Reservation rv = checkReserveValid(mr_id,reservedate,reservetime);
		System.out.println("��ѯ�Ƿ�����ͬʱ����ͬ�����ҵ�Ԥ��:"+rv);
		try{
			if(rv == null){
				affetResult = jdbcTemplate.update(sql);
			}else{
				affetResult = 2;
			}
			
		}catch(Exception e){
			System.out.println("���ݸ����Ĳ���User:"+user+" mr_id:"+mr_id+" reservedate:"+reservedate+" reservetime:"+reservetime+",�������ݿ����ʧ����");
		}
		System.out.println("method insertReservation(...) return:"+affetResult);
		return affetResult;
	}
	
	public Reservation checkReserveValid(int mr_id,String reservedate,String reservetime){
		Reservation rv = null;
		String sql = "SELECT * FROM reservation WHERE mr_id='"+mr_id+"' and start_booktime='"+reservedate+"' and time='"+reservetime+"'";
		System.out.println("method checkReserveValid() sql:"+sql);
		try{
			rv = jdbcTemplate.queryForObject(sql, new ReservationRowMapper());
			
		}catch(Exception e){
			System.out.println("���ݸ����Ĳ���mr_id:"+mr_id+" ,reservedate:"+reservedate+" ,reservetime:"+reservetime+"��ѯ���ݿ����ʧ����");
		}
		return rv;
	}


	@Override
	public List<Map<String, Object>> findReservationsByUserId(int userId) {
		List<Map<String, Object>> rvlist = null;
		String sql = "SELECT * FROM reservation WHERE user_id='"+userId+"' and start_booktime>now()";
		
		try{
			rvlist = jdbcTemplate.queryForList(sql);
			System.out.println("Reservation list:"+rvlist);
		}catch(Exception e){
			System.out.println("δ�ܻ�ȡ��Reservation����list����");
		}
		return rvlist;
	}


	@Override
	public int deleteReservationById(int id) {
		int affetResult = 0;
		String sql = "delete from reservation where id='"+id+"'";
		try{
			affetResult = jdbcTemplate.update(sql);
		}catch(Exception e){
			System.out.println("���ݸ����Ĳ���reservation id:"+id+",ɾ�����ݿ����ʧ����");
		}
		System.out.println("method deleteReservationById(int) return:"+affetResult);
		return affetResult;
	}

}
