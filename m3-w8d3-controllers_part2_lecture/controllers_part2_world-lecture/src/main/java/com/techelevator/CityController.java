package com.techelevator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.CityDAO;
import com.techelevator.dao.model.City;

@Controller
public class CityController {

	@Autowired
	private CityDAO cityDao;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showAddCity(HttpServletRequest request) {
		request.setAttribute("methodUsed", "GET");
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Adding a new City using a GET  - Parameters passed in the URL
	 * If the Page is refreshed, it adds the city again!
	 */
	@RequestMapping(path="/addCity", method=RequestMethod.GET)
	public String addNewCity(HttpServletRequest request) {
		request.setAttribute("methodUsed", "GET-withAddCity");
		
		String name = request.getParameter("name");
		String district = request.getParameter("district");
		String population = request.getParameter("population");
		
		City newCity = new City();
		newCity.setCountryCode("USA");
		newCity.setName(name);
		newCity.setDistrict(district);
		newCity.setPopulation(Integer.parseInt(population));
		
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Adding a new City using a POST - Parameters passed in message body
	 * If Refreshed, still adds the city again, but this time we get a warning!
	 */
	@RequestMapping(path="/addCity", method=RequestMethod.POST)
	public String addNewCityByPost(HttpServletRequest request) {
		request.setAttribute("methodUsed", "POST");
		
		String name = request.getParameter("name");
		String district = request.getParameter("district");
		String population = request.getParameter("population");
		
		City newCity = new City();
		newCity.setCountryCode("USA");
		newCity.setName(name);
		newCity.setDistrict(district);
		newCity.setPopulation(Integer.parseInt(population));
		
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Adding a new City using a POST With RequestParams - Parameters passed in message body
	 * This time the parameters are passed as RequestParam 
	 * If Refreshed, still adds the city again, but this time we get a warning!
	 */
	@RequestMapping(path="/addCityWithRequestParams", method=RequestMethod.POST)
	public String addNewCityByPost(HttpServletRequest request, @RequestParam String name, 
			@RequestParam(name="district") String state, @RequestParam int population, @RequestParam(required=false) String notRequired) {
		
		request.setAttribute("methodUsed", "POST-RequestParams");		
		City newCity = new City();
		newCity.setCountryCode("USA");
		newCity.setName(name);
		newCity.setDistrict(state);
		newCity.setPopulation(population);
		
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Adding a new City using a POST with Model Binding - Parameters passed in message body
	 * This time the parameters are bound to the City object
	 * If Refreshed, still adds the city again, but this time we get a warning!
	 */
	@RequestMapping(path="/addCityWithBinding", method=RequestMethod.POST)
	public String addNewCityByPost(City newCity, HttpServletRequest request) {
		request.setAttribute("methodUsed", "POST-ModelBinding");
		
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Adding a new City using a POST-REDIRECT-GET - Parameters passed in message body
	 * This time the parameters are bound to the City object
	 * Instead of returning the logical view name, it returns a redirect to the original GET method, this
	 * way if the page is refreshed it won't apply the change agian!
	 */
	@RequestMapping(path="/addCityWithPostAndRedirect", method=RequestMethod.POST)
	public String addNewCityByPostAndRedirect(City newCity, HttpServletRequest request) {
		request.setAttribute("methodUsed", "POST-REDIRECT-GET");
		
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);
			
		/*
		 * Instead of returning a view name, we can return redirect:<controller request mapping> to redirect to
		 * a GET and keep the form from submitting again on a refresh
		 */
		return "redirect:/thankyou";  
	}
	
	
	@RequestMapping(path="/thankyou", method=RequestMethod.GET)
	public String showThankYou() {
		return "thankYou";
	}
	
	/*
	 * Adding a new City using a POST-REDIRECT-GET - Parameters passed in message body
	 * This time the parameters are bound to the City object
	 * Instead of returning the logical view name, it returns a redirect to the original GET method, this
	 * way if the page is refreshed it won't apply the change agian!
	 * Instead of using the HttpServletRequest to return the values we will use the ModelMap
	 */
	@RequestMapping(path="/addCityWithPostWithModelMap", method=RequestMethod.POST)
	public String addNewCityByPostWithModelMap(City newCity, ModelMap map) {
	
		map.addAttribute("methodUsed", "POST - with ModelMap");
		
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);
	
		
		/*
		 * Instead of returning a view name, we can return redirect:<controller request mapping> to redirect to
		 * a GET and keep the form from submitting again on a refresh
		 */
		return "redirect:/";  
	}
	
}
