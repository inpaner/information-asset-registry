package view.gui.content.form;
import com.mysql.jdbc.Field;

import view.gui.content.Content;
import model.Core;

public class ViewCoreFormBuilder extends AddCoreFormBuilder{
	private Core core;
	
	public ViewCoreFormBuilder(Core core){
		super(core);
		this.core = core;
	}
	
	@Override
	public Content BuildContent() {
		super.BuildContent();
		return content;
	}
	
}
