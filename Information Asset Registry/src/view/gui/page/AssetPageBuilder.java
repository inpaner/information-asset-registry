package view.gui.page;

import javax.swing.JPanel;

import view.gui.content.AssetForm;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;
import view.gui.content.form.AddAssetFormBuilder;
import view.gui.content.form.ViewAssetFormBuilder;

public class AssetPageBuilder extends PageBuilder {

	public Page BuildPage() {
		return new Page();
	}

	@Override
	public void BuildHeader(JPanel header) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Content CreateContent() {
		return ContentBuilder.BuildAddForm(null);
	}

	@Override
	public void BuildFooter(JPanel footer) {
		// TODO Auto-generated method stub
		
	}

}
