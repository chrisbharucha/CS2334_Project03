
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	private static final int NUM_LETTERS = 26; //number of letters in alphabet
	private int[] ascii = new int[NUM_LETTERS]; //array that contains the ASCII values of letters
	private char[] letters; //array that contains all of the letters
	public static int average;
	private String stID; //the station ID that all the calculations will be done on
	
	public MesoAsciiCal(MesoStation stID) {
		//initializing local variables
		this.stID = stID.getStID();
		int startingVal = 65; //starting ASCII value
		for (int i = 0; i < ascii.length; ++i) { //using a for loop to fill in the ASCII values
			ascii[i] = startingVal++;
		}
		letters = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M', //filling the letters array
							'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
   }
   
   public int calAverage() {
	   char c1 = stID.charAt(0);
	   char c2 = stID.charAt(1);
	   char c3 = stID.charAt(2);
	   char c4 = stID.charAt(3);
	   double ascii1 = 0.0, ascii2 = 0.0, ascii3 = 0.0, ascii4 = 0.0; //variable to store all ASCII values in
		
	   for(int i = 0; i < ascii.length; ++i) { //this for loop finds all of the ASCII values for each char
		   int asciiVal = ascii[i];
		   char cTest = letters[i];
		   if (c1 == cTest) { //finds c1's ASCII if true
			   ascii1 = asciiVal;
		   }
		   if (c2 == cTest) { //finds c2's ASCII if true
			   ascii2 = asciiVal;
		   }
		   if (c3 == cTest) { //finds c3's ASCII if true
			   ascii3 = asciiVal;
		   }
		   if (c4 == cTest) { //finds c4's ASCII if true
			   ascii4 = asciiVal;
		   }
		}
	   double avg = (ascii1 + ascii2 + ascii3 + ascii4) / 4.0; //using 4.0 so that the ASCII values get casted to a double
	   /*
		* testing whether the decimal is less than or greater than 0.5 in order to apply the correct function
		*/
	   if ((avg - (int)avg) >= 0.25) {	
		   average = (int)Math.ceil(avg);
		   return average;
	   }
	   else {
		   average = (int)Math.floor(avg);
		   return average;
	   }
   }
}
