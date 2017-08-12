import java.util.ArrayList;

public class LecturerList {	
		ArrayList<Lecturer> lecturers;
	
		public LecturerList(){
			//ArrayList should always be instantiated on object creation
			lecturers = new ArrayList<Lecturer>();
		}
		
		//add a new lecturer object to our ArrayList
		public void add(Lecturer emp){
			lecturers.add(emp);
		}
		
		//returns the employee object where the name matches
		public Lecturer findLecturerById(int ID){
			Lecturer emp = null;
			for(Lecturer e:lecturers){
				if(e.contains(ID)){
					emp = e;
				}
			}
			
			return emp;
		}

}
		
