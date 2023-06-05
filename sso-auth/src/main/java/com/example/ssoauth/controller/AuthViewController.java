package com.example.ssoauth.controller;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ssoauth.contants.SecurityConstant;
import com.example.ssoauth.jwt.JwtUtil;
import com.example.ssoauth.utils.CookieUtils;

public class AuthViewController {
	@Autowired
	private JwtUtil jwtUtil;
	
	private static final String LOGOUT_PRE_ACTION = "logout"; 
	
	@GetMapping(value = "login")
	public String login(@RequestParam("redirect_uri") String redirectUri, HttpServletRequest request, HttpServletResponse response, Model model) {
		String preAction = request.getParameter("pre_action");
		if(preAction != null && LOGOUT_PRE_ACTION.equals(preAction)) {
			CookieUtils.deleteCookie(request, response, SecurityConstant.ACCESS_TOKEN_KEY);
		}
		
		String accessToken = getValueFormCookie(request, SecurityConstant.ACCESS_TOKEN_KEY);
		if (jwtUtil.validateJwtToken(accessToken)) {
			String url = redirectUri + "?" + SecurityConstant.ACCESS_TOKEN_KEY + "=" + accessToken;
			return "redirect:" + url;
		} else {
			model.addAttribute(SecurityConstant.REDIRECT_URI_KEY, redirectUri);
	        CookieUtils.addCookie(response, SecurityConstant.REDIRECT_URI_KEY, redirectUri, 8*3600);
	        return "html/login";
		}
	}
	
	private String getValueFormCookie(HttpServletRequest request, String name) {
		Optional<Cookie> cookie = CookieUtils.getCookie(request, name);
		if (cookie.isEmpty()) {
			return StringUtils.EMPTY;
		}
		return cookie.get().getValue();
	}

}
