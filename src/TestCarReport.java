import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestCarReport {

	public static void main(String[] args) {
		
		
		//TODO import to git/github with osmany help
		//TODO functionality change the amount of cars 
		//TODO copy the inventory report into a txt file for the end of the day 
		//TODO ability to remove cars from inventory 
		//TODO try out the program and make it executable
		//TODO clean up, add comments
		//TODO reimport to git/github 
		
		
		boolean done = false; 
		MotorCarDatabase mcd = new MotorCarDatabase();
		// testing cars to fill up inventory
		mcd.add("Ford", 5);
		mcd.add("Cadillac", 64);
		mcd.add("Subaru", 77);
		mcd.add("Ferrari", 1);
		
		while(!done) {
			int menuOption  = GetData.getInt("Welcome to Pete's Car Database System. What do you want to do today?(type in corresponding number)"
					+ "\n1. Add car and quantity to the database"
					+ "\n2. Remove Car(not created yet)"
					+ "\n3. Check if specific car inventory is too low"
					+ "\n4. Set car inventory threshold(default is 5)"
					+ "\n5. End Business day and print inventory NOT in alphabetical order"); //add on, make it print out a text file? 
			
			
			switch(menuOption) {
				case 1:
					String carName = GetData.getString("What is the name of the car?");
					int carQuan = GetData.getInt("How many units are there of this car?");

					mcd.add(carName, carQuan);
				
					break;
			
				case 2:
					System.out.println("Not created yet");
					break;
			
				case 3: 
					String searchTerm = GetData.getString("What is the name of the car?");
					displayTextArea(mcd.checkTreshold(searchTerm), "CHECKING CAR THRESHOLD");
				
					break; 
					
				case 4: 
					int setThreshold = GetData.getInt("What is the minimum amount to replenish inventory? ");
					mcd.setThresholdAmount(setThreshold);
					JOptionPane.showMessageDialog(null, "The new minimum amount has been set to " + mcd.getThresholdAmount());
					
					break;
				case 5: 
					
					displayTextArea(mcd.getInventoryReport(), "FINAL INVENTORY REPORT");
					JOptionPane.showMessageDialog(null, "Have a good day!");
					done = true;
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Not an option");
					break;
				
			}
			
			
		}
		System.out.println("You have left the menu, goodbye");
	}
	
	
	
	static void display(JScrollPane jps, String s, int t ) {
		JOptionPane.showMessageDialog(null, jps, s, t);
	}
	static void displayTextArea(String origText, String title) {
		JTextArea jta = new JTextArea(origText, 25, 25);
		JScrollPane jps = new JScrollPane(jta);
		display(jps, title, JOptionPane.INFORMATION_MESSAGE);
	}
	

}
