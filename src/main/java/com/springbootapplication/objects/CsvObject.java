package com.springbootapplication.objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvObject {
	private List<StateInfo> data;
	private int length;
	public CsvObject() {
		data = new ArrayList<StateInfo>();
		length = -1;
	}
	
	public void readCsv(String fileName, String splitBy) {
		// by default, splitBy should set to ","
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] realState = line.split(splitBy);
				if (realState.length == 18) {
					data.add(new StateInfo(realState[0] + " " + realState[1] + ", " + realState[2] + ", " + realState[3] + " " + realState[4],
							realState[5],realState[6],realState[7],realState[8],
							realState[9],realState[10],realState[11],realState[12],realState[13],realState[14],
							realState[15],realState[16],realState[17],realState[0] + " " + realState[1]));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File read error!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("readLine error!");
			e.printStackTrace();
		}
		System.out.println("Load file completed!");
		length = data.size();
	}
	
	public List<StateInfo> filter(int property, CharSequence criteria, List<StateInfo> data) {
		List<StateInfo> output = null;
		switch (property) {
		case 0: case 1: case 2: case 3:
			output = data.stream().filter(p -> p.getAddress().contains(criteria)).collect(Collectors.toList());
			return output;
		case 4:
			output = data.stream().filter(p -> p.getBedCount().contains(criteria)).collect(Collectors.toList());
			return output;
		case 5:
			output = data.stream().filter(p -> p.getBathCount().contains(criteria)).collect(Collectors.toList());
			return output;
		case 6:
			output = data.stream().filter(p -> p.getSquareFootage().contains(criteria)).collect(Collectors.toList());
			return output;
		case 7:
			output = data.stream().filter(p -> p.getYearBuilt().contains(criteria)).collect(Collectors.toList());
			return output;
		case 8:
			output = data.stream().filter(p -> p.getNeighborhood().contains(criteria)).collect(Collectors.toList());
			return output;
		case 9:
			output = data.stream().filter(p -> p.getNeighborhoodRating().contains(criteria)).collect(Collectors.toList());
			return output;
		case 10:
			output = data.stream().filter(p -> p.getStatus().contains(criteria)).collect(Collectors.toList());
			return output;
		case 11:
			output = data.stream().filter(p -> p.getPurchasePrice().contains(criteria)).collect(Collectors.toList());
			return output;
		case 12:
			output = data.stream().filter(p -> p.getProjectedCapEx().contains(criteria)).collect(Collectors.toList());
			return output;
		case 13:
			output = data.stream().filter(p -> p.getTotalCost().contains(criteria)).collect(Collectors.toList());
			return output;
		case 14:
			output = data.stream().filter(p -> p.getPriceSF().contains(criteria)).collect(Collectors.toList());
			return output;
		case 15:
			output = data.stream().filter(p -> p.getProjectedRent().contains(criteria)).collect(Collectors.toList());
			return output;
		case 16:
			output = data.stream().filter(p -> p.getProjectedGrossYield().contains(criteria)).collect(Collectors.toList());
			return output;
		default:
			System.out.println("Invalide property");
			return output;	
		}
	}
	
	public List<StateInfo> getAllList() {
		return data;
	}
	
	public StateInfo getByIndex(int i) {
		if (i > length) {
			System.out.println("Out of index!");
			return null;
		}	
		return data.get(i);
	}
}
