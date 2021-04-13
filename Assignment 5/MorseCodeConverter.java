import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Frank Choukouali
 *
 */
public class MorseCodeConverter {
	public static MorseCodeTree morseCodeTree = new MorseCodeTree();
	
	public static String printTree() {
		String result="";
		for(String elmt: morseCodeTree.toArrayList()) {
			result+=elmt+" ";
		}
		return result;
	}

	/**
	 * Converts Morse code into English.
	 * @param code
	 * @return
	 */
	public static String convertToEnglish(String code) {
		String result="";
		String[] codes = code.split("/");
		String letters[];
		for(int j=0;j<codes.length;j++) {
			letters = codes[j].split(" ");
			for(int i=0;i<letters.length;i++) {
				result += morseCodeTree.fetch(letters[i]);
			}
			result+=" ";
		}
		return result.trim();
	}
	
	/**
	 *  Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * @param codeFile
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		 String data="";
	    try {
	        Scanner myReader = new Scanner(codeFile);
	        while (myReader.hasNextLine()) {
	           data += myReader.nextLine();
	        }
	       return convertToEnglish(data);
	      } catch (FileNotFoundException e) {
	    	  throw new FileNotFoundException();
	      }
	}
}
