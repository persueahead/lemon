package com.taotao.search.controller;

import java.io.UnsupportedEncodingException;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.search.bean.SearchResult;
import com.taotao.search.service.SearchService;

@Controller
public class SearchController {
	private static final Integer pageSize = 32;
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public ModelAndView search(@RequestParam("q")String keyword,@RequestParam(value="page",defaultValue="1")Integer page){
		
		
		
		ModelAndView  modelAndView = new ModelAndView("search");
		
		try {
			keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			keyword = "";
		}
		modelAndView.addObject("query", keyword);
		modelAndView.addObject("page", page);
		SearchResult result;
		try {
			result = searchService.queryItemByKeyword(keyword,page,pageSize);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = new SearchResult();
			modelAndView.addObject("itemList", null);
			//根据数据的总条数除以每页的分页大小获取总页面
			modelAndView.addObject("pages",0);
			return modelAndView;
		}
		modelAndView.addObject("itemList", result.getRows());
		//根据数据的总条数除以每页的分页大小获取总页面
		modelAndView.addObject("pages",result.getTotal()%pageSize == 0?result.getTotal() / pageSize: result.getTotal() / pageSize + 1);
		return modelAndView;
	}

}
