package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.lista.model.Aluno;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JFrame1 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame1 frame = new JFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_nome = new JTextField();
		txt_nome.setBackground(new Color(230, 230, 250));
		txt_nome.setToolTipText("Nome do Aluno");
		txt_nome.setBounds(68, 32, 211, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_telefone = new JTextField();
		txt_telefone.setBackground(new Color(230, 230, 250));
		txt_telefone.setToolTipText("Telefone do Aluno");
		txt_telefone.setBounds(68, 81, 211, 19);
		contentPane.add(txt_telefone);
		txt_telefone.setColumns(10);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.setForeground(new Color(230, 230, 250));
		btn_cadastrar.setBackground(new Color(153, 51, 204));
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cadastrar aluno na lista
				String nome = txt_nome.getText();
				String telefone = txt_telefone.getText();			
				if (!nome.isEmpty()&&!telefone.isEmpty()) {
					Aluno aluno = new Aluno(nome, telefone);
					listaAlunos.add(aluno);
					// ou ListaAlunos.add(new Aluno(nome,telefone));
					JOptionPane.showMessageDialog(btn_cadastrar, "Cadastrado com sucesso!");
					txt_nome.setText("");
					txt_telefone.setText("");
					
				}else {
					JOptionPane.showMessageDialog(btn_cadastrar, "Campos vazios!");
				}
			}
		});
		btn_cadastrar.setBounds(68, 137, 211, 25);
		contentPane.add(btn_cadastrar);
		
		JButton btn_listar = new JButton("Listar");
		btn_listar.setForeground(new Color(230, 230, 250));
		btn_listar.setBackground(new Color(147, 112, 219));
		btn_listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame2 jFrame2 = new JFrame2(listaAlunos);
				jFrame2.setVisible(true);
			}
		});
		btn_listar.setBounds(258, 232, 76, 19);
		contentPane.add(btn_listar);
	}
}
