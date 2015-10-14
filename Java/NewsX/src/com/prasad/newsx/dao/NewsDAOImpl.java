package com.prasad.newsx.dao;

import java.util.List;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prasad.newsx.domain.News;
import com.prasad.newsx.domain.NewsMetric;

@Repository
public class NewsDAOImpl implements NewsDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void printNews() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.query("Select * from news", new BeanPropertyRowMapper<News>(News.class));
		
	}

	@Override
	public void persistNews(News n) {
		// TODO Auto-generated method stub
		n.setNews_id(System.currentTimeMillis());
		String insertSQL = "Insert into news(news_id,headlines, mainstory, imageurl, videourl, newstype)" +
				"VALUES ( ?,?,?,?,?,?)";
//using the capabilities of JdbcTemplate class
		jdbcTemplate.update(insertSQL, new Object[]{n.getNews_id(),n.getHeadlines(),n.getMainstory(),n.getImageurl(), 
		n.getVideourl(),n.getNewstype()});
		
	}

	@Override
	public News getNewsById(Long newsid) {
		// TODO Auto-generated method stub
		
		News news = jdbcTemplate.queryForObject("Select * from news where news_id =?",new Object[]{newsid},new BeanPropertyRowMapper<News>(News.class));
		return news;
	}

	@Override
	public List<News> searchNewsByQuery(String query) {
		String q = "select * from news where upper(headlines) Like upper('%"+query+"%')";
		return jdbcTemplate.query(q, new BeanPropertyRowMapper<News>(News.class));
		// TODO Auto-generated method stub
	}

	@Override
	public List<News> getNewsByType(String newsType) {
		// TODO Auto-generated method stub
		String q = "Selcet * from news where newstype = '?'";
		return jdbcTemplate.query(q,new Object[]{newsType} ,new BeanPropertyRowMapper<News>(News.class));
	}

	@Override
	public List<News> getRecomendedNewsByNewsType(String str) {
		// TODO Auto-generated method stub
		String query = "Select * from news where newstype = '"+str+"' order by Random() limit by 10";
		return null;
	}

	@Override
	public List<NewsMetric> getNewsMetric() {
		// TODO Auto-generated method stub
		List<NewsMetric> metrics = jdbcTemplate.query("select newstype AS \"newType\", count(*) AS \"count\" from news group by newstype",
				new BeanPropertyRowMapper<NewsMetric>(NewsMetric.class));
		return metrics;
	}

	@Override
	public List<News> getNewsForCarouselByNewsType(String str) {
		// TODO Auto-generated method stub 
		String query = "";
		if(org.springframework.util.StringUtils.isEmpty(str)){
			query = "Select * from news order by Random() limit 4";
		}else{
			query = "Select * from news where newstype = '"+str+"' order by Random() limit 4";
		}
		
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<News>(News.class));
	}

	@Override
	public List<News> getRecomendedNewsByNewsType(String str, Long count) {
		// TODO Auto-generated method stub
		String query;
		if(count == 0){
			query = "Select * from news where newstype = '"+str+"' order by Random() limit  25";
			
		}else{
			query = "Select * from news where newstype = '"+str+"' order by Random() limit "+ count;
			
		}
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<News>(News.class));
	}

}
