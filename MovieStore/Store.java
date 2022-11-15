package models;

import java.util.ArrayList;

public class Store {
	private ArrayList <Movie> movies;
	
	public Store() {
		 this.movies = new ArrayList<Movie>();
	}
	
	
	public Movie getMovie(int index) {
		return new Movie(movies.get(index));
	}
	
	public Movie getMovie(String movieName) {
		for (int i=0; i<this.movies.size(); i++) {
			if (this.movies.get(i).getName().equalsIgnoreCase(movieName)) {
				return  new Movie(movies.get(i));
			}
		}
		return null;
	}
	
	
	public void setMovie(int index, Movie movie) {
		this.movies.set(index, new Movie(movie));
	}
	
	public void addMovie(Movie movie) {
		this.movies.add(new Movie(movie));
		
	}
	public void sellMovie(String movieName) {
		if (this.movies.isEmpty()){
			throw new IllegalStateException("The store is empty.");
		}
		
		
		for (int i = 0; i<this.movies.size(); i++) {
			if (movies.get(i).getName().equalsIgnoreCase(movieName)){
				if (movies.get(i).isAvaliable()==false ) {
					throw new IllegalStateException("Cannot sell movie that was rented out");
				}else {
				this.movies.remove(i);
				System.out.println(movieName + " is sold.\n\n");
			}
				
			}
			}
		}
	
	
	public void rentMovie(String movieName) {
		if (this.movies.isEmpty()){
			throw new IllegalStateException("The store is empty.");
		}
		for (int i = 0; i<this.movies.size(); i++) {
			if (movies.get(i).getName().equalsIgnoreCase(movieName)) {
				this.movies.get(i).setAvaliable(false);
				System.out.println(movieName + " is rented.\n\n");
			}
		}
	}
	public void returnMovie(String movieName) {
		for (int i = 0; i<this.movies.size(); i++) {
			if (movies.get(i).getName().equalsIgnoreCase(movieName)) {
				this.movies.get(i).setAvaliable(true);
				System.out.println(movieName + " is returned.\n\n");
			}
		}
		

	}
	public String toString() {
		String temp = "";
		for (int i = 0; i<this.movies.size(); i++) {
			temp += this.movies.get(i).toString() + "\n\n";
		}
		return temp;
	}
	

}
