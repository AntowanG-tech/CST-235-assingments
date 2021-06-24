package bibleBeans;



public class BookObject  {
	
	String bookName;
	Chapter chapter;
	
	public BookObject () {
		
	}
	
	public BookObject (String bookName, Chapter chapter) {
		
		this.bookName = bookName;
		this.chapter = chapter;
		
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	
	

}
