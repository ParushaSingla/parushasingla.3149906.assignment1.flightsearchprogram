package com.nagarro.java.training.assignment1.servicesInterface;

import java.util.List;

import com.nagarro.java.training.assignment1.AirwayModel.FlightsModel;

/*
 * 
 * flightServicesInterface->Interface has function that get resultset for user requirement
 * 
 * 
 */


public interface flightServicesInterface {
	public List<FlightsModel> service() throws InterruptedException ;
}
