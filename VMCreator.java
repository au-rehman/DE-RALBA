package dralba;

import java.util.ArrayList;
import java.util.List;

import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;

public class VMCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static List<VMStatusTable> createVms(int VM_PES, int VMS) {
		
		List<VMStatusTable> list=new ArrayList<>();
		long size = 10000; // image size (Megabyte)
		int ram = 512; // vm memory (Megabyte)
		long bw = 1000;
		int mips = 500;

		for (int i = 0; i < VMS; i++) {
			VMStatusTable vmStatusTable=new VMStatusTable();
			Vm vm;
			switch(i%8)
			{
			case 0:
				 vm = new VmSimple(i, mips-200, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
					vmStatusTable.setMips(mips-200);
				break;
			case 1:
				 vm = new VmSimple(i, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips);
				break;
			case 2:
				 vm = new VmSimple(i, mips+50, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips+50);
				break;
			case 3:
				 vm = new VmSimple(i, mips*2, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips*2);
				break;			
			case 4:
				 vm = new VmSimple(i, mips+300, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips+300);
				break;
			case 5:
				 vm = new VmSimple(i, mips+150, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips+150);
				break;
			case 6:
				 vm = new VmSimple(i, mips+350, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips+350);
				break;
			case 7:
				 vm = new VmSimple(i, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips);
				break;	
			default:
				vm = new VmSimple(i, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
				 vmStatusTable.setMips(mips);
				break;
				
			}
			
			vmStatusTable.setVm(vm);
			vmStatusTable.setVMID(i);
		
			list.add(vmStatusTable);
			
		}

		return list;
	}
}
