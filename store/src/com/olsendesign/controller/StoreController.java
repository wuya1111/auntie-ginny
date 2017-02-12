package com.olsendesign.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.olsendesign.store.hibernate.entity.Account;
import com.olsendesign.store.hibernate.entity.Store;
import com.olsendesign.store.service.AccountService;
import com.olsendesign.store.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private AccountService accountService;
	
    @RequestMapping("/")
    public String home() {
        return "main-page";
    }
	
	@RequestMapping("/main")
    public String showMainPage(@CookieValue(value="accountCookie", defaultValue="") String accountHash,@CookieValue(value="storeId", defaultValue="1") String storeId, Model model, HttpServletResponse response) {
		System.out.println("Inside Store ShowMainPage()");
		Store store = storeService.getStore( new Integer(storeId));
		Account account = null;
		if ( accountHash != "" ) {
		    account = accountService.getAccountFromHash(accountHash);
		    if( account != null ) {
		        model.addAttribute("account", account);
		        model.addAttribute("user", account.getUser());
		        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
		        response.addCookie(accountCookie);
		    }
		}
		
		model.addAttribute("store", store);
		Cookie cookie = new Cookie("storeId", storeId );
		response.addCookie(cookie);
		return "main-page";
	}
	
	@RequestMapping("/logout")
	public String logout(@CookieValue(value="accountCookie", defaultValue="") String accountHash,@CookieValue(value="storeId", defaultValue="1") String storeId, Model model, HttpServletResponse response) {
		System.out.println("Inside Store Logout()");
		Store store = storeService.getStore( new Integer(storeId));
		Account account = null;
		if ( accountHash != "" ) {
		    account = accountService.getAccountFromHash(accountHash);
		    if( account != null ) {
		    	account.setHash("");
		    	account.setActive(false);
		    	accountService.saveAccount(account);
		    }
		}
		
		/* Set Cookie to "" */
	    Cookie accountCookie = new Cookie("accountCookie", "");
        response.addCookie(accountCookie);
    
		model.addAttribute("store", store);
		Cookie cookie = new Cookie("storeId", storeId );
		response.addCookie(cookie);
		return "main-page";
	}
	
	@PostMapping("/login")
	public String login(@CookieValue(value="storeId", defaultValue="1") String storeId, @ModelAttribute("account") Account account, Model model, HttpServletResponse response) {
		System.out.println("Inside Store Login()");
		
		Account authenticated_account = null;
		authenticated_account = accountService.loginUser(account);
		if ( authenticated_account != null ) {
		    model.addAttribute("account", authenticated_account);
		    model.addAttribute("user", authenticated_account.getUser());
		    Cookie accountCookie = new Cookie("accountCookie", authenticated_account.getAccountHash());
			response.addCookie(accountCookie);
		}
		Store store = storeService.getStore(new Integer(storeId));
		model.addAttribute("store", store);
	   	
		Cookie cookie = new Cookie("storeId", storeId );
		response.addCookie(cookie);
		
		return "main-page";
	}
	
	
	
}
