package view.gui.page;

import javax.swing.JPanel;

<<<<<<< HEAD
	@Override
	public void BuildPage() {
=======
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
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BuildHeader() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BuildContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BuildFooter() {
		// TODO Auto-generated method stub
		
	}


}
