package com.newsx.Domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class NewsRowMapper implements RowMapper<News>{

	@Override
	public News mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		News n = new News();
		n.setId(arg0.getLong(1));
		n.setHeadLines(arg0.getString(2));
		n.setMainStory(arg0.getString(3));
		n.setImageURL(arg0.getString(4));
		n.setVideoURL(arg0.getString(5));
		n.setNewsType(arg0.getString(6));
		//System.out.println(n);
		return n;
	}

}
