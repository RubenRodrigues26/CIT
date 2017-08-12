
public class DVD {

	private String Title;
	private String Genre;
	private String Artist;
	
	public DVD(String Title, String Genre, String Artist){
		setTitle(Title);
		setGenre(Genre);
		setArtist(Artist);
		}
	
	public DVD(){	
		
		}

	// Setters
	public void setTitle(String Title){
		this.Title = Title;
	}
		
	public void setGenre(String Genre){
		this.Genre = Genre;
	}
		
	public void setArtist(String Artist){
		this.Artist = Artist;
	}
		
	//Getters
	public String getTitle(){
		return this.Title;
	}
	public String getGenre(){
		return this.Genre;
	}
	public String getArtist(){
		return this.Artist;
	}	
	
	void print(){
		System.out.println(this.Title+this.Genre+this.Artist);
	}
}
