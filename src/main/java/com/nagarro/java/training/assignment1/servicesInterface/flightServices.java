package com.nagarro.java.training.assignment1.servicesInterface;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.nagarro.java.training.assignment1.AirwayModel.FlightSearchModel;
import com.nagarro.java.training.assignment1.AirwayModel.FlightsModel;
import com.nagarro.java.training.assignment1.dlo.GettingAllTheFiles;
import com.nagarro.java.training.assignment1.io.InputDetails;

/**
 * This Class implements Flightservices to gives resultset that contain sorted and searched result 
 * 
 * @author parushasingla
 *
 */
public class flightServices implements flightServicesInterface {
	/**
	 * 
	 * @param choice
	 *            is user choice either 1 or 2
	 * 
	 * @param list
	 *            is a resultant list after searching
	 * 
	 * @return a sorted list depends on user choice
	 */
	public List<FlightsModel> sorting(int choice, List<FlightsModel> list) {
		/*
		 * Sorting have two options either by fare or by both fare and duration
		 */
		if (choice == 1) {
			list.sort(FlightsModel::compareByFare);
		} else {
			list.sort(Comparator.comparing(FlightsModel::getFlightDuration).thenComparing(FlightsModel::compareByFare));
		}
		return list;
	}

	/**
	 * 
	 * @return List<FlightsModel> that contain searched and sorted list
	 * 
	 * @throws InterruptedException
	 *             Thrown when a thread is waiting, sleeping, or otherwise
	 *             occupied, and the thread is interrupted, either before or
	 *             during the activity
	 */
	@Override
	public List<FlightsModel> service() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		InputDetails in = new InputDetails();

		Thread threadGettingInput = new Thread(in);

		GettingAllTheFiles getAllFile = new GettingAllTheFiles(latch);
		Thread threadGettingAllCsv = new Thread(() -> {
			while (true) {
				getAllFile.completedData();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (latch.getCount() == 0)
					break;
			}
		});

		threadGettingInput.start();
		threadGettingAllCsv.start();

		threadGettingInput.join();

		FlightSearchModel ResultAirwayDetails = in.getInputObject();
		// System.out.println("H");
		HashMap<Integer, ArrayList<FlightsModel>> map = getAllFile.returnDataObject();
		latch.countDown();
		return sorting(Integer.parseInt(ResultAirwayDetails.getOutputpref()), Resultset(map, ResultAirwayDetails));
	}

	/**
	 * 
	 * @return List<FlightsModel> that contain searched list
	 * 
	 * @param HashMap<Integer,
	 *            ArrayList<FlightsModel>> map that contain all csv data
	 * 
	 * @param FlightSearchModel
	 *            resultAirwayDetails that contain list to be searched
	 * 
	 * @throws InterruptedException
	 *             Thrown when a thread is waiting, sleeping, or otherwise
	 *             occupied, and the thread is interrupted, either before or
	 *             during the activity
	 */
	public List<FlightsModel> Resultset(HashMap<Integer, ArrayList<FlightsModel>> map,
			FlightSearchModel resultAirwayDetails) throws InterruptedException {

		List<FlightsModel> res = new ArrayList<FlightsModel>();
		for (Integer value : map.keySet()) {

			ArrayList<FlightsModel> list = map.get(value);

			for (FlightsModel m : list) {
				if (resultAirwayDetails.compareTo(m) < 0) {

					res.add(m);
				}
			}
		}

		return res;
	}

}
