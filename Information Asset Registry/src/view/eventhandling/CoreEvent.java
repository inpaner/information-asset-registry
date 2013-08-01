package view.eventhandling;

import java.util.ArrayList;

import model.Core;
import model.User;

public class CoreEvent {
	public Core core;
	public ArrayList<Core> coreList;

	public CoreEvent(Core core) {
		this.core = core;
		this.coreList = new ArrayList<>();
	}
	
	public CoreEvent(ArrayList<Core> assetList){
		this.coreList = assetList;
		this.core = null;
	}

	public Core getCore() {
		return core;
	}


}
