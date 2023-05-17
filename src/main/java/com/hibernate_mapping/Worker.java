package com.hibernate_mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Worker {
	
	@Id
	private int workerId;
	private String workerName;
	private String workerField;
	
	@ManyToOne
	private Location loc;

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerField() {
		return workerField;
	}

	public void setWorkerField(String workerField) {
		this.workerField = workerField;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", workerName=" + workerName + ", workerField=" + workerField + ", loc="
				+ loc + "]";
	}

	
	

}
