package com.techelevator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest requestObject, HttpServletResponse resp) throws ServletException, IOException {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Mike", "Mazzullo", 21));
		personList.add(new Person("Asher", "Díaz", 22));
		personList.add(new Person("Sondra", "Coffin", 23));
		personList.add(new Person("Jeff", "Prescott", 12));

		requestObject.setAttribute("personList", personList);
		requestObject.setAttribute("mike", new Person("Mike", "Mazzullo", 21) );
		
		Map<String, String> animal2Herd = new HashMap<String, String>();
		animal2Herd.put("Lion", "Pride");
		animal2Herd.put("Rhino", "Crash");
		animal2Herd.put("Giraffe", "Tower");

		requestObject.setAttribute("herds", animal2Herd);
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/personList.jsp").forward(requestObject, resp);;
	}
}
