package com.nagarro.java.training.assignment1.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.nagarro.java.training.assignment1.AirwayModel.FlightsModel;
import com.nagarro.java.training.assignment1.io.InputDetails;
import com.nagarro.java.training.assignment1.io.OutputDetails;
import com.nagarro.java.training.assignment1.servicesInterface.flightServices;

/**
 * 
 * Main.java-A starting Main class
 * 
 * @author parushasingla
 * 
 * @version 1.8
 * 
 * @throws IOException  If an input or output 
 *                      exception occurred
 */
public class Main {
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		flightServices obj = new flightServices();
		List<FlightsModel> lis = obj.service();
		OutputDetails output = new OutputDetails();
		output.display(lis);
	}
}
// AI277 DEL MUB 05-12-2013 0600 4.10 5500 Y EB
//AI277|DEL|MUB|05-12-2013|0600|4.10|6500|Y|EB