package view;
import controller.Driver;
import view.eventhandling.AssetListener;
import view.gui.page.PageBuilder;


public class ViewAssetListFrame {
	/**
	 * Create the frame.
	 */
	public ViewAssetListFrame(AssetListener assetListener) {
		super();
		Driver.view.setPanel ( PageBuilder.AssignAssetListPageBuilder(assetListener) );
	}
}
