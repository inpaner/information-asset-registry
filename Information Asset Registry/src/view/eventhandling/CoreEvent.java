package view.eventhandling;

import java.util.ArrayList;

import view.gui.content.CoreForm;

import model.Core;
import model.User;

public class CoreEvent {
	private Core core;
	private ArrayList<Core> coreList;
	private CoreForm form;
	
	public CoreEvent(Core core) {
		this(core, null);
	}
	
	public CoreEvent(Core core, CoreForm form) {
	    this.core = core;
        this.coreList = new ArrayList<>();
        this.form = form;
	}
	
	public CoreEvent(ArrayList<Core> assetList){
		this.coreList = assetList;
		this.core = null;
	}

	public Core getCore() {
		return core;
	}
	
	public CoreForm getForm() {
	    return form;
	}


}
