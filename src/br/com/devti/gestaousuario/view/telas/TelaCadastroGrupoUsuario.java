package br.com.devti.gestaousuario.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.gestaousuario.core.entity.GrupoUsuarioEntity;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.service.GrupoUsuarioService;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroGrupoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroGrupoUsuario frame = new TelaCadastroGrupoUsuario();
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
	public TelaCadastroGrupoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome do grupo:");
		nomeLabel.setBounds(32, 119, 78, 14);
		contentPane.add(nomeLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(125, 116, 244, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel tituloLabel = new JLabel("Cadastro de grupo de usu\u00E1rios");
		tituloLabel.setFont(new Font("Tahoma", Font.ITALIC, 25));
		tituloLabel.setBounds(32, 11, 375, 65);
		contentPane.add(tituloLabel);
		
		JButton cadastrarbutton = new JButton("CADASTRAR");
		cadastrarbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupoUsuarioEntity grupoUsuario = new GrupoUsuarioEntity();
				grupoUsuario.setNomeGrupo(nomeField.getText());
				try {
					JOptionPane.showMessageDialog(null, new GrupoUsuarioService().salvarGrupoUsuario(grupoUsuario));
				} catch (HeadlessException | NegocioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cadastrarbutton.setBounds(164, 180, 105, 23);
		contentPane.add(cadastrarbutton);
	}
}
