package com.pe.pgn.clubpgn.security;

import java.util.Collection;

import java.util.Iterator;


import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.springframework.security.access.AccessDecisionManager;

import org.springframework.security.access.AccessDeniedException;

import org.springframework.security.access.ConfigAttribute;

import org.springframework.security.access.SecurityConfig;

import org.springframework.security.authentication.InsufficientAuthenticationException;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {

        private final static Log log = LogFactory.getLog(MyAccessDecisionManager.class);

        // In this method, need to compare authentication with configAttributes.

        // 1, A object is a URL, a filter was find permission configuration by this
        // URL, and pass to here.

        // 2, Check authentication has attribute in permission configuration
        // (configAttributes)

        // 3, If not match corresponding authentication, throw a
        // AccessDeniedException.
        public void decide(Authentication authentication, Object object,
                        Collection<ConfigAttribute> configAttributes)
                        throws AccessDeniedException, InsufficientAuthenticationException {

        	if (configAttributes == null) {
        		return;
        	}
        	
        	if (log.isDebugEnabled())
        		log.debug(object.toString()); // object is a URL.

        	Iterator<ConfigAttribute> ite = configAttributes.iterator();
        	while (ite.hasNext()) {

        		ConfigAttribute ca = ite.next();
        		String needRole = ((SecurityConfig) ca).getAttribute();

        		for (GrantedAuthority ga : authentication.getAuthorities()) {
        			if (needRole.equals(ga.getAuthority())) { // ga is user's role.
        				
        				return;
        			}
        		}

        	}
        	throw new AccessDeniedException("Acceso Denegado ("+object+")");
        }

        @Override
        public boolean supports(ConfigAttribute attribute) {

        	return true;
        }

        @Override

        public boolean supports(Class<?> clazz) {
        	
        	return true;
        }
}