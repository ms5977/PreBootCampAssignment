package com.main.services.Implementation;

import com.main.enitity.Credential;
import com.main.repository.CredentialRepository;
import com.main.services.CredentialService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements CredentialService {
    private final CredentialRepository credentialRepository;
    private final PasswordEncoder passwordEncoder;

    public CredentialServiceImpl(CredentialRepository credentialRepository, PasswordEncoder passwordEncoder) {
        this.credentialRepository = credentialRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Credential createCredential(Credential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        return credentialRepository.save(credential);
    }
}
