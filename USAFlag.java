package com.cflex.mp.test.engine.gui.client;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class USAFlag {
	public static void main (String[] args) {
		try{
	        BufferedImage img = new BufferedImage( 
	            600, 260, BufferedImage.TYPE_INT_ARGB );
	        // Streak
	        File f = new File("MyFile.png");
	        int r = 255;
	        int g = 10;
	        int b = 57;
	        int alpha = 255;
	        int col = (alpha << 24) | (r << 16) | (g << 8) | b;
	        int count = 0 ;
	        for(int x = 0; x < 600; x++){
	        	count = 0;
	        	for(int y = 0 ; y < 260; y++){
	        		if(count < 20) {
	        			System.out.println("("+x+","+y+")");
	        			img.setRGB(x, y, col);
	        			count++;
	        		} else {
	        			y += 19;
	        			count = 0;
	        		}
	        	}
	        }
	        
	        //Blue Rectangle 
	        r = 0;
	        g = 0;
	        b = 255;
	        alpha = 255;
	        col = 0;
	        col = (alpha << 24) | (r << 16) | (g << 8) | b;
	        
	        for(int x = 0; x < 210; x++) {
	        	for(int y = 0; y < 140; y++) {
	        		img.setRGB(x, y, col);
	        	}
	        }
	        
	        //Stars
	        count = 0;
	        int count2 = 0;
	        col = 0;
	        int xColIni = 10;
	        int xIniStar=10;
	        int xFinStar=0;	        
	        int t = 13; // tamanho quadrado estrela
	        int xSpc = 8;
	        int ySpc = 1;
	        for(int y = 16; y < 150; y++) {
	        	if((count2 % 2) == 0) {
	        		xIniStar = xColIni;
	        		xFinStar = 200;	        		
	        	} else {
	        		xIniStar = xColIni+t+(xSpc/2);
	        		xFinStar = 190;
	        	}
	        	for(int x = xIniStar; x < xFinStar; x++) {
	        		for (int i = 0; i < t; i++) {	
	        			y -= t;
	        			for (int j = 0; j < t; j++) {
	        				y++;
	        				System.out.println("("+x+","+y+")");
	        				img.setRGB(x, y, col);	 
	        			}
	        			
	        			x++;
	        		} 
	        		x += t + xSpc;	        		
	        	}
	        	y += t+ySpc;
	        	count2++;
	        }
	        
	        ImageIO.write(img, "PNG", f);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
