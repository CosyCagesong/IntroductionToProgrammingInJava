public class StaticMethods{
	public static String duplicate(String s)
{
String t = s + s;
return t;
}
	public static void main(String args[]){
		String s = "Hello";
s = duplicate(s);
String t = "Bye";
t = duplicate(duplicate(duplicate(t)));
StdOut.println(s + t);
		
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
