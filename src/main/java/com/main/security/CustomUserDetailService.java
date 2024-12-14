package com.main.security2;

import com.main.enitity.Credential;
import com.main.exception.ResourceNotFoundException;
import com.main.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private CredentialRepository credentialRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential credential = credentialRepository.findByUsername(username).orElseThrow(()->new ResourceNotFoundException("wrong user or password :"+username));
        return new CustomUserDetail(credential);
	}

}
