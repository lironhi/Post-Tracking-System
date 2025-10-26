package components;

import java.util.ArrayList;
import java.util.List;

public class HubMemento extends Branch {

	private ArrayList<Branch> state = new ArrayList<Branch>();
	
	public HubMemento(ArrayList<Branch> br) {
		this.state=br;
	}

	public ArrayList<Branch> getState(){
		return this.state;
	}
}
