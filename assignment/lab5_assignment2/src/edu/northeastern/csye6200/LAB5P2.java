package edu.northeastern.csye6200;

public class LAB5P2 {
	public static void main(String[] args){
		// TODO: write your code here
		System.out.println("Add two to room a and three to room b");
		RoomPeople roomA = new RoomPeople();
		roomA.addOneToRoom();
		roomA.addOneToRoom();
		
		RoomPeople roomB = new RoomPeople();
		roomB.addOneToRoom();
		roomB.addOneToRoom();
		roomB.addOneToRoom();
		
		System.out.println("Room a holds " + roomA.getNumber());
		System.out.println("Room b holds " + roomB.getNumber());
		System.out.println("Total in all rooms is " + RoomPeople.getTotal());
		
		System.out.println("Remove two from both rooms");
		
		roomA.removeOneFromRoom();
		roomA.removeOneFromRoom();
		roomB.removeOneFromRoom();
		roomB.removeOneFromRoom();
		
		System.out.println("Room a holds " + roomA.getNumber());
		System.out.println("Room b holds " + roomB.getNumber());
		System.out.println("Total in all rooms is " + RoomPeople.getTotal());
		
		System.out.println("Remove two from room a (should not change the values)");

		System.out.println("Room a holds " + roomA.getNumber());
		System.out.println("Room b holds " + roomB.getNumber());
		System.out.println("Total in all rooms is " + RoomPeople.getTotal());
	}
}

class RoomPeople {
    
	// TODO: write your code here
    int numberInRoom;
    static int totalNumber;
	
    public static int getTotal(){
    	// TODO: write your code here
    	return totalNumber;
    }
    
    public RoomPeople() {
    	// TODO: write your code here
    	numberInRoom = 0;
    }
    
    public void addOneToRoom(){
    	// TODO: write your code here
    	numberInRoom++;
    	totalNumber++;
    }
    
    public void removeOneFromRoom(){
    	// TODO: write your code here
    	if (numberInRoom == 0) return;
    	numberInRoom--;
    	totalNumber--;
    }
    
    public int getNumber(){
    	// TODO: write your code here
        return numberInRoom;
    }
}   
