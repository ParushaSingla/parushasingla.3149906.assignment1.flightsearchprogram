package com.nagarro.java.training.assignment1.io;

import java.util.List;

import com.nagarro.java.training.assignment1.AirwayModel.FlightsModel;
import com.nagarro.java.training.assignment1.validation.OutputValidation;

/**
 * OutputDetails-used print the sorted result
 * 
 * @author parushasingla
 *
 */
public class OutputDetails {
	/**
	 * 
	 * @param lis
	 *            List to be displayed
	 */

	public void display(List<FlightsModel> lis) {
		System.out.println("FlightNo"+"\t"+"Departur Loc"+"\t"+"ArrivalLoc"+"\t"+"Date  "+"\t\t\t"+"Price"+"\t\t"+"Time"+"\t\t"+"Duration");
		OutputValidation output = new OutputValidation();
		if (!output.checkList(lis)) {
			for (FlightsModel list : lis) {
				System.out.println(list);
			}
		}
	}

}
