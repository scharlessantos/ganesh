package ganesh.swing;

import ganesh.swing.ui.login.Login;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.scharlessantos.hermes.Hermes;

/**
 * 
 */
public class Starter {
	
	
	/**
	 * Inicia o GANESH Swing Client
	 */
	public static void main(String[] args){
		Hermes.info("" +
				"\n=====================================" +
				"\n    Starting Ganesh Swing Client" +
				"\n An open source program: NO WARRANTY" +
				"\n=====================================");

		try {
			Hermes.info("NimbusLookAndFeel");
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			Hermes.warn("No nimbus look and feel");
		}
		
		GaneshStart start = new GaneshStart();
		start.setName("Ganesh Start Thread");
		start.start();
		
	}
	
	private static class GaneshStart extends Thread{

		private Login login;

		
		@Override
		public void run() {
			if (login==null)
				login = new Login();
			
			login.setLocationRelativeTo(null);
			
			login.setVisible(true);
		}
		
	}
}
