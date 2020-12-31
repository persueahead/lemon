package com.bjlemon.utiles;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Util {
	/**
	 * sql语句都是通过sqlRunner里面的方法来实现的
	 */
//			连接池私有化
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
//			QuaryRunner私有化
	private static QueryRunner qr=new QueryRunner(dataSource);
	//构造方法私有化 单例模式
	private C3p0Util(){
		
	}
	//提供一个外部静态的连接池访问方法
	public static ComboPooledDataSource getInstance(){	
		return dataSource;
	}
	
	//提供获取数据库连接的方法
	public static Connection getConn() throws SQLException{
		return dataSource.getConnection();
	}

	public static QueryRunner getQr() {
		return qr;
	}
	//	查--------------------------------------------------------------------------------------
	/**
	 * 通用的查询多条数据的方法
	 * @param sql
	 * @param t
	 * @param params  可以是数组
	 * @return
	 * @throws SQLException
	 */
	public static <T>List<T> queryList(String sql,Class<T> t,Object...params)
			throws SQLException{
		List<T> list=qr.query(sql, new BeanListHandler<T>(t), params);
		
		return list;
	}
	/**
	 * 查询一个对象的方法
	 * @param sql
	 * @param t
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static <T>T queryOne(String sql,Class<T> t,Object...params) 
			throws SQLException{
		T entity=qr.query(sql, new BeanHandler<T>(t), params);
		return entity;
	}
	/**
	 * 查询一个数值型的数据的方法
	 * @param sql
	 * @param t
	 * @param params
	 * @return
	 * @throws SQLException
	 *  ScalarHandler:获取结果集中第一行数据指定列的值,常用来进行单值查询
	 */
	public static <T>T queryNumber(String sql,Class<T> t,Object...params) 
			throws SQLException{
		T entity=qr.query(sql, new ScalarHandler<T>(), params);
		return entity;
	}
//	增删改通用-------------------------------------------------------------------------
	/**
	 * 通用的执行更新数据的方法，包括增加、修改、删除
	 * @param sql
	 * @param params object类型，可以是数组
	 * @return
	 * @throws SQLException
	 */
	public static int update(String sql,Object...params)
			throws SQLException{
		int rows=qr.update(sql, params);
		return rows;
	}
}
