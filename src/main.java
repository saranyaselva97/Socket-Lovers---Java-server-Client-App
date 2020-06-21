
import java.awt.EventQueue;
import javax.swing.JFrame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MRBUDDY
 */
public class main {
    public static void main(String[] args) {  // functions starts here
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerView window = new ServerView();  // object creation
					window.frame.setVisible(true); // make jframe visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
}
