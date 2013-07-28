package view.gui.content;

import model.Asset;

public class AssetTable extends Table {
	protected Asset asset;
	
	public AssetTable(Asset asset){
		this.asset = asset;
	}
	
	public Object GetSelected() {
		return null;
	}

	public void Initialize() {
		
	}
}
