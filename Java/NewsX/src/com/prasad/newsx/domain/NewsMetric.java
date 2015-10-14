package com.prasad.newsx.domain;

import java.io.Serializable;

public class NewsMetric implements Serializable {

	
	private String newstype;
	
	private Long count;

	public String getNewsType() {
		return newstype;
	}

	public void setNewsType(String newsType) {
		this.newstype = newsType;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
