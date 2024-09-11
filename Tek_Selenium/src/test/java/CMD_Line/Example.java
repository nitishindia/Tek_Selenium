package CMD_Line;

public class Example {

	public static void main(String[] args) {
		
		System.out.println(args.length);
		for(String var : args) {
			System.out.println(var);
		}
	}
}
