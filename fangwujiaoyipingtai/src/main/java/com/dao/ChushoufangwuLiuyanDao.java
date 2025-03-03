package com.dao;

import com.entity.ChushoufangwuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushoufangwuLiuyanView;

/**
 * 出售房屋留言 Dao 接口
 *
 * @author 
 */
public interface ChushoufangwuLiuyanDao extends BaseMapper<ChushoufangwuLiuyanEntity> {

   List<ChushoufangwuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
