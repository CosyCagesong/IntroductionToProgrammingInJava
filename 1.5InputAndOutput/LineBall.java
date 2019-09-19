public class LineBall{
	public static void main(String args[]){
		int N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);
		StdDraw.setXscale(-1.2,1.2);
		StdDraw.setYscale(-1.2,1.2);
		double points[][] = new double[N][2];
		int i,j;
		StdDraw.setPenRadius(0.02);
		for (i = 0; i < N; i++){
			points[i][0] = Math.cos(i*2*Math.PI/N);
			points[i][1] = Math.sin(i*2*Math.PI/N);
			StdDraw.point(points[i][0], points[i][1]);
		}
		StdDraw.setPenRadius(0.002);		
		StdDraw.setPenColor(StdDraw.GRAY);
		for (i = 0; i < N; i++)
			for (j = i+1; j < N; j++)
				if (Math.random() < p)
					StdDraw.line(points[i][0],points[i][1],points[j][0],points[j][1]);
	}
}
