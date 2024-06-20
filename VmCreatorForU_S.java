package dralba;

import java.util.ArrayList;
import java.util.List;

import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;

public class VmCreatorForU_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<VMStatusTable> createVM_u_s_hihi(int VM_PES) {
		List<VMStatusTable> vmStatusTables = new ArrayList<>();
		List<Vm> vmList = new ArrayList<>();
		long size = 1000; // image size (MB)
		int ram = 512; // vm memory (MB)
		int mips = 0;
		int id = 0;
		long bw = 1000;
		String vmm = "Xen"; // VMM name

		VMStatusTable vmStatusTable = new VMStatusTable();
		Vm vm;

		mips = 44;
		id = 0;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 1;
		mips = 46;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 2;
		mips = 46;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 3;
		mips = 48;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 4;
		mips = 48;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 5;
		mips = 48;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 6;
		mips = 50;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 7;
		mips = 52;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 8;
		mips = 71;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 9;
		mips = 107;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 10;
		mips = 143;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 11;
		mips = 177;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 12;
		mips = 250;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 13;
		mips = 441;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 14;
		mips = 504;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 15;
		mips = 4000;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		return vmStatusTables;
	}

	
	public static List<VMStatusTable> createVM_u_s_hilo(int VM_PES) {
		List<VMStatusTable> vmStatusTables = new ArrayList<>();
		List<Vm> vmList = new ArrayList<>();
		long size = 1000; // image size (MB)
		int ram = 512; // vm memory (MB)
		int mips = 0;
		int id = 0;
		long bw = 1000;
		String vmm = "Xen"; // VMM name

		VMStatusTable vmStatusTable = new VMStatusTable();
		Vm vm;

		mips = 378 ;
		id = 0;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 1;
		mips = 461;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 2;
		mips = 543;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 3;
		mips = 585;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 4;
		mips = 639;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 5;
		mips = 640;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 6;
		mips = 666;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 7;
		mips = 678;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 8;
		mips = 738;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 9;
		mips = 854;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 10;
		mips = 864;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 11;
		mips = 1103;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 12;
		mips = 1707;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 13;
		mips = 1815;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 14;
		mips = 1881;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 15;
		mips = 2000;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		return vmStatusTables;
	}
	
	public static List<VMStatusTable> createVM_u_s_lohi(int VM_PES) {
		List<VMStatusTable> vmStatusTables = new ArrayList<>();
		List<Vm> vmList = new ArrayList<>();
		long size = 1000; // image size (MB)
		int ram = 512; // vm memory (MB)
		int mips = 0;
		int id = 0;
		long bw = 1000;
		String vmm = "Xen"; // VMM name

		VMStatusTable vmStatusTable = new VMStatusTable();
		Vm vm;

		mips = 19 ;
		id = 0;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 1;
		mips = 19;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 2;
		mips = 20;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 3;
		mips = 23;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 4;
		mips = 24;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 5;
		mips = 40;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 6;
		mips = 48;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 7;
		mips = 49;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 8;
		mips = 52;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 9;
		mips = 68;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 10;
		mips = 73;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 11;
		mips = 149;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 12;
		mips = 184;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 13;
		mips = 805;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 14;
		mips = 1375;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 15;
		mips = 3000;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		return vmStatusTables;
	}

	public static List<VMStatusTable> createVmsforlolo(int VM_PES) {

		List<VMStatusTable> vmStatusTables = new ArrayList<>();
		List<Vm> vmList = new ArrayList<>();
		long size = 1000; // image size (MB)
		int ram = 512; // vm memory (MB)
		int mips = 0;
		int id = 0;
		long bw = 1000;
		String vmm = "Xen"; // VMM name

		VMStatusTable vmStatusTable = new VMStatusTable();
		Vm vm;

		mips = 662;
		id = 0;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 1;
		mips = 706;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 2;
		mips = 723;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 3;
		mips = 769;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 4;
		mips = 770;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 5;
		mips = 795;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 6;
		mips = 803;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 7;
		mips = 930;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 8;
		mips = 1019;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 9;
		mips = 1082;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 10;
		mips = 1256;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 11;
		mips = 1445;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 12;
		mips = 1531;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 13;
		mips = 1678;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 14;
		mips = 1914;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		id = 15;
		mips = 2000;
		vm = new VmSimple(id, mips, VM_PES).setRam(ram).setBw(bw).setSize(size)
				.setCloudletScheduler(new CloudletSchedulerSpaceShared());
		vmStatusTable = new VMStatusTable();
		vmStatusTable.setMips(mips);
		vmStatusTable.setVm(vm);
		vmStatusTable.setVMID(id);
		vmStatusTables.add(vmStatusTable);

		return vmStatusTables;
	}

	public static List<Vm> getVmlist(List<VMStatusTable> vmStatusTables) {
		List<Vm> list = new ArrayList<>();
		for (VMStatusTable vmStatusTable : vmStatusTables) {
			list.add(vmStatusTable.getVm());
		}
		return list;
	}

}
