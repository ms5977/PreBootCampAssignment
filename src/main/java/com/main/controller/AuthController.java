package com.main.controller;

import com.main.enitity.Credential;
import com.main.exception.ApiException;
import com.main.payload.JwtAuthResponse;
import com.main.payload.LoginUserAuthRequest;
import com.main.security2.CustomUserDetail;
import com.main.security2.CustomUserDetailService;
import com.main.security2.JwtHelper;
import com.main.services.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

//    @Autowired
//    private ModelMapper mapper;
    private final CredentialService credentialService;
    public AuthController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping("/create")
    public ResponseEntity<Credential>createCredential(@RequestBody Credential credential){
        Credential credentialData = credentialService.createCredential(credential);
        return ResponseEntity.ok().body(credentialData);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody LoginUserAuthRequest loginUserAuthRequest)
    {
        this.authenticate(loginUserAuthRequest.getUsername(), loginUserAuthRequest.getPassword());
        UserDetails userDetails = customUserDetailService.loadUserByUsername(loginUserAuthRequest.getUsername());
        String token = jwtHelper.genrateToken(userDetails);

        JwtAuthResponse authResponse=new JwtAuthResponse();
        authResponse.setToken(token);
        CustomUserDetail customUserDetail=(CustomUserDetail) userDetails;

        return new ResponseEntity<JwtAuthResponse>(authResponse, HttpStatus.OK);
    }
    public void authenticate(String username,String password)
    {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException ex) {
            throw new ApiException("Invalid username and Password");
        }
    }
}
