package view.eventhandling;

public interface MainMenuListener {
    public void newAsset(CoreEvent event);
    public void updateAsset(CoreEvent event);
    public void deleteAsset(CoreEvent event);
    public void viewLogs();
}
