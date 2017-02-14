package com.olsendesign.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.util.compare.ComparableComparator;
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
			                @CookieValue(value="storeId", defaultValue="-1") String storeId,
			                Model model, 
			                HttpServletResponse response
			                ) {
		System.out.println("Inside adminHome() - Admin Controller ");
		
		Store store = storeService.getStore( new Integer(storeId));
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
	        
	        model.addAttribute("products", productService.getAllProducts());
	        model.addAttribute("roles", roleService.getAllRoles());
	        model.addAttribute("storeCopy", storeCopyService.getAllStoreCopy());
	        model.addAttribute("users", userService.getAllUsers());
	        
	        return "admin-main-page";
	    }
		return "main-page";
	}	

    // http://localhost:8081/store/admin/store/1/product/1/list 
	@RequestMapping(value="/store/{storeId}/product/{productId}/list")
	public String productList(
			                  @CookieValue(value="accountCookie", defaultValue="") String accountHash,
			                  @PathVariable(value="storeId") String storeId, 
			                  @PathVariable(value="productId") String productId, 
			                  //@RequestParam("file") MultipartFile fileUpload,
			                  Model model, 
			                  HttpServletResponse response
			                  ) {
		System.out.println("Inside productList() - Admin Controller ");

		Store store = storeService.getStore(new Integer(storeId));
	    model.addAttribute("store", store);
		
		Account account = isAdmin(accountHash);		
	    if( account != null ) {
		
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        List<Product> products = new ArrayList<Product>(store.getProducts());
	        Comparator<Product> c = new ComparableComparator<Product>();
	        products.sort(c);
			model.addAttribute("products", products);						
	        
	        Product product = productService.getProduct( new Integer(productId));
			model.addAttribute("product", product);						
		    return "admin-product-list";
	    }
		return "main-page";
 
	}
	
    // http://localhost:8081/store/admin/store/1/product/1/update 
	@RequestMapping(value="/store/{storeId}/product/{productUrlId}/update")
	public String productUpdate(
			                  @CookieValue(value="accountCookie", defaultValue="") String accountHash,
			                  @PathVariable(value="storeId") String storeId, 
			                  @PathVariable(value="productUrlId") String productUrlId, 
			                  @ModelAttribute("product") Product product,
			                  //@RequestParam("file") MultipartFile fileUpload,
			                  Model model, 
			                  HttpServletResponse response
			                  ) {
		System.out.println("Inside productUpdate() - Admin Controller ");
		
	    Store store = storeService.getStore(new Integer(storeId));
	    model.addAttribute("store", store);
	    product.setStore(store);    
	    
		Account account = isAdmin(accountHash);		
	    if( account != null && product.getProductId() == new Integer(productUrlId)  ) {
	    	
	        model.addAttribute("account", account);
	        model.addAttribute("user", account.getUser());
	        Cookie accountCookie = new Cookie("accountCookie", account.getAccountHash());
	        response.addCookie(accountCookie);
	        
	        int storeIdFromProduct = new Integer(product.getStore().getStoreId());
	        int storeIdFromUrl     = new Integer(storeId);
	        
	        if ( storeIdFromProduct == storeIdFromUrl ) {
	        	product.setStore(store);
	        	productService.saveProduct(product);
	        	System.out.println("   Product Updated : " + product);
	        } else{
	        	model.addAttribute("errors", "Error Updating Product StoreId Inconsistancy ");
                System.out.println("- Error - Someone is editing product and they are not passing the correct store ids: url id: " + storeIdFromUrl + " passed id: " + storeIdFromProduct);
                System.err.println(" - Possible Hack Attempt - Product Ids do not match. ");
	        	return "main-page";
	        }
	        
	        Product newProduct = productService.getProduct( new Integer(productUrlId));
			model.addAttribute("product", newProduct);			
			
	        List<Product> products = new ArrayList( storeService.getStore(store.getStoreId()).getProducts());
	        Comparator<Product> c = new ComparableComparator<Product>();
	        products.sort(c);
			model.addAttribute("products", products);						
			
		    return "admin-product-list";
	    }
	    System.out.println("   Bad account or bad productid match.");
		return "main-page";
 
	}	
	
	@RequestMapping(value="store/{storeId}/product/new")
	public String newProduct(
			                 @CookieValue(value="accountCookie", defaultValue="") String accountHash, 
			                 @PathVariable(value="storeId") String storeId,
			                 @ModelAttribute("product") Product product,
			                 Model model,
			                 HttpServletResponse response
			                 ) {
	    System.out.println("Inside newProduct() - Admin Controller ");
	    System.out.println("  Store Id: " + storeId );
	    Store store = storeService.getStore( new Integer(storeId));
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
	        
	        List<Product> products = new ArrayList( storeService.getStore(store.getStoreId()).getProducts());
	        ComparableComparator<Product> c = new ComparableComparator<Product>();
	        products.sort(c);
	        
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
				store.setStoreCopy(storeCopy);
				ArrayList<StoreCopy> storeCopyArr = new ArrayList<StoreCopy>(storeCopy);
		        ComparableComparator<StoreCopy> c1 = new ComparableComparator<StoreCopy>();
		        storeCopyArr.sort(c1);
		        model.addAttribute("storeCopy", storeCopyArr);
		        
				Set<Product> products = oldStore.getProducts();
				store.setProducts(products);
				ArrayList<Product> productsArr = new ArrayList<Product>(products);
		        ComparableComparator<Product> c2 = new ComparableComparator<Product>();
		        productsArr.sort(c2);
		        model.addAttribute("products", productsArr);

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
