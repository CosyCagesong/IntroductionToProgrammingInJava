import java.awt.Color;
public class Spatial{
	public static void main(String args[]){
		Picture inPic = new Picture("dolphin.jpg");
		int width = inPic.width();
		int height = inPic.height();
		Picture outPic = new Picture(width, height);
		int choose = Integer.parseInt(args[0]);
		for (int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				a
			}
		}
		outPic.show();
		outPic.save("output.jpg");
	}
}
