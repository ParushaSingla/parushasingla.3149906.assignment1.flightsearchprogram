package com.nagarro.java.training.assignment1.io;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.nagarro.java.training.assignment1.AirwayModel.FlightSearchModel;
import com.nagarro.java.training.assignment1.constants.Constants;
import com.nagarro.java.training.assignment1.validation.InputValidation;

/**
 * InputDetails- class used to input details from user.
 * 
 * @author parushasingla
 *
 */
public class InputDetails implements Runnable {
	String depLoc;
	String arrLoc;
	String date;
	String flightClass;
	String outputPref;
	Scanner scr = new Scanner(System.in);

	InputValidation check = new InputValidation();

	/**
	 * Used to take input from user
	 * @throws ParseException 
	 */
	public void input() throws ParseException  {
		System.out.println(Constants.ENTER_THE_DEPARTURE_LOC);
		depLoc = scr.next();
		checkDepLoc(depLoc);
		System.out.println(Constants.ENTER_THE_ARRIVAL_LOC);
		arrLoc = scr.next();
		checkArrLoc(arrLoc);
		System.out.println(Constants.ENTER_THE_DATE);
		date = scr.next();
		checkDateFormat(date);
		System.out.println(Constants.ENTER_THE_CLASS);
		flightClass = scr.next();
		checkFlightClass(flightClass);
		System.out.println(Constants.ENTER_PREF);
		outputPref = scr.next();
		checkOutputPref(outputPref);

	}

	/**
	 * 
	 * @return FlightSearchModel Object that need to be searched
	 * 
	 */
	public FlightSearchModel getInputObject() {
		FlightSearchModel obj = new FlightSearchModel(depLoc, arrLoc, date, flightClass, outputPref);
		return obj;
	}

	/**
	 * 
	 * @param outputPref2
	 *            User Input preference to be checked
	 */
	private void checkOutputPref(String outputPref2) {
		// TODO Auto-generated method stub
		while (true) {
			if (check.checkOutputPrref(outputPref))
				break;
			else {
				outputPref = scr.next();
			}
		}

	}

	/**
	 * 
	 * @param flightClass2
	 *            User Input class to be checked
	 */
	private void checkFlightClass(String flightClass2) {
		while (true) {
			if (check.checkTheClass(flightClass2))
				break;
			else {
				flightClass2 = scr.nextLine();
			}
		}

	}

	/**
	 * 
	 * @param date2
	 *            User Input date to be checked
	 * @throws ParseException 
	 */
	private void checkDateFormat(String date2) throws ParseException {
		// TODO Auto-generated method stub
		while (true) {
			if (check.checkDate(date2))
				break;
			else {
				date2 = scr.next();
			}
		}

	}

	/**
	 * 
	 * @param arrLoc2
	 *            User Input arrival location to be checked
	 */
	private void checkArrLoc(String arrLoc2) {
		// TODO Auto-generated method stub
		while (true) {
			if (check.checkArrLoca(arrLoc2))
				break;
			else {
				arrLoc2 = scr.next();
			}
		}
	}

	/**
	 * 
	 * @param depLoc2
	 *            User Input departure locations to be checked
	 */
	private void checkDepLoc(String depLoc2) {
		while (true) {
			if (check.checkDepLoca(depLoc2))
				break;
			else {
				depLoc2 = scr.next();
			}
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
			try {
				input();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

	}

}
