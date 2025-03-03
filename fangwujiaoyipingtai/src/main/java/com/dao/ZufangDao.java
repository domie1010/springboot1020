package com.dao;

import com.entity.ZufangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZufangView;

/**
 * 租房 Dao 接口
 *
 * @author 
 */
public interface ZufangDao extends BaseMapper<ZufangEntity> {

   List<ZufangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
