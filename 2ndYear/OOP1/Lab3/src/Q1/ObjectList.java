package Q1;
import java.util.ArrayList;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class ObjectList {

ArrayList<Object> RandomObj;
	
	public ObjectList(int i){
		RandomObj = new ArrayList<Object>();
	}
	
	public boolean add(Object emp){
		return RandomObj.add(emp);
	}
	
	public void remove(int i){
		//returns a boolean if the object is found in the list and removed
		RandomObj.remove(i);
	}
	public Object getObject(int i){
		return RandomObj.get(i);
	}
	
	public boolean isFull(){		
		return true;//Because we are using an ArrayList is always true, is adjusts itself to the left leaving no empty spaces in the array
	}
	
	public boolean isEmpty(){		
		return RandomObj.isEmpty();
	}
	
	public Object getTotal(){		
		return RandomObj.size();
	}
	
}
