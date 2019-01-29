package memorymitgui;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Model {
// programmfunktion
	// erstmal festgelegte feldgroesse
	ArrayList<Integer> liste = new ArrayList<Integer>();
	static int counter =-1;
	static boolean clicked = false;
	public static void setclicked(boolean click) {
		clicked = click;
	}
	private static int fieldsize = 4; // 4 x 4 feld
	private boolean gameover = false;
	public static int getFieldsize() {
		return fieldsize;
	}
	private static int[][] field = new int[fieldsize][fieldsize];
	
	public static int[][] getField() {
		return field;
	}
	public void gibfeldaus() {
		for(int i=0;i<fieldsize;i++) {
			
			for(int j=0;j<fieldsize;j++) {
				System.out.print(field[i][j]);
			}
			System.out.println("");
		}
	}
	static int indexi =0;
	static int indexj =0;
	
	static int indexi1 =0;
	static int indexj1 =0;
	/*
	public static void spiel() {
		if(counter < 1) {
			
			counter++;
		
		
		if(View.getclicked()[0][0] == true) {
			
			if(counter == 0) {
				indexi = 0;
				indexj=0;
				
				
			}
			else {
				indexi1=0;
				indexj1=0;
				
			}
			View.getclicked()[0][0] = false;
		}
		if(View.getclicked()[0][1] == true) {
			if(counter == 0) {
				indexi = 0;
				indexj=1;
			}
			else {
				indexi1=0;
				indexj1=1;
			}
			View.getclicked()[0][1] = false;
		}
		if(View.getclicked()[0][2] == true) {
			if(counter == 0) {
				indexi = 0;
				indexj=2;
			}
			else {
				indexi1=0;
				indexj1=2;
			}
			View.getclicked()[0][2] = false;
		}
		if(View.getclicked()[0][3] == true) {
			if(counter == 0) {
				indexi = 0;
				indexj=3;
			}
			else {
				indexi1=0;
				indexj1=3;
			}
			View.getclicked()[0][3] = false;
		}
		if(View.getclicked()[1][0] == true) {
			if(counter == 0) {
				indexi = 1;
				indexj=0;
			}
			else {
				indexi1=1;
				indexj1=0;
			}
			View.getclicked()[1][0] = false;
		}
		if(View.getclicked()[1][1] == true) {
			if(counter == 0) {
				indexi = 1;
				indexj=1;
			}
			else {
				indexi1=1;
				indexj1=1;
			}
			View.getclicked()[1][1] = false;
		}
		if(View.getclicked()[1][2] == true) {
			if(counter == 0) {
				indexi = 1;
				indexj=2;
			}
			else {
				indexi1=1;
				indexj1=2;
			}
			View.getclicked()[1][2] = false;
		}
		if(View.getclicked()[1][3] == true) {
			if(counter == 0) {
				indexi = 1;
				indexj=3;
			}
			else {
				indexi1=1;
				indexj1=3;
			}
			View.getclicked()[1][3] = false;
		}
		if(View.getclicked()[2][0] == true) {
			if(counter == 0) {
				indexi = 2;
				indexj=0;
			}
			else {
				indexi1=2;
				indexj1=0;
			}
			View.getclicked()[2][0] = false;
		}
		if(View.getclicked()[2][1] == true) {
			if(counter == 0) {
				indexi = 2;
				indexj=1;
			}
			else {
				indexi1=2;
				indexj1=1;
			}
			View.getclicked()[2][1] = false;
		}
		if(View.getclicked()[2][2] == true) {
			if(counter == 0) {
				indexi = 2;
				indexj=2;
			}
			else {
				indexi1=2;
				indexj1=2;
			}
			View.getclicked()[2][2] = false;
		}
		if(View.getclicked()[2][3] == true) {
			if(counter == 0) {
				indexi = 2;
				indexj=3;
			}
			else {
				indexi1=2;
				indexj1=3;
			}
			View.getclicked()[2][3] = false;
		}
		if(View.getclicked()[3][0] == true) {
			if(counter == 0) {
				indexi = 3;
				indexj=0;
			}
			else {
				indexi1=3;
				indexj1=0;
			}
			View.getclicked()[3][0] = false;
		}
		if(View.getclicked()[3][1] == true) {
			if(counter == 0) {
				indexi = 3;
				indexj=1;
			}
			else {
				indexi1=3;
				indexj1=1;
			}
			View.getclicked()[3][1] = false;
		}
		if(View.getclicked()[3][2] == true) {
			if(counter == 0) {
				indexi = 3;
				indexj=2;
			}
			else {
				indexi1=3;
				indexj1=2;
			}
			View.getclicked()[3][2] = false;
		}
		if(View.getclicked()[3][3] == true) {
			if(counter == 0) {
				indexi = 3;
				indexj=3;
			}
			else {
				indexi1=3;
				indexj1=3;
			}
			View.getclicked()[3][3] = false;
		}
		
		}
		else {
		System.out.println(indexi);
		System.out.println(indexj);
		System.out.println(indexi1);
		System.out.println(indexj1);
		
		
		if(field[indexi][indexj] == field[indexi1][indexj1]) {
			View.getbtn()[indexi][indexj].setIcon(null);
			View.getbtn()[indexi1][indexj1].setIcon(null);
			
		}
		counter =-1;
	}
	}
	*/
		
	
		/*
		System.out.println("hier klappts");
		// aufdecken einer karte = button visible setzen
		// wenn beide zahlen im array gleich sind bilder löschen 
		while(counter != 8) {
			for(int i=0;i<2;i++) { // zwei karten werden pro zug aufgedeckt
				for(int j=0;j<fieldsize;j++) {
					for(int k = 0;k<fieldsize;k++) {
						System.out.println("nice");
						if(View.getclicked()[j][k] == true) {
							System.out.println("click");
							View.getbtn()[j][k].setVisible(true);
							liste.add(field[j][k]);
							
							if(i==0) {
								 indexi = j;
								 indexj= k;
							}
							else {
								indexi1 =j;
								indexj1 =k;
							}
							View.getclicked()[j][k] = false;
						}
						
						
					}
				}
				
				
				
			}
			
			if(liste.size() != 0) {
			if(liste.get(0) == liste.get(1)) {
				// die beiden buttons löschen. vielleicht mit anderem image ersetzen
				//b1.setIcon(null);
				
				View.getbtn()[indexi][indexj].setVisible(false);
				View.getbtn()[indexi1][indexj1].setVisible(false);
				
				liste.remove(0);
				liste.remove(1);
				
				counter++;
			}
		}
			
		}
		
	}
	*/
	

	public void fillrandom() { // einer zahl farbe zuordnen
		for(int i=1;i<fieldsize+fieldsize+1;i++) {
			int zufallszahl1 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
			int zufallszahl2 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
			

			if(field[zufallszahl1][zufallszahl2] == 0) {
				field[zufallszahl1][zufallszahl2] = i;
			}
			else if(field[zufallszahl1][zufallszahl2] != 0) {
				while(field[zufallszahl1][zufallszahl2] != 0) {
					 zufallszahl1 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
					 zufallszahl2 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
				}
				field[zufallszahl1][zufallszahl2] = i;
			}
		}
		
		for(int i=1;i<fieldsize+fieldsize+1;i++) {
			int zufallszahl1 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
			int zufallszahl2 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
			

			if(field[zufallszahl1][zufallszahl2] == 0) {
				field[zufallszahl1][zufallszahl2] = i;
			}
			else if(field[zufallszahl1][zufallszahl2] != 0) {
				while(field[zufallszahl1][zufallszahl2] != 0) {
					 zufallszahl1 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
					 zufallszahl2 = 0 + (int)(Math.random() * ((fieldsize-1 - 0) + 1));
				}
				field[zufallszahl1][zufallszahl2] = i;
			}
		}
		
	}
	
	
	
}
