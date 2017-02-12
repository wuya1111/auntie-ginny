package com.olsendesign.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.olsendesign.store.hibernate.entity.Account;
import com.olsendesign.store.hibernate.entity.Product;
import com.olsendesign.store.hibernate.entity.Store;
import com.olsendesign.store.hibernate.entity.StoreCopy;
import com.olsendesign.store.service.AccountService;
import com.olsendesign.store.service.ProductService;
import com.olsendesign.store.service.StoreService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/")
	public String adminHome() {
		return "redirect:/admin/main";
	}
	
	@RequestMapping("/main")
	public String adminMain(@CookieValue(value="accountCookie", defaultValue="") String accountHash,@CookieValue(value="storeId", defaultValue="-1") int storeId, Model model, HttpServletResponse response) {
		System.out.println("Inside adminHome() - Admin Controller ");
		
		if ( storeId > 0 ) {
		    Store store = storeService.getStore(storeId);
		    if ( store != null ) {
		        model.addAttribute("store", store);
		    }
		}
		
		List<Store> stores = storeService.getStores();
		model.addAttribute("stores", stores);
	
		Account account = isAdmin(accountHash);
	    if( account != null ) {
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        return "admin-main-page";
	    }
		return "main-page";
	}	
	
	@RequestMapping("/product/edit/{productId}")
	public String productEdit(@CookieValue(value="accountCookie", defaultValue="") String accountHash,@PathVariable(value="productId") String productId, Model model, HttpServletResponse response) {
		System.out.println("Inside productEdit() - Admin Controller ");
		
		Account account = isAdmin(accountHash);		
	    if( account != null ) {
		
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        Product product = productService.getProduct( new Integer(productId));
			model.addAttribute("product", product);			
		    return "admin-product-edit";
	    }
		return "main-page";
 
	}	
		
	@RequestMapping(value="/store/edit/{storeId}")
	public String storeEdit(@CookieValue(value="accountCookie", defaultValue="") String accountHash,@PathVariable(value="storeId") String storeId, Model model, HttpServletResponse response) {
		System.out.println("Inside storeEdit() - Admin Controller ");
	    
		Account account = isAdmin(accountHash);
	    if( account != null ) {
		
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        Store store = storeService.getStore( new Integer(storeId));
			model.addAttribute("store", store);			
	        return "admin-store-edit";
	    }
		return "main-page";
	}

	@RequestMapping(value="/store/update")
	public String storeUpdate(@CookieValue(value="accountCookie", defaultValue="") String accountHash,@ModelAttribute("store") Store store, Model model) {
		System.out.println("Inside storeUpdate() - Admin Controller ");

		Account account = isAdmin(accountHash);
		if ( account != null ) {
		    model.addAttribute("account", account);
		    model.addAttribute("user", account.getUser());
		    
			System.out.println("Saving Store: " + store);
			int storeId = store.getStoreId();
			
			Store oldStore = storeService.getStore(storeId);
			Set<StoreCopy> storeCopy = oldStore.getStoreCopy();
			Set<Product> products = oldStore.getProducts();
			
			store.setStoreCopy(storeCopy);
			store.setProducts(products);
			
			storeService.saveStore(store);
			Store newStore = storeService.getStore(storeId);
		    model.addAttribute("store", newStore);
		    return "admin-store-edit";
		}
		return "main-page";
	}
	
	private Account isAdmin(String accountHash) {
		Account account = null;
		if ( accountHash != "" ) {
		    account = accountService.getAccountFromHash(accountHash);
		}
		return account;
	}
	
}
