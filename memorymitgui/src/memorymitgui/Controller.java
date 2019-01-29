package memorymitgui;

import java.awt.EventQueue;

import memorymitgui.View;

public class Controller {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model test = new Model();
					test.fillrandom();
					test.gibfeldaus();
					View frame = new View();
					
					frame.fieldcopy();
					frame.fillbtnarr();
					frame.setstarticon();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		

	}

}
