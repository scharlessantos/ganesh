package ganesh.swing.ui.login;

import ganesh.common.request.Request;
import ganesh.common.response.Response;
import ganesh.swing.ui.MessageHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.scharlessantos.hermes.Hermes;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5127775206753150588L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Ganesh Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(12, 0, 166, 255);
		label.setIcon(new ImageIcon(""));
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(189, 12, 260, 202);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(13, 12, 70, 15);
		panel.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(12, 36, 236, 38);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(13, 78, 70, 15);
		panel.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(12, 105, 236, 38);
		panel.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBounds(12, 147, 117, 38);
		panel.add(btnAcessar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(131, 147, 117, 38);
		panel.add(btnSair);

		JButton btnConfigurar = new JButton("C");
		btnConfigurar.setBounds(417, 230, 32, 25);
		contentPane.add(btnConfigurar);
		btnSair.addActionListener(new btnSairListener());
		btnAcessar.addActionListener(new btnOkListener());
	}

	@Override
	public void setVisible(boolean b) {
		Hermes.info("starting...");
		super.setVisible(b);
	}

	private class btnOkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Request req = new Request();
			Response resp = req.doRequest();

			if (resp.getMessage() != null)
				MessageHandler.show(resp.getMessage());

			if (resp.getSession() != null) {

			} else
				Hermes.info("Tentativa de login falhou");
		}

	}

	private class btnSairListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(Login.this, "Deseja realmente sair?", "Saindo...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
				System.exit(0);
			else
				txtUsuario.requestFocus();
		}

	}

}
