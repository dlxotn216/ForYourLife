package com.taesu.fyl.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kim on 2016-12-30.
 */
@Slf4j
@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        log.info("DEBUG CHECK ROLE: "+role);

        //ROLE_[target]
        String targetUrl = role.split("_")[1];
        targetUrl = targetUrl.substring(0, targetUrl.length()-1).toLowerCase();
        log.info("DEBUG CHECK ROLE: "+targetUrl);

        return targetUrl;
    }
}
