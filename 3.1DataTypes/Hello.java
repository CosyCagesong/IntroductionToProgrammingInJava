import java.awt.Color;
public class Hello{
	public static void main(String[] args)
	{
		double a[] = {0.1,0.2,0.3};
		int n = a.length;
		StdDraw.setXscale(0,n-1);
		StdDraw.setPenRadius(0.5/n);
		for (int i = 0; i < n; i++)
		StdDraw.line(i, 0, i, a[i]);
	}
	
}
