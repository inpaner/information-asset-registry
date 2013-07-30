package view.gui.content.form;
import view.gui.content.Content;
import model.Asset;

public class ViewAssetFormBuilder extends AddAssetFormBuilder{
	
	public ViewAssetFormBuilder(Asset asset){
		super(asset);
	}
	
	@Override
	public Content BuildContent() {
		return content;
	}
	
}
