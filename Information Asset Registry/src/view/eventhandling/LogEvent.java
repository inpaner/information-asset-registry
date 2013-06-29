package view.eventhandling;

import java.sql.Date;
import model.bean.Asset;

public class LogEvent {
	private int action;
	private int userID;
	private Asset asset;
	private Date date;
	
	public LogEvent(int action, int userID, Asset asset, Date date) {
		this.action = action;
		this.userID = userID;
		this.asset = asset;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
}
