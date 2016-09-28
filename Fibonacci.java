public class Fibonacci{
	public static int fib(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;

		return fib(n-1)+fib(n-2);
	}

	public static int[] fibOptimized(int n) {
		if(n==2) {
			int[] a = {1,1};
			return a;
		}
		
		int[] r = fibOptimized(n-1);
		int[] y = {r[1], r[0]+r[1]};
		return y; 
	}
	
	public static void main(String[] args) {
//		System.out.println(fibOptimized(Integer.parseInt(args[0]))[1]);
		System.out.println(fib(Integer.parseInt(args[0])));
	}

}


            