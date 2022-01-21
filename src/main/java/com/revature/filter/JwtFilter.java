package com.revature.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.revature.service.CustomUserDetailsService;
import com.revature.util.JwtUtil;

/**
 * The purpose of this class is to intercept a request made to the server, which
 * is achieved by overriding the doFilterInteral method from
 * OncePerRequestFilter.
 * 
 * The method on line 45 will capture the header and check whether the user is
 * logged in or not.
 */
@Component
@WebFilter("/*")
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService service;

	/**
	 * This method fires ONCE every time that a client sends an HTTP Request to this
	 * application.
	 * 
	 * It does: Check to make sure that the User is valid and that the token is
	 * valid. Then set the user as the authenticated User.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {

		String authorizationHeader = httpServletRequest.getHeader("Authorization");

		String token = null;
		String username = null;

		// Check that the authorization header is not null and that it indeed begins
		// with "GutendexryBearer "
		if (authorizationHeader != null && authorizationHeader.startsWith("GutendexryBearer ")) {

			token = authorizationHeader.substring(17);
			username = jwtUtil.extractUsername(token);
		}

		// This checks if the user is currently logged in
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// Build UserDetails object based on the user and log them in
			UserDetails userDetails = service.loadUserByUsername(username);

			if (jwtUtil.validateToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

				// Set the the Spring Security Context to classify user as officially logged-in
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT,DELETE,PATCH");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		
		filterChain.doFilter(httpServletRequest, httpServletResponse);
		
	}
}
