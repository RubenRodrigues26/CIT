import java.util.Scanner;

public class Menu {

	private Scanner in;
	private int choice;
	private LecturerList lecturerList;
	private BookList listOfBooks;

	public Menu() {
		// instantiate our list object
		lecturerList = new LecturerList();
		listOfBooks = new BookList();
	}

	// starts out system
	// shows the home menu
	// instantiates our scanner object
	public void start() {
		in = new Scanner(System.in);
		showHomeMenu();
	}
	
	// display the home menu
	public void showHomeMenu() {
		clearScreen();
		do {
			System.out.println("Welcome to LEcturer System");
			System.out.println("Please select from the following");
			System.out.println("====================================");
			System.out.println("1: Add new Lecturer");
			System.out.println("2: Search Lecturer by ID");
			System.out.println("3: Add new book");
			System.out.println("4: Remove book");
			System.out.println("5: Exit\n");
			this.choice = in.nextInt();
		} while (choice < 1 && choice > 5);
		handleHomeMenuChoice();
	}

	// handling the user selection on the home menu
	public void handleHomeMenuChoice() {
		switch (this.choice) {
		case 1:
			enterNewLecturer();
			break;
		case 2:
			;
			break;
		case 3:
			enterNewBook();
			break;
		case 4:
			enterBookTitleForRemoval();
			break;
		case 5:
			endProgram();
			break;
		}
	}
	
	
	public void enterNewLecturer() {
		clearScreen();
		// input variables
		String name;
		int ID;

		// Adding Lecturer
		Lecturer emp;
		do {
			clearScreen();
			System.out.print("Lecturer's Name? ");
			name = in.nextLine();
		} while (name.equals(""));

		do {
			clearScreen();
			System.out.print("ID number? ");
			ID = in.nextInt();
		} while (ID < 0 && ID > 1000000);

		emp = new Lecturer(name, ID);

		lecturerList.add(emp);
		
		do {
			clearScreen();
			System.out.print("Lecturer Added. Hit 1 to return to main menu! ");
			this.choice = in.nextInt();
		} while (this.choice != 1);
		showHomeMenu();// getting to this stage we have successfully added a new lecturer
						
	}
	
	
	public void enterNewBook() {
		clearScreen();
		// input variables
		String title;
		int ISBN;
		String author;
		double price;

		// Adding Book
		Book emp;
		do {
			clearScreen();
			System.out.print("Book title? ");
			title = in.nextLine();
		} while (title.equals(""));
		
		do {
			clearScreen();
			System.out.print("Book author? ");
			author = in.nextLine();
		} while (author.equals(""));

		do {
			clearScreen();
			System.out.print("ISBN? ");
			ISBN = in.nextInt();
		} while (ISBN < 0 && ISBN > 1000000);
		
		do {
			clearScreen();
			System.out.print("Price? ");
			price = in.nextDouble();
		} while (price < 0 && price > 1000000);

		emp = new Book(title, ISBN, author, price);

		listOfBooks.addBook(emp);
		
		do {
			clearScreen();
			System.out.print("Book Added. Hit 1 to return to main menu! ");
			this.choice = in.nextInt();
		} while (this.choice != 1);
		showHomeMenu();// getting to this stage we have successfully added a new book
						
	}
	
	// show screen to enter title book for removal
			public void enterBookTitleForRemoval() {
				clearScreen();
				String title = "";
				
				do {
					System.out.println("Please enter book title for removal\n");
					title = in.next();
				} while (title.equals("") || title.equals(" "));
				boolean removeSuccessful = listOfBooks.removeBook(listOfBooks.findBookByTitle(title));

				if (removeSuccessful) {
					showSuccessMessage();
				} else {
					showNotFoundMessage();
				}
			}

			// display successful search message
			public void showSuccessMessage() {
				do {
					System.out.println("Book removed successfully!");
					System.out.println("Hit 1 to return to main menu!");
					this.choice = in.nextInt();
				} while (choice != 1);
				showHomeMenu();
			}

			// display unsuccessful search message
			public void showNotFoundMessage() {
				do {
					System.out.println("Book not removed successfully!");
					System.out.println("Hit 1 to return to main menu!");
					this.choice = in.nextInt();
				} while (choice != 1);
				showHomeMenu();
			}
	
	public void clearScreen() {
		for (int i = 0; i < 50; i++)
			System.out.println("");
	}
	
	// display end message and exit
	public void endProgram() {
		clearScreen();
		System.out.println("Thank you for using the system!!\n Godbye!!!");
		System.exit(0);
	}
}
