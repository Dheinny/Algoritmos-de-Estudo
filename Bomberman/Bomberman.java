import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bomberman {
    
    static final private int TOP = 1;
    static final private int BOTTOM = 2;
    static final private int RIGHT = 3;
    static final private int LEFT = 4;
    
    static final private int EXPLOSION = 4;        
    
    static public int[] montaGrid(int R, int C, int N, Scanner sc) {
        int[] grid = new int[R*C];
        HashMap<String, Integer> mapPos = new HashMap<String, Integer>(){{put("O",1); put(".", -1);}}; 
     
        for(int i = 0; i < R; i++){
            String input = sc.next(); 
            String[] c = input.split("(?!^)");            
                
            for(int j = 0; j < C; j++) {
                grid[i*C + j] = mapPos.get(c[j]);                
            }
        }
        return grid;
    }
    
    static public boolean isEdge(int pos, int c, int orientation) {    
        return isEdge(pos, c, 1, orientation);
    }
    
    static public boolean isEdge(int pos, int c, int r, int orientation) {
        //left edge: i%c == 0
        //right edge: i%c == c-1
        //top edge : i-c < 0
        //bottom edge: i+c > r*c
        
        switch(orientation) {
            case TOP: return (pos-c) < 0;
            case BOTTOM: return (pos+c) > ((r*c)-1);
            case LEFT: return (pos%c) == 0;
            case RIGHT: return (pos%c) == c-1;
            default: return false;
        }
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();
        N = (((N == 1)||(N % 4) >= 2)) ? (N % 4) : (N % 4 + 4);
        
        int[] grid = montaGrid(R, C, N, sc);       
        
        //For each second, increment one to time of bomb implanted
        for(int n = 1; n <= N; n++) {
            for(int k = 0; k < R*C; k++) {
               grid[k] += 1;
                if(grid[k] == EXPLOSION){
                    grid[k] = 0;
                    // 0 means cell without bomb
                    if(!isEdge(k, C, TOP)) grid[k-C] = 0;
                    if(!isEdge(k, C, LEFT)) grid[k-1] = 0;
                    //Here, if left or bottom neighboring cell has a bomb to be exploded(EXPLOSION-1) in this round, 
                    //don't do nothing. Wait it explode itself in its turn and explode his neighboring cells.
                    //When a left or bottom neighboring cell is exploded, set -1, because when it arrives his turn, this number
                    //will be incresead in 1, and it'll become 0(i.e no bomb there).
                    if(!isEdge(k, C, RIGHT) && grid[k+1] < (EXPLOSION-1)) grid[k+1] = -1;                    
                    if(!isEdge(k, C, R, BOTTOM) && grid[k+C] < (EXPLOSION-1) ) { grid[k+C] = -1;}
                }
            }
        
     /*     // To show round by round
            System.out.println("======RODADA:"+n+"======");
            for(int k = 0; k < R*C; k++) {
                if(grid[k] == 0) System.out.print(".");
                else System.out.print(grid[k]);
                if(isEdge(k, C, RIGHT)) System.out.println("");
            }
    */
        }
  
        for(int k = 0; k < R*C; k++) {
            if(grid[k] == 0) System.out.print(".");
            else System.out.print("O");
            if(isEdge(k, C, RIGHT)) System.out.println("");
        }
    }
}