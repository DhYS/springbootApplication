package com.springbootapplication.objects;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public final class StateInfo {
	private final String address;
	private final String bedCount;
	private final String bathCount;
	private final String squareFootage;
	private final String yearBuilt;
	private final String neighborhood;
	private final String neighborhoodRating;
	private final String status;
	private final String purchasePrice;
	private final String projectedCapEx;
	private final String totalCost;
	private final String priceSF;
	private final String projectedRent;
	private final String projectedGrossYield;
	private final String zillowAddress;

	public StateInfo(String address, String bedCount, String bathCount, String squareFootage, String yearBuilt,
			String neighborhood, String neighborhoodRating, String status, String purchasePrice, String projectedCapEx,
			String totalCost, String priceSF, String projectedRent, String projectedGrossYield, String zillowAddress) {
		address = address.replaceAll("\"", "");
		zillowAddress = zillowAddress.replaceAll("\"", "");
		String[] temp = zillowAddress.split(" ");
		zillowAddress = temp[0];
		for (int i = 1; i < temp.length; i++) {
			zillowAddress = zillowAddress + "-" + temp[i];
		}
		this.address = address;
		this.bedCount = bedCount;
		this.bathCount = bathCount;
		this.squareFootage = squareFootage;
		this.yearBuilt = yearBuilt;
		this.neighborhood = neighborhood;
		this.neighborhoodRating = neighborhoodRating;
		this.status = status;
		this.purchasePrice = purchasePrice;
		this.projectedCapEx = projectedCapEx;
		this.totalCost = totalCost;
		this.priceSF = priceSF;
		this.projectedRent = projectedRent;
		this.projectedGrossYield = projectedGrossYield;
		this.zillowAddress = "http://www.zillow.com/homes/" + zillowAddress + "_rb";

	}

	public String getAddress() {
		if (checkNull(address))
			return "No valiad address";
		return address;
	}

	public String getBedCount() {
		if (checkNull(bedCount))
			return "\u0000";
		return bedCount;
	}

	public String getBathCount() {
		if (checkNull(bathCount))
			return "\u0000";
		return bathCount;
	}

	public String getBedBathCount() {
		if (checkNull(bedCount))
			if (checkNull(bathCount))
				return "\u0000";
			else
				return bathCount + " Bath";
		else if (!checkNull(bedCount))
			if (checkNull(bathCount))
				return bedCount + " Bed";
		return bedCount + " Bed / " + bathCount + " Bath";
	}

	public String getSquareFootage() {
		if (checkNull(squareFootage))
			return "\u0000";
		return squareFootage + " Square feet";
	}

	public String getYearBuilt() {
		return yearBuilt;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getNeighborhoodRating() {
		return neighborhoodRating;
	}

	public String getStatus() {
		return status;
	}

	public String getPurchasePrice() {
		if (checkNull(purchasePrice))
			return "\u0000";
		return "$" + purchasePrice;
	}

	public String getProjectedCapEx() {
		if (checkNull(projectedCapEx))
			return "\u0000";
		return "$" + projectedCapEx;
	}

	public String getTotalCost() {
		if (checkNull(totalCost))
			return "\u0000";
		return "$" + totalCost;
	}

	public String getPriceSF() {
		if (checkNull(priceSF))
			return "\u0000";
		return "$" + priceSF + " / SF";
	}

	public String getProjectedRent() {
		if (checkNull(projectedRent))
			return "\u0000";
		return "$" + projectedRent;
	}

	public String getProjectedGrossYield() {
		if (checkNull(projectedGrossYield))
			return "\u0000";
		return projectedGrossYield + "%";
	}

	public String getZillowAddress() {
		return zillowAddress;
	}

	public String getImage() throws IOException {
		System.out.println(zillowAddress);
		Document doc = Jsoup.connect(zillowAddress).get();
		Elements images = doc.getElementsByClass("hip-photo");
		if(images.size() > 0) {
			return "src=" + images.first().attr("src");
		}
		return "";
	}

	public boolean checkValidation() {
		return true;
	}

	public String toString() {
		return address + " , " + bedCount + " , " + bathCount + " , " + squareFootage + " , " + yearBuilt + " , "
				+ neighborhood + " , " + neighborhoodRating + " , " + status + " , " + purchasePrice + " , "
				+ projectedCapEx + " , " + totalCost + " , " + priceSF + " , " + projectedRent + " , "
				+ projectedGrossYield;
	}

	public boolean checkNull(String string) {
		if (string.length() == 0)
			return true;
		return false;
	}

}
