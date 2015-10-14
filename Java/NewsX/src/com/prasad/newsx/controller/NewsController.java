package com.prasad.newsx.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prasad.newsx.Service.NewsService;
import com.prasad.newsx.domain.News;

@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getWelcomePage(){
		ModelAndView mav = new ModelAndView("home"); //view name where home.jsp is the view name;
		
		mav.addObject("allnews",newsService.getAllNews());
		mav.addObject("carouselnews", newsService.getNewsForCarouselByNewsType(null));
		mav.addObject("chartdata", newsService.getChartData());
		System.out.println(newsService.getChartData());
		
		return  mav;
	}
	
	
	@RequestMapping(value="/addnews", method=RequestMethod.GET)
	public ModelAndView getAddNewsPage(){
		ModelAndView mav = new ModelAndView("addnews");
		List<String> newsType = new ArrayList<String>();
		newsType.add("Politics");
		newsType.add("Technology");
		newsType.add("Science");
		newsType.add("Sports");
		newsType.add("world");
		newsType.add("Aliens");
		mav.addObject("newsType", newsType);
		mav.addObject("news", new News());	
		
		return mav;
	}
	
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public ModelAndView getNewsPage(@RequestParam("id")Long id){
		
		ModelAndView mav = new ModelAndView("news");
		News n =newsService.getNewsByNewsID(id);
		mav.addObject("news", n);
		mav.addObject("recomendednews", newsService.getRecomendedNewsByNewsType(n.getNewstype(), 5L));
		return mav;
	}
	
	
	@RequestMapping(value="/addnews", method=RequestMethod.POST)
	public ModelAndView getAddNewsPageWithData(@ModelAttribute("news") News news){
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("chartdata", newsService.getChartData());
		//make the code 
		newsService.saveLatestNews(news);
		mav.addObject("allnews", newsService.getEveryNewsFromMyDB());
		mav.addObject("carouselnews", newsService.getNewsForCarouselByNewsType(null));
		mav.addObject("chartdata", newsService.getChartData());
	    System.out.println("chart data"+newsService.getChartData());
		return mav;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST )
	public ModelAndView getSearchResults(@RequestParam("query")String query){
		ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("allnews", newsService.searchNews(query));
		mav.addObject("carouselnews", newsService.getNewsForCarouselByNewsType(null));
		
		mav.addObject("chartdata", newsService.getChartData());
		
		
		return mav;
	}
	
	@RequestMapping(value="/news/type", method=RequestMethod.GET)
	public ModelAndView getNewsByChartClick(@PathVariable("type") String type){
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("allnews",newsService.getAllNewsByNewsType(type));
		mav.addObject("carouselnews", newsService.getNewsForCarouselByNewsType(null));
		mav.addObject("chartdata", newsService.getChartData());
		
		return mav;
	}
}
