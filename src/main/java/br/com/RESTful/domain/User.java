package br.com.RESTful.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements UserDetails {

	private static final long serialVersionUID = 1507218635788384719L;

	private String username;

	private String password;

	private List<Authority> authorities;

	public void setAuthorities(List<Authority> autorizacoes) {
		this.authorities = autorizacoes;
	}

	@Override
	public Collection<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
}
