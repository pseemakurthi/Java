package com.newsx.Domain;

import java.io.Serializable;

public class News {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getHeadLines() + getImageURL() + getVideoURL() + getId();
	}
	
	
	
	public News() {
		super();
	}




	public News(Long i, String string, String string2, String string3,
			String string4, String string5) {
		// TODO Auto-generated constructor stub
	}




	private long id;
	private String headLines;
	private String mainStory;
	private String imageURL;
	private String videoURL;
	private String newsType;
	
	
	
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHeadLines() {
		return headLines;
	}
	public void setHeadLines(String headLines) {
		this.headLines = headLines;
	}
	public String getMainStory() {
		return mainStory;
	}
	public void setMainStory(String mainStory) {
		this.mainStory = mainStory;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
}
