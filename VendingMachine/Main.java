import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		 System.out.println("\t************************************************");
	        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
	        System.out.println("\t************************************************\n");
	        
	        Item[][] items = new Item[][] {
	            { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
	             { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
	             { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
	         };
	        
	        Machine machine = new Machine(items);
	        
	        
	        
	        while (true) {
	        	System.out.println(machine);
	        	System.out.println("Pick a row:");
		        int row = scan.hasNextInt() ? scan.nextInt() : 404;
		        scan.nextLine();
		        
		        System.out.println("Pick a spot");
		        
		        int spot =scan.hasNextInt() ? scan.nextInt() : 404 ;
		        scan.nextLine();
		        
		        if (row ==404 || spot ==404) {
		        	System.out.println("INVALID INDEX.\n");
		        	continue;
		        }else if (row<0  || row >=machine.getLenght() || spot<0 ||spot >=machine.getRowLenght()){
		        	System.out.println("INVALID RANGE.\n");
		        	continue;
		        }else if (machine.getItem(row, spot).getQuantity()==0) {
		        	
		        	System.out.println("EMPTY SLOT.\n");
		        }else{
		        	machine.dispense(row, spot);
		        	System.out.println("\nEnjoy your!" + machine.getItem(row, spot).getName());
		        	
		        	

	        	System.out.println("Press 1 to purchase another one: ");
	        	if (scan.nextInt() !=1) {
	        		break;
	        	}
	        	
	        }
	        	
	        	        
	        
	       
	        
	    }

	}
	
		
	}



