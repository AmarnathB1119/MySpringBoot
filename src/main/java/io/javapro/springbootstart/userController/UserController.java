package io.javapro.springbootstart.userController;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javapro.springbootstart.userJwt.JwtUtil;
import io.javapro.springbootstart.userModel.AuthenticationRequest;
import io.javapro.springbootstart.userModel.AuthenticationResponse;
import io.javapro.springbootstart.userModel.User;
import io.javapro.springbootstart.userRepository.UserRepository;
import io.javapro.springbootstart.userService.UserDetailsServiceImpl;


@RestController
public class UserController {
	
//	@Autowired
//	private UserRepository userRepository;
//	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtils;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}
	
// Hard coded user Creditials 	
//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public ResponseEntity<?> createUserAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws  Exception{
//		
//		
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), 
//							authenticationRequest.getPassword())
//					);
//		}catch(Exception e){
//			throw new Exception("Incorrect Username or password", e);
//		}
//		
//		final  UserDetails userdetails = userDetailsServiceImpl
//				.loadUserByUsername(authenticationRequest.getUsername());
//		
//		final String jwt = jwtUtils.generateToken(userdetails);
//		
//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
//
//	}
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws  Exception{
		
		final String jwt;
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), 
							user.getPassword())
					);
			
			final  UserDetails userdetails = userDetailsServiceImpl
					.loadUserByUsername(user.getUsername());
			
		  jwt = jwtUtils.generateToken(userdetails);
			
			AuthenticationResponse authenticationResponse = new AuthenticationResponse();
			authenticationResponse.setJwt(jwt);
			
			
			System.out.println("successed");
			
			
			Map<String, String> successResponse = Map.of(
	    		      "status", HttpStatus.OK.toString(),
	    		      "jwt", jwt
	    		  );
			return new ResponseEntity<>(successResponse, HttpStatus.OK);

			
		}catch(BadCredentialsException e){
		
			
			
			
			System.out.println("Incorrect username or password");
			//throw new Exception("Incorrect username or password");
			
			Map<String, String> errorResponse = Map.of(
	    		      "status", HttpStatus.BAD_REQUEST.toString(),
	    		      "message", "Username or Password Issue!"
	    		  );
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
	}

}
