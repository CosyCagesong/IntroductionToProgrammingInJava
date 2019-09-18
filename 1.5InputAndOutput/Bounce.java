public class Bounce{
	public static void main(String args[]){
		StdDraw.setXscale(-1,1);
		StdDraw.setYscale(-1,1);
		double rx = .48, ry=.86;
		double vx = .0015, vy=.0023;
		double radius =.05;
		while(true){
			if(Math.abs(rx+vx)+radius>1.0) vx=-vx;
			if(Math.abs(ry+vy)+radius>1.0) vy=-vy;
			rx+=vx;
			ry+=vy;
			StdDraw.clear();
			StdDraw.filledCircle(rx,ry,radius);
			StdDraw.show(100);
		}
	}
}
