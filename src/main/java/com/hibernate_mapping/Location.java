package com.hibernate_mapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	private int locationId;
	private String locationPlace;
	private String locationState;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationPlace() {
		return locationPlace;
	}
	public void setLocationPlace(String locationPlace) {
		this.locationPlace = locationPlace;
	}
	public String getLocationState() {
		return locationState;
	}
	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationPlace=" + locationPlace + ", locationState="
				+ locationState + "]";
	}
	
	
	
	

}
