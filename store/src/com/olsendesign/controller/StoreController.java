package com.olsendesign.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.olsendesign.store.hibernate.entity.Account;
import com.olsendesign.store.hibernate.entity.Store;
import com.olsendesign.store.hibernate.entity.User;
import com.olsendesign.store.service.AccountService;
import com.olsendesign.store.service.StoreService;
import com.olsendesign.store.service.UserService;

@Controller
@RequestMapping("/")
public class StoreController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	
    @RequestMapping("/list")
    public String home(
    		           Model model,
    		           HttpServletResponse response
    		           ) {
		System.out.println("Inside home()  - StoreController");
    	List<Store> stores = storeService.getStores();
    	model.addAttribute("stores", stores);
        return "store-list";
    }
	
	@RequestMapping(value="/{storeId}/main")
    public String showMainPage(
    		                   @CookieValue(value="accountCookie", defaultValue="") String accountHash,
    		                   @PathVariable(value="storeId") String storeId, 
    		                   Model model, 
    		                   HttpServletResponse response
    		                   ) {
		System.out.println("Inside showMainPage() " + storeId + "  - StoreController");
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
	
	@RequestMapping("/{storeId}/logout")
	public String logout(
			             @CookieValue(value="accountCookie", defaultValue="") String accountHash,
		                 @PathVariable(value="storeId") String storeId, 
			             Model model, 
			             HttpServletResponse response
			             ) {
		System.out.println("Inside Store Logout() - StoreController");
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
	
	@PostMapping(value="/{storeId}/login")
	public String login(
			            //@CookieValue(value="storeId", defaultValue="1") String storeId,
		                @PathVariable(value="storeId") String storeId, 
			            @ModelAttribute("account") Account account, 
			            Model model, 
			            HttpServletResponse response
			            ) {
		System.out.println("Inside Store Login() - StoreController");
		
		Account authenticated_account = null;
		authenticated_account = accountService.loginUser(account);
		
		if ( authenticated_account != null ) {
			System.out.println("  Found Account : " + account.getAccountHash() );
		    model.addAttribute("account", authenticated_account);
		    model.addAttribute("user", authenticated_account.getUser());
		    Cookie accountCookie = new Cookie("accountCookie", authenticated_account.getAccountHash());
			response.addCookie(accountCookie);
		} else {
			System.out.println("  Account NOT found for : " + account.getEmailAddress() );
			model.addAttribute("errors", "Email address not found or bad password combo.");
		}
		
		Store store = storeService.getStore(new Integer(storeId));
		model.addAttribute("store", store);
	   	
		Cookie cookie = new Cookie("storeId", storeId);
		response.addCookie(cookie);
		
		return "main-page";
	}	
	
	@RequestMapping(value="/{storeId}/profile")
	public String profile(
		                @PathVariable(value="storeId") int storeId, 
		                @CookieValue(value="accountCookie", defaultValue="") String accountHash, 
			            Model model, 
			            HttpServletResponse response
			            ) {
		System.out.println("Inside Store Profile() - StoreController");
		
		Store store = storeService.getStore(storeId);
		model.addAttribute("store", store);
		
		Account authenticated_account = null;
		authenticated_account = accountService.getAccountFromHash(accountHash);
		
		if ( authenticated_account != null ) {
			System.out.println("  Found Account : " + authenticated_account.getAccountHash() );
		    model.addAttribute("account", authenticated_account);
		    model.addAttribute("user", authenticated_account.getUser());
		    Cookie accountCookie = new Cookie("accountCookie", authenticated_account.getAccountHash());
			response.addCookie(accountCookie);
    		return "profile";
		} else {
			model.addAttribute("errors", "Email address not found or bad password combo.");
		}
		
		Cookie cookie = new Cookie("storeId", new Integer(store.getStoreId()).toString() );
		response.addCookie(cookie);
		
		return "main-page";
	}
	
	@RequestMapping(value="/{storeId}/user/update")
	public String userUpdate(
			            @ModelAttribute("user") User user,
		                @PathVariable(value="storeId") int storeId, 
		                @CookieValue(value="accountCookie", defaultValue="") String accountHash, 
			            Model model, 
			            HttpServletResponse response
			            ) {
		System.out.println("Inside userUpdate() - StoreController");
		
		Store store = storeService.getStore(storeId);
		model.addAttribute("store", store);
		
		Account authenticated_account = null;
		authenticated_account = accountService.getAccountFromHash(accountHash);
		
		int auth_user_account_id = authenticated_account.getUser().getAccountId();
		int passed_account_id = user.getAccountId();
		
		if ( authenticated_account != null && auth_user_account_id == passed_account_id ) {
			System.out.println("  Found Account : " + authenticated_account.getAccountHash() );
		    model.addAttribute("account", authenticated_account);
		    
		    user.setAccountId( authenticated_account.getAccountId() );
		    userService.saveUser(user);
		    user = userService.getUser(user.getAccountId());
		    model.addAttribute("account", authenticated_account );
		    model.addAttribute("user", user);
		    Cookie accountCookie = new Cookie("accountCookie", authenticated_account.getAccountHash());
			response.addCookie(accountCookie);
    		return "profile";
		} else {
			model.addAttribute("errors", "Email address not found or bad password combo.");
		}
		
		Cookie cookie = new Cookie("storeId", new Integer(store.getStoreId()).toString() );
		response.addCookie(cookie);
		
		return "main-page";
	}
	
}