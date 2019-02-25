package com.nagarro.java.training.assignment1.dlo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.nagarro.java.training.assignment1.AirwayModel.FlightsModel;
import com.nagarro.java.training.assignment1.constants.Constants;

/**
 * {@link GettingAllTheFiles} used get all the CSV file data
 * 
 * @author parushasingla
 *
 */
public class GettingAllTheFiles implements Runnable {
	private CountDownLatch latch;
	HashMap<Integer, ArrayList<FlightsModel>> map = new HashMap<Integer, ArrayList<FlightsModel>>();

	public GettingAllTheFiles(CountDownLatch latch) {
		this.latch = latch;
	}

	/**
	 * Get complete CSV data
	 */

	public void completedData() {
		String path = Constants.DIRECTORY;
		List<String> results = new ArrayList<String>();

		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}
		int i = 1;
		for (String p : results) {

			ArrayList<FlightsModel> rs = readcsv(path + Constants.STRING_SEPRATOR + p);
			map.put(i, rs);
			i++;

		}
	}

	/**
	 * 
	 * @return HashMap<Integer, ArrayList<FlightsModel>> that contains data
	 *         corresponding to paticular csv file
	 */

	public HashMap<Integer, ArrayList<FlightsModel>> returnDataObject() {
		return map;
	}

	/**
	 * 
	 * @param filePth
	 *            complete address of paticular csv file
	 * @return ArrayList<FlightsModel> complete data of paticular csv file
	 */
	public ArrayList<FlightsModel> readcsv(String filePth) {
		BufferedReader reader = null;
		ArrayList<FlightsModel> list = new ArrayList<FlightsModel>();
		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePth));
			reader.readLine();
			while ((line = reader.readLine()) != null) {

				String[] field = line.split(Constants.STRING_DELIMATOR);
				if (field.length > 0) {
					list.add(new FlightsModel(field[0], field[1], field[2], field[3], field[4], field[5], field[6],
							field[7], field[8]));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				reader.close();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	@Override
	public void run() {
		completedData();
	}

}
