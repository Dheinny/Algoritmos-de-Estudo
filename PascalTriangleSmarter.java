public class PascalTriangleSmarter{
	public static int pascalSolve(int n, int r) {
	        //System.out.println(n +"-"+r);
        	if(n==0 && r==0) {return 1;}
        	if(r==0) { return 1;}
        	if(r==n) {return 1;}
        
     	   	//Recursive Case:
        	int res = pascalSolve(n-1, r-1) + pascalSolve(n-1, r);
        
        	return res;       
    	}

	public static void main (String [] args) {
        
        	int k = Integer.parseInt(args[0]);
        
        	for(int i=0; i<=k; i++){
            	for(int j=0; j<=i; j++){
                	System.out.printf("%04d ", pascalSolve(i, j));
            	}
            	System.out.println("");
        	}	
	}
}