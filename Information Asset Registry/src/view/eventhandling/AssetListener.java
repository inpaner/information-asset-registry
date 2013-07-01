package view.eventhandling;

public interface AssetListener {
	public void NewAssetHandling(AssetEvent event);
	public void UpdateAssetHandling(AssetEvent event);
	public void DeleteAssetHandling(AssetEvent event);
	public void ViewLogsHandling();
	public void ReturnToMain();
}
