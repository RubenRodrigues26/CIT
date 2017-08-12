package Q1;
/**
 * Write a description of class TestObjectList here.
 * 
 * @Author (Ruben Rodrigues) 
 * @ID (R00144165)
 */
public class TestObjectList
{
   public static void main(String[] args)
   {
       ObjectList ol = new ObjectList(3);//Declare and allocate a ObjectList object (ol) into the ArrayList position 4
       
       String s = "Im Happy";//Creating a String (s) and and giving it the value "Im Happy"
       Dog d = new Dog();//Declare and allocate a Dog object (d)
       DVD v = new DVD();//Declare and allocate a DVD object (v)
       Integer i = 1234;//Creating a Integer (i) and gives it the value 1234
       
       System.out.println(ol.add(s));//Adds the value of the String (s) into the object (ol) ArrayList and print to the console true for successful add
       System.out.println(ol.add(d));//Adds whatever is in the Dog constructor to the ArrayList and print to the console true for successful add
       System.out.println(ol.add(v));//Adds whatever is in the DVD constructor to the ArrayList and print to the console true for successful add
       System.out.println(ol.add(i));//Adds and Outputs the value of the Integer (i) in the object (ol) ArrayList and print to the console true for successful add
       
       ol.remove(0);//Removing whatever input is in position 1 of the ArrayList 
       System.out.println(ol.add(i));//Adds and Outputs the value of the Integer (i) in the object (ol) ArrayList position 4 and print to the console true for successful add
       
       
       System.out.println("Is the list full? "+ ol.isFull()); //Output of the console if the list is full or not calling the method isFull()
       System.out.println("Is the list empty? "+ ol.isEmpty());//Output of the console if the list is full or not calling the method isEmpty()
       
       System.out.println("Total number of objects in the list: " + ol.getTotal());//Output of the list checking the total number of objects in it calling the method getTotal()
       
       Object g = ol.getObject(0);//Declare and allocate a ObjectList object (g) 
       ((Dog) g).bark();//Using the object g to call the method back() form the class Dog
       
   }
}
