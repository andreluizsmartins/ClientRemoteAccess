package br.com.sankhya.model;

public class ConsentAccess {

	String id,serviceOrder, purposeOfAuthorisation, deadlineForAccess, user, password, agreedScienceTerm, repealed, observation, authorizedUser, dateOfAuthorization, expiryDate, idSas, userSas, urlJdbc, httpPort, versionSankhyaom, versionSO, versionServer, memoria, binarioSystema, hash; 
	boolean openConnect;
	public ConsentAccess() {
		// TODO Auto-generated constructor stub
	}

	
	public ConsentAccess(String id, String serviceOrder, String purposeOfAuthorisation, String deadlineForAccess,
			String user, String password, String agreedScienceTerm, String repealed, String observation,
			String authorizedUser, String dateOfAuthorization, String expiryDate, String idSas, String userSas,
			String urlJdbc, String httpPort, String versionSankhyaom, String versionSO, String versionServer,
			String memoria, String binarioSystema, String hash, boolean openConnect) {
		super();
		this.id = id;
		this.serviceOrder = serviceOrder;
		this.purposeOfAuthorisation = purposeOfAuthorisation;
		this.deadlineForAccess = deadlineForAccess;
		this.user = user;
		this.password = password;
		this.agreedScienceTerm = agreedScienceTerm;
		this.repealed = repealed;
		this.observation = observation;
		this.authorizedUser = authorizedUser;
		this.dateOfAuthorization = dateOfAuthorization;
		this.expiryDate = expiryDate;
		this.idSas = idSas;
		this.userSas = userSas;
		this.urlJdbc = urlJdbc;
		this.httpPort = httpPort;
		this.versionSankhyaom = versionSankhyaom;
		this.versionSO = versionSO;
		this.versionServer = versionServer;
		this.memoria = memoria;
		this.binarioSystema = binarioSystema;
		this.hash = hash;
		this.openConnect = openConnect;
	}

	

	@Override
	public String toString() {
		return "ConsentAccess [id=" + id + ", serviceOrder=" + serviceOrder + ", purposeOfAuthorisation="
				+ purposeOfAuthorisation + ", deadlineForAccess=" + deadlineForAccess + ", user=" + user + ", password="
				+ password + ", agreedScienceTerm=" + agreedScienceTerm + ", repealed=" + repealed + ", observation="
				+ observation + ", authorizedUser=" + authorizedUser + ", dateOfAuthorization=" + dateOfAuthorization
				+ ", expiryDate=" + expiryDate + ", idSas=" + idSas + ", userSas=" + userSas + ", urlJdbc=" + urlJdbc
				+ ", httpPort=" + httpPort + ", versionSankhyaom=" + versionSankhyaom + ", versionSO=" + versionSO
				+ ", versionServer=" + versionServer + ", memoria=" + memoria + ", binarioSystema=" + binarioSystema
				+ ", hash=" + hash + "]";
	}


	public boolean isOpenConnect() {
		return openConnect;
	}


	public void setOpenConnect(boolean openConnect) {
		this.openConnect = openConnect;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder(String serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	public String getPurposeOfAuthorisation() {
		return purposeOfAuthorisation;
	}

	public void setPurposeOfAuthorisation(String purposeOfAuthorisation) {
		this.purposeOfAuthorisation = purposeOfAuthorisation;
	}

	public String getDeadlineForAccess() {
		return deadlineForAccess;
	}

	public void setDeadlineForAccess(String deadlineForAccess) {
		this.deadlineForAccess = deadlineForAccess;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAgreedScienceTerm() {
		return agreedScienceTerm;
	}

	public void setAgreedScienceTerm(String agreedScienceTerm) {
		this.agreedScienceTerm = agreedScienceTerm;
	}

	public String getRepealed() {
		return repealed;
	}

	public void setRepealed(String repealed) {
		this.repealed = repealed;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getAuthorizedUser() {
		return authorizedUser;
	}

	public void setAuthorizedUser(String authorizedUser) {
		this.authorizedUser = authorizedUser;
	}

	public String getDateOfAuthorization() {
		return dateOfAuthorization;
	}

	public void setDateOfAuthorization(String dateOfAuthorization) {
		this.dateOfAuthorization = dateOfAuthorization;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIdSas() {
		return idSas;
	}

	public void setIdSas(String idSas) {
		this.idSas = idSas;
	}

	public String getUserSas() {
		return userSas;
	}

	public void setUserSas(String userSas) {
		this.userSas = userSas;
	}

	public String getUrlJdbc() {
		return urlJdbc;
	}

	public void setUrlJdbc(String urlJdbc) {
		this.urlJdbc = urlJdbc;
	}

	public String getHttpPort() {
		return httpPort;
	}

	public void setHttpPort(String httpPort) {
		this.httpPort = httpPort;
	}

	public String getVersionSankhyaom() {
		return versionSankhyaom;
	}

	public void setVersionSankhyaom(String versionSankhyaom) {
		this.versionSankhyaom = versionSankhyaom;
	}

	public String getVersionSO() {
		return versionSO;
	}

	public void setVersionSO(String versionSO) {
		this.versionSO = versionSO;
	}

	public String getVersionServer() {
		return versionServer;
	}

	public void setVersionServer(String versionServer) {
		this.versionServer = versionServer;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getBinarioSystema() {
		return binarioSystema;
	}

	public void setBinarioSystema(String binarioSystema) {
		this.binarioSystema = binarioSystema;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
	

}
