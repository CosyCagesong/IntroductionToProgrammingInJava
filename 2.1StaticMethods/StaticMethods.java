public class StaticMethods{
	public static String duplicate(String s){
		String t = s + s;
		return t;
	}
	public static void main(String args[]){
		int N = Integer.parseInt(args[0]);
		for (int i=0;i<N;i++)
			System.out.format("%d ",StdRandom.uniform(10));
	}
	public static int max3(int a, int b, int c){
		if(b>a)a=b;
		if(c>a)a=c;
		return a;
	}
	public static double max3(double a, double b, double c){
		if(b>a)a=b;
		if(c>a)a=c;
		return a;
	}
}
