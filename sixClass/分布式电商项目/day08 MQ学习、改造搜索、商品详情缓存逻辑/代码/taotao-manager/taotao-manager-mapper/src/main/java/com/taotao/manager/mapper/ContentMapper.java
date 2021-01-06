package com.taotao.manager.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.taotao.manager.pojo.Content;
/**
 * 内容
 * @author youyuan
 *
 */
public interface ContentMapper extends Mapper<Content>{

	List<Content> queryContentByCategoryId(Long categoryId);

}
