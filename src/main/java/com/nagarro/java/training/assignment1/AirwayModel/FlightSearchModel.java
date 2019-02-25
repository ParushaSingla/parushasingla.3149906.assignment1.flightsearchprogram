package com.nagarro.java.training.assignment1.AirwayModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * FlightSearchModel Model refer to the data User is searching
 * 
 * @author parushasingla
 *
 */
public class FlightSearchModel implements Comparable<FlightsModel>, Runnable {
	String depLoc;
	String arrLoc;
	String Date;
	String flightClass;
	String outputpref;
	FlightsModel fm;

	public FlightSearchModel(String depLoc, String arrLoc, String date, String flightClass, String flightPref) {
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.Date = date;
		this.flightClass = flightClass;
		this.outputpref = flightPref;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getOutputpref() {
		return outputpref;
	}

	public void setOutputpref(String outputpref) {
		this.outputpref = outputpref;
	}

	public int compareTo(FlightsModel m) {
		// TODO Auto-generated method stub
		this.fm = m;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date start = null;
		java.util.Date end = null;
		try {
			start = sdf.parse(this.Date);

			end = sdf.parse(m.validTill);

			if (start.before(end) || sdf.format(start).equals(sdf.format(end))) {
			} else {
				return 0;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (m.getArrLoc().equals(this.getArrLoc()) && m.getDepLoc().equals(this.getDepLoc())
				&& m.getAvailability().equals("Y") && m.getFlightClass().equals(this.getFlightClass()))
			// && (start.compareTo(end) > 0))
			return -1;
		return 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		compareTo(fm);
	}

}
