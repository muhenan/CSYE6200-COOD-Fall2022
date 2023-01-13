package model;

public class UserScore {

	String name;
	int score;
	
	public UserScore(){
		this.name = "Player";
		this.score = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return this.getName()+" - "+this.getScore();
	}
	
	
}
