
public class TestLists {
	public static void main(String[] args){
		AlphabeticalList<String> stack = new AlphabeticalList<String>();
		
		// Add all objects
		stack.add("C");		
		stack.add("A");
		stack.add("B");
		
		// Print all objects
		System.out.println(stack.size);
		for(String s : stack){
			System.out.println(s);
		}
		System.out.println();
		
		// Remove one object and reprint
		stack.remove();	
		System.out.println(stack.size);
		for(String s: stack){
			System.out.println(s);
		}
		System.out.println();
		
		// Remove one object and reprint
		stack.remove();
		System.out.println(stack.size);
		for(String s: stack){
			System.out.println(s);
		}
		System.out.println();
		
		// Remove last object and reprint
		stack.remove();
		System.out.println(stack.size);
		for(String s: stack){
			System.out.println(s);
		}
		System.out.println();
		
		// Remove when empty
		stack.remove();
		System.out.println(stack.size);
		for(String s: stack){
			System.out.println(s);
		}
		System.out.println();
		
		// Add new object and print
		stack.add("D");
		System.out.println(stack.size);
		for(String s: stack){
			System.out.println(s);
		}
	}
}
