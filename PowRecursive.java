public class PowRecursive{

	public long calcPow(long base, long exp) {
		if(exp == 0) {
			return 1;
		}
		
		return base * calcPow(base, exp-1);
	}

	public static void main(String[] args) {
		PowRecursive op = new PowRecursive();
		System.out.println(op.calcPow(Long.parseLong(args[0]), Long.parseLong(args[1])));
	}	
}
