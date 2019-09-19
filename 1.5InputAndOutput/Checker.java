public class Checker{
	public static void main(String args[]){
		int N = Integer.parseInt(args[0]);
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0,N);
		int i,j;
		StdDraw.setPenColor(StdDraw.RED);
		for (i = 0; i < N; i++){
			for (j = i%2; j < N; j+=2){
				StdDraw.filledSquare(j+0.5, i+0.5, 0.5);
			}
		}
		StdDraw.setPenColor(StdDraw.BLACK);
		for (i = 0; i < N; i++){
			for (j = (i+1)%2; j < N; j+=2){
				StdDraw.filledSquare(j+0.5, i+0.5, 0.5);
			}
		}
	}
}
