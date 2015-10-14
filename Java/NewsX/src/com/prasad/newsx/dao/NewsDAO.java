package com.prasad.newsx.dao;

import java.util.List;

import com.prasad.newsx.domain.News;
import com.prasad.newsx.domain.NewsMetric;


public interface NewsDAO {
	public void printNews();	
	public List<News> getAllNews();
	
	public void persistNews(News n);
	public News getNewsById(Long newsDi);
	
	public List<News> searchNewsByQuery(String query);
	public List<News> getNewsByType(String str);
	
	
	public List<News> getRecomendedNewsByNewsType(String str);
	
	public List<NewsMetric> getNewsMetric();
	public List<News> getNewsForCarouselByNewsType(String str);
	public List<News> getRecomendedNewsByNewsType(String str, Long count);
	
	//public List<News> getNewsByType(String newsType);
	
	
	
}
