package com.nagarro.java.training.assignment1.validation;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.java.training.assignment1.Exception.UserInputException;
import com.nagarro.java.training.assignment1.constants.Constants;

/**
 * 
 * This is validation class
 * 
 * @author parushasingla
 *
 */
public class InputValidation {
	/**
	 * 
	 * @param depLoc2
	 *            User Inputed departure location
	 * 
	 * @return boolean value depend on the entered departure location is correct
	 * 
	 */
	public boolean checkDepLoca(String depLoc2) {
		try {
			if (!(depLoc2.length() == 3) || !Character.isUpperCase(depLoc2.charAt(0))
					|| !Character.isUpperCase(depLoc2.charAt(1)) || !Character.isUpperCase(depLoc2.charAt(2)))
				throw new UserInputException(Constants.ENTER_THE_DEPARTURE_LOC);
		} catch (UserInputException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param arrLoc2
	 *            User Inputed arrival Location
	 * 
	 * @return boolean value depend on the entered arrival location is correct
	 * 
	 */
	public boolean checkArrLoca(String arrLoc2) {
		try {
			if (arrLoc2.length() == 3 && Character.isUpperCase(arrLoc2.charAt(0))
					&& Character.isUpperCase(arrLoc2.charAt(1)) && Character.isUpperCase(arrLoc2.charAt(2))) {
				return true;
			} else {
				throw new UserInputException(Constants.ENTER_THE_ARRIVAL_LOC);
			}
		} catch (UserInputException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * 
	 * @param date2
	 *            User Entered date
	 * 
	 * @return boolean value depend on the entered date format is correct
	 * @throws ParseException 
	 */
	public boolean checkDate(String date2)  {
		// try {
		// String regex = Constants.REGREX;
		// Pattern pattern = Pattern.compile(regex);
		// Matcher matcher = pattern.matcher((CharSequence) date2);
		// if (matcher.matches())
		// return true;
		// else {
		// throw new UserInputException(Constants.ENTER_THE_DATE);
		// }

		try {
			String format = "dd-MM-yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			 sdf.parse(date2);
	
		} catch (ParseException e) {
			System.out.println(Constants.ENTER_THE_DATE);
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param flightClass2
	 *            either(E/EB)
	 * 
	 * @return boolean value depend on the entered flight class is correct
	 */
	public boolean checkTheClass(String flightClass2) {
		try {
			if (flightClass2.equals(Constants.E_CLASS) || flightClass2.equals(Constants.EB_CLASS)) {
				return true;
			} else {
				throw new UserInputException(Constants.ENTER_THE_CLASS);
			}
		} catch (UserInputException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	/**
	 * 
	 * @param outputPref
	 *            User Input Preference That depicts output
	 * 
	 * @return boolean value depend on the entered preference is correct
	 */
	public boolean checkOutputPrref(String outputPref) {
		try {
			if (outputPref.equals(Constants.FIRST_CHOICE) || outputPref.equals(Constants.SECOND_CHOICE)) {
				return true;
			} else {
				throw new UserInputException(Constants.ENTER_PREF);
			}
		} catch (UserInputException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
