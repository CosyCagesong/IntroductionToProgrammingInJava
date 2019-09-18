public class Ex02{
	public static void main(String args[]){
		int max = 0, min = 0, value;
		boolean set = false;
		StdOut.printf("pls enter positive numbers.\n");
		while (!StdIn.isEmpty()){
			value = StdIn.readInt();
			if (value <= 0)
				StdOut.printf("enter a positive pls.\n");
			else if (set == false){
				set = true;
				max = min = value;
			}
			else if (value > max) max =value;
			else if (value < min) min =value;
		}
		StdOut.printf("MAX = %d; MIN = %d.", max, min);
	}
}
