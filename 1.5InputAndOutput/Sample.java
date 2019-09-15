public class Sample{
	public static void main(String args[]){
		double a=Double.parseDouble(args[0]);
		double x1=2, diff=100,x2=0;
		while(diff*diff>=0.000001){
			x2=x1/2+a/2/x1;
			diff=x2-x1;
			x1=x2;
		StdOut.printf("%.3f",x2
		);
	}
}
