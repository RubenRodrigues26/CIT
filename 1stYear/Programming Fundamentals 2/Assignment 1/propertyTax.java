import java.util.Scanner;
import java.text.DecimalFormat;

public class propertyTax {

	public static final int TERRACE = 800;
	public static final int SEMI_DETACHED = 900;
	public static final int DETACHED = 1000;
	public static final int BEDROOM = 100;
	public static final double URBAN_HOUSE = 1.25;
	public static final double INICIAL_CALCULE = 0.15;
	private static DecimalFormat df = new DecimalFormat(".00");//Giving the values two decimal places
	public static void main(String[] args) {

		//Initiate variables & keyboard
		Scanner input = new Scanner(System.in);
		int bedroomNumber;
		int numberProperties;
		int maxPropertyTaxNumber =0;
		int minPropertyTaxNumber =0;
		double propertySize = 0;
		double propertyInformation = 0;
		double calculatedSize;
		double calculatedTaxes =0;
		double totalPropertyTax = 0;
		double averagePropertyTax = 0;
		double maxPropertyTax = 0;
		double minPropertyTax = Double.MAX_VALUE;
		char houseSize;
		String size;
		String type;

		//Asking for information and saving into the inputs
		System.out.print("Number of Properties:");
		numberProperties = input.nextInt();
		System.out.println(" ");
		//Use a "for loop" in case there is more then 1 property
		for (int i = 1; i <= numberProperties; i++)
		{
			System.out.print("Property "+i+":Number of bedrooms?");
			bedroomNumber = input.nextInt();
			System.out.print("Property "+i+":Terraced, Semi-detached or Detached (T/S/D)?");
			size = input.next();
			houseSize = size.charAt(0);//Selecting the first character they type
			houseSize = Character.toUpperCase(houseSize);//Putting that first character to upper case
			//Storing the different houses square feet informations into the variable 
			if(houseSize == 'T')
			{
				propertySize = TERRACE;
			}
			else if (houseSize == 'S')
			{
				propertySize = SEMI_DETACHED;
			}
			else if (houseSize == 'D')
			{
				propertySize = DETACHED;
			}
			else{
				System.out.println("Please select one of the Letters.");
			} 
			//Asking for information and saving into the inputs
			System.out.print("Property "+i+":Urban or Rural (U/R)?");
			type = input.next();
			houseSize = type.charAt(0);
			houseSize = Character.toUpperCase(houseSize);
			//Storing the informations into the variable in case it will be a Urban house
			if(houseSize == 'U')
			{
				propertyInformation = URBAN_HOUSE;
			}
			else if (houseSize == 'R')
			{
				propertyInformation = 1;
			}
			else
			{
				System.out.println("Please select one of the Letters.");
			} 

			//Calling the two methods storing the total square feet and tax price in each veriable
			calculatedSize=calculateSize( propertySize, bedroomNumber);
			calculatedTaxes=calculatePropertyTax( propertyInformation, calculatedSize );

			System.out.println(" ");
			System.out.println("Property "+i+":Property tax is \u20ac"+df.format(calculatedTaxes));
			System.out.println(" ");

			//Storing the informations into the variables for the maximum and minimum property taxes and their number
			if(maxPropertyTax<calculatedTaxes)
			{
				maxPropertyTax=calculatedTaxes;
				maxPropertyTaxNumber=i;
			}
			if(calculatedTaxes<minPropertyTax)
			{
				minPropertyTax=calculatedTaxes;
				minPropertyTaxNumber=i;
			}
			totalPropertyTax+=calculatedTaxes;
			averagePropertyTax=totalPropertyTax/2;
		}
		input.close();//Close the scanner to improve performance since the program wont use this anymore

		System.out.println("Higher Property Tax: Property "+maxPropertyTaxNumber+" @ \u20ac"+df.format(maxPropertyTax));
		System.out.println("Lower Property Tax: Property "+minPropertyTaxNumber+" @ \u20ac"+df.format(minPropertyTax));
		System.out.println("Average Property Tax: \u20ac"+df.format(averagePropertyTax));
		System.out.println("Total Property Tax: \u20ac"+df.format(totalPropertyTax));
	}

	//Method to calculate the total of square feet of each house 
	public static double calculateSize(double propertySize, int bedroomNumber)
	{
		return propertySize+(bedroomNumber*BEDROOM);
	}

	// Method to calculate the total tax price for each house  
	public static double calculatePropertyTax(double propertyInformation, double calculatedSize )
	{
		return calculatedSize*INICIAL_CALCULE*propertyInformation;
	}


}