package br.com.sankhya.Application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.sankhya.db.DataBaseFactory;

public class vwSalvarHash extends JFrame {
	private JTextField txtHash;

	//public static vwSalvarHash frame = new vwSalvarHash();
	private JTextField txtDSCP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//vwAutenticar frame = new vwAutenticar();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vwSalvarHash(SwingApp ex) {
		setTitle("Acesso Remoto - Salvar Hash");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 161);
		getContentPane().setLayout(null);
		setLocation(700, 319);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setBounds(10, 56, 76, 14);
		getContentPane().add(lblNewLabel_1);
		

		
		JButton btnLogin = new JButton("Salvar");
		btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				if(!ex.txtUsername.getText().equals("") && !txtDSCP.getText().equals("") ){
					Object[] options = {"Sim","Não"};
					if(JOptionPane.showOptionDialog(null, "Deseja salvar essa nova configuração?", "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0] )==0) {
						try {
							DataBaseFactory.setHash(Util.getEncoded(ex.txtUsername.getText()+":"+ex.txtPassword.getText()+":"+ex.txtHost.getText()+":"+ex.txtHostRemote.getText()+":"+ex.txtLocalPort.getText()+":"+ex.txtRemotePort.getText()), txtDSCP.getText());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						ex.populateCombo();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Campos Hash e Descrição não podem ser vazios!", "Alerta", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(163, 84, 89, 23);
		getContentPane().add(btnLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				dispose();
			
			}
		});
		btnCancelar.setBounds(270, 84, 89, 23);
		getContentPane().add(btnCancelar);
		
		txtDSCP = new JTextField();
		txtDSCP.setColumns(10);
		txtDSCP.setBounds(86, 56, 413, 20);
		getContentPane().add(txtDSCP);
		
	}
}
