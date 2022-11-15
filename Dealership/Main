import java.util.Scanner;

import models.Car;
import models.Dealership;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        Car[] cars = new Car[] {
            new Car(" ford   ", 5000),
            new Car("  nissan  ", 12000),
        };
        cars[1].setMake("bmv");
        cars[1].setPrice(8500);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            System.out.println(dealership);
            System.out.print("Enter the spot number of the car you want to buy: ");
            if (!scan.hasNextInt()) {   //if response is not an integer break the loop and ask for another input
                scan.nextLine();
                System.out.println("INVALID INPUT.");
                continue;
            }
            int spot = scan.nextInt();
            scan.nextLine();
            
            if (spot>= dealership.getLength()  || spot<0) {
            	System.out.println("Please choose a valid parking spot.");
            	
            }else if  (dealership.getCar(spot)== null) {
            	System.out.println("EMPTY SPOT.");    
                continue;
                }else {
                	dealership.sell(spot);
                	
                }
            if (dealership.isEmpty()) {
            	System.out.println("We are all sold out.");
            	break;
            }else {
            	System.out.println("Type yes to to continue:");
            	String moveOn=scan.next();
            	if (! moveOn.equalsIgnoreCase("yes")) {
            		break;	
            	
            	}
            }
            
            
            	
            	
            	
            
                
        }

       scan.close();

    }
}
