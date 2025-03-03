package com.dao;

import com.entity.ZufangOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZufangOrderView;

/**
 * 预约租房看房 Dao 接口
 *
 * @author 
 */
public interface ZufangOrderDao extends BaseMapper<ZufangOrderEntity> {

   List<ZufangOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
