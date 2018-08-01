package com.techelevator;

import java.util.Map;

import com.techelevator.dao.ActorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showSearchActorForm() {
		return "actorList";
	}

	@RequestMapping(path="/actorSearch", method=RequestMethod.GET)
	public String searchActors(@RequestParam String lastName, ModelMap map) {
		map.addAttribute("actors", actorDao.getMatchingActors(lastName.toUpperCase()));
		return "actorList";
	}
}
