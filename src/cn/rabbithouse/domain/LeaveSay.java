package cn.rabbithouse.domain;

public class LeaveSay {
	private String  artId;
	private String 	message;
	private String  whoLeave;
	private String   leaveDate;
	public LeaveSay(){};
	public LeaveSay(String artId, String message, String whoLeave, String leaveDate) {
		super();
		this.artId = artId;
		this.message = message;
		this.whoLeave = whoLeave;
		this.leaveDate = leaveDate;
	}
	public String getArtId() {
		return artId;
	}
	public void setArtId(String artId) {
		this.artId = artId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getWhoLeave() {
		return whoLeave;
	}
	public void setWhoLeave(String whoLeave) {
		this.whoLeave = whoLeave;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
}	
