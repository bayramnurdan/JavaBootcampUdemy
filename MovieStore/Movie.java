package models;

public class Movie {
	private String name;
	private String format;
	private double rating;
	private double sellingPrice;
	private double rentalPrice;
	private boolean isAvailable;
	
	public Movie(String name, String format,double rating) {
		if (name==null || name.isBlank()) {
			throw new IllegalArgumentException("Name of movie can't be null or blank.");
		}
		if (!(format.equalsIgnoreCase("DVD") ||format.equalsIgnoreCase("Blue-Ray"))) {
			throw new IllegalArgumentException("Format of movie must be DVD or Blue-Ray.");	
		}
		if (rating<0  || rating>10) {
			throw new IllegalArgumentException("Rating must be in range 0-10");
		}
		this.name = name;
		this.format = format;
		this.rating = rating;
		this.isAvailable =true;
	}
	
	public Movie(Movie movie) {   //copy constructor
		this.name = movie.name;
		this.format = movie.format;
		this.rating = movie.rating;
		this.isAvailable =movie.isAvailable;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if (name==null || name.isBlank()) {
			throw new IllegalArgumentException("Name of movie can't be null or blank.");
		}
		this.name = name;
	}
	public String getFormat() {
		return this.format;
	}
	public void setFormat(String format) {
		if (!(format.equalsIgnoreCase("DVD") && format.equalsIgnoreCase("Blue-Ray"))) {
			throw new IllegalArgumentException("Format of movie must be DVD or Blue-Ray.");	
		}
		this.format = format;
	}
	
	public double getRating() {
		return this.rating;
	}
	
	private void setRating(double rating) {
		if (rating<0  || rating>10) {
			throw new IllegalArgumentException("Rating must be in range 0-10");
		}
		this.rating = rating;
	}
	
	public double getSellingPrice() {
		return this.sellingPrice;
	}
	private void setSellingPrice(double price) {
		this.sellingPrice = price;
	}
	
	public double getRentalPrice() {
		return this.rentalPrice;
	}
	private void setRentalPrice(double price) {
		this.rentalPrice = price;
	}
	
	public boolean isAvaliable() {
		return this.isAvailable;
	}
	public void setAvaliable(boolean availability) {
		this.isAvailable =availability;
	}
	
	public String toString() {
		return "\t Name: " + this.name + "\n" +
				"\t Format: " + this.format + "\n" +
				"\t Rating: " + this.rating + "\n" +
				"\t Selling Price: " + this.sellingPrice + "\n" +
				"\t Rental Price: " + this.rentalPrice + "\n" +
				"\t Availability: " + (this.isAvailable ? "in stock" : "rented") + "\n";
	}
	
}
