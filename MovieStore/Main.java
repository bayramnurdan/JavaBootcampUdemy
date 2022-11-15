import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

      Store store = new Store();
      try {
    	  
      loadMovies("/Users/nurdanemin/Desktop/movies.txt", store);
      System.out.println("MOVIES LOADED\n\n");
      manageMovies(store);
      
    }catch ( FileNotFoundException e) {
    	
    	System.out.println(e.getMessage());
    }finally {
   
    	System.out.println("Process Complete");
    } 
      }
    
    public static void  manageMovies(Store store) {
    	Scanner scan = new Scanner(System.in);
    	while (true) {
    		System.out.println(store);
    		System.out.print("\nWould you like to \n\t"
    				+ "a) purchase \n\t"
    				+ "b) rent \n\t"
    				+ "c) return ");
    		String userResponse = scan.nextLine();
    		if (userResponse.equals("a")) {
    			
    			
    			System.out.println("Movie name you want to purchase");
    			String movieName= scan.nextLine();
    			
    			if (movieName.isBlank()) {
    				System.out.println("\nThe input you provided is not valid. Please try again\n");
    				continue;
    				}
    			
    			store.sellMovie(movieName);
    			
    			
    		}else if (userResponse.equals("b")) {
    			
    			
    			System.out.println("Movie name you want to rent");
    			String movieName= scan.nextLine();
    			
    			if (movieName.isBlank()) {
    				System.out.println("\nThe input you provided is not valid. Please try again\n");
    				continue;
    				}
    			if (store.getMovie(movieName).isAvaliable()) {
    				store.rentMovie(movieName);
    			}else {
    				System.out.println("\nThe movie is not available for purchase. Please try again\n");
    				continue;
    			}
    			
    		}else if (userResponse.equals("c")) {
    			
    			System.out.println("Movie name you want to return");
    			String movieName= scan.nextLine();
    			if (movieName.isBlank()) {
    				System.out.println("\nThe input you provided is not valid. Please try again\n");
    				continue;
    				}
    			store.returnMovie(movieName);
    		}else {
    			break;
    		}
    	}
    }

    public static void loadMovies(String fileName, Store store) throws FileNotFoundException {
    	FileInputStream fis = new FileInputStream(fileName);
    	Scanner scan = new Scanner(fis);
    	while(scan.hasNextLine()) {
    		String[] line = scan.nextLine().split("--");
    		Movie movie = new Movie(line[0], line[1], Double.parseDouble(line[2]));   //use wrapper class of double tobe able to use parse func
    		store.addMovie(movie);
    	}
    }
    
}
