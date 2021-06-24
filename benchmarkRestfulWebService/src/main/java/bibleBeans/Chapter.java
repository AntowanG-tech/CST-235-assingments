package bibleBeans;

public class Chapter {
	
      int chapterNo;
      Verse verse;
      
      public Chapter () {
    	  
      }
      
      public Chapter (int chapterNo, Verse verse) {
    	  
    	  this.chapterNo = chapterNo;
    	  this.verse = verse;
    	  
      }

	public int getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(int chapterNo) {
		this.chapterNo = chapterNo;
	}

	public Verse getVerse() {
		return verse;
	}

	public void setVerse(Verse verse) {
		this.verse = verse;
	}
      
      

}
