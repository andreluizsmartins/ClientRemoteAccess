package br.com.sankhya.model;

public class RemoteAccess {

	int id, idConsent, idServer;
	String hostconn, user, pass, porthub01, porthub02, hostdb, portdb, instancedb, portApp;
	public RemoteAccess() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdConsent() {
		return idConsent;
	}
	public void setIdConsent(int idConsent) {
		this.idConsent = idConsent;
	}
	public int getIdServer() {
		return idServer;
	}
	public void setIdServer(int idServer) {
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
	public void setPorthub01(String parthub01) {
		this.porthub01 = parthub01;
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
	public String getInstancedb() {
		return instancedb;
	}
	public void setInstancedb(String instancedb) {
		this.instancedb = instancedb;
	}
	public String getPortApp() {
		return portApp;
	}
	public void setPortApp(String portApp) {
		this.portApp = portApp;
	}
	@Override
	public String toString() {
		return "RemoteAccess [id=" + id + ", idConsent=" + idConsent + ", idServer=" + idServer + ", hostconn="
				+ hostconn + ", user=" + user + ", pass=" + pass + ", parthub01=" + porthub01 + ", porthub02="
				+ porthub02 + ", hostdb=" + hostdb + ", portdb=" + portdb + ", instancedb=" + instancedb + ", portApp="
				+ portApp + "]";
	}

	
	
}
