package br.com.caelum.mog.domains.models;

public class CompanyInfo {

	private String unitName;
	private String unitEmail;

	public CompanyInfo(String unitName, String unitEmail) {
		this.unitName = unitName;
		this.unitEmail = unitEmail;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitEmail() {
		return unitEmail;
	}

	public void setUnitEmail(String unitEmail) {
		this.unitEmail = unitEmail;
	}
	
	
}
