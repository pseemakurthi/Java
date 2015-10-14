package com.prasad.newsx.Service;

import java.util.List;

import com.prasad.newsx.domain.News;
import com.prasad.newsx.domain.NewsMetric;

public interface NewsService {
	
	public List<News> getEveryNewsFromMyDB();
	
	public News getNewsByNewsID(Long id);
	public List<News> getAllNews();
	
	public void saveLatestNews(News n);
	
	public List<News> searchNews(String str);
	
	public List<News> getAllNewsByNewsType(String str);
	
	public List<News> getNewsForCarouselByNewsType(String str);
	
	public List<News> getRecomendedNewsByNewsType(String str);
	
	public List<NewsMetric> getNewsMetric();
	
	public List<News> getRecomendedNewsByNewsType(String str, Long count);
	
	public String getChartData();
	

}
