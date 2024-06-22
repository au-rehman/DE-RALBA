package dralba;

import java.awt.Event;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import org.cloudbus.cloudsim.allocationpolicies.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.brokers.DatacenterBroker;
import org.cloudbus.cloudsim.brokers.DatacenterBrokerSimple;
import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.cloudlets.CloudletSimple;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.datacenters.Datacenter;
import org.cloudbus.cloudsim.datacenters.DatacenterSimple;
import org.cloudbus.cloudsim.hosts.Host;
import org.cloudbus.cloudsim.hosts.HostSimple;

import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;

import org.cloudbus.cloudsim.provisioners.ResourceProvisionerSimple;
import org.cloudbus.cloudsim.resources.Pe;
import org.cloudbus.cloudsim.resources.PeSimple;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.schedulers.vm.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModel;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModelFull;
import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudsimplus.builders.tables.CloudletsTableBuilder;
import org.cloudsimplus.integrationtests.VmCreationFailureIntegrationTest;
import org.cloudsimplus.listeners.CloudletVmEventInfo;
import org.cloudsimplus.listeners.EventInfo;



public class DRalba {
	private String baseURL = "C:/Users/Atiq ur Rehman/Downloads/GoCJ_Dataset_600.csv";
	private static final double TIME_TO_TERMINATE_SIMULATION = 10000;

	
	private static final int SCHEDULING_INTERVAL = 1;
	private static int LAST_INTERRUPT_TIME = 0;
	
	private static final int HOSTS = 16;
	private static final int HOST_PES = 4;

	private static  int VMS = 15;
	private static final int VM_PES = 1;


	private static  int CLOUDLETS = 1000;
	private static int ARRIVED_CLOUDLETS = 0;
	private static final int CLOUDLET_PES = 1;
	
	private final CloudSim simulation;
	private List<Host> hostList;
	private List<Vm> vmList;
	private List<VMStatusTable> vmStatusTables;
	private List<CloudletStatusTable> cloudletStatusTables;
	private List<Cloudlet> cloudletlist;
	private List<Cloudlet> waitingCloudletList;
	Map<Cloudlet,Vm> cloudlet2Vm;
	
	private DatacenterBroker broker;
	private Datacenter datacenter;
	public static boolean dynamicCloudletArrived=false;
	
	public static void main(String[] args) {
		new DRalba();
	}
	
	private DRalba()
	{
		System.out.println("Starting " + getClass().getSimpleName());
		simulation = new CloudSim();
		simulation.terminateAt(TIME_TO_TERMINATE_SIMULATION);
		
		this.hostList = new ArrayList<>();
		this.vmList = new ArrayList<>();
		this.cloudletlist=new ArrayList<>();
		this.waitingCloudletList=new ArrayList<>();
		
		this.datacenter = createDatacenter();
		this.broker = new DatacenterBrokerSimple(simulation);
		
		vmStatusTables=VMCreator.createVms(VM_PES, VMS);
		VMS=vmStatusTables.size();
		
		this.broker.submitVmList(getVmlist());
		calculateComputationRatio();
		
		
		
		this.cloudletStatusTables=createDataset();
		
		this.cloudletlist=getCloudletList();
		this.broker.submitCloudletList(this.cloudletlist);
		calculateVMShare();
		printVMShareStatusTable();
		filler();
		simulation.addOnClockTickListener(this::createRandomCloudlets);
		runSimulationAndPrintResults();
		printVMShareStatusTable();
		List<Cloudlet> newList=broker.getCloudletFinishedList();
		this.vmList=getVmList();
		double sumAvgRt=0.00;
       	for (int a=0; a<VMS;a++){
        		System.out.println("Average Response Time of Vm-" + vmList.get(a).getId() + "   =  " + VmAvgRt( newList, vmList.get(a).getId()));
        		sumAvgRt += VmAvgRt( newList, vmList.get(a).getId());
       	}
       	sumAvgRt /= VMS;
       	
        for (int a=0; a<VMS;a++){
        	System.out.println("Makespane of Vm-" + vmList.get(a).getId() + "  with computing power " + vmList.get(a).getMips() + " is equal to  =  " + getVmMakeSpane( newList, vmList.get(a).getId()));
        	}

        Double makeSpane = getVmMakeSpane(newList, getVmWithMakeSpane(newList,vmList).getId());       	
        System.out.println("Throughput = " + CLOUDLETS/makeSpane);
        System.out.println("Average Response Time   =  " + sumAvgRt);       	
        System.out.println("ARUR  = " + getAvgResourceUtilizationRatio(vmList,newList));
        System.out.println("Makespane  ( VM- " +  getVmWithMakeSpane(newList, vmList).getId()  +" ) =  " + makeSpane);
        

		System.out.println(getClass().getSimpleName() + " finished!");
	}
	
		
	private Datacenter createDatacenter() {
	   for(int i = 0; i < HOSTS; i++) {
	            Host host = createHost();
	            hostList.add(host);
	        }
		final Datacenter dc = new DatacenterSimple(simulation, hostList, new VmAllocationPolicySimple());
		dc.setSchedulingInterval(SCHEDULING_INTERVAL);
		return dc;
	}
	private void filler()
	{
		
		while(cloudletlist.size()!=0)
		{
			VMStatusTable vmStatusTable=getMaxVMShare();
			
			
			Cloudlet cloudlet=getMaxcloudletForVmShare(vmStatusTable);
			
			if(cloudlet!=null)
			{
				assignCloudlettoVM(vmStatusTable, cloudlet);
				setVMforCloudletTable(vmStatusTable.getVm(),cloudlet);
			
			}
			else if(dynamicCloudletArrived)
			{
				updateVMStatusTable((int)simulation.clock());
				dynamicCloudletArrived=false;
			}
			else
			{
				cloudlet=getMaxcloudlet();
				vmStatusTable=getVmWithMinFinishTime(cloudlet);
				assignCloudlettoVM(vmStatusTable, cloudlet);
				setVMforCloudletTable(vmStatusTable.getVm(),cloudlet);
				
			}
		}
	}
	private Host createHost() {
		List<Pe> peList = new ArrayList<>();
		long mips = 1000 * VMS;
		
		for (int i = 0; i < HOST_PES; i++) {
			peList.add(new PeSimple(mips, new PeProvisionerSimple()));
		}
		long ram = 2048; // host memory (Megabyte)
		long storage = 1000000; // host storage (Megabyte)
		long bw = 10000; // Megabits/s

		return new HostSimple(ram, bw, storage, peList).setRamProvisioner(new ResourceProvisionerSimple())
				.setBwProvisioner(new ResourceProvisionerSimple()).setVmScheduler(new VmSchedulerTimeShared());

	}
	
	private List<Vm> getVmlist()
	{
		List<Vm> list=new ArrayList<>();
		for(VMStatusTable vmStatusTable:vmStatusTables)
		{
			list.add(vmStatusTable.getVm());
		}
		return list;
	}
	
	private void calculateComputationRatio()
	{
		for(VMStatusTable vmStatusTable:vmStatusTables)
		{
			vmStatusTable.setComputationRatio(vmStatusTable.getMips()/getTotalMips());
		}
	}
	private double getTotalMips()
	{
		double mips=0;
		for(VMStatusTable vmStatusTable:vmStatusTables)
		{
			mips+=vmStatusTable.getMips();
		}
		return mips;
	}
	private List<CloudletStatusTable> createDataset()
	{
		List<CloudletStatusTable> list=new ArrayList<>();
		try {
		FileReader in = new FileReader(baseURL);
		
	    BufferedReader br = new BufferedReader(in);

	    int counter=0;
	    String row=br.readLine();
	    while (row != null) {
	    	String[] line=row.split(",");
	    
	    	long length=(long)Double.parseDouble(line[0]);
	    	int arrivalTime=Integer.parseInt(line[1]);
	    	CloudletStatusTable cloudletStatusTable=new CloudletStatusTable(length, arrivalTime, false);
			if (arrivalTime == 0) {	
				cloudletStatusTable.setCloudlet(createCloudlet(counter++, length));

			}
			list.add(cloudletStatusTable);
	    	
			 row=br.readLine();
	    }
	    in.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	
		CLOUDLETS=list.size();
		
		return list;
	}
	private List<Cloudlet> getCloudletList()
	{
		List<Cloudlet> list=new ArrayList<>();
		for(CloudletStatusTable cloudletStatusTable:cloudletStatusTables)
		{
			if(cloudletStatusTable.getCloudlet()!=null)
				list.add(cloudletStatusTable.getCloudlet());
		}
		return list;
	}
	private List<Vm> getVmList()
	{
		List<Vm> list=new ArrayList<>();
		for(VMStatusTable cloudletStatusTable:vmStatusTables)
		{
		
			list.add(cloudletStatusTable.getVm());
		}
		return list;
	}
	private double getTotalMI()
	{
		double totalMIs=0;
		for(CloudletStatusTable cloudletStatusTable:cloudletStatusTables)
		{
			if(cloudletStatusTable.isScheduled==false && cloudletStatusTable.getCloudlet()!=null)
				totalMIs+=cloudletStatusTable.getLength();
		}
		for(VMStatusTable vmStatusTable:vmStatusTables)
		{
			totalMIs+=vmStatusTable.getRemainingMI();
		}
		return totalMIs;
	}
	private Cloudlet createCloudlet(int id, long length) {
		long fileSize = 300;
		long outputSize = 300;
		UtilizationModel utilizationModel = new UtilizationModelFull();
		Cloudlet cloudlet = new CloudletSimple(id, length, CLOUDLET_PES).setFileSize(fileSize).setOutputSize(outputSize)
				.setUtilizationModel(utilizationModel)
				.addOnFinishListener(this::onCloudletFinishListener)
				 .addOnStartListener(this::onCloudletStartListener);
		ARRIVED_CLOUDLETS += 1;
		return cloudlet;
	}
	private void runSimulationAndPrintResults() {
		simulation.start();
		List<Cloudlet> cloudlets = broker.getCloudletFinishedList();
		new CloudletsTableBuilder(cloudlets).build();
	}
	
	private void calculateVMShare()
	{
		for(VMStatusTable vmStatusTable:vmStatusTables)
		{
			double vmShare=0;
			vmShare=vmStatusTable.getComputationRatio()*getTotalMI();
			vmShare=vmShare-vmStatusTable.getRemainingMI();
			vmStatusTable.setVMShare(vmShare);
			
			
			
		}
		
	}
	
	private void printVMShareStatusTable(){
		for(VMStatusTable status:vmStatusTables)
		{
			System.out.println("Vm ID="+status.getVMID()+" VMShare="+status.getVMShare()+" MIPS="+status.getMips()+" Ready Time="+status.getReadTime()+" TotalMI="+ status.getTotalAssignedMI()+" Executed MIs="+ status.getExecutedMI()+" Remaining MI="+status.getRemainingMI());
		}
	}
	
	private VMStatusTable  getMaxVMShare()
	{
		double maxShare=0;
		VMStatusTable maxVM=vmStatusTables.get(0);
		maxShare=vmStatusTables.get(0).getVMShare();
		for(int i=0; i<vmStatusTables.size()-1; i++)
		{
			if(vmStatusTables.get(i+1).getVMShare()>maxShare)
			{
				maxShare=vmStatusTables.get(i+1).getVMShare();
				maxVM=vmStatusTables.get(i+1);
			}
		}
		return maxVM;
	}
	private static double getCloudletExecTime(Cloudlet cloudlet, Vm vm, Double VmExecTime)
	{
		double execTime = 0.0;
		execTime = VmExecTime + (cloudlet.getLength()/vm.getMips());
		return execTime;
	}
	private  VMStatusTable getVmWithMinFinishTime(Cloudlet cloudlet)
	{		
		VMStatusTable vmStatusTable=getMaxVMShare();
		Double execTime = getCloudletExecTime(cloudlet,vmStatusTable.getVm(),vmStatusTable.getReadTime());
		
		 for(VMStatusTable object:vmStatusTables) {
			 if(object.getVMShare()>0)
			 {
				Double cExecTime = getCloudletExecTime(cloudlet,object.getVm(),object.getReadTime());
				if (execTime > cExecTime)
				{
					vmStatusTable=object;
					execTime=cExecTime;
					
				}
			 }
		}
		return vmStatusTable;
	}
	private Cloudlet getMaxcloudlet()
	{
		double length=0;
		Cloudlet maxCloudlet=cloudletlist.get(0);
		length=cloudletlist.get(0).getLength();
		for(int i=0; i<cloudletlist.size()-1; i++)
		{
		
			if(cloudletlist.get(i+1).getLength()>length)
			{
				length=cloudletlist.get(i+1).getLength();
				maxCloudlet=cloudletlist.get(i+1);
			}
		}
		
		return maxCloudlet;
	}
	
	private Cloudlet getMaxcloudletForVmShare(VMStatusTable vmStatusTable)
	{
		List<Cloudlet> nList = new ArrayList<Cloudlet>();
		for(int i=0; i<cloudletlist.size()-1; i++)
		{
			
			if(cloudletlist.get(i).getLength()<=vmStatusTable.getVMShare())
				nList.add(cloudletlist.get(i));
			
			if(nList.size()!=0)
			{
				return getMaxCloudlet(nList);
			}
			
			
		}
		
		return null;
	}
	private  Cloudlet getMaxCloudlet(List<Cloudlet> cList)
	{
		Cloudlet maxCloudlet;
		maxCloudlet = cList.get(0);
		for(Cloudlet cld:cList){
			if (cld.getLength() > maxCloudlet.getLength())
				maxCloudlet = cld;
		}
		return maxCloudlet;
	}
	private void assignCloudlettoVM(VMStatusTable vmStatusTable, Cloudlet cloudlet)
	{
		broker.bindCloudletToVm(cloudlet, vmStatusTable.getVm());
		vmStatusTable.setVMShare(vmStatusTable.getVMShare()-cloudlet.getLength());
		vmStatusTable.setTotalAssignedMI(vmStatusTable.getTotalAssignedMI()+cloudlet.getLength());
		vmStatusTable.setRemainingMI(vmStatusTable.getRemainingMI()+cloudlet.getLength());
		vmStatusTable.setReadTime(vmStatusTable.getReadTime()+getExecutionTime(vmStatusTable.getVm(), cloudlet, vmStatusTable.getReadTime()));
		vmStatusTable.addCloudlets(cloudlet);
		System.out.println("Cloudlet "+cloudlet.getLength()+" Scheduled on VM "+vmStatusTable.getVMID());
		cloudletlist.remove(cloudlet);
	}
	private double getExecutionTime(Vm vm, Cloudlet cloudlet, double readyTime)
	{
		return (cloudlet.getLength()/vm.getMips())+readyTime;
	}

	private void updateVMStatusTable(int simulationClockTime)
	{
		System.out.println("UPDATING VM STATUS TABLE");
		System.out.println("Simulation Time Clock "+simulationClockTime);
		for(VMStatusTable table:vmStatusTables)
		{
			double updateTimeDifference=simulationClockTime-table.getLastUpdatedTime();
			
			if((table.getReadTime()-updateTimeDifference)<0)
			{
				table.setReadTime(0);
				table.setRemainingMI(0);
				table.setExecutedMI(table.getTotalAssignedMI());
			}
			else
			{
				double executedMI=(table.getMips()*simulationClockTime);
				table.setReadTime(table.getReadTime()-updateTimeDifference);
				table.setExecutedMI(executedMI);
				table.setRemainingMI(table.getTotalAssignedMI()-executedMI);
			}

			table.setLastUpdatedTime(simulationClockTime);
		
		}
		calculateVMShare();
		printVMShareStatusTable();
		
	}
	private VMStatusTable updateVMStatusTable(int simulationClockTime, VMStatusTable table)
	{
			double updateTimeDifference=simulationClockTime-table.getLastUpdatedTime();
			
			if((table.getReadTime()-updateTimeDifference)<0)
			{
				table.setReadTime(0);
				table.setRemainingMI(0);
				table.setExecutedMI(table.getTotalAssignedMI());
			}
			else
			{
				double executedMI=(table.getMips()*simulationClockTime);
				table.setReadTime(table.getReadTime()-updateTimeDifference);
				table.setExecutedMI(executedMI);
				table.setRemainingMI(table.getTotalAssignedMI()-executedMI);
			}

			table.setLastUpdatedTime(simulationClockTime);
		

		return table;
		
	}
	 private void onCloudletFinishListener(CloudletVmEventInfo eventInfo) {
		 	Cloudlet finishedCloudlet=eventInfo.getCloudlet();
		 	Vm vm=eventInfo.getVm();
		 	VMStatusTable vmStatusTable=getVMStatusTableInstance(vm);
		 	
		 	vmStatusTable=updateVMStatusTable((int)eventInfo.getTime(),vmStatusTable);
		 	if(vmStatusTable.getReadTime()<=0)
		 	{
		 		VMStatusTable heavyMachine=getVMwithLargestReadyTime();
		 		List<Cloudlet> list=heavyMachine.getCloudlets();
		 		for(int i=0; i<list.size(); i++)
		 		{
		 			if(list.get(i).isFinished()!=true)
		 			{
		 				double currentMachineExecTime=getExecutionTime(vm, list.get(i), vmStatusTable.getReadTime());
		 				double heavyMachineExecTime=getExecutionTime(heavyMachine.getVm(), list.get(i), heavyMachine.getReadTime());
		 				if(currentMachineExecTime<heavyMachineExecTime)
		 				{
		 					assignCloudlettoVM(vmStatusTable, list.get(i));
		 					heavyMachine.setReadTime(heavyMachine.getReadTime()-heavyMachineExecTime);
		 					heavyMachine.setTotalAssignedMI(heavyMachine.getTotalAssignedMI()-list.get(i).getLength());
		 					heavyMachine.getCloudlets().remove(list.get(i));
		 				}
		 			}
		 			
		 		}
		 		updateVMStatusTable((int)simulation.clock());
		 	}
	   }
	  private void onCloudletStartListener(CloudletVmEventInfo eventInfo) {
	    }
	  private void setVMforCloudletTable(Vm vm, Cloudlet cloudlet)
	  {
		  for(CloudletStatusTable table:cloudletStatusTables)
		  {
			  if(table.getCloudlet()!=null)
				  if(table.getCloudlet().getId()==cloudlet.getId())
				  {
					  table.setVm(vm);
					  table.setScheduled(true);
				  }
		  }
	  }
	  
	  private void createRandomCloudlets(final EventInfo evt) {
		  
		  if (cloudletStatusTables.size() != ARRIVED_CLOUDLETS) {
				CloudletStatusTable task = cloudletStatusTables.get(ARRIVED_CLOUDLETS);
				 
				if (task.isScheduled == false
						&& evt.getTime() >= task.getArrivalTime()) {
					do {
						dynamicCloudletArrived=true;
						task = cloudletStatusTables.get(ARRIVED_CLOUDLETS);
						System.out.println("Newly Arrived Task Length= "+task.getLength()+" Arrival Time="+task.getArrivalTime());
						task.setCloudlet(createCloudlet(ARRIVED_CLOUDLETS, (long)task.getLength()));
						waitingCloudletList.add(task.getCloudlet());
					}while(ARRIVED_CLOUDLETS!=cloudletStatusTables.size() && cloudletStatusTables.get(ARRIVED_CLOUDLETS).getArrivalTime()==task.getArrivalTime());
				
					cloudletlist.addAll(waitingCloudletList);
					System.out.println(waitingCloudletList.size()+" New Arrived cloudlets are going for mapping");
					broker.submitCloudletList(cloudletlist);
					filler();
					LAST_INTERRUPT_TIME = task.getArrivalTime();
					waitingCloudletList.clear();
				}
			}


		}
	  
	  private boolean checkAllVmShareNegative()
	  {
		  int counter=0;
		  for(VMStatusTable object:vmStatusTables)
		  {
			  if(object.getVMShare()<0)
				  counter++;
		  }
		  if(counter==vmStatusTables.size())
			  return true;
		  return false;
	  }
	  
	  private static double VmMakespane(List<Cloudlet> list, int VmId)
		{
			double mkspane = 0; 
			for(int i=0;i<list.size();i++)
				if (list.get(i).getVm().getId() == VmId)
					if (list.get(i).getFinishTime() > mkspane)
						mkspane =  list.get(i).getFinishTime(); 
			return mkspane;
		}
		
		//Find the VM with smallest remaining executing share
		private static Vm getMinVmShare(Map<Vm,Double> vSMap)
		{
			Vm min;
			Iterator<Vm> vmKeySetIterator = vSMap.keySet().iterator();
			min = vmKeySetIterator.next();			
			while (vmKeySetIterator.hasNext()){
				Vm vm = vmKeySetIterator.next();				
				if (vSMap.get(vm) < vSMap.get(min))
				min = vm;
			}
			return min;
		}
		// method to find the average waiting time in a virtual machine
		private static double VmAvgRt(List<Cloudlet> list, long VmId)
		{
			int c = 0;
			double art = 0; 
			for(int i=0;i<list.size();i++)
				if (list.get(i).getVm().getId() == VmId)
				{
					art = art + list.get(i).getExecStartTime();    c++;
				}
			if (art!=0)
				art =  art / c;
			return art;
		}
		private static Vm getVmWithMakeSpane(List<Cloudlet> cList, List<Vm> vList)
		{
			Map<Vm,Double> vMap = new HashMap<Vm,Double>();
			Double vmMakeSpane = 0.0, makeSpane = 0.0;
			Vm vm = null;
			for (int v=0; v < vList.size(); v++)
			{
			vmMakeSpane = getVmMakeSpane(cList,vList.get(v).getId());				
			if (vmMakeSpane > makeSpane)
				{
				makeSpane = vmMakeSpane; 
				vm = vList.get(v);
				}
			}
			return vm;
		}
		private static double getVmMakeSpane(List<Cloudlet> list, long VmId)
		{
			double mkspane = 0; 
			for(int i=0;i<list.size();i++)
				if (list.get(i).getVm().getId() == VmId)
					if (list.get(i).getFinishTime() > mkspane)
						mkspane =  list.get(i).getFinishTime(); 
			return mkspane;
		}
		private static Double getAvgResourceUtilizationRatio(List<Vm> vList, List<Cloudlet> cList)
		{
			Double ARUR = 0.0, avgMakeSapne = 0.0, sum = 0.0;		
			for(Vm vm:vList){
			 sum += getVmMakeSpane(cList, vm.getId());
			}
			avgMakeSapne = sum/vList.size();
			ARUR = avgMakeSapne/getVmMakeSpane(cList,getVmWithMakeSpane(cList,vList).getId());
			return ARUR;
		}
		
		private VMStatusTable getVMStatusTableInstance(Vm vm)
		{
			for(VMStatusTable object:vmStatusTables)
			{
				if(object.getVMID()==vm.getId())
				{
					return object;
				}
			}
			
			return null;
		}
		
		private VMStatusTable getVMwithLargestReadyTime()
		{
			VMStatusTable vmStatusTable=vmStatusTables.get(0);
			for(VMStatusTable object:vmStatusTables)
			{
				if(object.getReadTime()>vmStatusTable.getReadTime())
				{
					vmStatusTable=object;
				}
			}
			return vmStatusTable;
		}
}
