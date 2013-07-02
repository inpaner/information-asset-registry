package view.eventhandling;

public interface AssetListener {
	public void MoveToNewAssetHandling(AssetEvent event);
	public void MoveToUpdateAssetHandling(AssetEvent event);
	public void DeleteAssetHandling(AssetEvent event);
	public void CreateNewAsset(AssetEvent event);
	public void UpdateAsset(AssetEvent event);
}
