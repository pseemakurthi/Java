package com.newsx.DAO;

import java.util.List;

import com.newsx.Domain.News;
import com.newsx.Domain.News2;
import com.newsx.Domain.NewsMetric;

public interface NewsDAO {
	public void printNews();	
	public List<News> getAllNews();
	public List<News2> getDefaultNews();
	public void persistNews(News n);
	public News getNewsById(Long newsDi);
	
	public List<News> searchNewsByQuery(String query);
	
	public List<News> getNewsByType(String newsType);
	
	public List<NewsMetric> getNewsMetricByType();
	
	//public List<News> getRecomendedNewsByNewsType(String str, Long count);
	
	
 	
}
