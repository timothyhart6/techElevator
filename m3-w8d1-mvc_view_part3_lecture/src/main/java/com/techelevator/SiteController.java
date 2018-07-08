package com.techelevator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class SiteController {
	
	private ForumDao forumDao;
	
	public SiteController() {
		forumDao = new ForumDao();
	}

	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@RequestMapping("/aboutUs")
	public String showAboutUs() {
		return "aboutUs";
	}
	
	@RequestMapping("/forum")
	public String showForumList(HttpServletRequest request) {
		request.setAttribute("topicList", forumDao.readAllTopics());
		return "forum/forumList";
	}
	
	@RequestMapping("/forum/forumDetail") 
	public String showForumDetails(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("forumId"));
		request.setAttribute("topic", forumDao.getForumTopicById(id));
		return "forum/forumDetail";
	}
}
