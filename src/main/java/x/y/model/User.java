package x.y.model;

import java.io.Serializable;

import com.google.code.ssm.api.CacheKeyMethod;

public class User implements Serializable{

	private String id;
	private String username;

	@CacheKeyMethod
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
