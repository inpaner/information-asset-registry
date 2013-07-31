package view.gui.content;

import java.util.ArrayList;

import view.gui.content.form.field.Field;
import model.Asset;

public class AssetForm extends Form {
	protected Asset asset;
	
	public AssetForm (Asset asset){
		this.asset = asset;
	}
	
	@Override
	public void Reset() {
		
	}

	@Override
	public void Initialize() {
		/* TODO This allows you to
		 * load the information of
		 * the asset
		 */
		
	}

	@Override
	public ArrayList<Field> getFields() {
		
		return null;
	}
	
}
