package model;
//enum to define the various ships that we have
public enum PacMan {
	
	YELLOW("/resources/pacmanUp.gif", "/resources/pacmanUp.gif");
	
	String pacManUrl;
	String pacManLife;
	
	private PacMan(String pacManUrl, String pacManLife) {
		this.pacManUrl = pacManUrl;
		this.pacManLife = pacManLife;
	}
	
	public String getPacManUrl() {
		return this.pacManUrl;
	}
	
	public String getPacManLife() {
		return pacManLife;
	}

}
