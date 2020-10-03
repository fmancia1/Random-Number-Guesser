import java.util.Scanner;

public class RandomNumberGuesser {
	static Scanner in;
  	static int lowerLimit, upperLimit;
  	static int numberOfGuesses;
  	static int number;
  
	public RandomNumberGuesser(){
		in = new Scanner(System.in);
      	lowerLimit = 1;
      	upperLimit = 100;
      	numberOfGuesses = 0;
      	number = RNG.rand();
	}
  	
  	public static void compareGuess(int guessed) {
      	numberOfGuesses = numberOfGuesses + 1;
      	System.out.println("Number of guesses is " + numberOfGuesses);
     	if (guessed < number) {
        	LowGuess(guessed);
        }
      	else if (guessed == number) {
        	System.out.println("Congratulations, you guessed correctly");
          	System.out.println("Try again? (yes or no)");
          	String answer = in.nextLine();
          if(answer.equals("yes")){
        	  lowerLimit = 1;
        	  upperLimit = 100;
        	  numberOfGuesses = 0;
        	  number = RNG.rand();
        	  printHeader();
          }
          else{
            System.out.println("Thanks for playing...");
            System.out.println("Programmer's name: Fatima Mancia"); 
            System.exit(0);
          }
        }
      	else {
            HighGuess(guessed); 
        }
    }
  	
  	public static void printHeader() {
		System.out.println("Random Number Guesser");
		System.out.println("Write a number between 1 and 100");
      	FirstGuess();
	}
  
    public static void FirstGuess() {
      	System.out.println("Enter your first guest:");
    	String answer = in.nextLine();
      	int guessed = Integer.parseInt(answer);
		compareGuess(guessed);
    }
  
  	public static void printLimits() {
     	System.out.println("Enter your next guess between " + String.valueOf(lowerLimit) + " and " +  String.valueOf(upperLimit));
    }
  
  	public static void HighGuess(int guessed) { 
      upperLimit = guessed;
      System.out.println("Your answer is too high");
      printLimits();
      String answer = in.nextLine();
      int guessed1 = Integer.parseInt(answer);
	  compareGuess(guessed1);
    }
  
    public static void LowGuess(int guessed){
        lowerLimit = guessed;
        System.out.println("Your answer is too low");
      	printLimits();
      String answer = in.nextLine();
      int guessed2 = Integer.parseInt(answer);
      compareGuess(guessed2);
    }
  	public static void main(String[]  args) {
  		RandomNumberGuesser r = new RandomNumberGuesser();
  		r.printHeader(); 
    }
}