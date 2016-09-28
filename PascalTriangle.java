public class PascalTriangle {
	public static int factorial(int n, int l) {
		//System.out.println(n +"-"+l);
		if(n<=l) return 1;

		return n*factorial(n-1,l);
	}
	
	public static void printLinePT(int n, int r) {
		//base case:
		if(r == 0) {System.out.print("1"); return;}

        printLinePT(n, r-1);
        //Recursive case:
		//vai chamar n vezes a propria função e imprimir o valor da formula n! / (r! * (n-r)!)
		int nrFact = factorial(n-r,1);
		int rFact = nrFact*factorial(r, n-r);
    		int nFact = rFact * factorial(n, r); 

		System.out.print(" "+nFact/(rFact*nrFact));
	}
	
	public static void printPT(int k) {
		//receber o e fazer uma chamada pra cada linha, passando nk linha, e 1

		//Base Case
		if (k == 0) return;
		printPT(k-1);
        printLinePT(k-1, k-1); 
        System.out.println("");

		return;
	}
	
	public static void main (String [] args) {
		printPT(Integer.parseInt(args[0]));
	
	}
}