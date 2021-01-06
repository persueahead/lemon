package com.taotao.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.taotao.cart.bean.User;
import com.taotao.cart.pojo.Cart;
import com.taotao.cart.service.CartCookieService;
import com.taotao.cart.service.CartService;
import com.taotao.cart.threadlocal.UserThreadlocal;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private CartCookieService cartCookieService;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("cart");
		User user = UserThreadlocal.get();
		List<Cart> list = new ArrayList<>();
		if(user != null){
			list = cartService.queryCartList();
		}else{
			try {
				list = cartCookieService.queryCartList(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		modelAndView.addObject("cartList", list);
		return modelAndView;
	}

	@RequestMapping(value="{itemId}",method=RequestMethod.GET)
	public String addItemToCart(@PathVariable("itemId")Long itemId,HttpServletRequest request,HttpServletResponse response){
		User user = UserThreadlocal.get();
		if(user != null){
			//登录状态
			cartService.addItemToCar(itemId);
		}else{
			//未登录状态
			try {
				cartCookieService.addItemToCar(itemId,request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/cart/list.html";
	}
	
	//update/num/"+_thisInput.attr("itemId")+"/"+_thisInput.val()
	@RequestMapping(value="/update/num/{itemId}/{num}",method=RequestMethod.POST)
	public ResponseEntity<Void> updateCartNum(@PathVariable("itemId")Long itemId,@PathVariable("num")Integer num,
			HttpServletRequest request,HttpServletResponse response){
		try {
			User user = UserThreadlocal.get();
			if(user != null){
				//登录状态
				cartService.updateCartNum(itemId,num);
			}else{
				//未登录状态
				try {
					cartCookieService.updateCartNum(itemId,num,request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	@RequestMapping(value="/delete/{itemId}",method=RequestMethod.GET)
	public String deleteItem(@PathVariable("itemId")Long itemId,HttpServletRequest request,
			HttpServletResponse response){
		User user = UserThreadlocal.get();
		if(user != null){
			//删除商品
			cartService.deleteItem(itemId);
		}else{
			//未登录状态
			try {
				cartCookieService.deleteItem(itemId,request,response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "cart";
	}
	
}
