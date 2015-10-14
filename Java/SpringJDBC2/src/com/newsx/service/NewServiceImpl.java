package com.newsx.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.newsx.DAO.NewsDAO;
import com.newsx.Domain.News;
import com.newsx.Domain.News2;

public class NewServiceImpl implements NewService{
	
	private NewsDAO newsDAO;

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	public void printNews() {
		// TODO Auto-generated method stub
		newsDAO.printNews();
		
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.getAllNews();
	}

	@Override
	public List<News2> getAllDefaultNews() {
		// TODO Auto-generated method stub
		return newsDAO.getDefaultNews();
	}

	@Override
	public void saveNews(News news) {
		// TODO Auto-generated method stub
		newsDAO.persistNews(news);
		
	}

}
