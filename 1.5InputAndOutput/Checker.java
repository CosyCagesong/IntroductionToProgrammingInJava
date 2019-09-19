public class Checker{
	public static void main(String args[]){
		int N = Integer.parseInt(args[0]);
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0,N);
		int i,j;
		boolean linehead=true, current;
		for (i = 0; i < N; i++){
			current = linehead;
			for (j = 0; j < N; j++){
				if (current == true) StdDraw.setPenColor(StdDraw.RED);
				else StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledSquare(j+0.5, i+0.5, 0.5);
				current = !current;
			}
			linehead = !linehead;
		}
	}
}
