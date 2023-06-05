package com.example.ssoauth.contants;

public class SecurityConstant {
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
    public static final String ACCESS_TOKEN_KEY = "access_token";
    public static final String REDIRECT_URI_KEY = "redirect_uri";
    
    public static final String OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME = "oauth2_auth_request";
    public static final String REDIRECT_URI_PARAM_COOKIE_NAME = "redirect_uri";
    public static final int COOKIE_EXPIRE_SECONDS = 180;

}
