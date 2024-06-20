package dralba;

import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.vms.Vm;

public class CloudletStatusTable {
	int cloudletID;
	double length;
	int arrivalTime;
	Vm vm;
	Cloudlet cloudlet; 
	boolean isScheduled;
	boolean isFinished;
	
	CloudletStatusTable()
	{
		isScheduled=false;
	}
	
	
	public CloudletStatusTable(int cloudletID, double length, int arrivalTime, Vm vm, Cloudlet cloudlet,
			boolean isScheduled) {
		super();
		this.cloudletID = cloudletID;
		this.length = length;
		this.arrivalTime = arrivalTime;
		this.vm = vm;
		this.cloudlet = cloudlet;
		this.isScheduled = isScheduled;
	}
	public CloudletStatusTable(double cloudletLength, int arrivalTime, boolean isScheduled) {
		super();
		this.length = cloudletLength;
		this.arrivalTime = arrivalTime;
		this.isScheduled = isScheduled;
		
	}



	public int getCloudletID() {
		return cloudletID;
	}
	public void setCloudletID(int cloudletID) {
		this.cloudletID = cloudletID;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Vm getVm() {
		return vm;
	}
	public void setVm(Vm vm) {
		this.vm = vm;
	}
	public Cloudlet getCloudlet() {
		return cloudlet;
	}
	public void setCloudlet(Cloudlet cloudlet) {
		this.cloudlet = cloudlet;
	}
	public boolean isScheduled() {
		return isScheduled;
	}
	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}


	public boolean isFinished() {
		return isFinished;
	}


	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
	
	

}
