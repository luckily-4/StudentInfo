package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Course;
import com.artisan.util.StringUtil;

/**
 * 
 * @author llq
 *课程信息操作数据库
 */
public class CourseDao extends BaseDao {
	public boolean addCourse(Course course){
		String sql = "insert into s_course values(null,?,?,?,?,0)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setInt(2, course.getTeacher_id());
			preparedStatement.setInt(3, course.getMax_student_num());
			preparedStatement.setString(4, course.getInfo());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Course> getCourseList(Course course){
		List<Course> retList = new ArrayList<Course>();
		StringBuffer sqlString = new StringBuffer("select * from s_course");
		if(!StringUtil.isEmpty(course.getName())){
			sqlString.append(" and name like '%"+course.getName()+"%'");
		}
		if(course.getTeacher_id() != 0){
			sqlString.append(" and teacher_id ="+course.getTeacher_id());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Course c = new Course();
				c.setId(executeQuery.getInt("id"));
				c.setName(executeQuery.getString("name"));
				c.setTeacher_id(executeQuery.getInt("teacher_id"));
				c.setMax_student_num(executeQuery.getInt("max_student_num"));
				c.setInfo(executeQuery.getString("info"));
				c.setSelected_num(executeQuery.getInt("selected_num"));
				retList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_course where id=?";
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
	public boolean update(Course course){
		String sql = "update s_course set name=?, teacher_id=?,max_student_num=?,info=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setInt(2, course.getTeacher_id());
			preparedStatement.setInt(3, course.getMax_student_num());
			preparedStatement.setString(4, course.getInfo());
			preparedStatement.setInt(5, course.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean selectedEnable(int course_id){
		String sql = "select * from s_course where id=?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, course_id);
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				int max_student_num = executeQuery.getInt("max_student_num");
				int selected_num = executeQuery.getInt("selected_num");
				if(selected_num >= max_student_num)return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public boolean updateSelectedNum(int course_id,int num){
		String sql = "update s_course set selected_num = selected_num + ? where id = ?";
		if(num < 0){
			sql = "update s_course set selected_num = selected_num - ? where id = ?";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, course_id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
}
