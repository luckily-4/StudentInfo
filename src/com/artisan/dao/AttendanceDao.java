package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.artisan.model.Attendance;
import com.artisan.model.SelectedCourse;
import com.artisan.util.StringUtil;

public class AttendanceDao extends BaseDao {
	public boolean addAttendance(Attendance attendance){
		String sql = "insert into s_attendance values(null,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, attendance.getStudent_id());
			preparedStatement.setInt(2, attendance.getCourse_id());
			preparedStatement.setString(3, attendance.getAttendance_date());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean isAttendanced(Attendance attendance){
		String sql = "select * from s_attendance where student_id=? and course_id = ? and attendance_date = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, attendance.getStudent_id());
			prst.setInt(2, attendance.getCourse_id());
			prst.setString(3, attendance.getAttendance_date());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Attendance> getAttendancedList(Attendance attendance){
		List<Attendance> retList = new ArrayList<Attendance>();
		StringBuffer sqlString = new StringBuffer("select * from s_attendance");
		if(attendance.getStudent_id() != 0){
			sqlString.append(" and student_id = "+attendance.getStudent_id());
		}
		if(attendance.getCourse_id() != 0){
			sqlString.append(" and course_id ="+attendance.getCourse_id());
		}
		if(!StringUtil.isEmpty(attendance.getAttendance_date())){
			sqlString.append(" and attendance_date like'%"+attendance.getAttendance_date()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Attendance a = new Attendance();
				a.setId(executeQuery.getInt("id"));
				a.setStudent_id(executeQuery.getInt("student_id"));
				a.setCourse_id(executeQuery.getInt("course_id"));
				a.setAttendance_date(executeQuery.getString("attendance_date"));
				retList.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_attendance where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<HashMap<Integer, String>> getAttendanceStatsList(Integer course_id,String dateString){
		List<HashMap<Integer, String>> retList = new ArrayList<HashMap<Integer,String>>();
		StringBuffer sqlString = new StringBuffer("select count(id) as attendance_num,attendance_date from s_attendance where course_id = ? ");
		if(!StringUtil.isEmpty(dateString)){
			sqlString.append(" and attendance_date = '"+dateString + "'");
		}
		sqlString.append(" GROUP BY attendance_date");
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			preparedStatement.setInt(1, course_id);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				HashMap<Integer, String> retMap = new HashMap<Integer, String>();
				retMap.put(executeQuery.getInt("attendance_num"), executeQuery.getString("attendance_date"));
				retList.add(retMap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
}
