package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.artisan.model.Score;

public class ScoreDao extends BaseDao {
	public boolean addScore(Score score){
		String sql = "insert into s_score values(null,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, score.getStudent_id());
			preparedStatement.setInt(2, score.getCourse_id());
			preparedStatement.setInt(3, score.getScore());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Score> getScoreList(Score score){
		List<Score> retList = new ArrayList<Score>();
		StringBuffer sqlString = new StringBuffer("select * from s_score");
		if(score.getStudent_id() != 0){
			sqlString.append(" and student_id = "+score.getStudent_id());
		}
		if(score.getCourse_id() != 0){
			sqlString.append(" and course_id ="+score.getCourse_id());
		}
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Score s = new Score();
				s.setId(executeQuery.getInt("id"));
				s.setStudent_id(executeQuery.getInt("student_id"));
				s.setCourse_id(executeQuery.getInt("course_id"));
				s.setScore(executeQuery.getInt("score"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean isAdd(Score score){
		String sql = "select * from s_score where student_id=? and course_id = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, score.getStudent_id());
			prst.setInt(2, score.getCourse_id());
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
	public boolean update(int id,int score){
		String sql = "update s_score set score = ? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, score);
			preparedStatement.setInt(2, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id){
		String sql = "delete from s_score where id=?";
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
	public Map<String,String> getStatsInfo(int course_id){
		Map<String,String> ret = new HashMap<String,String>();
		String sql = "select count(id) as student_num,max(score) as max_score,min(score) as min_score,AVG(score) as mid_score from s_score where course_id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, course_id);
			ResultSet executeQuery = preparedStatement.executeQuery();
			if(executeQuery.next()){
				ret.put("student_num", executeQuery.getInt("student_num")+"");
				ret.put("max_score", executeQuery.getInt("max_score")+"");
				ret.put("min_score", executeQuery.getInt("min_score")+"");
				ret.put("mid_score", executeQuery.getFloat("mid_score")+"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
