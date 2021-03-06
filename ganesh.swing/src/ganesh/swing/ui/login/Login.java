/*Ganesh Swing Client, developed in 2013*/
package ganesh.swing.ui.login;

import ganesh.common.request.LoginRequest;
import ganesh.common.response.Response;
import ganesh.swing.GaneshSwing;
import ganesh.swing.Starter;
import ganesh.swing.ui.GaneshFrame;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.controls.I18nButton;
import ganesh.swing.ui.images.Images;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.scharlessantos.atlas.Language;
import org.scharlessantos.hermes.Hermes;

public class Login extends GaneshFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 734600433675637333L;

	private JPanel contentPanel;
	private JPanel i18nPanel;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JButton btnAcessar;
	private JButton btnSair;

	private boolean close = true;

	/**
	 * Create the frame.
	 */
	public Login() {
		super();
		setResizable(false);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new SairListener());

		setTitle("Ganesh Login");
		setBounds(100, 100, 473, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(12, 0, 166, 255);
		label.setIcon(Images.get(Images.GANESH));
		contentPanel.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(189, 12, 260, 202);
		contentPanel.add(panel);
		panel.setLayout(null);

		lblUsuario = new JLabel(M.usuario());
		lblUsuario.setBounds(13, 12, 70, 15);
		panel.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(12, 36, 236, 38);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblSenha = new JLabel(M.senha());
		lblSenha.setBounds(13, 78, 70, 15);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(12, 105, 236, 38);
		panel.add(txtSenha);
		txtSenha.setColumns(10);

		btnAcessar = new JButton(M.acessar());
		btnAcessar.setBounds(12, 147, 117, 38);
		panel.add(btnAcessar);

		btnSair = new JButton(M.sair());
		btnSair.setBounds(131, 147, 117, 38);
		panel.add(btnSair);

		//Botões de i18n
		i18nPanel = new JPanel();
		i18nPanel.setBorder(new TitledBorder(M.idioma()));
		i18nPanel.setBounds(350, 218, 100, 52);
		contentPanel.add(i18nPanel);
		i18nPanel.setLayout(null);

		JButton btn = new I18nButton(Language.PT_BR, true);
		btn.setBounds(13, 18, 36, 25);
		i18nPanel.add(btn);

		btn = new I18nButton(Language.EN_US, true);
		btn.setBounds(52, 18, 36, 25);
		i18nPanel.add(btn);

		btnSair.addActionListener(new SairListener());
		btnAcessar.addActionListener(new OkListener());
	}

	@Override
	public void setVisible(boolean b) {
		Hermes.info("starting...");
		super.setVisible(b);
	}

	private class OkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LoginRequest req = new LoginRequest(txtUsuario.getText(), txtSenha.getText(), GaneshSwing.getLanguage());
			Response resp = req.doRequest();

			if (resp.getMessage() != null)
				MessageHandler.show(resp.getMessage());

			if (resp.getSession() != null) {
				GaneshSwing.setSession(resp.getSession());
				Login.this.close = false;
				Login.this.processWindowEvent(new WindowEvent(Login.this, WindowEvent.WINDOW_CLOSING));
			} else
				Hermes.info("Tentativa de login falhou");
		}
	}

	private class SairListener extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Login.this.processWindowEvent(new WindowEvent(Login.this, WindowEvent.WINDOW_CLOSING));
		}

		@Override
		public void windowClosing(WindowEvent e) {
			if (Login.this.close) {
				if (JOptionPane.showConfirmDialog(Login.this, M.desejaRealmenteSair(), M.saindo() + "...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					System.exit(0);
				else {
					txtUsuario.requestFocus();
				}
			} else {
				Starter.loadMain();
				Login.this.dispose();
			}
		}

	}

	@Override
	public void onLanguageChanged() {
		lblUsuario.setText(M.usuario());
		lblSenha.setText(M.senha());
		btnAcessar.setText(M.acessar());
		btnSair.setText(M.sair());

		txtUsuario.setText("");
		txtSenha.setText("");

		txtUsuario.requestFocus();

		((TitledBorder)i18nPanel.getBorder()).setTitle(M.idioma());

		repaint();
	}

}
