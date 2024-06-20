package dralba;

import java.util.ArrayList;
import java.util.List;

import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.vms.Vm;

public class VMStatusTable {
	 int VMID;
	 int mips;
	 double computationRatio; 
	 double VMShare;
	 double readTime;
	 double totalAssignedMI;
	 double executedMI;
	 double remainingMI;
	 double lastUpdatedTime;
	 int numberOfTasks;
	 Vm vm;
	 public List<Cloudlet> cloudlets;
	
	public VMStatusTable ()
	{
		cloudlets=new ArrayList<>();
	}
	
	public VMStatusTable(int vMID, int mips, double computationRatio, double vMShare, double readTime,
			double totalAssignedMI, double executedMI, double remainingMI, int lastUpdatedTime) {
		super();
		VMID = vMID;
		this.mips = mips;
		this.computationRatio = computationRatio;
		VMShare = vMShare;
		this.readTime = readTime;
		this.totalAssignedMI = totalAssignedMI;
		this.executedMI = executedMI;
		this.remainingMI = remainingMI;
		this.lastUpdatedTime = lastUpdatedTime;
		cloudlets=new ArrayList<>();
	}

	
	public Vm getVm() {
		return vm;
	}

	public void setVm(Vm vm) {
		this.vm = vm;
	}

	public int getVMID() {
		return VMID;
	}
	public void setVMID(int vMID) {
		VMID = vMID;
	}
	public int getMips() {
		return mips;
	}
	public void setMips(int mips) {
		this.mips = mips;
	}
	public double getComputationRatio() {
		return computationRatio;
	}
	public void setComputationRatio(double computationRatio) {
		this.computationRatio = computationRatio;
	}
	public double getVMShare() {
		return VMShare;
	}
	public void setVMShare(double vMShare) {
		VMShare = vMShare;
	}
	public double getReadTime() {
		return readTime;
	}
	public void setReadTime(double readTime) {
		this.readTime = readTime;
	}
	public double getTotalAssignedMI() {
		return totalAssignedMI;
	}
	public void setTotalAssignedMI(double totalAssignedMI) {
		this.totalAssignedMI = totalAssignedMI;
	}
	public double getExecutedMI() {
		return executedMI;
	}
	public void setExecutedMI(double executedMI) {
		this.executedMI = executedMI;
	}
	public double getRemainingMI() {
		return remainingMI;
	}
	public void setRemainingMI(double remainingMI) {
		this.remainingMI = remainingMI;
	}
	public double getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(double lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public List<Cloudlet> getCloudlets() {
		return cloudlets;
	}

	public void addCloudlets(Cloudlet cloudlet) {
		this.cloudlets.add(cloudlet);
	}

	public int getNumberOfTasks() {
		return numberOfTasks;
	}

	public void setNumberOfTasks(int numberOfTasks) {
		this.numberOfTasks = numberOfTasks;
	}
	
	
	

}
