package tqb.user.entity;

import java.util.HashSet;
import java.util.Set;

import tqb.visit.entity.Visit;

public class User {
	private int uid;
	private String username;
	private String password;
	private String address;

	private Set<Visit> visitSet = new HashSet<Visit>();

	public Set<Visit> getVisitSet() {
		return visitSet;
	}

	public void setVisitSet(Set<Visit> visitSet) {
		this.visitSet = visitSet;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
