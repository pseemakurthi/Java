package com.newsx.Domain;

public class News2 {
	private String news_id;
	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}


	private String headLines;
	private String mainstory;
	private String imageurl;
	private String videourl;
	private String newstype;
	
	
	
	public String getNewstype() {
		return newstype;
	}
	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}
	public String getHeadLines() {
		return headLines;
	}
	public void setHeadLines(String headLines) {
		this.headLines = headLines;
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
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return getHeadLines() + getImageurl() + getMainstory() + getNewstype();
	}

}
