package com.prasad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.Beans.News;
import com.prasad.DAO.NewsDAO;
import com.prasad.service.NewService;

@Service
public class NewServiceImpl implements NewService{

	@Autowired
	public NewsDAO newsDAO;
	
	
	
	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.getAllNews();
	}

}
