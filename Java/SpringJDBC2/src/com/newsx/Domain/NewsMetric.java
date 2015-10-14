package com.newsx.Domain;

import java.io.Serializable;

public class NewsMetric  implements Serializable{
	
	private String newsType;
	private Long count;
	
	public String getNewsType() {
		return newsType;
	}
	
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	public Long getCount() {
		return count;
	}
	
	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		
		return ("news Type  >>>" + getNewsType() + " >>>>>> " + getCount());
	}
	
	
	
}
