package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		LLStack<Character> stack = new LLStack<Character>(); 
		for (int i=0; i < s.length(); i++) { 
			char c = s.charAt(i);
			if (Character.isLetter(c))
				if (Character.isUpperCase(c))
					stack.push(c);
				else if(stack.isEmpty())
					return false;
				else{
					char t = stack.top();
					 if (t == Character.toUpperCase(c))
						 stack.pop();
					 else
						 return false;
				}
			
			else
			return false;
		}
		if(!stack.isEmpty())
			return false;
		
		return true;  // need to change if necessary....
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		if(!isValidContent())
			throw new StringIsNotSymmetricException("parenthesizedExpression: String is not valid.");
		String parenthesized = "";
		String upp;
		String lcp;
		for (int i=0; i < s.length(); i++) { 
			char c = s.charAt(i);
			
			if (Character.isUpperCase(c)){
				upp = "< " + c + " ";
			parenthesized +=  upp;
			}
			else{
				lcp = " " +c+ ">";
				parenthesized +=  lcp;
			}
		}
		
		
		return parenthesized;  
	}

}
