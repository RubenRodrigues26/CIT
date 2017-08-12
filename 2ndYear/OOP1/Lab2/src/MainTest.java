
public class MainTest {

public static void main(String[] args) {
		
		Actor myActor1 = new Actor("Hugo Barona"," Florida", 29);
		Actor myActor2 = new Actor("Ruben Rodrigues","California", 27);
		
		Film m1 = new Film("Wolf" );
		Film m2 = new Film("As good as it gets");
		Film m3 = new Film("One flew over the Cuckoo’s Nest");
		
		Film[] myFilms = new Film[3];
		myFilms[0] = m1;
		myFilms[1] = m2;
		myFilms[2] = m3;
		
		myActor1.setmyFilm(myFilms);
		myActor1.print();
		
		Film m10 = new Film("The american" );
		Film m20 = new Film("Ghost Rider spirit of vengence");
		Film m30 = new Film("Barah Aanan");
		
		myFilms[0] = m10;
		myFilms[1] = m20;
		myFilms[2] = m30;
		
		myActor2.setmyFilm(myFilms);
		myActor2.print();
		
	}

}