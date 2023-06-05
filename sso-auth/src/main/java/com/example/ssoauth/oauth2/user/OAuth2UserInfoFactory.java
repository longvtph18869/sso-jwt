package com.example.ssoauth.oauth2.user;

import java.util.Map;

import com.example.ssoauth.exception.OAuth2AuthenticationProcessingException;
import com.example.ssoauth.oauth2.AuthProvider;

public class OAuth2UserInfoFactory {

	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
		if (registrationId.equalsIgnoreCase(AuthProvider.GOOGLE.toString())) {
			return new GoogleOAuth2UserInfo(attributes);
		} else if (registrationId.equalsIgnoreCase(AuthProvider.FACEBOOK.toString())) {
			return new FacebookOAuth2UserInfo(attributes);
		} else {
			throw new OAuth2AuthenticationProcessingException(
					"Sorry! Login with " + registrationId + " is not supported yet.");
		}
	}

}

