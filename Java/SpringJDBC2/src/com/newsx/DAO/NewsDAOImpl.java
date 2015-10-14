package com.newsx.DAO;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.newsx.Domain.News;
import com.newsx.Domain.News2;
import com.newsx.Domain.NewsMetric;
import com.newsx.Domain.NewsRowMapper;

public class NewsDAOImpl implements NewsDAO{
	
	
	private JdbcTemplate jdbcTemplate;
	
//DATA SOURCE is deleted.
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

@Override
public void printNews() {
		// TODO Auto-generated method stub
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList("Select * from news");
		for(Map<String, Object> row : rows){
			for(Map.Entry<String, Object> entry : row.entrySet()){
				System.out.println(entry.getKey() + "    >>>>   " + entry.getValue());
			}
		}
	}


@Override
public List<News> getAllNews() {
	// TODO Auto-generated method stub
	List<News> news = jdbcTemplate.query("Select * from news", new NewsRowMapper());
			return news;
}


@Override
public List<News2> getDefaultNews() {
	List<News2> news = jdbcTemplate.query("Select * from news", new BeanPropertyRowMapper(News2.class));
	return news;
}


@Override
public void persistNews(News n) {
	// TODO Auto-generated method stub
	
	String insertSQL = "Insert into news(news_id,headlines, mainstory, imageurl, videourl, newstype)" +
					"VALUES ( ?,?,?,?,?,?)";
	//using the capabilities of JdbcTemplate class
	jdbcTemplate.update(insertSQL, new Object[]{n.getId(),n.getHeadLines(),n.getMainStory(),n.getImageURL(), 
			n.getVideoURL(),n.getNewsType()});
}


@Override
public News getNewsById(Long newsId) {
	News news = jdbcTemplate.queryForObject("Select * from news where news_id =?",new Object[]{newsId},new NewsRowMapper());
	return news;
}


@Override
public List<News> searchNewsByQuery(String query) {
	// TODO Auto-generated method stub
	
	List<News> searchResults = jdbcTemplate.query("Select * from news where headlines = % ? %", new Object[]{query}, 
			new NewsRowMapper());
	return searchResults;
}


@Override
public List<News> getNewsByType(String newsType) {
	// TODO Auto-generated method stub
	
	List<News> searchResults = jdbcTemplate.query("Select * from news where newstype = % ? %", new Object[]{newsType}, 
			new NewsRowMapper());
	return searchResults;
}


@Override
public List<NewsMetric> getNewsMetricByType() {
	// TODO Auto-generated method stub
	
	List<NewsMetric> metrics = jdbcTemplate.query("select newstype AS \"newsType\", count(*) AS \"count\" from news groupby newstype",
			new BeanPropertyRowMapper<NewsMetric>(NewsMetric.class));
	return null;
}







//@Override
//public List<News> getNews() {
//	List<News> news = new ArrayList<News>();
//	List<Map<String,Object>> rows = jdbcTemplate.queryForList("Select * from news");
//	for(Map<String, Object> row : rows){
//		News n = new News();
//		for(Map.Entry<String, Object> entry : row.entrySet()){
//			System.out.println(entry.getKey() + "    >>>>   " + entry.getValue());
//			if(entry.getKey() == "news_id"){
//				n.setId((long) entry.getValue());
//			}
//			
//		}
//		news.add(n);
//	}
//	
// return news;
//}



}
