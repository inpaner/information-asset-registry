package view.gui.page;

import javax.swing.JPanel;

import view.eventhandling.AssetListener;
import view.gui.content.Content;

public class AssetListPageBuilder extends PageBuilder {
	private AssetListener assetListener;

	public AssetListPageBuilder(AssetListener assetListener) {
	this.assetListener = assetListener;
	}
	@Override
	public void BuildHeader(JPanel header) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Content CreateContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void BuildFooter(JPanel footer) {
		// TODO Auto-generated method stub
		
	}

}
