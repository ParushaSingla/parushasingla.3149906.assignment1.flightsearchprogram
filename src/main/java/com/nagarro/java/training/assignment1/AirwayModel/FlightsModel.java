package com.nagarro.java.training.assignment1.AirwayModel;

/**
 * {@link FlightsModel} Model corresponding to csv data
 * 
 * @author parushasingla
 *
 */
public class FlightsModel {
	String flightNo;
	String depLoc;
	String arrLoc;
	String validTill;
	String flightTime;
	String flightDuration;
	String flightFare;
	String availability;
	String flightClass;

	public FlightsModel(String flightNo, String depLoc, String arrLoc, String date, String flightTime,
			String flightDuration, String flightFare, String availability, String flightClass) {
		setFlightNo(flightNo);
		setDepLoc(depLoc);
		setArrLoc(arrLoc);
		setValidTill(date);
		setFlightTime(flightTime);
		setFlightDuration(flightDuration);
		setFlightFare(flightFare);
		setAvailability(availability);
		setFlightClass(flightClass);
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	public String getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(String flightFare) {
		this.flightFare = flightFare;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		String str = "";
		Double flightUpdatedFare = 0.0;
		if (flightClass.equals("EB")) {
			flightUpdatedFare = Double.parseDouble(flightFare) + (0.4 * Double.parseDouble(flightFare));
		}
		str = flightNo + "\t\t" + depLoc + "\t\t" + arrLoc + "\t\t" + validTill + "\t\t" + flightUpdatedFare + "\t\t" 
				+ flightTime + "\t\t" + flightDuration;
		return str;
	}

	public static int compareByFare(FlightsModel m, FlightsModel o) {
		return Integer.parseInt(m.getFlightFare()) - Integer.parseInt(o.getFlightFare());
	}

}
