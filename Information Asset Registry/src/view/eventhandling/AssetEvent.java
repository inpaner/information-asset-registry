package view.eventhandling;

import java.util.ArrayList;

import model.Asset;
import model.User;

public class AssetEvent {
	public Asset asset;
	public ArrayList<Asset> assetList;

	public AssetEvent(Asset asset) {
		this.asset = asset;
		this.assetList = null;
	}
	
	public AssetEvent(ArrayList<Asset> assetList){
		this.assetList = assetList;
		this.asset = null;
	}

	public Asset getAsset() {
		return asset;
	}

	public ArrayList<Asset> getAssetList() {
		return assetList;
	}

}
