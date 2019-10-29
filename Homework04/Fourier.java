import java.awt.Color;
public class Fourier{
    public static double grayLevel(Color c){
        return .299*c.getRed()+.587*c.getGreen()+.114*c.getBlue();
    }
    public static double[][] grayArray(Picture pic){
        int width = pic.width();
        int height = pic.height();
        double result[][] = new double[height][width];
        for(int x=0; x<height; x++)
            for (int y=0; y<width; y++){
                Color temp = pic.get(y,x);
                result[x][y] = grayLevel(temp);
            }
        return result;
    }
    public static Picture grayArray2Pic(double[][] grayArr){
        int height = grayArr.length;
        int width = grayArr[0].length;
        Picture result = new Picture(width, height);
        for(int x=0; x<height; x++)
            for(int y=0; y<width; y++){
                int grayScale = (int)grayArr[x][y];
                if(grayScale>255)grayScale=255;
                if(grayScale<0)grayScale=0;
                Color temp = new Color(grayScale,grayScale,grayScale);
                result.set(y,x,temp);
            }
        return result;
    }
    public static Comp[][] grayArray2freqArray(double[][] grayArr){
        int height = grayArr.length;
        int width = grayArr[0].length;
        Comp result[][] = new Comp[height][width];
        for(int u=0; u<height;u++)for(int v=0; v<width; v++)
        for(int x=0; x<height;x++)for(int y=0; y<width; y++){
            if (x==0&&y==0) result[u][v] = new Comp(0,0,0);
            double exponent = -1*2*Math.PI*(1.*u*x/height+1.*v*y/width);
            Comp increment = new Comp(grayArr[x][y], exponent, 1);
            result[u][v] = result[u][v].plus(increment);
        }    
        return result;
    }
    public static double[][] freqArray2grayArray(Comp[][] freqArr){
        int height = freqArr.length;
        int width = freqArr[0].length;
        Comp temp = new Comp(0,0,0),temp2;
        double result[][] = new double[height][width];
        for(int x=0; x<height;x++)for(int y=0; y<width; y++)
        for(int u=0; u<height;u++)for(int v=0; v<width; v++){
            if (u==0&&v==0) temp = new Comp(0,0,0);
            double exponent = 2*Math.PI*(1.*u*x/height+1.*v*y/width);
            temp2 = new Comp(1.0,exponent,1);
            temp2 = temp2.times(freqArr[u][v]);
            temp = temp.plus(temp2);
            result[u][v] = temp.abs()/width/height;
        }    
        return result;
    }
    public static void main(String args[]){
        Picture a = new Picture("small.jpg");
        Comp freq[][]=grayArray2freqArray(grayArray(a));
        double comeback[][] = freqArray2grayArray(freq);
        Picture last = grayArray2Pic(comeback);
        last.show();
    }
}
