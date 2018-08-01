package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
public class ActorApiController {


	@Autowired
	private ActorDao actorDao;
	
	
	
	@RequestMapping(path="/api/actor", method=RequestMethod.GET)
	public List<Actor> actorSearch(@RequestParam String lastName) throws JsonProcessingException {
	
		return actorDao.getMatchingActors(lastName.toUpperCase());
		
		/*
		 * Since we have the Jackson data-binding library in the pom.xml, Spring automatically 
		 * does this work for us.
		 */
//		List<Actor> actors = actorDao.getMatchingActors(lastName.toUpperCase());
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonActors = mapper.writeValueAsString(actors);	
//		return jsonActors;
	}
	
	@RequestMapping(path="/api/actor", method=RequestMethod.POST)
	public Actor addActor(@ModelAttribute Actor actor) {
		actorDao.addActor(actor);
		return actor;
	}
	
	@RequestMapping(path="/api/actor", method=RequestMethod.DELETE)
	public boolean deleteActor(@RequestParam String id) {
		if (id != null) {
			actorDao.deleteActor(Integer.parseInt(id));
		}
		return true;
	}
	
	@RequestMapping(path="/api/actor", method=RequestMethod.PUT)
	public boolean updateActor(@ModelAttribute Actor actor) {
		actorDao.updateActor(actor);
		return true;
	}
	
}
