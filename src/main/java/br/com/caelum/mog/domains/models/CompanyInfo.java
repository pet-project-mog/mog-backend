package br.com.caelum.mog.domains.models;

import br.com.caelum.mog.enums.CompanyUnit;

public class CompanyInfo {

	private CompanyUnit companyUnit;

	public CompanyInfo(CompanyUnit companyUnit){
		this.companyUnit = companyUnit;
	}

	public String getUnitName() {
		return companyUnit.getName();
	}

	public String getUnitEmail() {
		return companyUnit.getEmail();
	}

	public String getUnitTelephone() {
		return companyUnit.getTelephone();
	}


}
