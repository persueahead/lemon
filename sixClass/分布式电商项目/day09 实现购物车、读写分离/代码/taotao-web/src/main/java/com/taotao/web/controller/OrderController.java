package com.taotao.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.manager.pojo.Item;
import com.taotao.web.bean.Cart;
import com.taotao.web.bean.Order;
import com.taotao.web.bean.User;
import com.taotao.web.interceptors.UserLoginHandlerInterceptor;
import com.taotao.web.service.CartService;
import com.taotao.web.service.ItemService;
import com.taotao.web.service.OrderService;
import com.taotao.web.service.UserService;
import com.taotao.web.threadlocal.UserThreadlocal;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ItemService service;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="{itemId}",method=RequestMethod.GET)
	public ModelAndView toOrder(@PathVariable("itemId")Long itemId){
		Item item = service.queryItemById(itemId);
		ModelAndView modelAndView = new ModelAndView("order");
		modelAndView.addObject("item", item);
		return modelAndView;
	}
	@RequestMapping(value="submit",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> submitOrder(Order order,@CookieValue("taotao_cookie")String token){
		
		//往order中添加用户的参数信息   userId,nikname
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			String order_id = orderService.submitOrder(order);
			if(StringUtils.isNotBlank(order_id)){
				map.put("data", order_id);
				map.put("status", 200);
			}else{
				map.put("status", 500);
			}
			return ResponseEntity.status(HttpStatus.OK).body(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	@RequestMapping(value="success",method=RequestMethod.GET)
	public ModelAndView toSuccess(@RequestParam("id")String orderId){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		Order order = orderService.queryOrderById(orderId);
		modelAndView.addObject("order", order);
		modelAndView.addObject("date", new DateTime().plusDays(2).toString("MM月dd天"));
		return modelAndView;
		
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView toOrderConfig(){
		ModelAndView modelAndView = new ModelAndView("order-cart");
		List<Cart> list = cartService.queryCarts();
		modelAndView.addObject("carts", list);
		return modelAndView;
	}
}
