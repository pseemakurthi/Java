package com.newsx.service;

import java.util.List;

import com.newsx.Domain.News;
import com.newsx.Domain.News2;

public interface NewService {
	public void printNews();
	public List<News> getAllNews();
	public List<News2> getAllDefaultNews();
	public void saveNews(News news);
}
