package com.prasad.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prasad.Beans.News;
import com.prasad.DAO.NewsDAO;

@Repository
public class NewsDAOImpl implements NewsDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		// USing the BeanPropertyRowMapper which gives the automapping resultset.
		return jdbcTemplate.query("select * from news", new BeanPropertyRowMapper<News>(News.class));
	}
	
	
 
}
