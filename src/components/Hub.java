package components;

import java.util.ArrayList;
import java.util.Random;

public class Hub extends Branch{
	
	private ArrayList<Branch> branches=new ArrayList<Branch>();
	private int currentIndex=0;
	
	public Hub() {
		super("HUB");
	}
	

	public void setBranches(ArrayList<Branch> br) {
		this.branches=br;
	}
	public ArrayList<Branch> getBranches() {
		return branches;
	}

	
	public void add_branch(Branch branch) {
		branches.add(branch);
	}

	public HubMemento saveStateToMemento() {
		return new HubMemento(this.branches);
	}

	public void getStateFromMemento(HubMemento hubMem) {
		this.branches=hubMem.getState();
	}
	
	
	public synchronized void sendTruck(StandardTruck t) {
		synchronized(t) {
			t.notify();
		}
		t.setAvailable(false);
		t.setDestination(branches.get(currentIndex));
		t.load(this, t.getDestination(), Status.BRANCH_TRANSPORT);
		t.setTimeLeft(((new Random()).nextInt(10)+1)*10);
		t.initTime = t.getTimeLeft();
		System.out.println(t.getName() + " is on it's way to " + t.getDestination().getName() + ", time to arrive: "+t.getTimeLeft());	
		currentIndex=(currentIndex+1)%branches.size();
	}
	
	
	public synchronized void shipNonStandard(NonStandardTruck t) {
		for (Package p: listPackages) {
			if (p instanceof NonStandardPackage) {
				/*if (((NonStandardPackage) p).getHeight() <= t.getHeight() 
					&& ((NonStandardPackage) p).getLength()<=t.getLength()
					&& ((NonStandardPackage) p).getWidth()<=t.getWidth()){*/
						synchronized(t) {
							t.notify();
						}
						t.collectPackage(p);
						listPackages.remove(p);
						return;
					//}
			}
		}	
	}
	
	
	@Override
	public void work() {

	}
	
	
	@Override
	public void run() {
		while(true) {
		    synchronized(this) {
                while (threadSuspend)
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		    }
			for (Truck t : listTrucks) {
				if (t.isAvailable()){
					if(t instanceof NonStandardTruck) {
						shipNonStandard((NonStandardTruck)t);
					}
					else {
						sendTruck((StandardTruck)t);
					}
				}	
			}
		}
	}



}
