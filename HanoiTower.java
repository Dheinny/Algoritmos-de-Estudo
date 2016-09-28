public class HanoiTower{

	public static int moveDisc(int nDisc, int iRodAtual, int iRodF){
		System.out.println("Disco "+nDisc+": "+iRodAtual+" -> "+iRodF);
		return 1;
	}

	public static int moveHanoiTower(int n, int rodAtual, int rodAux, int rodFinal, int count){
		//Mover a torre de n-1 tamanho, para o pivo auxiliar
		//Mover a peça N para o pivo final
		//Mover a torre n-1 para o pivo final
		//Base Case: n=1, move ela pra posição final
		if(n==1){
			return moveDisc(n, rodAtual, rodFinal);
			
		} 
		
		//Recursive Case:
		count = moveHanoiTower(n-1, rodAtual, rodFinal, rodAux, count);
		count+=moveDisc(n, rodAtual, rodFinal);
		count += moveHanoiTower(n-1, rodAux, rodAtual, rodFinal, count);
		return count;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int rodAtual = 1;
		int rodAux = 2;
		int rodFinal =3;
		int count = 0;
		System.out.println("No de jogadas: "+moveHanoiTower(n, rodAtual, rodAux, rodFinal, count));
	}
}