package br.com.sankhya.httpClient;

import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.sankhya.Application.SwingApp;
import br.com.sankhya.model.ConsentAccess;
import br.com.sankhya.model.Hash;
import br.com.sankhya.model.RemoteAccess;
import ch.qos.logback.core.subst.Token.Type;



public class ApiClient {

	public ApiClient() {
		// TODO Auto-generated constructor stub
	}

public static ConsentAccess readConsentAccess(Hash hash, SwingApp app){
		Gson gson = new Gson();
	
		String json = gson.toJson(hash);
		JSONObject object = new JSONObject(json.toString()); 
		try {
			HttpResponse<String> response = Unirest.post("http://191.101.234.65:8080/remoteaccess-api/v1/accessconsent/getByHash")
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzQG5rI3lAIiwiZXhwIjoyNjAzMzEyMTAwLCJpYXQiOjE2MDMzMTIxMDF9._1Q1APfxcpxjag1pyUtTvS5JKbqswZTiLULT4tQ9Mdxdij0_zn10cFd4wEwQBMhwc5xOG_MPiuD019GPvNoo8g")
					.body(object)
					.asString();
			System.out.println(response.getStatus());
			System.out.println(response.getBody());
			if(response.getStatus() == 200 || response.getStatus() == 404){
				if(response.getBody().equals("") || response.getStatus() == 404) {
					
					return null;
				}
				
				
				java.lang.reflect.Type caccType = new TypeToken<ArrayList<ConsentAccess>>(){}.getType();
				 
				ArrayList<ConsentAccess> cAccArray = gson.fromJson(response.getBody(), caccType);  
				
				return cAccArray.get(0);
				
				
			}else {
				return null;
			}
					
		} catch (UnirestException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			app.updateMsg("Erro na comunicação com o servidor externo: "+e.getMessage());
			return null;
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			app.updateMsg("Erro na leitura dos dados: "+e.getMessage());
			return null;
		}
		
	}

	public static RemoteAccess playRemoteAccess(ConsentAccess cAcc, SwingApp app){
		Gson gson = new Gson();
		String json = gson.toJson(cAcc);
		JSONObject object = new JSONObject(json.toString()); 
		try {
			HttpResponse<String> response = Unirest.post("http://191.101.234.65:8080/remoteaccess-api/v1/remoteaccess")
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzQG5rI3lAIiwiZXhwIjoyNjAzMzEyMTAwLCJpYXQiOjE2MDMzMTIxMDF9._1Q1APfxcpxjag1pyUtTvS5JKbqswZTiLULT4tQ9Mdxdij0_zn10cFd4wEwQBMhwc5xOG_MPiuD019GPvNoo8g")
					.body(object)
					.asString();
			System.out.println(response.getBody());
			if(response.getStatus() == 201){
				
				RemoteAccess ra = new RemoteAccess();
				ra = gson.fromJson(response.getBody(), RemoteAccess.class);
				
				return ra;
			}else {
				return null;
			}
					
		} catch (UnirestException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			app.updateMsg("Erro na comunicação com o servidor externo: "+e.getMessage());
		}
		return null;
	}
}
