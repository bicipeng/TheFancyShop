package com.fancyshop.ecommerce.security;

import com.fancyshop.ecommerce.service.AppUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final AppUserDetailsService userDetailsService;

    public JwtAuthFilter(JwtUtil jwtUtil, AppUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwtToken = authHeader.substring(7);
            try {
                username = jwtUtil.extractUsername(jwtToken);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or expired token");
                return;
            }
        }

        // if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        //     var userDetails = userDetailsService.loadUserByUsername(username);
        //     if (jwtUtil.validateToken(jwtToken, userDetails.getUsername())) {
        //         var authToken = new UsernamePasswordAuthenticationToken(
        //                 userDetails, null, userDetails.getAuthorities()
        //         );
        //         authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        //         SecurityContextHolder.getContext().setAuthentication(authToken);
        //     }
        // }

        filterChain.doFilter(request, response);
    }
}
