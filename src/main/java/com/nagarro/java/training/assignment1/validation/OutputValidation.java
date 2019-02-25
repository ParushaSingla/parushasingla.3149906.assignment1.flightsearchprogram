package com.nagarro.java.training.assignment1.validation;

import java.util.List;

import com.nagarro.java.training.assignment1.AirwayModel.FlightsModel;
import com.nagarro.java.training.assignment1.Exception.UserInputException;
import com.nagarro.java.training.assignment1.constants.Constants;

public class OutputValidation {

	public boolean checkList(List<FlightsModel> lis) {
		try {
			if (!lis.isEmpty()) {
				return false;
			} else {
				throw new UserInputException(Constants.NO_FLIGHT_FOUND);
			}
		} catch (UserInputException e) {
			System.out.println(e.getMessage());
			return true;
		}

	}

}
