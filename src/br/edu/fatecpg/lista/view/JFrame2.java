package br.edu.fatecpg.lista.view;
 
import java.awt.EventQueue;

import java.util.ArrayList;
 
import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
 
import br.edu.fatecpg.lista.model.Aluno;

import javax.swing.JComboBox;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
 
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.Color;
 
public class JFrame2 extends JFrame {
 
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txt_name;

	private JTextField txt_tel;
 
	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					JFrame2 frame = new JFrame2(null);

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}
 
	/**

	 * Create the frame.

	 * @param listaAlunos 

	 */

	public JFrame2(ArrayList<Aluno> listaAlunos) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lbl_nome = new JLabel("Nome:");

		lbl_nome.setBounds(22, 106, 70, 15);

		contentPane.add(lbl_nome);

		JLabel lbl_telefone = new JLabel("Telefone:");

		lbl_telefone.setBounds(12, 148, 70, 15);

		contentPane.add(lbl_telefone);

		txt_name = new JTextField();
		txt_name.setBackground(new Color(211, 211, 211));

		txt_name.setBounds(84, 104, 114, 19);

		contentPane.add(txt_name);

		txt_name.setColumns(10);

		txt_tel = new JTextField();
		txt_tel.setBackground(new Color(211, 211, 211));

		txt_tel.setBounds(84, 146, 114, 19);

		contentPane.add(txt_tel);

		txt_tel.setColumns(10);

		JComboBox<Aluno> comboBox = new JComboBox<>(listaAlunos.toArray(new Aluno[0]));
		comboBox.setBackground(new Color(216, 191, 216));

		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();

				if(alunoSelecionado != null) {

					txt_name.setText(alunoSelecionado.getNome());

					txt_tel.setText(alunoSelecionado.getTelefone());					

				}

			}

		});

		comboBox.setBounds(109, 12, 208, 29);

		contentPane.add(comboBox);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setForeground(new Color(230, 230, 250));
		btnCadastro.setBackground(new Color(153, 51, 204));

		btnCadastro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFrame1 jFrame1 = new JFrame1();

				jFrame1.setVisible(true);

			}

		});

		btnCadastro.setBounds(321, 226, 117, 25);

		contentPane.add(btnCadastro);


		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(new Color(230, 230, 250));
		btnAlterar.setBackground(new Color(147, 112, 219));

		btnAlterar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String nome = txt_name.getText();

				String telefone = txt_tel.getText();

				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();

				if (!nome.isEmpty()&&!telefone.isEmpty()) {

				alunoSelecionado.setNome(nome);

				alunoSelecionado.setTelefone(telefone);

				JOptionPane.showMessageDialog(btnAlterar, "Alterado com sucesso!");

				txt_name.setText("");

				txt_tel.setText("");

			}else {

				JOptionPane.showMessageDialog(btnAlterar, "Erro ao alterar!");

				}}

		});

		btnAlterar.setBounds(81, 177, 117, 25);

		contentPane.add(btnAlterar);


		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(230, 230, 250));
		btnExcluir.setBackground(new Color(147, 112, 219));

		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();

				int i =  JOptionPane.showConfirmDialog(btnExcluir, "Tem certeza que deseja excluir este aluno?");

				if(i == JOptionPane.YES_OPTION) {

					listaAlunos.remove(alunoSelecionado);

					JOptionPane.showMessageDialog(btnExcluir, "Excluido com sucesso!");

				}

				comboBox.removeAllItems();

				for (Aluno aluno : listaAlunos) {

					comboBox.addItem(aluno);

				}

				txt_name.setText("");

				txt_tel.setText("");				

			}

		});

		btnExcluir.setBounds(81, 214, 117, 25);

		contentPane.add(btnExcluir);

 
	}

}

 