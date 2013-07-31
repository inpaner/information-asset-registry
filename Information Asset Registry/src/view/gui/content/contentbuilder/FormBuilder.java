package view.gui.content.contentbuilder;

import view.gui.content.Content;

public abstract class FormBuilder extends ContentBuilder{

	/**
	 *  Using the asset, determine the
	 * attributes it has and start to
	 * create multiple fields using the
	 * FieldFactory, and add it into the
	 * content file to be returned.
	 */
	public Content BuildContent() {
		
		return content;
	}
}
