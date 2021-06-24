package bibleBeans;



public class BibleObject {
	
	String bibleName = "The Holy Bible";
	
	BookObject[] differentBooksInBible;
	
	public BibleObject () {
		
	}
	
	public BibleObject (String bibleName, BookObject[] differentBooksInBible) {
		
		this.bibleName = bibleName;
		this.differentBooksInBible = differentBooksInBible;
		
	}

	public String getBibleName() {
		return bibleName;
	}

	public void setBibleName(String bibleName) {
		this.bibleName = bibleName;
	}

	public BookObject[] getDifferentBooksInBible() {
		return differentBooksInBible;
	}

	public void setDifferentBooksInBible(BookObject[] differentBooksInBible) {
		this.differentBooksInBible = differentBooksInBible;
	}

	
	
	

}
