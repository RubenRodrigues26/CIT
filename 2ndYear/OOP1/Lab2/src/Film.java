public class Film {


	public String name;
	public String code; 

	Film(String name){
		setname(name);
		code = this.getInitials(name);
		
	}
	private String getInitials(String name){
		
		
		String[] parts = name.split(" ");
		String initials = "";
		
		for(int i = 0; i < parts.length; i++){
			String temp =parts[i]; 
			initials+=temp.charAt(0);
		}
		
		return initials;
	}

	public void setname(String name){
		this.name = name;
	}
			
	public void setcode(String code){
		this.code = code;
	}
			
	//Getters
	public String getname(){
		return this.name;
	}
	public String getcode(){
		return this.code;
	}
	public String toString(){
		return getname() + " - " + getcode() + "\n";
	}
	
	void print(){
		System.out.println(this.toString());
	}
}
	