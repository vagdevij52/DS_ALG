/*
 * []{}() -- Valid brackets
 * [[{}]()] - is this valid or not? 
 * Hint - Use Stack 
 * Solution - push the left bracket
 * if the next bracket is right bracket check if stack is empty
 * if its empty -its invalid
 * else check the top element of stack
 * if the top element matches as the left bracket pop it out
 * repeat this until it becomes invalid or stack is empty
 * if stack is empty it is valid Brackets*/
package data_structures;

public class Brackets_StackImplementation {
	
	public boolean isValidBrackets(String[] args) {
		Stack stack=new Stack();
		String br=new String("[[{}]()]");
		for(int i=0;i<br.length()-1;i++) {
			char c=br.charAt(i);
			if(c=='['||c=='{'||c=='(') {
				stack.push(c);
			}else {
				if(stack.isEmpty()) return false;
				else {
					String rev = getReveresedBracket(stack.peek().toString());
				}
			}
		}
		return true;
	}
	
	public String getReveresedBracket(String s) {
		if(s.equals("{")) return "}";
		if(s.equals("(")) return ")";
		if(s.equals("[")) return "]";	
		return "";
	}
}
