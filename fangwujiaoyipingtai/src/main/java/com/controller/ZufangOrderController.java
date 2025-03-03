
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
 * 预约租房看房
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zufangOrder")
public class ZufangOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ZufangOrderController.class);

    @Autowired
    private ZufangOrderService zufangOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZufangService zufangService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zufangOrderService.queryPage(params);

        //字典表数据转换
        List<ZufangOrderView> list =(List<ZufangOrderView>)page.getList();
        for(ZufangOrderView c:list){
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
        ZufangOrderEntity zufangOrder = zufangOrderService.selectById(id);
        if(zufangOrder !=null){
            //entity转view
            ZufangOrderView view = new ZufangOrderView();
            BeanUtils.copyProperties( zufangOrder , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zufangOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                ZufangEntity zufang = zufangService.selectById(zufangOrder.getZufangId());
                if(zufang != null){
                    BeanUtils.copyProperties( zufang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZufangId(zufang.getId());
                    view.setZufangYonghuId(zufang.getYonghuId());
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
    public R save(@RequestBody ZufangOrderEntity zufangOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zufangOrder:{}",this.getClass().getName(),zufangOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            zufangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        zufangOrder.setInsertTime(new Date());
        zufangOrder.setCreateTime(new Date());
        zufangOrderService.insert(zufangOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZufangOrderEntity zufangOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zufangOrder:{}",this.getClass().getName(),zufangOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            zufangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZufangOrderEntity> queryWrapper = new EntityWrapper<ZufangOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZufangOrderEntity zufangOrderEntity = zufangOrderService.selectOne(queryWrapper);
        if(zufangOrderEntity==null){
            zufangOrderService.updateById(zufangOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ZufangOrderEntity zufangOrder, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,zufangOrder:{}",this.getClass().getName(),zufangOrder.toString());

//        if(zufangOrder.getZufangOrderYesnoTypes() == 2){//通过
//            zufangOrder.setZufangOrderTypes();
//        }else if(zufangOrder.getZufangOrderYesnoTypes() == 3){//拒绝
//            zufangOrder.setZufangOrderTypes();
//        }
        zufangOrder.setZufangOrderShenheTime(new Date());//审核时间
        zufangOrderService.updateById(zufangOrder);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zufangOrderService.deleteBatchIds(Arrays.asList(ids));
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
            List<ZufangOrderEntity> zufangOrderList = new ArrayList<>();//上传的东西
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
                            ZufangOrderEntity zufangOrderEntity = new ZufangOrderEntity();
//                            zufangOrderEntity.setZufangOrderUuidNumber(data.get(0));                    //看房编号 要改的
//                            zufangOrderEntity.setZufangId(Integer.valueOf(data.get(0)));   //租房 要改的
//                            zufangOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            zufangOrderEntity.setZufangOrderName(data.get(0));                    //申请看房人姓名 要改的
//                            zufangOrderEntity.setZufangOrderPhone(data.get(0));                    //申请看房人联系电话 要改的
//                            zufangOrderEntity.setInsertTime(date);//时间
//                            zufangOrderEntity.setKanfangTime(sdf.parse(data.get(0)));          //看房时间 要改的
//                            zufangOrderEntity.setZufangOrderYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            zufangOrderEntity.setZufangOrderYesnoText(data.get(0));                    //回复内容 要改的
//                            zufangOrderEntity.setZufangOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            zufangOrderEntity.setCreateTime(date);//时间
                            zufangOrderList.add(zufangOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //看房编号
                                if(seachFields.containsKey("zufangOrderUuidNumber")){
                                    List<String> zufangOrderUuidNumber = seachFields.get("zufangOrderUuidNumber");
                                    zufangOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zufangOrderUuidNumber = new ArrayList<>();
                                    zufangOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zufangOrderUuidNumber",zufangOrderUuidNumber);
                                }
                                //申请看房人联系电话
                                if(seachFields.containsKey("zufangOrderPhone")){
                                    List<String> zufangOrderPhone = seachFields.get("zufangOrderPhone");
                                    zufangOrderPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zufangOrderPhone = new ArrayList<>();
                                    zufangOrderPhone.add(data.get(0));//要改的
                                    seachFields.put("zufangOrderPhone",zufangOrderPhone);
                                }
                        }

                        //查询是否重复
                         //看房编号
                        List<ZufangOrderEntity> zufangOrderEntities_zufangOrderUuidNumber = zufangOrderService.selectList(new EntityWrapper<ZufangOrderEntity>().in("zufang_order_uuid_number", seachFields.get("zufangOrderUuidNumber")));
                        if(zufangOrderEntities_zufangOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZufangOrderEntity s:zufangOrderEntities_zufangOrderUuidNumber){
                                repeatFields.add(s.getZufangOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [看房编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //申请看房人联系电话
                        List<ZufangOrderEntity> zufangOrderEntities_zufangOrderPhone = zufangOrderService.selectList(new EntityWrapper<ZufangOrderEntity>().in("zufang_order_phone", seachFields.get("zufangOrderPhone")));
                        if(zufangOrderEntities_zufangOrderPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZufangOrderEntity s:zufangOrderEntities_zufangOrderPhone){
                                repeatFields.add(s.getZufangOrderPhone());
                            }
                            return R.error(511,"数据库的该表中的 [申请看房人联系电话] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zufangOrderService.insertBatch(zufangOrderList);
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

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = zufangOrderService.queryPage(params);

        //字典表数据转换
        List<ZufangOrderView> list =(List<ZufangOrderView>)page.getList();
        for(ZufangOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZufangOrderEntity zufangOrder = zufangOrderService.selectById(id);
            if(zufangOrder !=null){


                //entity转view
                ZufangOrderView view = new ZufangOrderView();
                BeanUtils.copyProperties( zufangOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(zufangOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ZufangEntity zufang = zufangService.selectById(zufangOrder.getZufangId());
                if(zufang != null){
                    BeanUtils.copyProperties( zufang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZufangId(zufang.getId());
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
    public R add(@RequestBody ZufangOrderEntity zufangOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zufangOrder:{}",this.getClass().getName(),zufangOrder.toString());
            ZufangEntity zufangEntity = zufangService.selectById(zufangOrder.getZufangId());
            if(zufangEntity == null){
                return R.error(511,"查不到该租房");
            }
            // Double zufangNewMoney = zufangEntity.getZufangNewMoney();

        ZufangEntity zufangEntity1 = zufangService.selectById(zufangOrder.getZufangId());
        if(zufangEntity1 == null)
            return R.error("查不到出售房屋");
        else if (zufangEntity1.getZufangZhuangtaiTypes() == 2)
            return R.error("房屋已经被出租了,没有必要再预约了");
        else if(zufangEntity1.getYonghuId().intValue() == zufangOrder.getYonghuId().intValue())
            return R.error("您无法预约看房自己的房子");


        ZufangOrderEntity zufangOrderEntity = zufangOrderService.selectOne(new EntityWrapper<ZufangOrderEntity>()
                .eq("zufang_id", zufangOrder.getZufangId())
                .eq("zufang_order_yesno_types", 1)
                .eq("yonghu_id", zufangOrder.getYonghuId())
        );
        if(zufangOrderEntity != null)
            return R.error("该租房已有申请看房记录,请等待审核");


        if(false){
            }
            else if(zufangEntity.getZufangNewMoney() == null){
                return R.error(511,"租房价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            zufangOrder.setYonghuId(userId); //设置订单支付人id
            zufangOrder.setZufangOrderUuidNumber(String.valueOf(new Date().getTime()));
            zufangOrder.setInsertTime(new Date());
            zufangOrder.setCreateTime(new Date());
                zufangOrderService.insert(zufangOrder);//新增订单
            return R.ok();
    }



}
