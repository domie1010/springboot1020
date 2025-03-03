package com.dao;

import com.entity.ZufangLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZufangLiuyanView;

/**
 * 租房留言 Dao 接口
 *
 * @author 
 */
public interface ZufangLiuyanDao extends BaseMapper<ZufangLiuyanEntity> {

   List<ZufangLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
