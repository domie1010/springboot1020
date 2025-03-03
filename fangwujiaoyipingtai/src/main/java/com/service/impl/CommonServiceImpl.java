
package com.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommonDao;
import com.service.CommonService;


/**
 * 系统用户
 * @author
 * @date
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private CommonDao commonDao;

	@Override
	public List<String> getOption(Map<String, Object> params) {
		return commonDao.getOption(params);
	}
	
	@Override
	public Map<String, Object> getFollowByOption(Map<String, Object> params) {
		return commonDao.getFollowByOption(params);
	}


	/**
	 tableName 查询表
	 condition1 条件1
	 condition1Value 条件1值
	 average 计算平均评分
	 * */
	public Map<String, Object> queryScore(Map<String, Object> params){
		return commonDao.queryScore(params);
	}
	
	@Override
	public void sh(Map<String, Object> params) {
		commonDao.sh(params); 
	}

	@Override
	public int remindCount(Map<String, Object> params) {
		return commonDao.remindCount(params);
	}

	@Override
	public Map<String, Object> selectCal(Map<String, Object> params) {
		return commonDao.selectCal(params);
	}
	
	@Override
	public List<Map<String, Object>> selectGroup(Map<String, Object> params) {
		return commonDao.selectGroup(params);
	}
	
	@Override
	public List<Map<String, Object>> selectValue(Map<String, Object> params) {
		return commonDao.selectValue(params);
	}

	@Override
	public List<Map<String, Object>> chartBoth(Map<String, Object> params) {
		return commonDao.chartBoth(params);
	}

	@Override
	public List<Map<String, Object>> chartOne(Map<String, Object> params) {
		return commonDao.chartOne(params);
	}


	/**
	 * 新的级联字典表的  分组求和统计
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> newSelectGroupSum(Map<String, Object> params) {
		return commonDao.newSelectGroupSum(params);
	}


	/**
	 * 新的级联字典表的  分组条数统计
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> newSelectGroupCount(Map<String, Object> params) {
		return commonDao.newSelectGroupCount(params);
	}

	/**
	 * 当前表的日期分组求和
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> newSelectDateGroupSum(Map<String, Object> params) {
		return commonDao.newSelectDateGroupSum(params);
	}


	/**
	 * 查询字典表的分组统计总条数
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> newSelectDateGroupCount(Map<String, Object> params) {
		return commonDao.newSelectDateGroupCount(params);
	}

	@Override
	public int plusCloumNumber(Map<String, Object> params) {
		return commonDao.plusCloumNumber(params);
	}
	@Override
	public int reduceCloumNumber(Map<String, Object> params) {
		return commonDao.reduceCloumNumber(params);
	}
	@Override
	public int updateCloumValue(Map<String, Object> params) {
		return commonDao.updateCloumValue(params);
	}

/**
 * 饼状图
 * -- 饼状图  查询当前表
 -- 				查询字典表【月】
 -- 				 统计   -- 查询某个月的每个类型的订单销售数量
 -- 				 求和   -- 查询某个月的每个类型的订单销售额
 -- 				查询某个字符串【月】
 -- 				 统计   -- 查询某个月的每个员工的订单销售数量
 -- 				 求和   -- 查询某个月的每个员工的订单销售额
 -- 				查询时间【年】
 -- 				 统计 	-- 查询每个月的订单销售数量
 -- 				 求和 	-- 查询每个月的订单销售额
 -- 饼状图  查询级联表
 -- 				查询字典表
 -- 				 统计  	-- 查询某个月的每个类型的订单销售数量
 -- 				 求和   -- 查询某个月的每个类型的订单销售额
 -- 				查询某个字符串
 -- 				 统计   -- 查询某个月的每个员工的订单销售数量
 -- 				 求和   -- 查询某个月的每个员工的订单销售额
 -- 				查询时间
 -- 				 统计 	-- 统计每个月的订单销售数量
 -- 				 求和 	-- 查询每个月的订单销售额
 */


/**
 * 柱状图
 -- 柱状图  查询当前表
 --             某个【年，月】
 -- 			 当前表 2 级联表 1
 -- 						统计
 --   						【日期，字符串，下拉框】
 -- 						求和
 --   						【日期，字符串，下拉框】
 -- 柱状图  查询级联表
 -- 					某个【年，月】
 -- 						统计
 --   						【日期，字符串，下拉框】
 -- 						求和
 --   						【日期，字符串，下拉框】
 */
	/**
	 * 柱状图求和
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> barSum(Map<String, Object> params){
		return commonDao.barSum(params);
	}

	/**
	 * 柱状图统计
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> barCount(Map<String, Object> params){
		return commonDao.barCount(params);
	}

}
