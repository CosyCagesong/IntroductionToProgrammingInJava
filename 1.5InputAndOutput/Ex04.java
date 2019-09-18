public class Ex04{
	public static void main(String args[]){
		int N = Integer.parseInt(args[0]);
		double sumOfSquaredError = 0.0, mean, sd;
		int sum = 0;
		int a[] = new int[N];
		for (int i = 0; i < N; i++){
			a[i] = StdIn.readInt();
			sum += a[i];
		}
		mean = 1.*sum / N;
		for (int i = 0; i < N; i++){
			sumOfSquaredError += Math.pow(a[i] - mean, 2);
		}
		sd = Math.pow(sumOfSquaredError/(N-1), 0.5);
		for (int i = 0; i < N; i++){
			if (Math.abs(a[i] - mean) > 1.5*sd)StdOut.printf("%d is far\n",a[i]);
		}
	}
}
