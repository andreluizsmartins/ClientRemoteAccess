package br.com.sankhya.sshManager;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import br.com.sankhya.Application.SwingApp;
import br.com.sankhya.model.AccessConnet;

public class sshManager {
	
	public sshManager() {
		
	}

	public Session connect(AccessConnet accessConnet, String connectionIPRemote,  String connectionIP, String knownHostsFileNameString, SwingApp app, String keyPath) {
		Session session = null;
		StringBuilder message = new StringBuilder();
		app.updateMsg(" [REMOTE ACCESS - SSHManager.connect]: inciando conexão SSH.... \r\n");
		int intTimeOut = 86400000;// INFO: 24h = 86400000 ms;
		
		try {
			
			java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
			
			if (keyPath != ""){
				System.out.println(keyPath.getBytes());

				String key = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCHd91YwWnA9EqFwODgSGU5EdkOY3vWQ1eUZdxIjKegpX9x6yZSG5Q4BiJYVcEj3Wj6E0aQoJIURwceVCZkA6ekXdA8cZDuDOOde8KaUTAyxJkOE+TBGi9Us+qIq6Ggu3s8g/Qen9mPx60qrEQkNZwmKGc+kAYeDY85UGhuOKR5UJFPyXnIV+IR++fbygdqVsmfQfo7cIeqCcqZz9NiqpVMqyefppzHyCPIf8B9mUH/5ND2jsf/QtGB5anmQTk9tgLpjmyb1rESO27CttsGwjQAuz2D7hXSeOVKlI4YJXQ2gNOYGbWwPLBjDgHsQ+NazNgM/828eGamGkNpmJE9j2Ch rsa-key-20231129";
				jsch.addIdentity(accessConnet.getUser(),key.getBytes(),null, "@ndr3lu1z".getBytes());
				
			}
            session = jsch.getSession(accessConnet.getUser(), accessConnet.getHostconn(), 22);	
	    	if (keyPath != ""){
				
				session.setConfig("PreferredAuthentications", "privatekey");
			}
	    	session.setPassword(accessConnet.getPass());
	    	session.setConfig(config);
	    	session.setServerAliveCountMax(7);
			
			
	    	session.connect(intTimeOut);
	    	
		    session.setPortForwardingL(Integer.parseInt(accessConnet.porthub01 ),
		    		accessConnet.getHostdb(), Integer.parseInt( accessConnet.portdb));
			
			message.append(" [REMOTE ACCESS - SSHManager.connect]: setPortForwardingL(DB) = ")
						.append(accessConnet.porthub01 + ":").append(accessConnet.getHostdb() + ":")
						.append(accessConnet.portdb + " - ")
						.append("Conexão Remota Estabelecida! \r\n");
			
		}catch(JSchException e) {
			
			message.append("******ERRO****** "+e.getMessage());
		}
		app.updateMsg(message.toString());
		
		return session;	
	}
	public static void close(SwingApp app, Session session) throws JSchException {

		StringBuilder message = new StringBuilder(
				" [REMOTE ACCESS - SSHManager.close]: Fechando Conexão JSchSSHChannel(Session)... \r\n");

		if (session != null) {

			session.disconnect();
			

		} else {
			app.updateMsg(" [REMOTE ACCESS ERROR - SSHManager.close]: Erro na Conexão!");
			throw new JSchException(" [REMOTE ACCESS ERROR - SSHManager.close]: Erro na Conexão!");
			
		}

//		this.firtSesConnection.disconnect();

		message.append(" [REMOTE ACCESS - SSHManager.close]: JSchSSHChannel(Session) = ").append("Conexão Fechada ! \r\n");
		app.updateMsg(message.toString());
		

	}
	public static boolean isActivedSessionJsch(Session session) {

		final boolean isActived = session != null && session.isConnected();

		return isActived;

	}
}
