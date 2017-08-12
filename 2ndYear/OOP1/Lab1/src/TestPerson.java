

public class TestPerson {

	public static void main(String[] args) {
		
		Person p = new Person(10, "Iphone", "Ruben");
		
		p.jump();
		
		p.jump(10);
			
		System.out.print(p.getName()+" ");
		System.out.print(p.getPhone()+" ");
		System.out.println(p.getStars());

		p.setName("David");
		p.setPhone("Android");
		p.setStars(20);
		
		System.out.print("Name:"+p.getName()+" ");
		System.out.print("Phone:"+p.getPhone()+" ");
		System.out.println("Stars:"+p.getStars());
		
		
		//System.out.println(p.toString());
		
		p.print();
				
				
	}

}