package com.techelevator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.CityDAO;
import com.techelevator.dao.model.City;
import com.techelevator.dao.model.User;

/*
 * Login with the following
 * 	username: John
 * 	password: 123
 */

@Controller
@SessionAttributes("user")
public class CityController {

	@Autowired
	private CityDAO cityDao;
		
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showCityList(ModelMap map) {
		
		if (map.get("user") == null) {
			return "redirect:/login";
		}
		
		map.addAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "cityList";
	}
	
	
	@RequestMapping(path="/addCity", method=RequestMethod.GET)
	public String showAddCity(ModelMap map) {
		if (map.get("user") == null) {
			return "redirect:/login";
		}
		return "addCity";  
	}
	
	@RequestMapping(path="/addCity", method=RequestMethod.POST)
	public String addNewCity(City newCity, RedirectAttributes attr) {
	
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);
		
		//attr.addFlashAttribute("city", newCity);
		return "redirect:/addCityResult";  
	}
	
	@RequestMapping(path="/addCityResult", method=RequestMethod.GET)
	public String showAddCity(Model model, ModelMap map) {	
		
		// The model can be checked if it contains our flash attribute by using the Model's containsAttribute function
		if (model.containsAttribute("city")) {
			/* The Flash Attribute object can be retrieved from the Model by using the asMap() function and 
			 * then the Maps .get(key) method.
			 * Since it is stored as an Object, we must cast it to the appropriate type
			 */
			City newCity = (City) model.asMap().get("city");
			if (newCity.getPopulation() < 20) {
				map.addAttribute("comment", "Does this qualify as a city?");
			}
		}
		
		return "cityConfirm";  
	}
	
	

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String doLogin(User user, @RequestParam String password, ModelMap map) {
		
		if (!isValidLogin(user, password)) {
			map.addAttribute("error", "Invalid username or password");
			return "login";
		}
		
		map.addAttribute("user", user);
		return "redirect:/";
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.GET) 
	public String doLogout(HttpSession session, ModelMap map) {
		
		session.invalidate();
		map.addAttribute("bgClass", "white");
		map.clear();
		
		return "redirect:/";
	}
	
	private boolean isValidLogin(User user, String password) {
		if (user == null || user.getUsername() == null || user.getUsername().length() < 1 
				|| password == null || password.length() < 1
				|| !(user.getUsername().equals("John") && password.equals(("123")))) {
			return false;
		}
		user.setName("John Doe");
		return true;
	}
	
}
