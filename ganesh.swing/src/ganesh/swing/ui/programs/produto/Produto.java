/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.swing.ui.programs.produto;

import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Produto {

	private JFrame frmCadastroDeProdutos;
	private JTextField txtCodProduto;
	private JTextField txtNomeProduto;
	private JTextField txtComplementoProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Produto window = new Produto();
					window.frmCadastroDeProdutos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Produto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeProdutos = new JFrame();
		frmCadastroDeProdutos.setTitle("Cadastro de Produtos ");
		frmCadastroDeProdutos.setBounds(100, 100, 363, 299);
		frmCadastroDeProdutos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeProdutos.getContentPane().setLayout(null);

		txtCodProduto = new JTextField();
		txtCodProduto.setBounds(30, 51, 73, 20);
		frmCadastroDeProdutos.getContentPane().add(txtCodProduto);
		txtCodProduto.setColumns(10);

		txtNomeProduto = new JTextField();
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(30, 107, 164, 20);
		frmCadastroDeProdutos.getContentPane().add(txtNomeProduto);

		txtComplementoProduto = new JTextField();
		txtComplementoProduto.setColumns(10);
		txtComplementoProduto.setBounds(30, 161, 210, 20);
		frmCadastroDeProdutos.getContentPane().add(txtComplementoProduto);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(30, 26, 46, 14);
		frmCadastroDeProdutos.getContentPane().add(lblCdigo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 82, 46, 14);
		frmCadastroDeProdutos.getContentPane().add(lblNome);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(30, 136, 73, 14);
		frmCadastroDeProdutos.getContentPane().add(lblComplemento);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pes\u00E1vel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(264, 36, 73, 55);
		frmCadastroDeProdutos.getContentPane().add(panel);

		Checkbox checkbox = new Checkbox("Sim");
		panel.add(checkbox);

		Panel panel_1 = new Panel();
		panel_1.setBounds(30, 212, 291, 33);
		frmCadastroDeProdutos.getContentPane().add(panel_1);

		JButton btnNovo = new JButton("Novo");
		panel_1.add(btnNovo);

		JButton btnAlterar = new JButton("Alterar");
		panel_1.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		panel_1.add(btnExcluir);

		JButton btnCancel = new JButton("Cancelar");
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
		btnAlterar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
		btnNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
	}
}
