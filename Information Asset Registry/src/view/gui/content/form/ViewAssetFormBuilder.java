package view.gui.content.form;
import com.mysql.jdbc.Field;

import view.gui.content.Content;
import model.Core;

public class ViewAssetFormBuilder extends AddAssetFormBuilder{
	private Core core;
	
	public ViewAssetFormBuilder(Core core){
		super(core);
		this.core = core;
	}
	
	@Override
	public Content BuildContent() {
		super.BuildContent();
		return content;
	}
	
}
