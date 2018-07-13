package com.techelevator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.model.SignUp;
import com.techelevator.dao.model.User;

@Controller
@RequestMapping("/mailingList")
public class MailingListController {

	@RequestMapping("/signup")
	public String showMailingListForm(Model model) {
		
		/*
		 * To bind form validation to our Java Bean, we must have the Java Bean
		 * in the Model.  Here we check if a signup bean already exists in the model, so we don't overwrite 
		 * a signup in in progress, and if it does not we create a new empty SignUp Bean and put it in the Model. 
		 */
		if(! model.containsAttribute("signup")) {
			model.addAttribute("signup", new SignUp());
		}
		
		return "mailingList/signup";
	}
	
	/*
	 * Our Controller for a form with validation needs defined differently than a regular controller
	 * 1.  To the model (SignUp) we wish to perform the validation we add the @Valid annotation and the 
	 *     @ModelAttribute("key") annotation, where the key is the key we used to set the object in the model, 
	 *     when we originally loaded the page, in this case signup
	 * 2.  We also need the BindingResult object, which will hold the validation errors to display to the user.
	 * 
	 * The RedirectAttributes object is not needed for validation, but is needed so we can set a FlashAttribute to 
	 * forward the SignUp object to the Thank You page.
	 */
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String handleMailingListForm(
			@Valid @ModelAttribute("signup") SignUp signup, 
			BindingResult result,
			RedirectAttributes attr
	) {
		
		if(result.hasErrors()) {
			return "mailingList/signup"; 
		}
			 
		return "redirect:/mailingList/thankYou";
	}
	
	@RequestMapping(path="/thankYou", method=RequestMethod.GET)
	public String showThankYou(Model modelHolder, ModelMap map) {
		
		/*
		 * We can't guarantee that the SignUp object is in the Flash Attribute, and don't want to risk
		 * a NullPointerException, so we check if it exists
		 */
		if(! modelHolder.containsAttribute("signup")) {
			// If it does not exist, we create an empty object to avoid the NullPointerException and place
			// that is our modelMap for the View to use. 
			map.addAttribute("signupResult", new SignUp());
		} else {
			// If it does exist, then we get the SignUp object from the Model, where it was set as a RedirectAttribute
			// and place it in the ModelMap for use in the View.
			map.addAttribute("signupResult", modelHolder.asMap().get("signup"));
		}
		return "mailingList/mailingListThankYou";
	}
}
