package view.eventhandling;

public interface MainMenuListener {
    public void newAsset(AssetEvent event);
    public void updateAsset(AssetEvent event);
    public void deleteAsset(AssetEvent event);
    public void viewLogs();
}
