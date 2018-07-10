package com.techelevator.doughnutshop.model;

import java.util.List;

public interface DoughnutDAO {

	public List<Doughnut> getDoughnuts();
	public Doughnut getDoughnut(long id);
	
}
