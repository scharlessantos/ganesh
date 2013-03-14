/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.swing.ui.programs.produto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		frmCadastroDeProdutos.setBounds(100, 100, 549, 325);
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

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
		btnNovo.setBounds(14, 212, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnNovo);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
		btnAlterar.setBounds(128, 212, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
		btnExcluir.setBounds(248, 212, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnExcluir);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}
		});
		btnCancel.setBounds(363, 212, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnCancel);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(30, 26, 46, 14);
		frmCadastroDeProdutos.getContentPane().add(lblCdigo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 82, 46, 14);
		frmCadastroDeProdutos.getContentPane().add(lblNome);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(30, 136, 73, 14);
		frmCadastroDeProdutos.getContentPane().add(lblComplemento);
	}
}
