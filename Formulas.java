public class Formulas{
	public int sumFirstN(int n){
		if(n==0) {System.out.print(n); return n;}
		
		int soma = sumFirstN(n-1);
		System.out.println("Sum("+n+") = "+soma);	
			
		return n+soma;
	}

	public static void main(String[] args){
		Formulas op = new Formulas();
		System.out.print("="+op.sumFirstN(Integer.parseInt(args[0])));
	}
}

