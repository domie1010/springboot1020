
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 租房
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zufang")
public class ZufangController {
    private static final Logger logger = LoggerFactory.getLogger(ZufangController.class);

    @Autowired
    private ZufangService zufangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CheckData.checkMap(params);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("zufangDeleteStart",1);params.put("zufangDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zufangService.queryPage(params);

        //字典表数据转换
        List<ZufangView> list =(List<ZufangView>)page.getList();
        for(ZufangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZufangEntity zufang = zufangService.selectById(id);
        if(zufang !=null){
            //entity转view
            ZufangView view = new ZufangView();
            BeanUtils.copyProperties( zufang , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zufang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZufangEntity zufang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zufang:{}",this.getClass().getName(),zufang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            zufang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZufangEntity> queryWrapper = new EntityWrapper<ZufangEntity>()
            .eq("yonghu_id", zufang.getYonghuId())
            .eq("zufang_name", zufang.getZufangName())
            .eq("zufang_uuid_number", zufang.getZufangUuidNumber())
            .eq("zufang_types", zufang.getZufangTypes())
            .eq("quyu_types", zufang.getQuyuTypes())
            .eq("zufang_xiaoqu", zufang.getZufangXiaoqu())
            .eq("zufang_weizhi", zufang.getZufangWeizhi())
            .eq("zufang_clicknum", zufang.getZufangClicknum())
            .eq("zufang_zhuangtai_types", zufang.getZufangZhuangtaiTypes())
            .eq("shangxia_types", zufang.getShangxiaTypes())
            .eq("zufang_delete", zufang.getZufangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZufangEntity zufangEntity = zufangService.selectOne(queryWrapper);
        if(zufangEntity==null){
            zufang.setZufangClicknum(1);
            zufang.setShangxiaTypes(1);
            zufang.setZufangDelete(1);
            zufang.setCreateTime(new Date());
            zufangService.insert(zufang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZufangEntity zufang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zufang:{}",this.getClass().getName(),zufang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            zufang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZufangEntity> queryWrapper = new EntityWrapper<ZufangEntity>()
            .notIn("id",zufang.getId())
            .andNew()
            .eq("yonghu_id", zufang.getYonghuId())
            .eq("zufang_name", zufang.getZufangName())
            .eq("zufang_uuid_number", zufang.getZufangUuidNumber())
            .eq("zufang_types", zufang.getZufangTypes())
            .eq("quyu_types", zufang.getQuyuTypes())
            .eq("zufang_xiaoqu", zufang.getZufangXiaoqu())
            .eq("zufang_weizhi", zufang.getZufangWeizhi())
            .eq("zufang_clicknum", zufang.getZufangClicknum())
            .eq("zufang_zhuangtai_types", zufang.getZufangZhuangtaiTypes())
            .eq("shangxia_types", zufang.getShangxiaTypes())
            .eq("zufang_delete", zufang.getZufangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZufangEntity zufangEntity = zufangService.selectOne(queryWrapper);
        if("".equals(zufang.getZufangPhoto()) || "null".equals(zufang.getZufangPhoto())){
                zufang.setZufangPhoto(null);
        }
        if(zufangEntity==null){
            zufangService.updateById(zufang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ZufangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZufangEntity zufangEntity = new ZufangEntity();
            zufangEntity.setId(id);
            zufangEntity.setZufangDelete(2);
            list.add(zufangEntity);
        }
        if(list != null && list.size() >0){
            zufangService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ZufangEntity> zufangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZufangEntity zufangEntity = new ZufangEntity();
//                            zufangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            zufangEntity.setZufangName(data.get(0));                    //房屋名称 要改的
//                            zufangEntity.setZufangUuidNumber(data.get(0));                    //房屋编号 要改的
//                            zufangEntity.setZufangPhoto("");//详情和图片
//                            zufangEntity.setZufangTypes(Integer.valueOf(data.get(0)));   //出租房屋类型 要改的
//                            zufangEntity.setQuyuTypes(Integer.valueOf(data.get(0)));   //区域 要改的
//                            zufangEntity.setZufangXiaoqu(data.get(0));                    //所在小区 要改的
//                            zufangEntity.setZufangWeizhi(data.get(0));                    //所在详细位置 要改的
//                            zufangEntity.setZufangMianji(data.get(0));                    //房屋面积 要改的
//                            zufangEntity.setZufangOldMoney(data.get(0));                    //原价/月 要改的
//                            zufangEntity.setZufangNewMoney(data.get(0));                    //现加/月 要改的
//                            zufangEntity.setZufangClicknum(Integer.valueOf(data.get(0)));   //房屋热度 要改的
//                            zufangEntity.setZufangContent("");//详情和图片
//                            zufangEntity.setZufangZhuangtaiTypes(Integer.valueOf(data.get(0)));   //房屋状态 要改的
//                            zufangEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            zufangEntity.setZufangDelete(1);//逻辑删除字段
//                            zufangEntity.setCreateTime(date);//时间
                            zufangList.add(zufangEntity);


                            //把要查询是否重复的字段放入map中
                                //房屋编号
                                if(seachFields.containsKey("zufangUuidNumber")){
                                    List<String> zufangUuidNumber = seachFields.get("zufangUuidNumber");
                                    zufangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zufangUuidNumber = new ArrayList<>();
                                    zufangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zufangUuidNumber",zufangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //房屋编号
                        List<ZufangEntity> zufangEntities_zufangUuidNumber = zufangService.selectList(new EntityWrapper<ZufangEntity>().in("zufang_uuid_number", seachFields.get("zufangUuidNumber")).eq("zufang_delete", 1));
                        if(zufangEntities_zufangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZufangEntity s:zufangEntities_zufangUuidNumber){
                                repeatFields.add(s.getZufangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [房屋编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zufangService.insertBatch(zufangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CheckData.checkMap(params);

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = zufangService.queryPage(params);

        //字典表数据转换
        List<ZufangView> list =(List<ZufangView>)page.getList();
        for(ZufangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZufangEntity zufang = zufangService.selectById(id);
            if(zufang !=null){

                //点击数量加1
                zufang.setZufangClicknum(zufang.getZufangClicknum()+1);
                zufangService.updateById(zufang);

                //entity转view
                ZufangView view = new ZufangView();
                BeanUtils.copyProperties( zufang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(zufang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZufangEntity zufang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zufang:{}",this.getClass().getName(),zufang.toString());
        Wrapper<ZufangEntity> queryWrapper = new EntityWrapper<ZufangEntity>()
            .eq("yonghu_id", zufang.getYonghuId())
            .eq("zufang_name", zufang.getZufangName())
            .eq("zufang_uuid_number", zufang.getZufangUuidNumber())
            .eq("zufang_types", zufang.getZufangTypes())
            .eq("quyu_types", zufang.getQuyuTypes())
            .eq("zufang_xiaoqu", zufang.getZufangXiaoqu())
            .eq("zufang_weizhi", zufang.getZufangWeizhi())
            .eq("zufang_clicknum", zufang.getZufangClicknum())
            .eq("zufang_zhuangtai_types", zufang.getZufangZhuangtaiTypes())
            .eq("shangxia_types", zufang.getShangxiaTypes())
            .eq("zufang_delete", zufang.getZufangDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZufangEntity zufangEntity = zufangService.selectOne(queryWrapper);
        if(zufangEntity==null){
            zufang.setZufangDelete(1);
            zufang.setCreateTime(new Date());
        zufangService.insert(zufang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
