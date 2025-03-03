package com.dao;

import com.entity.ChushoufangwuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushoufangwuCollectionView;

/**
 * 出售房屋收藏 Dao 接口
 *
 * @author 
 */
public interface ChushoufangwuCollectionDao extends BaseMapper<ChushoufangwuCollectionEntity> {

   List<ChushoufangwuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
