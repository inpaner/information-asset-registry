package view.gui.content.form;
import com.mysql.jdbc.Field;

import view.gui.content.Content;
import model.Asset;

public class ViewAssetFormBuilder extends AddAssetFormBuilder{
	private Asset asset;
	
	public ViewAssetFormBuilder(Asset asset){
		super(asset);
		this.asset = asset;
	}
	
	@Override
	public Content BuildContent() {
		Field field;
		
		asset.get(asset.pk());
		
		return content;
	}
	
}
