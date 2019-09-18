public class Triangle{
	public static void main(String args[]){
	int N = 50;
	StdDraw.setXscale(-1, N);
	StdDraw.setYscale(-1, N);
	for (int i=0; i<=N; i++)StdDraw.line(0,N-i,i,0);
	}
}
