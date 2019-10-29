public class Comp{
    private double re, im;
    public Comp(double a, double b, int mode){
        if (mode == 0){re = a;  im = b;}
        else if (mode ==1){
            double r=a, theta=b;
            re = r * Math.cos(theta);
            im = r * Math.sin(theta);
        }
        else System.out.format("mode argument is incorrect!");
    }
    public Comp plus(Comp b){
        return new Comp(re + b.re, im + b.im,0);
    }
    public Comp times(Comp b){
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Comp(real, imag,0);
    }
    public Comp recip(){
        double denominator = re * re - im * im;
        return new Comp(re/denominator, -1*im/denominator,0);
    }
    public double abs(){
        return Math.sqrt(re*re + im*im);
    }
    public static void main(String args[]){
        return;
    }
}
