package program;

import java.util.ArrayList;

import components.MainOffice;
import components.Package;
import components.Address;

public class Customer implements Runnable {
	private ArrayList<Package> packages = new ArrayList<Package>();
    private Address customerAddress;
	private int serial;
	
	
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			MainOffice.addPackage();
		}
		
	}

	public int getStreet() {
		return customerAddress.street;
	}
	
    public int getZip() {
		return customerAddress.zip;
	}

    public int getSerial() {
		return serial;
	}
	

}