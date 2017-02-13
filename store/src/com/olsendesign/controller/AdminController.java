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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.olsendesign.store.hibernate.entity.Account;
import com.olsendesign.store.hibernate.entity.Product;
import com.olsendesign.store.hibernate.entity.Store;
import com.olsendesign.store.hibernate.entity.StoreCopy;
import com.olsendesign.store.service.AccountService;
import com.olsendesign.store.service.ProductService;
import com.olsendesign.store.service.RoleService;
import com.olsendesign.store.service.StoreCopyService;
import com.olsendesign.store.service.StoreService;
import com.olsendesign.store.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private StoreCopyService storeCopyService;
	
	
	@RequestMapping(value="/")
	public String adminHome(
			                @CookieValue(value="storeId", defaultValue="-1") String storeId
			                ) {
		System.out.println("Inside adminHome() - AdminController");
		return "redirect:" + storeId + "/admin/main";
	}
	
	@RequestMapping(value="/main")
	public String adminMain(
			                @CookieValue(value="accountCookie", defaultValue="") String accountHash,
			                @CookieValue(value="storeId", defaultValue="-1") int storeId,
			                Model model, 
			                HttpServletResponse response
			                ) {
		System.out.println("Inside adminHome() - Admin Controller ");
		
		Store store = storeService.getStore(storeId);
		if ( store != null ) {
			model.addAttribute("store", store);
		} else {
			model.addAttribute("store", new Store());
		}
		
		List<Store> stores = storeService.getStores();
		model.addAttribute("stores", stores);
	
		Account account = isAdmin(accountHash);
	    if( account != null ) {
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        System.out.println("Get all the objects!");
	        model.addAttribute("accounts", accountService.getAllAccounts());
	        System.out.println("1");
	        model.addAttribute("products", productService.getAllProducts());
	        System.out.println("2");
	        //model.addAttribute("roles", roleService.getAllRoles());
	        System.out.println("3");
	        model.addAttribute("storeCopy", storeCopyService.getAllStoreCopy());
	        System.out.println("4");
	        model.addAttribute("users", userService.getAllUsers());
	        System.out.println(" Done Get all the objects!");
	        
	        return "admin-main-page";
	    }
		return "main-page";
	}	
	
	@RequestMapping(value="{storeId}/product/edit/{productId}")
	public String productEdit(
			                  @CookieValue(value="accountCookie", defaultValue="") String accountHash,
			                  @PathVariable(value="storeId") String storeId, 
			                  @PathVariable(value="productId") String productId, 
			                  @RequestParam("file") MultipartFile fileUpload,
			                  Model model, 
			                  HttpServletResponse response
			                  ) {
		System.out.println("Inside productEdit() - Admin Controller ");
		
		Account account = isAdmin(accountHash);		
	    if( account != null ) {
		
	    	Store store = storeService.getStore(new Integer(storeId));
	    	
	        model.addAttribute("store", store);
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        Product product = productService.getProduct( new Integer(productId));
			model.addAttribute("product", product);			
		    return "admin-product-list";
	    }
		return "main-page";
 
	}	
	
	@RequestMapping(value="store/{storeId}/product/new")
	public String newProduct(
			                 @CookieValue(value="accountCookie", defaultValue="") String accountHash, 
			                 @PathVariable(value="storeId") int storeId,
			                 @ModelAttribute("product") Product product,
			                 Model model,
			                 HttpServletResponse response
			                 ) {
	    System.out.println("Inside newProduct() - Admin Controller ");
	    System.out.println("  Store Id: " + storeId );
	    Store store = storeService.getStore(storeId);
	    System.out.println("  Store Name: " + store.getName() );
	    
		Account account = isAdmin(accountHash);
		if( account != null ) {
			
			System.out.println("  Is an Admin!");
			model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        model.addAttribute("store",store);
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        product.setStore(store);
	        
	        System.out.println("  Pre-Saved Product"); 
	        productService.saveProduct(product);
	        System.out.println("  Post-Saved Product"); 
			return "admin-product-list";
		}
		return "main-page";
	}
	
	@RequestMapping(value="/store/{storeId}/list")
	public String storeList(
			                @CookieValue(value="accountCookie", defaultValue="") String accountHash,
			                @PathVariable(value="storeId") String storeId, 
			                Model model, 
			                HttpServletResponse response
			                ) {
		System.out.println("Inside storeList() - Admin Controller ");
	    
		Account account = isAdmin(accountHash);
	    if( account != null ) {
		
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        Store store = storeService.getStore( new Integer(storeId));
			model.addAttribute("store", store);			

			model.addAttribute("product", new Product() );			
			model.addAttribute("storeCopy", new StoreCopy() );			
	        return "admin-store-edit";
	    }
		return "main-page";
	}

	@RequestMapping(value="/store/{storeId}/update")
	public String storeUpdate(
			                  @CookieValue(value="accountCookie", defaultValue="") String accountHash,
			                  @PathVariable(value="storeId") String storeId,
			                  @ModelAttribute("store") Store store,
			                  Model model
			                  ) {
		System.out.println("Inside storeUpdate() - Admin Controller ");

		Account account = isAdmin(accountHash);
		if ( account != null ) {
		    model.addAttribute("account", account);
		    model.addAttribute("user", account.getUser());
		
			System.out.println("Saving Store: " + store);
			int oldStoreId = store.getStoreId();
			
			if ( oldStoreId == new Integer(storeId) ) {
				Store oldStore = storeService.getStore(oldStoreId);
				Set<StoreCopy> storeCopy = oldStore.getStoreCopy();
				Set<Product> products = oldStore.getProducts();

				store.setStoreCopy(storeCopy);
				store.setProducts(products);

				storeService.saveStore(store);
				Store newStore = storeService.getStore(new Integer(storeId));
				model.addAttribute("store", newStore);
			} 
			
			model.addAttribute("product", new Product() );			
			model.addAttribute("storeCopy", new StoreCopy() );			
		    
		    return "admin-store-edit";
		}
		return "main-page";
	}
	
	private Account isAdmin(String accountHash) {
		System.out.println("Inside isAdmin() - Admin Controller");
		Account account = null;
		if ( accountHash != "" ) {
		    account = accountService.getAccountFromHash(accountHash);
		}
		return account;
	}
	
}
