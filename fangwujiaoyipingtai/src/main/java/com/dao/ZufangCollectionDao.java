package com.dao;

import com.entity.ZufangCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZufangCollectionView;

/**
 * 租房收藏 Dao 接口
 *
 * @author 
 */
public interface ZufangCollectionDao extends BaseMapper<ZufangCollectionEntity> {

   List<ZufangCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
