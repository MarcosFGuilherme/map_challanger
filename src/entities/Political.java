package entities;

public class Political {
	private String political;
	private String politicalParty;
	
	public Political(String political, String politicalParty) {
		
		this.political = political;
		this.politicalParty = politicalParty;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((political == null) ? 0 : political.hashCode());
		result = prime * result + ((politicalParty == null) ? 0 : politicalParty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Political other = (Political) obj;
		if (political == null) {
			if (other.political != null)
				return false;
		} else if (!political.equals(other.political))
			return false;
		if (politicalParty == null) {
			if (other.politicalParty != null)
				return false;
		} else if (!politicalParty.equals(other.politicalParty))
			return false;
		return true;
	}
	
}
