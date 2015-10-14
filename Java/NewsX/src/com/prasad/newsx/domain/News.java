package com.prasad.newsx.domain;

import java.io.Serializable;

public class News implements Serializable{ 
	private String headlines;
	private String mainstory;
	private String imageurl;
	private String videourl;
	private String newstype;
	private Long news_id;
	
	
	public Long getNews_id() {
		return news_id;
	}
	public void setNews_id(Long news_id) {
		this.news_id = news_id;
	}
	public String getHeadlines() {
		return headlines;
	}
	public void setHeadlines(String headLines) {
		this.headlines = headLines;
	}
	public String getMainstory() {
		return mainstory;
	}
	public void setMainstory(String mainstory) {
		this.mainstory = mainstory;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getVideourl() {
		return videourl;
	}
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	public String getNewstype() {
		return newstype;
	}
	
	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getHeadlines()+getImageurl() + getMainstory();
	}
}
