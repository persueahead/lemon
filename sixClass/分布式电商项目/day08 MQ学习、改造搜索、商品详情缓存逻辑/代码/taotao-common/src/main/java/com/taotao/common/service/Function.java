package com.taotao.common.service;
/**
 * 公用方法的抽取
 * @author youyuan
 *
 * @param <T>
 * @param <E>
 */
public interface Function<T,E> {

	public T callback(E e);
}
