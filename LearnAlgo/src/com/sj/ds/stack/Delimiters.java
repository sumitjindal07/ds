package com.sj.ds.stack;

public class Delimiters {

	public static void main(String[] args) {
		
		String[] tests = {"c[d]",
						"a{b[c]d}e",
						"a{b(c]d}e",
						"a[b{c}d]e}",
						"a{b(c)",
						"[{(<>)}]",};
		
		for(String test:tests){
			boolean valid = isValidStr(test);			
			System.out.println(test+" has valid delimeters? ="+valid);
		}
		
		System.out.println("\n\nWith reurcion\n\n\n");
		for(String test:tests){
			boolean valid = isValidStrWithRec(test, 0, '\0');			
			System.out.println(test+" has valid delimeters? ="+valid);
		}
	}
	
	private static boolean isOpening(char c){
		switch(c){
		case('['):
		case('{'):
		case('('):
		case('<'):
			return true;
		}
		return false;
	}
	
	private static char isClosing(char c){
		switch(c){
		case(']'):
			return '[';
		case('}'):
			return '{';
		case(')'):
			return '(';
		case('>'):
			return '<';
		}
		return '\0';
	}

	private static boolean isValidStr(String test) {
		
		CharStack cs = new CharStack(test.length()/2);
		char pair = '\0';
		for(char c:test.toCharArray()){
			if(isOpening(c)){
				if(cs.isFull())
					return false;
				else
					cs.push(c);
			}else if((pair = isClosing(c))!='\0'){
				if(cs.isEmpty() || cs.pop()!=pair)
					return false;
			}
		}
		return cs.isEmpty();
	}
	
	
	//Not working
	private static boolean isValidStrWithRec(String test, int index, char pair) {
		
		if(index>=test.length())
			return true;
		
		char c;
		do{
			c = test.charAt(index++);			
		}while(!isOpening(c) && isClosing(c)=='\0');
		
		//char c = test.charAt(index);
		if(isOpening(c)){
			return isValidStrWithRec(test, index, c);
		}
			
		char cc = isClosing(c);
		if(cc!='\0'){
			if(cc==pair)
				return true;
			else
				return false;
		}
		return false;
	}
}