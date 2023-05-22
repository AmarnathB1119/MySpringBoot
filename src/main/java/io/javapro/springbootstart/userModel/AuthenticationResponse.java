package io.javapro.springbootstart.userModel;

public class AuthenticationResponse {

	

	private  String jwt;
	private  String error;

	public AuthenticationResponse() {
		
	}
	
	public AuthenticationResponse(String jwt, String error) {
		super();
		this.jwt = jwt;
		this.error = error;
	}

	public String getJwt() {
		return jwt;
	}

	public String getError() {
		return error;
	}
	
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
