

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ZellenWeltSwingMain {
	
	  public static void createAndShowGui() {
	        JFrame f = new JFrame("Zellenwelt");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        Container panel = new ZellenWelt();
	        f.getContentPane().add(panel, BorderLayout.CENTER);
	       
	        f.setLocationRelativeTo(null);
	        f.setSize(300, 300);
//	        f.pack();
	        f.setVisible(true);
	    }

	    public static void main(final String[] args) {
	        Runnable gui = new Runnable() {

	            @Override
	            public void run() {
	                createAndShowGui();
	            }
	        };
	        //GUI must start on EventDispatchThread:
	        SwingUtilities.invokeLater(gui);
	    }

}
