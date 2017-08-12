//Includes Part a and b.
public class TestDVD
{
    public static void main(String[] args)
    {
    	
        DVD  dvd1 = new DVD(); //Declare and allocate a DVD object (dvd1)
        dvd1.setTitle("Song Bird "); //Giving the value "Song Bird" trough calling of setTitle()  
        dvd1.setGenre("Blues ");
        dvd1.setArtist("Eva Cassidy ");
        dvd1.print();
          
        DVD dvd2 = new DVD("Johnny B. Goode"," Chuck Berry"," Ruben");
        dvd2.print();//Doesn't know what to print an error will appear
        
    }
  
}
