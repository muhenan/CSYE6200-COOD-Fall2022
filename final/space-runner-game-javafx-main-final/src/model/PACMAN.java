package model;
//enum to define the various pacmen that we have
public enum PACMAN {
	
	YELLOW("/resources/pacmanUp.gif", "/resources/pacmanUp.gif");
	
	String urlPacman;
	String urlLife;
	
	private PACMAN(String urlPacman, String urlLife) {
		this.urlPacman = urlPacman;
		this.urlLife = urlLife;
	}
	
	public String getUrl() {
		return this.urlPacman;
	}
	
	public String getUrlLife() {
		return urlLife;
	}

}
