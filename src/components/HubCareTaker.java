package components;

import java.util.ArrayList;
import java.util.List;

public class HubCareTaker {
    private List<HubMemento> memList = new ArrayList<HubMemento>();
	
	public void add(HubMemento state) {
		this.memList.add(state);
	}
	
	public HubMemento get(int i) {
		return this.memList.get(i);
	}
}
