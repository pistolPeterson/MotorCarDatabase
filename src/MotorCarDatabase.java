import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MotorCarDatabase {
	private String text = "";
	private int thresholdAmount = 5;
	Set set; 
	Iterator iterator;
	

	
	HashMap<String, Integer> hmap;
	
	public MotorCarDatabase() {
		hmap = new HashMap<String, Integer>();
	}
	
	void add(String name, Integer quantity) {
		hmap.put(name, quantity);
	}
	
	String getInventoryReport() {
		
		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>(hmap);
		
		
		 iterateSet(tmap);

		 text += "CAR\tQUANTITY\n";
			
			while(iterator.hasNext()) { 
				
				Map.Entry mentry = (Map.Entry)iterator.next();
				text+= mentry.getKey() + "\t" + mentry.getValue()+"\n";
				
			}
			return text; 
	}
	
	 void iterateSet(Map m){
		 set = m.entrySet();
		 iterator = set.iterator();
	}
	 
	
	
	String checkTreshold(String keyName){
		String s = ""; 
		
		if(hmap.isEmpty())
			return "The database is empty!";
		
		iterateSet(hmap);
		
		while(iterator.hasNext()) { 
			
			Map.Entry mentry = (Map.Entry)iterator.next();
		
			if(keyName.equalsIgnoreCase(mentry.getKey().toString()) && (Integer)mentry.getValue() < thresholdAmount) { //if the search terms are equal and its under the threshold
				increaseQuantityToThreshold(mentry);
				return mentry.getKey() +  " has low inventory. It has now been replenished back to the threshold.";
				
			} else if((keyName.equalsIgnoreCase(mentry.getKey().toString()) && (Integer)mentry.getValue() >= thresholdAmount)) {//if the search terms are equal and its not under the threshold
				return mentry.getKey() +  " is not under the threshold.\nNo further action is needed.";
			}
		}
		
	
		return "This car does not exist. Please try again"; //default text if the car name does not exist
	}
	
	void increaseQuantityToThreshold(Map.Entry me) {
		hmap.replace(me.getKey().toString(), thresholdAmount);
	}
	void setThresholdAmount(int amount) {
		thresholdAmount = amount;
	}
	
	int getThresholdAmount() {
		return thresholdAmount;
	}
	
}
