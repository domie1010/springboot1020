
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
 * 出售房屋
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chushoufangwu")
public class ChushoufangwuController {
    private static final Logger logger = LoggerFactory.getLogger(ChushoufangwuController.class);

    @Autowired
    private ChushoufangwuService chushoufangwuService;


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
        params.put("chushoufangwuDeleteStart",1);params.put("chushoufangwuDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chushoufangwuService.queryPage(params);

        //字典表数据转换
        List<ChushoufangwuView> list =(List<ChushoufangwuView>)page.getList();
        for(ChushoufangwuView c:list){
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
        ChushoufangwuEntity chushoufangwu = chushoufangwuService.selectById(id);
        if(chushoufangwu !=null){
            //entity转view
            ChushoufangwuView view = new ChushoufangwuView();
            BeanUtils.copyProperties( chushoufangwu , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(chushoufangwu.getYonghuId());
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
    public R save(@RequestBody ChushoufangwuEntity chushoufangwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chushoufangwu:{}",this.getClass().getName(),chushoufangwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chushoufangwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChushoufangwuEntity> queryWrapper = new EntityWrapper<ChushoufangwuEntity>()
            .eq("yonghu_id", chushoufangwu.getYonghuId())
            .eq("chushoufangwu_name", chushoufangwu.getChushoufangwuName())
            .eq("chushoufangwu_uuid_number", chushoufangwu.getChushoufangwuUuidNumber())
            .eq("chushoufangwu_types", chushoufangwu.getChushoufangwuTypes())
            .eq("chushoufangwu_xinjiu_types", chushoufangwu.getChushoufangwuXinjiuTypes())
            .eq("quyu_types", chushoufangwu.getQuyuTypes())
            .eq("chushoufangwu_xiaoqu", chushoufangwu.getChushoufangwuXiaoqu())
            .eq("chushoufangwu_weizhi", chushoufangwu.getChushoufangwuWeizhi())
            .eq("chushoufangwu_clicknum", chushoufangwu.getChushoufangwuClicknum())
            .eq("chushoufangwu_zhuangtai_types", chushoufangwu.getChushoufangwuZhuangtaiTypes())
            .eq("shangxia_types", chushoufangwu.getShangxiaTypes())
            .eq("chushoufangwu_delete", chushoufangwu.getChushoufangwuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushoufangwuEntity chushoufangwuEntity = chushoufangwuService.selectOne(queryWrapper);
        if(chushoufangwuEntity==null){
            chushoufangwu.setChushoufangwuClicknum(1);
            chushoufangwu.setShangxiaTypes(1);
            chushoufangwu.setChushoufangwuDelete(1);
            chushoufangwu.setCreateTime(new Date());
            chushoufangwuService.insert(chushoufangwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChushoufangwuEntity chushoufangwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chushoufangwu:{}",this.getClass().getName(),chushoufangwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chushoufangwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChushoufangwuEntity> queryWrapper = new EntityWrapper<ChushoufangwuEntity>()
            .notIn("id",chushoufangwu.getId())
            .andNew()
            .eq("yonghu_id", chushoufangwu.getYonghuId())
            .eq("chushoufangwu_name", chushoufangwu.getChushoufangwuName())
            .eq("chushoufangwu_uuid_number", chushoufangwu.getChushoufangwuUuidNumber())
            .eq("chushoufangwu_types", chushoufangwu.getChushoufangwuTypes())
            .eq("chushoufangwu_xinjiu_types", chushoufangwu.getChushoufangwuXinjiuTypes())
            .eq("quyu_types", chushoufangwu.getQuyuTypes())
            .eq("chushoufangwu_xiaoqu", chushoufangwu.getChushoufangwuXiaoqu())
            .eq("chushoufangwu_weizhi", chushoufangwu.getChushoufangwuWeizhi())
            .eq("chushoufangwu_clicknum", chushoufangwu.getChushoufangwuClicknum())
            .eq("chushoufangwu_zhuangtai_types", chushoufangwu.getChushoufangwuZhuangtaiTypes())
            .eq("shangxia_types", chushoufangwu.getShangxiaTypes())
            .eq("chushoufangwu_delete", chushoufangwu.getChushoufangwuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushoufangwuEntity chushoufangwuEntity = chushoufangwuService.selectOne(queryWrapper);
        if("".equals(chushoufangwu.getChushoufangwuPhoto()) || "null".equals(chushoufangwu.getChushoufangwuPhoto())){
                chushoufangwu.setChushoufangwuPhoto(null);
        }
        if(chushoufangwuEntity==null){
            chushoufangwuService.updateById(chushoufangwu);//根据id更新
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
        ArrayList<ChushoufangwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChushoufangwuEntity chushoufangwuEntity = new ChushoufangwuEntity();
            chushoufangwuEntity.setId(id);
            chushoufangwuEntity.setChushoufangwuDelete(2);
            list.add(chushoufangwuEntity);
        }
        if(list != null && list.size() >0){
            chushoufangwuService.updateBatchById(list);
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
            List<ChushoufangwuEntity> chushoufangwuList = new ArrayList<>();//上传的东西
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
                            ChushoufangwuEntity chushoufangwuEntity = new ChushoufangwuEntity();
//                            chushoufangwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chushoufangwuEntity.setChushoufangwuName(data.get(0));                    //出售房屋名称 要改的
//                            chushoufangwuEntity.setChushoufangwuUuidNumber(data.get(0));                    //出售房屋编号 要改的
//                            chushoufangwuEntity.setChushoufangwuPhoto("");//详情和图片
//                            chushoufangwuEntity.setChushoufangwuTypes(Integer.valueOf(data.get(0)));   //房屋类型 要改的
//                            chushoufangwuEntity.setChushoufangwuXinjiuTypes(Integer.valueOf(data.get(0)));   //新房旧房 要改的
//                            chushoufangwuEntity.setQuyuTypes(Integer.valueOf(data.get(0)));   //区域 要改的
//                            chushoufangwuEntity.setChushoufangwuXiaoqu(data.get(0));                    //所在小区 要改的
//                            chushoufangwuEntity.setChushoufangwuWeizhi(data.get(0));                    //所在详细位置 要改的
//                            chushoufangwuEntity.setChushoufangwuMianji(data.get(0));                    //房屋面积 要改的
//                            chushoufangwuEntity.setChushoufangwuOldMoney(data.get(0));                    //原总价 要改的
//                            chushoufangwuEntity.setChushoufangwuNewMoney(data.get(0));                    //现总价 要改的
//                            chushoufangwuEntity.setChushoufangwuClicknum(Integer.valueOf(data.get(0)));   //房屋热度 要改的
//                            chushoufangwuEntity.setChushoufangwuContent("");//详情和图片
//                            chushoufangwuEntity.setChushoufangwuZhuangtaiTypes(Integer.valueOf(data.get(0)));   //房屋状态 要改的
//                            chushoufangwuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            chushoufangwuEntity.setChushoufangwuDelete(1);//逻辑删除字段
//                            chushoufangwuEntity.setCreateTime(date);//时间
                            chushoufangwuList.add(chushoufangwuEntity);


                            //把要查询是否重复的字段放入map中
                                //出售房屋编号
                                if(seachFields.containsKey("chushoufangwuUuidNumber")){
                                    List<String> chushoufangwuUuidNumber = seachFields.get("chushoufangwuUuidNumber");
                                    chushoufangwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chushoufangwuUuidNumber = new ArrayList<>();
                                    chushoufangwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chushoufangwuUuidNumber",chushoufangwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出售房屋编号
                        List<ChushoufangwuEntity> chushoufangwuEntities_chushoufangwuUuidNumber = chushoufangwuService.selectList(new EntityWrapper<ChushoufangwuEntity>().in("chushoufangwu_uuid_number", seachFields.get("chushoufangwuUuidNumber")).eq("chushoufangwu_delete", 1));
                        if(chushoufangwuEntities_chushoufangwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushoufangwuEntity s:chushoufangwuEntities_chushoufangwuUuidNumber){
                                repeatFields.add(s.getChushoufangwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出售房屋编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chushoufangwuService.insertBatch(chushoufangwuList);
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
        PageUtils page = chushoufangwuService.queryPage(params);

        //字典表数据转换
        List<ChushoufangwuView> list =(List<ChushoufangwuView>)page.getList();
        for(ChushoufangwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChushoufangwuEntity chushoufangwu = chushoufangwuService.selectById(id);
            if(chushoufangwu !=null){

                //点击数量加1
                chushoufangwu.setChushoufangwuClicknum(chushoufangwu.getChushoufangwuClicknum()+1);
                chushoufangwuService.updateById(chushoufangwu);

                //entity转view
                ChushoufangwuView view = new ChushoufangwuView();
                BeanUtils.copyProperties( chushoufangwu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chushoufangwu.getYonghuId());
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
    public R add(@RequestBody ChushoufangwuEntity chushoufangwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chushoufangwu:{}",this.getClass().getName(),chushoufangwu.toString());
        Wrapper<ChushoufangwuEntity> queryWrapper = new EntityWrapper<ChushoufangwuEntity>()
            .eq("yonghu_id", chushoufangwu.getYonghuId())
            .eq("chushoufangwu_name", chushoufangwu.getChushoufangwuName())
            .eq("chushoufangwu_uuid_number", chushoufangwu.getChushoufangwuUuidNumber())
            .eq("chushoufangwu_types", chushoufangwu.getChushoufangwuTypes())
            .eq("chushoufangwu_xinjiu_types", chushoufangwu.getChushoufangwuXinjiuTypes())
            .eq("quyu_types", chushoufangwu.getQuyuTypes())
            .eq("chushoufangwu_xiaoqu", chushoufangwu.getChushoufangwuXiaoqu())
            .eq("chushoufangwu_weizhi", chushoufangwu.getChushoufangwuWeizhi())
            .eq("chushoufangwu_clicknum", chushoufangwu.getChushoufangwuClicknum())
            .eq("chushoufangwu_zhuangtai_types", chushoufangwu.getChushoufangwuZhuangtaiTypes())
            .eq("shangxia_types", chushoufangwu.getShangxiaTypes())
            .eq("chushoufangwu_delete", chushoufangwu.getChushoufangwuDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushoufangwuEntity chushoufangwuEntity = chushoufangwuService.selectOne(queryWrapper);
        if(chushoufangwuEntity==null){
            chushoufangwu.setChushoufangwuDelete(1);
            chushoufangwu.setCreateTime(new Date());
        chushoufangwuService.insert(chushoufangwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
