package com.dao;

import com.entity.ChushoufangwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushoufangwuView;

/**
 * 出售房屋 Dao 接口
 *
 * @author 
 */
public interface ChushoufangwuDao extends BaseMapper<ChushoufangwuEntity> {

   List<ChushoufangwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
