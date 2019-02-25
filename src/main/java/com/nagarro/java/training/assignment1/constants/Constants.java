package com.nagarro.java.training.assignment1.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nagarro.java.training.assignment1.AirwayModel.FlightsModel;

/**
 * Constants - all constants define here.
 * 
 * @author parushasingla
 *
 */
public class Constants {
	public static List<FlightsModel> resultantOfAllSearchedFlights = Collections.synchronizedList(new ArrayList<>());

	public static final String ENTER_PREF = "Enter Either 1 OR 2. " + "\n 1-> To filter by only by fare"
			+ "\n 2-> TO filter both by fare and flight duration.";
	public static final String ENTER_THE_CLASS = "Enter the Class(E/EB)" + "\n E=Economic and EB=Business";
	public static final String ENTER_THE_DATE = "Enter the Date(eg->05-10-2013)";
	public static final String ENTER_THE_ARRIVAL_LOC = "Enter the Arrival Loc(eg->MUB)";
	public static final String ENTER_THE_DEPARTURE_LOC = "Enter the Departure Loc(eg->DEL)";
	public static final String DIRECTORY = "C:\\Users\\parushasingla\\Documents\\Assignment Links\\Assignment Links";

	public static final String EB_CLASS = "EB";
	public static final String E_CLASS = "E";
	public static final String REGREX = "^(1[0-2]|0[1-9])-(3[01]" + "|[12][0-9]|0[1-9])-[0-9]{4}$";
	public static final String SECOND_CHOICE = "2";
	public static final String FIRST_CHOICE = "1";
	public static final String STRING_DELIMATOR = "\\|";
	public static final String STRING_SEPRATOR = "\\";

	public static final String NO_FLIGHT_FOUND = "SORRY!NO FLIGHT FOUND!";
}
