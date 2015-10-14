package com.prasad.newsx.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.newsx.dao.NewsDAO;
import com.prasad.newsx.domain.News;
import com.prasad.newsx.domain.NewsMetric;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDAO newsDAO;

	@Override
	public List<News> getEveryNewsFromMyDB() {
		newsDAO.getAllNews();
		return null;
	}

	@Override
	public News getNewsByNewsID(Long id) {
		// TODO Auto-generated method stub
		
		return newsDAO.getNewsById(id);
	}

	@Override
	public void saveLatestNews(News n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> searchNews(String str) {
		// TODO Auto-generated method stub
		return newsDAO.searchNewsByQuery(str);
	}

	@Override
	public List<News> getAllNewsByNewsType(String str) {
		// TODO Auto-generated method stub
		return newsDAO.getNewsByType(str);
	}

	@Override
	public List<News> getNewsForCarouselByNewsType(String str) {
		// TODO Auto-generated method stub
		return newsDAO.getNewsForCarouselByNewsType(str);
	}

	@Override
	public List<News> getRecomendedNewsByNewsType(String str) {
		// TODO Auto-generated method stub
		return newsDAO.getRecomendedNewsByNewsType(str);
	}

	@Override
	public List<NewsMetric> getNewsMetric() {
		// TODO Auto-generated method stub
		return newsDAO.getNewsMetric();
	}

	@Override
	public List<News> getRecomendedNewsByNewsType(String str, Long count) {
	
		return newsDAO.getRecomendedNewsByNewsType(str, count);
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.getAllNews();
	}

	@Override
	public String getChartData() {
		// TODO Auto-generated method stub
		//List<NewsMetric> metrics = getNewsMetric(); // this  is
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(NewsMetric nm : getNewsMetric()){
			sb.append("{ y:"+nm.getCount()+", label: \""+nm.getNewsType()+"\" },");
		}
		sb.append("}");
		
		
		return sb.toString();
	}

}
