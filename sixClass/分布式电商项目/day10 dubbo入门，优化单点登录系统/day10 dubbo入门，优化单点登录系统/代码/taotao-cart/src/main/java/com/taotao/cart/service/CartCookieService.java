package com.taotao.cart.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.cart.bean.Item;
import com.taotao.cart.pojo.Cart;
import com.taotao.common.utils.CookieUtils;

@Service
public class CartCookieService {
	
	private String COOKIE_NAME = "TT_Cart";
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private  int COOKIE_MAX_AGE = 60*60*24*7;
	
	@Autowired
	private ItemServer itemServer;

	/**
	 * 向cookie中添加商品数据,如果当前的商品存在则把数量加1如果不存在则创建商品，存到cookie中
	 * @param itemId
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void addItemToCar(Long itemId, HttpServletRequest request,
		HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		List<Cart> list = queryCartList(request);
		Cart des = null;
		if(list != null && list.size() > 0){
			for(Cart cart:list){
				if(cart.getItemId().equals(itemId)){
					des = cart;
					break;
				}
			}
		}
		//判断当前的商品是否存在
		if(des != null){
			des.setNum(des.getNum()+1);
			des.setUpdated(new Date());
		}else{
			//没有查询到记录时创建一条记录插入到数据了
			Cart cart = new Cart();
			cart.setCreated(new Date());
			cart.setItemId(itemId);
			cart.setNum(1);
			cart.setUpdated(cart.getCreated());
			//标题，图片，价格
			Item item = itemServer.queryItemById(String.valueOf(itemId));
			cart.setItemImage(StringUtils.split(item.getImage(),",")[0]);
			cart.setItemPrice(item.getPrice());
			cart.setItemTitle(item.getTitle());
			list.add(cart);
		}
		CookieUtils.setCookie(request, response, COOKIE_NAME, objectMapper.writeValueAsString(list), COOKIE_MAX_AGE, true);
		
	}
    /**
     * 从cooki购物车信息
     * @param request
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
	public List<Cart> queryCartList(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		List<Cart> list;
		String jsonStr = CookieUtils.getCookieValue(request, COOKIE_NAME, true);
		if(StringUtils.isEmpty(jsonStr)){
			list = new ArrayList<Cart>();
		}else{
			list = objectMapper.readValue(jsonStr, objectMapper.getTypeFactory().constructCollectionType(List.class, Cart.class));
		}
		return list;
	}
	/**
	 * 
	 * @param itemId
	 * @param num  跟新cookie中购物车商品的个数
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void updateCartNum(Long itemId, Integer num,
			HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		List<Cart> list = queryCartList(request);
		if(list != null && list.size() > 0){
			for(Cart cart:list){
				if(cart.getItemId().equals(itemId)){
					cart.setNum(cart.getNum()+1);
					cart.setUpdated(new Date());
					break;
				}
			}
		}
		CookieUtils.setCookie(request, response, COOKIE_NAME, objectMapper.writeValueAsString(list), COOKIE_MAX_AGE, true);
	}
	/**
	 * 根据商品的id删除购物车中商品的信息
	 * @param itemId
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void deleteItem(Long itemId, HttpServletRequest request,
			HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		List<Cart> list = queryCartList(request);
		if(list != null && list.size() > 0){
			Iterator<Cart> iterator = list.iterator();
			while(iterator.hasNext()){
				Cart cart = iterator.next();
				if(cart.getItemId().equals(itemId)){
					iterator.remove();
					break;
				}
			}
		}
		CookieUtils.setCookie(request, response, COOKIE_NAME, objectMapper.writeValueAsString(list), COOKIE_MAX_AGE, true);
		
	}

	
}
