package br.com.sankhya.model;

public class AccessConnet {

	public Integer id;  

	public Integer idConsent;

	public Integer idServer;

	public String hostconn;

	public String user;

	public String pass;

	public String porthub01;

	public String porthub02;

	public String hostdb;

	public String portdb;

	public String instanciadb;

	public String portApp;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdConsent() {
		return idConsent;
	}

	public void setIdConsent(Integer idConsent) {
		this.idConsent = idConsent;
	}

	public Integer getIdServer() {
		return idServer;
	}

	public void setIdServer(Integer idServer) {
		this.idServer = idServer;
	}

	public String getHostconn() {
		return hostconn;
	}

	public void setHostconn(String hostconn) {
		this.hostconn = hostconn;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPorthub01() {
		return porthub01;
	}

	public void setPorthub01(String porthub01) {
		this.porthub01 = porthub01;
	}

	public String getPorthub02() {
		return porthub02;
	}

	public void setPorthub02(String porthub02) {
		this.porthub02 = porthub02;
	}

	public String getHostdb() {
		return hostdb;
	}

	public void setHostdb(String hostdb) {
		this.hostdb = hostdb;
	}

	public String getPortdb() {
		return portdb;
	}

	public void setPortdb(String portdb) {
		this.portdb = portdb;
	}

	public String getInstanciadb() {
		return instanciadb;
	}

	public void setInstanciadb(String instanciadb) {
		this.instanciadb = instanciadb;
	}

	public String getPortApp() {
		return portApp;
	}

	public void setPortApp(String portApp) {
		this.portApp = portApp;
	}

	public AccessConnet() {
		
	}
	
	public AccessConnet(String user, String password) {
		
		this.user = user;
		
		this.pass = password;	
		
	}

}