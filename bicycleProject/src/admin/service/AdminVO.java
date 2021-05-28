package admin.service;

public class AdminVO {

	private String adminSN;// 관리자 시리얼 넘버
	private String adminID;
	private String adminPassword;
	private String adminName;
	private String adminGender;

	public String getAdminSN() {
		return adminSN;
	}

	public void setAdminSN(String adminSN) {
		this.adminSN = adminSN;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

}
