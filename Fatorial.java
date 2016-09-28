public class Fatorial{
	public int calcFatorial(int fator){
		if(fator == 1) return fator;

		return fator*calcFatorial(fator-1);
	}

	public static void main(String [] args){
		Fatorial op = new Fatorial();
		System.out.println(op.calcFatorial(Integer.parseInt(args[0])));
	}
}