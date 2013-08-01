package view.gui.content;

import java.awt.Dimension;

public abstract class Table extends Content {
	public static final Dimension tableDimension = new Dimension(750, 550);

	/**
	 * This method is supposed to return the
	 * currently selected row of the table.
	 * @return
	 */
	public abstract Object GetSelected();
}
