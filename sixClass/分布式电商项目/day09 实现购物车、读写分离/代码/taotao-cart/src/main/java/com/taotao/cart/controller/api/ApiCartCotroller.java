package com.taotao.cart.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taotao.cart.pojo.Cart;
import com.taotao.cart.service.CartService;

@Controller
@RequestMapping("api/cart")
public class ApiCartCotroller {
	@Autowired
	private CartService cartService;
	@RequestMapping(value="query/list/{userId}",method=RequestMethod.GET)
	public ResponseEntity<List<Cart>> queryCartList(@PathVariable("userId")Long userId){
		try {
			List<Cart> list = cartService.queryCartList(userId);
			if(list == null || list.size() == 0){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
	}
}
