package view;
import java.awt.Dimension;

import view.eventhandling.AssetListener;
import view.gui.page.PageBuilder;


public class ViewAssetListFrame extends View  {
	private static final Dimension viewAssetFrameDimension = new Dimension(View.ViewWidth, 600);

	/**
	 * Create the frame.
	 */
	public ViewAssetListFrame(AssetListener assetListener) {
		super();
		setPreferredSize(viewAssetFrameDimension);
		setTitle("Asset management system");
		SelectBuilder( PageBuilder.AssignAssetListPageBuilder(assetListener) );
	}
}
