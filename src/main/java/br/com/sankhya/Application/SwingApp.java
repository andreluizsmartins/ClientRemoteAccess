package br.com.sankhya.Application;



import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import br.com.sankhya.db.DataBaseFactory;
import br.com.sankhya.model.AccessConnet;
import br.com.sankhya.model.ConsentAccess;
import br.com.sankhya.sshManager.sshManager;


@SpringBootApplication
public class SwingApp extends JFrame {
	 JTextField txtHost;
	 JTextField txtLocalPort;
	 JTextField txtHostRemote;
	 JTextField txtRemotePort;
	 JTextField txtUsername;
	 JTextField txtPassword;
	 JTextField txtPrivateKey;
	private ConsentAccess cacc;
	private JButton btnConnect;
	private JButton btnDisconnect;
	private JLabel lblAlerta;
	private JTextPane txtArea1;
	private JComboBox comboBox;
	private JButton btnOpen = new JButton("O");
	private JButton open = new JButton("Open"), save = new JButton("Save");
	boolean db;
	boolean app;
	boolean connect = false;
	StringBuilder message = new StringBuilder();
	Session session;
	private static SwingApp ex;
	@Autowired
    private Map<String, Session> eventsMap;
	
	public static void main(String[] args) {
	
	    	ConfigurableApplicationContext  ctx = new SpringApplicationBuilder(SwingApp.class)
	                .headless(false).run(args);
	
	        EventQueue.invokeLater(() -> {
	
	        	ex = ctx.getBean(SwingApp.class);
	            ex.setVisible(true);
	        });
	         
	    }
	public void populateCombo() {
		comboBox.removeAllItems();
		for(String hash : DataBaseFactory.getHash()) {
        	comboBox.addItem(hash);
        }
	}  
    public SwingApp() {
    	setResizable(false);
    	//DataBaseFactory.dropTables();
    	DataBaseFactory.setTables();
        initUI();
        createLayout();
        populateCombo();
        
       
      //  URL iconURL = getClass().getResource("/img/80635e6-small-Sankhya_site_favicon_32x32_1.png");
       // iconURL is null when not found
      //  ImageIcon icon = new ImageIcon(iconURL);
      //  this.setIconImage(icon.getImage());
        
    }
    
    public boolean getApp() {
    	return app;
    }
    public boolean getBD() {
    	return db;
    }
    public void updateMsg(String msg){
    	message.append(msg+"\r\n");
    	txtArea1.setText(message.toString());
    	
    }

    private void initUI() {

        setTitle("Tunneling Smart");
        setSize(904, 477);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLayout() {

    	Container pane = getContentPane();
    	
    	JLabel lblNewLabel_2 = new JLabel("Host:");
    	lblNewLabel_2.setBounds(40, 108, 42, 14);
    	
    	txtHost = new JTextField();
    	txtHost.setBounds(92, 105, 494, 20);
    	txtHost.setColumns(10);
    	
    	JLabel lblNewLabel_3 = new JLabel("Portal Local:");
    	lblNewLabel_3.setBounds(10, 139, 72, 14);
    	
    	txtLocalPort = new JTextField();
    	txtLocalPort.setBounds(90, 136, 259, 20);
    	txtLocalPort.setColumns(10);
    	
    	JLabel lblNewLabel_4 = new JLabel("Host Remoto:");
    	lblNewLabel_4.setBounds(359, 139, 55, 14);
    	
    	txtHostRemote = new JTextField();
    	txtHostRemote.setBounds(420, 136, 120, 20);
    	txtHostRemote.setColumns(10);
    	
    	JLabel lblNewLabel_5 = new JLabel("Porta Remota:");
    	lblNewLabel_5.setBounds(550, 139, 65, 14);
    	
    	txtRemotePort = new JTextField();
    	txtRemotePort.setBounds(622, 136, 147, 20);
    	txtRemotePort.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Username:");
    	lblNewLabel_8.setBounds(20, 79, 65, 14);
		JLabel lblNewLabel_7 = new JLabel("Password:");
    	lblNewLabel_7.setBounds(260, 79, 65, 14);

		JLabel lblNewLabel_9 = new JLabel("PrivateKey:");
    	lblNewLabel_9.setBounds(510, 79, 65, 14);
    	
		txtPrivateKey = new JTextField();
    	txtPrivateKey.setBounds(590, 79, 200, 20);
    	txtPrivateKey.setColumns(20);

		txtUsername = new JTextField();
    	txtUsername.setBounds(94, 79, 147, 20);
    	txtUsername.setColumns(10);

		txtPassword = new JTextField();
    	txtPassword.setBounds(340, 79, 147, 20);
    	txtPassword.setColumns(10);
    	
		btnOpen.setBounds(799, 79, 23, 23);
		btnOpen.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
				updateMsg("Iniciando Conexão>>>>");
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(lblNewLabel_9);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					//filename.setText(c.getSelectedFile().getName());
					txtPrivateKey.setText(c.getCurrentDirectory().toString()+"\\"+c.getSelectedFile().getName());
				}
				if (rVal == JFileChooser.CANCEL_OPTION) {
					//filename.setText("You pressed cancel");
					txtPrivateKey.setText("");
				}
			}
		});

    	btnConnect = new JButton("Conectar");
    	btnConnect.setBounds(299, 167, 112, 23);
    	btnConnect.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			 
		updateMsg("Iniciando Conexão>>>>");
	
			
		AccessConnet accessConsent = new AccessConnet();
		try {
			accessConsent.setPass(txtPassword.getText());
			accessConsent.setUser(txtUsername.getText());
			accessConsent.setPortApp("");
			accessConsent.setPortdb(txtRemotePort.getText());
			accessConsent.setHostconn(txtHost.getText());
			accessConsent.setHostdb(txtHostRemote.getText());
			accessConsent.setPorthub01(txtLocalPort.getText());
			accessConsent.setPorthub02("");
			sshManager ssh = new sshManager();
			session=ssh.connect(accessConsent, "127.0.0.1", "127.0.0.1", "LOCALHOST", ex, txtPrivateKey.getText()) ;
			eventsMap.put(session.getHost(), session);	
					
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				updateMsg("Erro ao tentar realizar a conexão \n\r"+e1.getMessage());
			}finally {
					updateMsg("Conexão Realizada com sucesso!!");
					connect = true;
					Thread thread = new Thread() {
						@Override
						public void run() {
							do{
								try {
									Thread.sleep(1000+60+60);
									session.sendKeepAliveMsg();
									updateMsg(session.getHost());
									if(!session.isConnected()){
										session.connect();
									}
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}  catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

							}while(connect);
							
						}
					};
					thread.setPriority(1);
					thread.setName(session.getHost());
					thread.start();
			
				}
				    		
    		}
    		
    	});
    	
    	lblAlerta = new JLabel("");
    	lblAlerta.setBounds(93, 62, 0, 0);
    	lblAlerta.setBackground(Color.RED);
    	lblAlerta.setFont(new Font("Tahoma", Font.BOLD, 11));
    	
    	JButton btnDisconnect = new JButton("Desconectar");
    	btnDisconnect.setBounds(440, 167, 112, 23);
    	btnDisconnect.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(sshManager.isActivedSessionJsch(session)) {
	    			try {
						sshManager.close(ex, session);
						connect = false;
					} catch (JSchException e1) {
						updateMsg("Erro ao finalizar a conexão "+e1.getMessage());
						e1.printStackTrace();
					}
    			}else{
    				updateMsg("**********Não existe uma conexão ativa para ser fechada**********");
    			}
    		}
    	});
    	getContentPane().setLayout(null);
        getContentPane().add(lblNewLabel_3);
        getContentPane().add(lblNewLabel_2);
        getContentPane().add(txtHost);
        getContentPane().add(lblAlerta);
        getContentPane().add(txtLocalPort);
        getContentPane().add(btnConnect);
		getContentPane().add(btnOpen);
        getContentPane().add(btnDisconnect);
        getContentPane().add(lblNewLabel_4);
        getContentPane().add(txtHostRemote);
        getContentPane().add(lblNewLabel_5);
        getContentPane().add(txtRemotePort);
		getContentPane().add(lblNewLabel_7);
		getContentPane().add(lblNewLabel_8);
		getContentPane().add(lblNewLabel_9);
		getContentPane().add(txtUsername);
		getContentPane().add(txtPassword);
		getContentPane().add(txtPrivateKey);
        JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setLocation(30, 219);
        scrollPane.setSize(838, 160);
        
        getContentPane().add(scrollPane);
        
        txtArea1 = new JTextPane();
        txtArea1.setFont(new Font("DialogInput", Font.PLAIN, 11));
        txtArea1.setForeground(Color.GREEN);
        txtArea1.setBackground(Color.BLACK);
        txtArea1.setEditable(false);
        scrollPane.setViewportView(txtArea1);
        
        JLabel lblNewLabel_6 = new JLabel("Conn:");
        lblNewLabel_6.setBounds(31, 29, 46, 14);
        getContentPane().add(lblNewLabel_6);
        
        comboBox = new JComboBox();
        comboBox.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		
        		try {
					txtUsername.setText(Util.getDecoded(e.getItem().toString().split("::")[e.getItem().toString().split("::").length-1]).split(":")[0]);
					txtPassword.setText(Util.getDecoded(e.getItem().toString().split("::")[e.getItem().toString().split("::").length-1]).split(":")[1]);
					txtHost.setText(Util.getDecoded(e.getItem().toString().split("::")[e.getItem().toString().split("::").length-1]).split(":")[2]);
					txtHostRemote.setText(Util.getDecoded(e.getItem().toString().split("::")[e.getItem().toString().split("::").length-1]).split(":")[3]);
					txtLocalPort.setText(Util.getDecoded(e.getItem().toString().split("::")[e.getItem().toString().split("::").length-1]).split(":")[4]);
					txtRemotePort.setText(Util.getDecoded(e.getItem().toString().split("::")[e.getItem().toString().split("::").length-1]).split(":")[5]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        comboBox.setBounds(87, 26, 594, 20);
        getContentPane().add(comboBox);
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 11));
        btnSalvar.setToolTipText("Salvar");
        //btnSalvar.setIcon(new ImageIcon(SwingApp.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
        btnSalvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		vwSalvarHash frameHash = new vwSalvarHash(ex);
        		frameHash.setVisible(true);
        	}
        });
        btnSalvar.setBounds(701, 25, 80, 23);
        getContentPane().add(btnSalvar);
        
        JButton btnDeletar = new JButton("Apagar");
        btnDeletar.setFont(new Font("Arial", Font.BOLD, 11));
        btnDeletar.setToolTipText("Excluir");
        btnDeletar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(comboBox.getSelectedItem()!= null) {
        			Object[] options = {"Sim","Não"};
				if(JOptionPane.showOptionDialog(null, "Certeza em excluir registro?", "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0] )==0) {
	        		
	        		DataBaseFactory.deleteHash(comboBox.getSelectedItem().toString().split("::")[comboBox.getSelectedItem().toString().split("::").length-1]);
	        		populateCombo();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Não há regstro para deletar :)");
        		}
        	}
        });
        //btnDeletar.setIcon(new ImageIcon(SwingApp.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
        btnDeletar.setBounds(791, 25, 80, 23);
        getContentPane().add(btnDeletar);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(30, 62, 841, 1);
        getContentPane().add(separator);
        
        
    }
	
}