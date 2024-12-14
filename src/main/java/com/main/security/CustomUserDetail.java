package com.main.security2;

import java.util.Collection;
import java.util.List;

import com.main.enitity.Credential;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetail implements UserDetails {

	private final Credential credential;
	public CustomUserDetail(Credential credential) {
		this.credential = credential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = credential.getRoles().stream().map((role)->new SimpleGrantedAuthority(role.getName())).toList();
		return authorities;
	}

	@Override
	public String getUsername() {
		return credential.getUsername();
	}

	@Override
	public String getPassword() {
		return credential.getPassword();
	}
	public Credential getUsers() {
        return credential;
    }

}
