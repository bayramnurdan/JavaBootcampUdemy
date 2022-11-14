import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
	    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
	    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
	    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
	    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
	    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
	    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
	    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
	    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
	    "wombat", "zebra"};

	    public static String[] gallows = {"+---+\n" +
	    "|   |\n" +
	    "    |\n" +
	    "    |\n" +
	    "    |\n" +
	    "    |\n" +
	    "=========\n",

	    "+---+\n" +
	    "|   |\n" +
	    "O   |\n" +
	    "    |\n" +
	    "    |\n" +
	    "    |\n" +
	    "=========\n",

	    "+---+\n" +
	    "|   |\n" +
	    "O   |\n" +
	    "|   |\n" +
	    "    |\n" +
	    "    |\n" +
	    "=========\n",

	    " +---+\n" +
	    " |   |\n" +
	    " O   |\n" +
	    "/|   |\n" +
	    "     |\n" +
	    "     |\n" +
	    " =========\n",

	    " +---+\n" +
	    " |   |\n" +
	    " O   |\n" +
	    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
	    "     |\n" +
	    "     |\n" +
	    " =========\n",

	    " +---+\n" +
	    " |   |\n" +
	    " O   |\n" +
	    "/|\\  |\n" +
	    "/    |\n" +
	    "     |\n" +
	    " =========\n",

	    " +---+\n" +
	    " |   |\n" +
	    " O   |\n" +
	    "/|\\  |\n" + 
	    "/ \\  |\n" +
	    "     |\n" +
	    " =========\n"};

	    public static void main(String[] args) {
	    	Scanner scan = new Scanner(System.in);
	    	String randomWord = words[(int) (Math.random()*words.length)];
	    	char []  placeHolder = new char[randomWord.length()];
	    	boolean userWins=false;
	    	
	    	for (int i=0; i<randomWord.length(); i++) {
	    		placeHolder[i] = '-';
	    	}
	    	boolean gameEnds = false;
	    	int numberOfMisses =0;
    		String misses= "";
	    	System.out.println(randomWord);
	    	
	    	while(! gameEnds) {
	    		boolean correctGuess= false;
	    		if (Arrays.equals(placeHolder, randomWord.toCharArray())) {
	    			System.out.println(randomWord + "\n");
	    			System.out.println("Great Work!!!!!!!!!!!");
	    			break;
	    		}
	    		System.out.println(gallows[numberOfMisses]);
	    		if(misses.length()==6) {
	    			System.out.println("RIP...\n");
	    			System.out.println("The word was: " + randomWord);
	    			break;
	    		}
	    		
	    		System.out.print("Word:  ");
	    		
	    		for (int i=0;i<randomWord.length(); i++) {   //print the placeholder
	    			System.out.print(placeHolder[i] + "  ");
	    				
	    			}
	    		
	    		
	    		System.out.println("\n");
	    		System.out.println("Misses:" + misses + "\n");
	    		
	    		System.out.println("Make a guess: ");
	    		char userGuess = scan.next().charAt(0);  //take the user's guess
	    		
	    		for (int i=0; i<randomWord.length(); i++) {    //check if char in word
	    			if (randomWord.charAt(i) == userGuess) {
	    				placeHolder[i] = userGuess;
	    				correctGuess =true;
	    			}
	    		}
	    		if (!correctGuess) {   
	    			numberOfMisses ++;
	    			misses += userGuess;
	    		}
	    		
	    		
	    		
	    		
	    		
	    			
	    		}
	    }

	}







