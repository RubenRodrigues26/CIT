
public class Q4 {

	public static void main(String[] args) {
		
		verse1();
		verse2();
		verse3();
		verse4();
		verse5();
		verse6();
		}
		public static void verse1()
		{
			System.out.println("There was an old woman who swallowed a fly.");
		text1();
		}
		public static void verse2()
		{
			System.out.println("There was an old woman who swallowed a spider,");
			System.out.println("That wriggled and iggled and jiggled inside her.");
			text2();
			text1();
		}
		public static void verse3()
		{
			System.out.println("There was an old woman who swallowed a bird,");
			System.out.println("How absurd to swallow a bird.");
			text3();
			text1();
		}
		public static void verse4()
		{
			System.out.println("There was an old woman who swallowed a cat,");
			System.out.println("Imagine that to swallow a cat.");
			text4();
			text1();
		}
		
		public static void verse5()
		{
			System.out.println("There was an old woman who swallowed a dog,");
			System.out.println("What a hog to swallow a dog.");
			text5();
			text1();
		}
		
		public static void verse6()
		{
			System.out.println("There was an old woman who swallowed a horse,");
			System.out.println("She died of course.");
		}	
		public static void text1()
		{
			System.out.println("I dont know why she swallowed that fly,");
			System.out.println("Perhaps she will die.");
			System.out.println("");
		}
		public static void text2()
		{
			System.out.println("She swallowed the dog to catch the cat,");
		}
		public static void text3()
		{
			text2();
			System.out.println("She swallowed the cat to catch the bird,");
		}
		public static void text4()
		{	
			text3();
			System.out.println("She swallowed the bird to catch the spider,");
		}
		public static void text5()
		{
			text4();
			System.out.println("She swallowed the spider to catch the fly,");
		
		
		
	}

}
