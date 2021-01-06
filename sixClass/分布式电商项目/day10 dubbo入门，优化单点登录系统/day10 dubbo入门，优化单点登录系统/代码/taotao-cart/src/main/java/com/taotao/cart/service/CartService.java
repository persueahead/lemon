package com.taotao.cart.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.taotao.cart.bean.Item;
import com.taotao.cart.bean.User;
import com.taotao.cart.mapper.CartMapper;
import com.taotao.cart.pojo.Cart;
import com.taotao.cart.threadlocal.UserThreadlocal;

@Service
public class CartService {
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ItemServer itemServer;
	/**
	 * 添加商品到购物车，如果数据库中有记录则将个数加一，如果没有记录则添加一条购物车的记录
	 * @param itemId
	 */
	public void addItemToCar(Long itemId) {
		User user = UserThreadlocal.get();
		Cart record = new Cart();
		record.setItemId(itemId);
		record.setUserId(user.getId());
		Cart cart = cartMapper.selectOne(record);
		if(cart == null){
			//没有查询到记录时创建一条记录插入到数据了
			cart = new Cart();
			cart.setCreated(new Date());
			cart.setItemId(itemId);
			cart.setNum(1);
			cart.setUpdated(cart.getCreated());
			cart.setUserId(user.getId());
			//标题，图片，价格
			Item item = itemServer.queryItemById(String.valueOf(itemId));
			cart.setItemImage(StringUtils.split(item.getImage(),",")[0]);
			cart.setItemPrice(item.getPrice());
			cart.setItemTitle(item.getTitle());
			cartMapper.insert(cart);
		}else{
			cart.setNum(cart.getNum()+1);
			cart.setUpdated(new Date());
			cartMapper.updateByPrimaryKey(cart);
		}
		
	}
	/**
	 * 从数据库中查询用户的购物车信息
	 * @return
	 */
	public List<Cart> queryCartList() {
		return queryCartList(UserThreadlocal.get().getId());
	}
	/**
	 * 修改购物车中商品的数量
	 * @param itemId
	 * @param num
	 */
	public void updateCartNum(Long itemId, Integer num) {
		User user = UserThreadlocal.get();
		Cart cart = new Cart();
		cart.setNum(num);
		cart.setUpdated(new Date());
		Example example = new Example(Cart.class);
		example.createCriteria().andEqualTo("userId", user.getId()).andEqualTo("itemId", itemId);
		cartMapper.updateByExampleSelective(cart, example);
	}
	/**
	 * 根据条件删除商品信息
	 * @param itemId
	 */
	public void deleteItem(Long itemId) {
		Cart cart = new Cart();
		cart.setItemId(itemId);
		cart.setUserId(UserThreadlocal.get().getId());
		cartMapper.delete(cart);
	}
	public List<Cart> queryCartList(Long userId) {
		Example example = new Example(Cart.class);
		example.setOrderByClause("created desc");
		example.createCriteria().andEqualTo("userId",userId);
		return cartMapper.selectByExample(example);
		
	}
	
}
