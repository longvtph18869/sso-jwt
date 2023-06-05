package com.example.ssoauth.oauth2;

public enum AuthProvider {
	GOOGLE("google"), FACEBOOK("facebook");

	private String provider;

	AuthProvider(String provider) {
		this.provider = provider;
	}

	public String getProvider() {
		return provider;
	}
}
