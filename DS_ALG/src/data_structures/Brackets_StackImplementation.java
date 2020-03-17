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
	
	public boolean isValidBrackets() {
		Stack stack=new Stack();
		String br=new String("[[{}]()]");
		for(int i=0;i<br.length()-1;i++) {
			String c=Character.toString(br.charAt(i));
			if(c=="["||c=="{"||c=="(") {
				stack.push(c);
			}else {
				if(stack.isEmpty()) return false;
				else {
					if(!stack.isEmpty()) {
					String rev = getReveresedBracket(stack.peek().toString());
					if(c.equals(rev))
						stack.pop();
					else
						return false;
					}else
						return false;
				}
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public String getReveresedBracket(String s) {
		if(s.equals("{")) return "}";
		if(s.equals("(")) return ")";
		if(s.equals("[")) return "]";	
		return "";
	}
	
	public static void main(String[] args) {
		Brackets_StackImplementation obj=new Brackets_StackImplementation();
		boolean result= obj.isValidBrackets();
		if(result)
		System.out.println("Valid brackets");
		else
			System.out.println("Invalid brackets");
	}
}
