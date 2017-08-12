
public class Q5 {

	public static void main(String[] args) {
		
		figure1();
		System.out.println("\n\n");
		figure2();
		System.out.println("\n\n");
		figure3();
	}
		public static void figure1(){
			doubleLine();
			x();
		}
		public static void figure2(){
			starsLine();
			xUp();
			doubleLine();
		}
		public static void figure3(){
			star3nline();
			xUp();
		}	
		public static void x(){
			twoStars();
			oneStar();
			twoStars();
		}
		public static void xUp(){
			starsLine();
			twoStars();
			oneStar();
			twoStars();
		}
		public static void xDown()
		{
			twoStars();
			oneStar();
			twoStars();
			starsLine();
		}
		public static void twoLines(){
			starsLine();
			starsLine();
		}	
		public static void doubleLine()
		{
			starsLine();
			starsLine();
		}
		public static void star3nline(){
			oneStar();
			oneStar();
			oneStar();
			starsLine();	
		}
		public static void starsLine(){
			System.out.println("*****");
		}
		public static void twoStars(){
			System.out.println(" * * ");
		}
		public static void oneStar(){
			System.out.println("  *  ");
		

	}

}
