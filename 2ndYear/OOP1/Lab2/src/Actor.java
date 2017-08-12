
public class Actor {

	public String name;
	public String address;
	public int age;
	public Film[] myFilm = new Film[3];

	Actor(String name, String address, int age){
		setname(name);
		setaddress(address);
		setage(age);
	}
	// Setters
	public void setname(String name){
		this.name = name;
	}
			
	public void setaddress(String address){
		this.address = address;
	}
			
	public void setage(int age){
		this.age = age;
	}
	public void setmyFilm(Film[] myFilm){
		this.myFilm = myFilm;
	}
			
	//Getters
	public String getname(){
		return this.name;
	}
	public String getaddress(){
		return this.address;
	}
	public int getage(){
		return this.age;
	}
	public Film[] getmyFilm(){	
		return this.myFilm;
	}
	
	public String toString(){
		String goFirst = getname()+" who´s " +getage()+" lives in "+getaddress() + "\n";
		
		for(int i = 0; i < myFilm.length; i++){
			Film temp = myFilm[i];
			
			if(temp != null)
				goFirst += temp.toString();
		}
		
		return 	goFirst;	
	}
	
	void print(){
		System.out.println(this.toString());
	}
	
}
