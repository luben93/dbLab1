package controller;

public class Music {
	private String artist, album, genre, rating, review;

	public Music() {
		System.out.println("just smile and wave boys :)");
	}

	public Music(String artist, String album, String genre, String rating,
			String review) {
		this.album = album;
		this.artist = artist;
		this.genre = genre;
		this.rating = rating;
		this.review = review;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setArtis(String artist) {
		this.artist = artist;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setReview(String reivew) {
		this.review = review;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}

	public String getGenre() {
		return genre;
	}

	public String getRating() {
		return rating;
	}

	public String getreview() {
		return review;
	}

	public String toString() {
		String out = null;
		out = album + " " + artist + " " + genre + " " + rating + " " + review;
		return out;
	}
	
	public String[] getArray(){
		String[] temp =new String[5];
		//for(int i=0;i<5;i++){
			temp[0]=album;
			temp[1]=artist;
			temp[2]=genre;
			temp[3]=rating;
			temp[4]=review;
		//}
		
		return temp;
	}

}
