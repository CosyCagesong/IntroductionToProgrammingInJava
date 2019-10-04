import java.awt.Color;
public class Fade{
	public static void main(String args[]){
		Picture back = new Picture("back.jpg");
		Picture front = new Picture("front.jpg");
		blend(back, front, 0.2, 0.8).show();
		blend(back, front, 0.8, 0.2).show();
		blend(back, front, 0.5, 0.5).show();
	}
	public static Picture blend(Picture picA, Picture picB, double a, double b){
		int width = picA.width();
		int height = picB.height();
		Picture pic = new Picture(width, height);
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				Color cA = picA.get(x,y);
				Color cB = picB.get(x,y);
				Color newColor = blend(cA, cB, a, b);
				pic.set(x, y, newColor);
			}
		}
		return pic;
	}
	public static Color blend(Color cA, Color cB, double a, double b){
		int red = (int) (a * cA.getRed() + b * cB.getRed());
		int green = (int) (a * cA.getGreen() + b * cB.getGreen());
		int blue = (int) (a * cA.getBlue() + b * cB.getBlue());
		return new Color(red, green, blue);
	}
}
