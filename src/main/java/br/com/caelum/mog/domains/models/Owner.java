package br.com.caelum.mog.domains.models;

import org.springframework.util.Assert;

public class Owner {
	
	private String ownerName;
	
	 /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Owner() { }
    
    public Owner(String ownerName) {
        Assert.hasText(ownerName, "Name required");

        this.ownerName = ownerName;
    }
    
	public String getOwnerName() {
		return ownerName;
	}
}
