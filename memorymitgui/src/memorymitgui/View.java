package memorymitgui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Timer;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.jws.WebParam.Mode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

public class View extends JFrame {
	JButton spieler = new JButton(); // button zumanzeigen des aktuellen spielers
	// 
	
	private static JButton[][] btn = new JButton[Model.getFieldsize()][Model.getFieldsize()]; // array in welchem die buttons gespeichert werden
	JButton b1 = new JButton("");
	JButton b2 = new JButton("");
	JButton b3 = new JButton("");
	JButton b4 = new JButton("");
	JButton b5 = new JButton("");
	JButton b6 = new JButton("");
	JButton b7 = new JButton("");
	JButton b8 = new JButton("");
	JButton b9 = new JButton("");
	JButton b10 = new JButton("");
	JButton b11 = new JButton("");
	JButton b12 = new JButton("");
	JButton b13 = new JButton("");
	JButton b14 = new JButton("");
	JButton b15 = new JButton("");
	JButton b16 = new JButton("");
	// buttons werden erzeugt
	
	
	
	public static JButton[][] getbtn(){
		return btn;
	}
	
	
	boolean[][] bt = new boolean[Model.getFieldsize()][Model.getFieldsize()];
	
	public void gibfeldaus() {
		for(int i=0;i<Model.getFieldsize();i++) {
			
			for(int j=0;j<Model.getFieldsize();j++) {
				System.out.print(neuarr[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void fillbtnarr() { // das array wird mit dem entsprechenden buttons wird gefüllt
		btn[0][0] = b1;
		btn[0][1] = b2;
		btn[0][2] = b3;
		btn[0][3] = b4;
		btn[1][0] = b5;
		btn[1][1] = b6;
		btn[1][2] = b7;
		btn[1][3] = b8;
		btn[2][0] = b9;
		btn[2][1] = b10;
		btn[2][2] = b11;
		btn[2][3] = b12;
		btn[3][0] = b13;
		btn[3][1] = b14;
		btn[3][2] = b15;
		btn[3][3] = b16;
	}

	
	public void ausgabe(){ // methode  zum debug, gibt inhalt des Modellarray aus
		for(int i=0;i<Model.getFieldsize();i++) {
			for(int j=0;j<Model.getFieldsize();j++) {
				System.out.println(neuarr[i][j]);
			}
		}
		}
	
	String buttonidf = "";
	String neu = "";
	public void setstarticon() { // für jeden button wird das starticon gesetzt
		for(int i=0;i<Model.getFieldsize();i++) {
			for(int j=0;j<Model.getFieldsize();j++) {
				btn[i][j].setIcon(new ImageIcon(View.class.getResource("starticon.png")));
			}
		}
	}
	private JPanel contentPane; // das jpanel wird erzeugt
	private MouseAdapter mouseListener;         
	int[][] neuarr = new int[Model.getFieldsize()][Model.getFieldsize()];  // ein array wird erzeugt, es hat so viele elemente , wie das Model array
	public void fieldcopy() {
		neuarr = Model.getField().clone(); // neuarr wird mit werten vom Modellarray belegt, dieses istalso eine kopie davon
	}

	public View() {
		/*
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 440);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setVisible(true);
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		*/
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// so machen dass beim mausklick die position des buttons an model Ã¼bergeben werden kann !
		
		GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
		gbc_btnNewButton1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton1.gridx = 0;
		gbc_btnNewButton1.gridy = 0;
		contentPane.add(b1, gbc_btnNewButton1);
		b1.setVisible(true);
		
        b1.addMouseListener( new Clicker() );
		b1.requestFocus();
		
		
	        
		GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
		gbc_btnNewButton2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton2.gridx = 0;
		gbc_btnNewButton2.gridy = 1;
		contentPane.add(b2, gbc_btnNewButton2);
		b2.setVisible(true);
		b2.addMouseListener( new Clicker() );
		b2.requestFocus();
		
		
		
		GridBagConstraints gbc_btnNewButton3 = new GridBagConstraints();
		gbc_btnNewButton3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton3.gridx = 0;
		gbc_btnNewButton3.gridy = 2;
		contentPane.add(b3, gbc_btnNewButton3);
		b3.setVisible(true);
		b3.addMouseListener( new Clicker() );
		b3.requestFocus();
		
		GridBagConstraints gbc_btnNewButton4 = new GridBagConstraints();
		gbc_btnNewButton4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton4.gridx = 0;
		gbc_btnNewButton4.gridy = 3;
		contentPane.add(b4, gbc_btnNewButton4);
		b4.setVisible(true);
		b4.addMouseListener( new Clicker() );
		b4.requestFocus();
		
		
		GridBagConstraints gbc_btnNewButton5 = new GridBagConstraints();
		gbc_btnNewButton5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton5.gridx = 1;
		gbc_btnNewButton5.gridy = 0;
		contentPane.add(b5, gbc_btnNewButton5);
		b5.setVisible(true);
		b5.addMouseListener( new Clicker() );
		b5.requestFocus();
		
		
		GridBagConstraints gbc_btnNewButton6 = new GridBagConstraints();
		gbc_btnNewButton6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton6.gridx = 1;
		gbc_btnNewButton6.gridy = 1;
		contentPane.add(b6, gbc_btnNewButton6);
		b6.setVisible(true);
		b6.addMouseListener( new Clicker() );
		b6.requestFocus();
		
		GridBagConstraints gbc_btnNewButton7 = new GridBagConstraints();
		gbc_btnNewButton7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton7.gridx = 1;
		gbc_btnNewButton7.gridy = 2;
		contentPane.add(b7, gbc_btnNewButton7);
		b7.setVisible(true);
		b7.addMouseListener( new Clicker() );
		b7.requestFocus();
		
		GridBagConstraints gbc_btnNewButton8 = new GridBagConstraints();
		gbc_btnNewButton8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton8.gridx = 1;
		gbc_btnNewButton8.gridy = 3;
		contentPane.add(b8, gbc_btnNewButton8);
		b8.setVisible(true);
		b8.addMouseListener( new Clicker() );
		b8.requestFocus();
		
		GridBagConstraints gbc_btnNewButton9 = new GridBagConstraints();
		gbc_btnNewButton9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton9.gridx = 2;
		gbc_btnNewButton9.gridy = 0;
		contentPane.add(b9, gbc_btnNewButton9);
		b9.setVisible(true);
		b9.addMouseListener( new Clicker() );
		b9.requestFocus();
		
		GridBagConstraints gbc_btnNewButton10 = new GridBagConstraints();
		gbc_btnNewButton10.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton10.gridx = 2;
		gbc_btnNewButton10.gridy = 1;
		contentPane.add(b10, gbc_btnNewButton10);
		b10.setVisible(true);
		b10.addMouseListener( new Clicker() );
		b10.requestFocus();
		
		GridBagConstraints gbc_btnNewButton11 = new GridBagConstraints();
		gbc_btnNewButton11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton11.gridx = 2;
		gbc_btnNewButton11.gridy = 2;
		contentPane.add(b11, gbc_btnNewButton11);
		b11.setVisible(true);
		b11.addMouseListener( new Clicker() );
		b11.requestFocus();
		
		GridBagConstraints gbc_btnNewButton12 = new GridBagConstraints();
		gbc_btnNewButton12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton12.gridx = 2;
		gbc_btnNewButton12.gridy = 3;
		contentPane.add(b12, gbc_btnNewButton12);
		b12.setVisible(true);
		b12.addMouseListener( new Clicker() );
		b12.requestFocus();
		
		GridBagConstraints gbc_btnNewButton13 = new GridBagConstraints();
		gbc_btnNewButton13.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton13.gridx = 3;
		gbc_btnNewButton13.gridy = 0;
		contentPane.add(b13, gbc_btnNewButton13);
		b13.setVisible(true);
		b13.addMouseListener( new Clicker() );
		b13.requestFocus();
		
		GridBagConstraints gbc_btnNewButton14 = new GridBagConstraints();
		gbc_btnNewButton14.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton14.gridx = 3;
		gbc_btnNewButton14.gridy = 1;
		contentPane.add(b14, gbc_btnNewButton14);
		b14.setVisible(true);
		b14.addMouseListener( new Clicker() );
		b14.requestFocus();
		
		GridBagConstraints gbc_btnNewButton15 = new GridBagConstraints();
		gbc_btnNewButton15.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton15.gridx = 3;
		gbc_btnNewButton15.gridy = 2;
		contentPane.add(b15, gbc_btnNewButton15);
		b15.setVisible(true);
		b15.addMouseListener( new Clicker() );
		b15.requestFocus();
		
		GridBagConstraints gbc_btnNewButton16 = new GridBagConstraints();
		gbc_btnNewButton16.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton16.gridx = 3;
		gbc_btnNewButton16.gridy = 3;
		contentPane.add(b16, gbc_btnNewButton16);
		b16.setVisible(true);
		b16.addMouseListener( new Clicker() );
		b16.requestFocus();
		
		
		GridBagConstraints gbc_spieler = new GridBagConstraints();
		gbc_spieler.insets = new Insets(0, 0, 5, 0);
		gbc_spieler.gridx = 4;
		gbc_spieler.gridy = 0;
		contentPane.add(spieler, gbc_spieler);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.setText("spieler1punktzahl");
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.setText("spieler2punktzahl");
		
		
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 5;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 5;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
	}
	int counter = 0; // zähler zum für jedes klicken 
	int indexi = 2;
	int indexj = 0;
	int indexi1 = 1;
	int indexj1 = 2;
	int globalcount=0;
	int spieler1count = 0;
	int spieler2count = 0;
	int samecount =0;
	
	ArrayList<Integer> liste = new ArrayList<Integer>();
	private final JButton btnNewButton = new JButton("New button");
	private final JButton btnNewButton_1 = new JButton("New button");
	private final JButton btnNewButton_2 = new JButton("New button");
	private final JButton btnNewButton_3 = new JButton("New button");
	private class Clicker implements MouseListener{
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		counter++;
		if(globalcount % 2 == 0) {
			System.out.println("Spieler 1 ist dran");
			spieler.setText("Spieler 1");
			
		}
		else if(globalcount % 2 != 0)  {
			System.out.println("Spieler 2 ist dran");
			spieler.setText("Spieler 2");
		}
			if(counter == 2) {
				globalcount++;
			}
			if(samecount == 7) {
				if(globalcount % 2 == 0) {
					spieler1count++;
					
				}
				else if(globalcount % 2 != 0)  {
					spieler2count++;
				}
				if(spieler1count > spieler2count) {
					spieler.setText("spieler 1 hat gewonnen");
				}
				else {
					spieler.setText("spieler 2 hat gewonnen");
				}
				
			}
		
			
		if(counter == 3) {
			if(neuarr[indexi][indexj] == neuarr[indexi1][indexj1]) {
				samecount++;
				btn[indexi][indexj].setIcon(new ImageIcon(View.class.getResource(("btngleich.png"))));
				btn[indexi1][indexj1].setIcon(new ImageIcon(View.class.getResource(("btngleich.png"))));
				counter =1;
				bt[indexi][indexj] = false;
				bt[indexi1][indexj1] = false;
				btn[indexi][indexj].setEnabled(false);
				btn[indexi1][indexj1].setEnabled(false);
				if(globalcount % 2 == 0) {
					spieler1count++;
					btnNewButton_3.setText(Integer.toString(spieler1count));
					System.out.println(spieler1count);
				}
				else if(globalcount % 2 != 0) {
					spieler2count++;
					btnNewButton_2.setText(Integer.toString(spieler2count));
					System.out.println(spieler2count);
				}
			}
			else if((neuarr[indexi][indexj] != neuarr[indexi1][indexj1])) {
				btn[indexi][indexj].setIcon(new ImageIcon(View.class.getResource("starticon.png")));
				
				btn[indexi1][indexj1].setIcon(new ImageIcon(View.class.getResource("starticon.png")));
				
				counter =1;
			}
			
		}
		
		
			// sagen wecher spieler dran ist
			for(int i =0;i<Model.getFieldsize();i++) {
				for(int j=0;j<Model.getFieldsize();j++) {
					if(btn[i][j] == e.getSource()) {
						
						if(counter ==1) {
							indexi =i;
							indexj=j;
						}
						else if(counter == 2) {
							indexi1 = i;
							indexj1=j;
						}
						
						switch(neuarr[i][j]) {
						case 1:
							
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild1.png")));
							
							validate();
							
							break;
						case 2:
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild2.png")));
							validate();
							
							break;
						case 3:
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild3.png")));				
							validate();
							
							break;
						case 4:
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild4.png")));		
							validate();
							 
							break;
						case 5:
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild5.png")));		
							validate();
							
							break;
						case 6:
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild6.png")));			
							validate();
							
							break;
						case 7:
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild7.png")));			
							validate();
							 
							break;
						case 8:
							btn[i][j].setIcon(new ImageIcon(View.class.getResource("bild8.png")));		
							validate();
							
							break;
						}
					}
					
				}
			}
	
			
			
				
				/*
				if(neuarr[indexj][indexi] == neuarr[indexj1][indexi1]) {
					System.out.println("gleich");
					btn[indexi][indexj].setIcon(null);
					btn[indexi1][indexj1].setIcon(null);
				}
				else {
					System.out.println("ungleixh");
					btn[indexi][indexj].setIcon(new ImageIcon("rsc/starticon.png")); 
				    btn[indexi1][indexj1].setIcon(new ImageIcon("rsc/starticon.png")); 
				}
				*/
				
				
				
				
				
			
				/*
				if(Model.getField()[indexi][indexj] == Model.getField()[indexi1][indexj1] )	{
					btn[indexi][indexj].setIcon(null);
					btn[indexi1][indexj1].setIcon(null);
				}
				else 	{
					btn[indexi][indexj].setIcon(new ImageIcon(View.class.getResource("starticon.png")));
					btn[indexi1][indexj1].setIcon(new ImageIcon(View.class.getResource("starticon.png")));
					
				}
				*/
				/*
				if(counter == 4) {
					
					if(Model.getField()[indexi][indexj] == Model.getField()[indexi1][indexj1] )	{
						btn[indexi][indexj].setIcon(null);
						btn[indexi1][indexj1].setIcon(null);
					}
					else 	{
						btn[indexi][indexj].setIcon(new ImageIcon(View.class.getResource("starticon.png")));
						btn[indexi1][indexj1].setIcon(new ImageIcon(View.class.getResource("starticon.png")));
						
					}
				}
				*/
				
			}
			
			
			
			
		
			//Model.spiel(MouseEvent e);
// wenn ein button geklickt wurde kann ich genau sagen welcher button es war dann
			// muss der spielzug vollfÃ¼hrt werden mit einer methode ??
			/*
			if(e.getSource() == b1) {
				clicked[0][0] = true;
				 // JA SO GEHT DAS BEI DRÃœCKEN WIRD METHODE AUFGERUFEN DIE
				// DIE CLICKS VERARBEITET
				// GUTE MÃ–GLICHKEIT : b1.setIcon(null);
		
			}
			if(e.getSource() == b2) {
				clicked[0][1] = true;
				 System.out.println("clicked");
				
			}
			if(e.getSource() == b3) {
				clicked[0][2] = true;
				
			}
			if(e.getSource() == b4) {
				clicked[0][3] = true;
				
			}
			if(e.getSource() == b5) {
				clicked[1][0] = true;
				 
			}
			if(e.getSource() == b6) {
				clicked[1][1] = true;
				 
			}
			if(e.getSource() == b7) {
				clicked[1][2] = true;
			}if(e.getSource() == b8) {
				clicked[1][3] = true;
			}
			if(e.getSource() == b9) {
				clicked[2][0] = true;
			}
			if(e.getSource() == b10) {
				clicked[2][1] = true;
			}
			if(e.getSource() == b11) {
				clicked[2][2] = true;
				 
			}
			if(e.getSource() == b12) {
				clicked[2][3] = true;
			}
			if(e.getSource() == b13) {
				clicked[3][0] = true;
			}
			if(e.getSource() == b14) {
				clicked[3][1] = true;
			}
			if(e.getSource() == b15) {
				clicked[3][2] = true;
			}
			if(e.getSource() == b16) {
				clicked[3][3] = true;
			}

			
		}
		*/

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
	}
	}
	


