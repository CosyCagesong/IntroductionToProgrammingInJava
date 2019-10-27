//package Tool;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.imageio.ImageIO;
public class ImgOP {
	//获取图像的宽
	public static int getWidth(File inf){
		BufferedImage bf = null;
		try {
			bf = ImageIO.read(inf);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		WritableRaster wr = bf.getRaster();
		int width = wr.getWidth();
		return width;
	}
	//获取图像的高
	public static int getHeight(File inf){
		BufferedImage bf = null;
		try {
			bf = ImageIO.read(inf);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		WritableRaster wr = bf.getRaster();
		int height = wr.getHeight();
		return height;
	}
	
	public static double[][] getRed(File imageFilePath){
		
		BufferedImage bufferedImage=null;
		
		try{
			
			bufferedImage=ImageIO.read(imageFilePath);
		
		}catch(IOException e){
		
			e.printStackTrace();
		
		}
		
		int width=bufferedImage.getWidth();
		int height=bufferedImage.getHeight();
		double[][]  imageRed=new double[width][height];
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				
				int pix=bufferedImage.getRGB(i, j);
				pix=(pix & 0xff0000) >> 16;
				imageRed[i][j]=pix;
				
			}
		}
		
		return imageRed;
		
	}
	
	
	//获取图像的灰度值
	public static int[][] getGray(File imageFilePath){
		
		BufferedImage bufferedImage=null;
		
		try{
			
			bufferedImage=ImageIO.read(imageFilePath);
		
		}catch(IOException e){
		
			e.printStackTrace();
		
		}
		
		int width=bufferedImage.getWidth();
		int height=bufferedImage.getHeight();
		int[][]  imageGray=new int[width][height];
		WritableRaster raster = bufferedImage.getRaster();
		int pixels[] = new int[width*height];
		raster.getPixels(0,0,width,height,pixels);
		imageGray = arrayToMatrix(pixels,width,height);
		return imageGray;
		
	}
	
	public static int[][] arrayToMatrix(int m[], int width, int height){
		int result[][] = new int[width][height];
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				int p = j * width + i;
				result[i][j] = m[p];
			}
		}
		return result;
	}

	
	
	/**
	 * 提取已知图像的Green矩阵
	 */
	
	public static double[][] getGreen(File imageFilePath){
		
		BufferedImage bufferedImage=null;
		
		try{
			
			bufferedImage=ImageIO.read(imageFilePath);
			
		}catch(IOException e){
			
			e.printStackTrace();
			
		}
		
		int width=bufferedImage.getWidth();
		int height=bufferedImage.getHeight();
		double[][] imageGreen=new double[width][height];
		
		for(int i=0;i<width;i++){		
			for(int j=0;j<height;j++){
				
				int pix=bufferedImage.getRGB(i, j);
				pix=(pix & 0x00ff00) >> 8;
				imageGreen[i][j]=pix;
				
			}				
		}
		
		return imageGreen;
		
	}
	
	/**
	 * 提取已知图像的Blue矩阵
	 */
	public static double[][] getBlue(File imageFilePath){
		
		BufferedImage bufferedImage=null;
		
		try{
			
			bufferedImage=ImageIO.read(imageFilePath);
			
		}catch(IOException e){
			
			e.printStackTrace();
			
		}
		
		int width=bufferedImage.getWidth();
		int height=bufferedImage.getHeight();
		double[][] imageBlue=new double[width][height];
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				
				int pix=bufferedImage.getRGB(i, j);
				pix=(pix & 0xff);
				imageBlue[i][j]=pix;
				
			}
		}
		
		return imageBlue;
		
	}
	
	
	/**
	 * 提取缓存图像的Red矩阵，输出为存放图像Red矩阵的二维数组
	 */
	public static double[][] getBufferedImageRedMatrix(BufferedImage bufferedImage){
		
		int width=bufferedImage.getWidth();
		int height=bufferedImage.getHeight();
		double[][] imageMatrix=new double[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				
				int pix=bufferedImage.getRGB(i,j);
				pix=(pix & 0xff0000) >> 16;
				imageMatrix[i][j]=pix;
				
			}
		}
		return imageMatrix;
		
	}
	
	/**
	 * 提取缓存图像的Green矩阵，输出为存放图像Red矩阵的二维数组
	 */
	public static double[][] getBufferedImageGreenMatrix(BufferedImage bufferedImage){
		
		int width=bufferedImage.getWidth();
		int height=bufferedImage.getHeight();
		double[][]	imageMatrix=new double[width][height];
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				
				int pix=bufferedImage.getRGB(i, j);
				pix=(pix & 0x00ff00)>>8;
				imageMatrix[i][j]=pix;
			}
		}
		return imageMatrix;
	}
	
	/**
	 * 提取缓存图像的Blue矩阵，输出为存放图像Red矩阵的二维数组
	 */
	public static double[][] getBufferedImageBlueMatrix(BufferedImage bufferedImage){
		
		int width=bufferedImage.getWidth();
		int height=bufferedImage.getHeight();
		double[][]	imageMatrix=new double[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				
				int pix=bufferedImage.getRGB(i, j);
				pix=(pix & 0xff);
				imageMatrix[i][j]=pix;
				
			}
		}
		return imageMatrix;
		
	}
	//已知RGB三个二维矩阵，输出图像
	public static File RGBprintImageToFile(double Red[][],double Green[][],double Blue[][],String strfilePath){
		
		int width=Red.length;
		int height=Red[0].length;
		File newImageFile=new File(strfilePath);
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		int[][] imageMatrix=new int[width][height];
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				
				imageMatrix[i][j]=(int)Red[i][j]<<16|(int)Green[i][j]<<8|(int)Blue[i][j]; 
				image.setRGB(i, j, (int)imageMatrix[i][j]);
				
			}
		}
		
		try{
			ImageIO.write(image, "bmp", newImageFile);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return newImageFile;
		
	}
	//已知图像的单通道灰度矩阵，输出图像
	public static BufferedImage printBufferedImage(int matrixGray[][]){
		
		int width=matrixGray.length;
		int height=matrixGray[0].length;
		BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
//		BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.1);
		int pixels[] = matrixToArray(matrixGray);
		WritableRaster raster = bufferedImage.getRaster();
		raster.setPixels(0,0,width,height,pixels);
		return bufferedImage;
	}
	
	  public static int[] matrixToArray(int m[][]){
		   int p = m.length * m[0].length;
		   int[] result = new int[p];
		   for(int i=0; i<m.length; i++){
			   for(int j=0; j<m[i].length; j++){
			       int q = j * m.length + i;
			       result[q] = m[i][j];
			   }
		   }
		   return result;
	  }

	
	//获取图像的像素的一维数组
	public static int[] getPixels(File inf){
		int width,height = 0;
		BufferedImage bf = null;
		try {
			bf = ImageIO.read(inf);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		WritableRaster wr = bf.getRaster();
		width = wr.getWidth();
		height = wr.getHeight();
		int[] pixels = new int[3*width*height];
		System.out.println(width);
		System.out.println(height);
		System.out.println(pixels.length);
		wr.getPixels(0, 0, width, height, pixels);
		
		return pixels;
	}
	
	public static void pixelPrintImage(File outfile,int width,int height,int[] pixels){
		BufferedImage bf = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		WritableRaster wr = bf.getRaster();
		wr.setPixels(0, 0, width, height, pixels);
		try {
			ImageIO.write(bf, "bmp", outfile);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//将数组Img1赋值给Img2
	public static void ImgtoImg(int[][] Img1,int[][] Img2){
		for(int i = 0;i < Img2.length;i++){
			for(int j = 0; j < Img2[0].length;j++){
				Img2[i][j] = Img1[i][j];
			}
		}
	}
	public static int[][] imageBlock(int[][] oImg,int intStartX,int intStartY,int intBlockWidth,int intBlockHeight){
		int[][] imgBlock=new int[intBlockWidth][intBlockHeight];
		for(int i=0;i<intBlockWidth;i++){
			for(int j=0;j<intBlockHeight;j++){
				imgBlock[i][j]=oImg[intStartX+i][intStartY+j];
			}
		}
		return imgBlock;
	}
	
	public static int[][] transformGrayImage24Into8(File path){
		double[][] image = getGreen(path);
		int[][] result = new int[image.length][image[0].length];
		for(int i =0;i < result.length;i++){
			for(int j = 0;j < result[0].length;j++){
				result[i][j] = (int)image[i][j];
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		File path = new File("inputimg//kieltemp.bmp");
		int[][] a = transformGrayImage24Into8(path);
		BufferedImage Bi = printBufferedImage(a);
		try {
			ImageIO.write(Bi, "bmp", new File("inputimg//kiel128.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
