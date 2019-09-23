package com.sllit.ssd.oauthsample.services;

import com.sllit.ssd.oauthsample.models.AccessTokenCache;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

/**
 * @dharshikasingarathnam
 */

@Service
public class AuthenticationService {

    public boolean isAuthenticated(Cookie[] cookies){
        return null != AccessTokenCache.getAccessTokenCache().getAccessTokens().get(getSessionFromCookies(cookies));
    }

    public String getAccessTokenForSession(String session){
        return (String) AccessTokenCache.getAccessTokenCache().getAccessTokens().get(session);
    }

    public String getSessionFromCookies(Cookie[] cookies){
        if (null != cookies && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionID")) {
                    return (cookie.getValue());
                }
            }
        }
        return "";
    }
}
