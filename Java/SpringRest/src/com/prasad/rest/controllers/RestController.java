package com.prasad.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.prasad.Beans.News;
import com.prasad.service.NewService;

@Controller
public class RestController {
	
	@Autowired
	private NewService newsService; 
	
	@ResponseBody //convert the javaobjects to jason
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public List<News> getAllNews(){

		return newsService.getAllNews();
	}
}
