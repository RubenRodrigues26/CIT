
public class Q6 {

	public static void main(String[] args) {
		
		shuttle();
	}
		
		public static void head()
		{
			System.out.println("   /\\\n"+
							"  /  \\\n"+
							" /    \\\n"+
							"/      \\");
		}
		public static void connection()
		{
			System.out.println("#------#");
		}
		public static void sides()
		{	
			System.out.println("-      -\n"+
								"-      -\n"+
								"-      -");
		}
		public static void bottom()
		{
			System.out.println("  //\\\\\n"+
								" //  \\\\\n"+
								"//    \\\\\n");
		}
		public static void shuttle()
		{
			head();
			connection();
			sides();
			connection();
			sides();
			connection();
			sides();
			connection();
			bottom();
	}

}
