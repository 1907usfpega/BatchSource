/**
 * 
 */
package question18;

/**
 * @author Deonta Kilpatrick
 * implements the methods from the abstract class stringmanipulation
 */
public class Strings extends StringManipulation {

	//taking the long way by going through each character and returning true if any of them is a uppercase letter
	@Override
	public boolean anyUppercase(String word) {
		for(int i = 0; i < word.length(); i++) {
			switch(word.charAt(i)) {
			case 'A': return true;
			case 'B': return true;
			case 'C': return true;
			case 'D': return true;
			case 'E': return true;
			case 'F': return true;
			case 'G': return true;
			case 'H': return true;
			case 'I': return true;
			case 'J': return true;
			case 'K': return true;
			case 'L': return true;
			case 'M': return true;
			case 'N': return true;
			case 'O': return true;
			case 'P': return true;
			case 'Q': return true;
			case 'R': return true;
			case 'S': return true;
			case 'T': return true;
			case 'U': return true;
			case 'V': return true;
			case 'W': return true;
			case 'X': return true;
			case 'Y': return true;
			case 'Z': return true;
			}
		}
		return false;
	}

	//took the short way; just utilized to toUppercase method for strings
	@Override
	public String toUppercase(String word) {
		/*for(int i = 0; i < word.length(); i++) {
			switch(word.charAt(i)) {
			case 'a': 
					word.replace('a', 'A');
			case 'b': word.replace('b', 'B');
			case 'c': word.replace('c', 'C');
			break;
			case 'd': word.replace('d', 'D');
			break;
			case 'e': word.replace('e', 'E');
			case 'f': word.replace('f', 'F');
			case 'g': word.replace('g', 'G');

			case 'h': word.replace('h', 'H');
			
			case 'i': word.replace('i', 'I');
			
			case 'j': word.replace('j', 'J');
			
			case 'k': word.replace('k', 'K');
			
			case 'l': word.replace('l', 'L');
		
			case 'm': word.replace('m', 'M');
			
			case 'n': word.replace('n', 'N');
		
			case 'o': word.replace('o', 'O');
			
			case 'p': word.replace('p', 'P');
	
			case 'q': word.replace('q', 'Q');
		
			case 'r': word.replace('r', 'R');
		
			case 's': word.replace('s', 'S');
			
			case 't': word.replace('t', 'T');
		
			case 'u': word.replace('u', 'U');
		
			case 'v': word.replace('v', 'V');
	
			case 'w': word.replace('w', 'W');
		
			case 'x': word.replace('x', 'X');
		
			case 'y': word.replace('y', 'Y');
		
			case 'z': word.replace('z', 'Z');
			
			}
		}
		return word;*/
		return word.toUpperCase();
	}
	
	//parses the string into a number adds 10 prints value
	@Override
	public void addTen(String num) {
		System.out.println((Integer.parseInt(num) + 10));
	}
}
