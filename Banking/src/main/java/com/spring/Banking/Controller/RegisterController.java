package com.spring.Banking.Controller;

import com.spring.Banking.Entity.User;
import com.spring.Banking.Model.JwtRequest;
import com.spring.Banking.Model.JwtResponse;
import com.spring.Banking.Model.UserModel;
import com.spring.Banking.Service.CustomUserDetailsServiceImpl;
import com.spring.Banking.Service.UserService;
import com.spring.Banking.Util.JwtUtility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        // add check for email exists in DB
        if(userService.existsByEmail(userModel.getEmail())){
            //    return new ResponseEntity<User>("Email is already taken!", false), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        User user = userService.registerUser(userModel);
        // Instead of publishing from backend we will send the verification link from the front end
//        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
//        String verificationLink = applicationUrl(request)+ "/verifyRegistration?token="+userService.getVerificationTokenForUser(user.getId()).getToken();
//        final RegisterUserResponse registeredUser = new RegisterUserResponse(verificationLink);
        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        UsernamePasswordAuthenticationToken unauthenticatedToken = UsernamePasswordAuthenticationToken.unauthenticated(
                jwtRequest.getUsername(), jwtRequest.getPassword());
        try {
//            System.out.println(jwtRequest.getUsername());
//            System.out.println(jwtRequest.getPassword());

            authenticationProvider.authenticate(
                    unauthenticatedToken
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<JwtResponse>(new JwtResponse(null,e.getMessage(),false,null,null),HttpStatus.UNAUTHORIZED);
        }catch(NullPointerException ex) {
            return new ResponseEntity<JwtResponse>(new JwtResponse(null,"User name Not Found",false,null,null),HttpStatus.UNAUTHORIZED);
        }catch(DisabledException ex) {
            return new ResponseEntity<JwtResponse>(new JwtResponse(null,"User Account is disabled",false,null,null),HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails
                = customUserDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return new ResponseEntity<JwtResponse>(new JwtResponse(token,"Token generated Successfully",true, userDetails.getUsername(),userDetails.getAuthorities().iterator().next().toString()),HttpStatus.OK);
    }

}