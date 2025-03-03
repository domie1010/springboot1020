
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
 * 预约出售房屋看房
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chushoufangwuOrder")
public class ChushoufangwuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ChushoufangwuOrderController.class);

    @Autowired
    private ChushoufangwuOrderService chushoufangwuOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ChushoufangwuService chushoufangwuService;
    @Autowired
    private YonghuService yonghuService;



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
        PageUtils page = chushoufangwuOrderService.queryPage(params);

        //字典表数据转换
        List<ChushoufangwuOrderView> list =(List<ChushoufangwuOrderView>)page.getList();
        for(ChushoufangwuOrderView c:list){
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
        ChushoufangwuOrderEntity chushoufangwuOrder = chushoufangwuOrderService.selectById(id);
        if(chushoufangwuOrder !=null){
            //entity转view
            ChushoufangwuOrderView view = new ChushoufangwuOrderView();
            BeanUtils.copyProperties( chushoufangwuOrder , view );//把实体数据重构到view中

                //级联表
                ChushoufangwuEntity chushoufangwu = chushoufangwuService.selectById(chushoufangwuOrder.getChushoufangwuId());
                if(chushoufangwu != null){
                    BeanUtils.copyProperties( chushoufangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChushoufangwuId(chushoufangwu.getId());
                    view.setChushoufangwuYonghuId(chushoufangwu.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(chushoufangwuOrder.getYonghuId());
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
    public R save(@RequestBody ChushoufangwuOrderEntity chushoufangwuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chushoufangwuOrder:{}",this.getClass().getName(),chushoufangwuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chushoufangwuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chushoufangwuOrder.setInsertTime(new Date());
        chushoufangwuOrder.setCreateTime(new Date());
        chushoufangwuOrderService.insert(chushoufangwuOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChushoufangwuOrderEntity chushoufangwuOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chushoufangwuOrder:{}",this.getClass().getName(),chushoufangwuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chushoufangwuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChushoufangwuOrderEntity> queryWrapper = new EntityWrapper<ChushoufangwuOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushoufangwuOrderEntity chushoufangwuOrderEntity = chushoufangwuOrderService.selectOne(queryWrapper);
        if(chushoufangwuOrderEntity==null){
            chushoufangwuOrderService.updateById(chushoufangwuOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ChushoufangwuOrderEntity chushoufangwuOrder, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,chushoufangwuOrder:{}",this.getClass().getName(),chushoufangwuOrder.toString());

//        if(chushoufangwuOrder.getChushoufangwuOrderYesnoTypes() == 2){//通过
//            chushoufangwuOrder.setChushoufangwuOrderTypes();
//        }else if(chushoufangwuOrder.getChushoufangwuOrderYesnoTypes() == 3){//拒绝
//            chushoufangwuOrder.setChushoufangwuOrderTypes();
//        }
        chushoufangwuOrder.setChushoufangwuOrderShenheTime(new Date());//审核时间
        chushoufangwuOrderService.updateById(chushoufangwuOrder);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chushoufangwuOrderService.deleteBatchIds(Arrays.asList(ids));
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
            List<ChushoufangwuOrderEntity> chushoufangwuOrderList = new ArrayList<>();//上传的东西
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
                            ChushoufangwuOrderEntity chushoufangwuOrderEntity = new ChushoufangwuOrderEntity();
//                            chushoufangwuOrderEntity.setChushoufangwuOrderUuidNumber(data.get(0));                    //看房编号 要改的
//                            chushoufangwuOrderEntity.setChushoufangwuId(Integer.valueOf(data.get(0)));   //出售房屋 要改的
//                            chushoufangwuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chushoufangwuOrderEntity.setChushoufangwuOrderName(data.get(0));                    //申请看房人姓名 要改的
//                            chushoufangwuOrderEntity.setChushoufangwuOrderPhone(data.get(0));                    //申请看房人联系电话 要改的
//                            chushoufangwuOrderEntity.setInsertTime(date);//时间
//                            chushoufangwuOrderEntity.setKanfangTime(sdf.parse(data.get(0)));          //看房时间 要改的
//                            chushoufangwuOrderEntity.setChushoufangwuOrderYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            chushoufangwuOrderEntity.setChushoufangwuOrderYesnoText(data.get(0));                    //回复内容 要改的
//                            chushoufangwuOrderEntity.setChushoufangwuOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            chushoufangwuOrderEntity.setCreateTime(date);//时间
                            chushoufangwuOrderList.add(chushoufangwuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //看房编号
                                if(seachFields.containsKey("chushoufangwuOrderUuidNumber")){
                                    List<String> chushoufangwuOrderUuidNumber = seachFields.get("chushoufangwuOrderUuidNumber");
                                    chushoufangwuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chushoufangwuOrderUuidNumber = new ArrayList<>();
                                    chushoufangwuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chushoufangwuOrderUuidNumber",chushoufangwuOrderUuidNumber);
                                }
                                //申请看房人联系电话
                                if(seachFields.containsKey("chushoufangwuOrderPhone")){
                                    List<String> chushoufangwuOrderPhone = seachFields.get("chushoufangwuOrderPhone");
                                    chushoufangwuOrderPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> chushoufangwuOrderPhone = new ArrayList<>();
                                    chushoufangwuOrderPhone.add(data.get(0));//要改的
                                    seachFields.put("chushoufangwuOrderPhone",chushoufangwuOrderPhone);
                                }
                        }

                        //查询是否重复
                         //看房编号
                        List<ChushoufangwuOrderEntity> chushoufangwuOrderEntities_chushoufangwuOrderUuidNumber = chushoufangwuOrderService.selectList(new EntityWrapper<ChushoufangwuOrderEntity>().in("chushoufangwu_order_uuid_number", seachFields.get("chushoufangwuOrderUuidNumber")));
                        if(chushoufangwuOrderEntities_chushoufangwuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushoufangwuOrderEntity s:chushoufangwuOrderEntities_chushoufangwuOrderUuidNumber){
                                repeatFields.add(s.getChushoufangwuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [看房编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //申请看房人联系电话
                        List<ChushoufangwuOrderEntity> chushoufangwuOrderEntities_chushoufangwuOrderPhone = chushoufangwuOrderService.selectList(new EntityWrapper<ChushoufangwuOrderEntity>().in("chushoufangwu_order_phone", seachFields.get("chushoufangwuOrderPhone")));
                        if(chushoufangwuOrderEntities_chushoufangwuOrderPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChushoufangwuOrderEntity s:chushoufangwuOrderEntities_chushoufangwuOrderPhone){
                                repeatFields.add(s.getChushoufangwuOrderPhone());
                            }
                            return R.error(511,"数据库的该表中的 [申请看房人联系电话] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chushoufangwuOrderService.insertBatch(chushoufangwuOrderList);
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
        PageUtils page = chushoufangwuOrderService.queryPage(params);

        //字典表数据转换
        List<ChushoufangwuOrderView> list =(List<ChushoufangwuOrderView>)page.getList();
        for(ChushoufangwuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChushoufangwuOrderEntity chushoufangwuOrder = chushoufangwuOrderService.selectById(id);
            if(chushoufangwuOrder !=null){


                //entity转view
                ChushoufangwuOrderView view = new ChushoufangwuOrderView();
                BeanUtils.copyProperties( chushoufangwuOrder , view );//把实体数据重构到view中

                //级联表
                    ChushoufangwuEntity chushoufangwu = chushoufangwuService.selectById(chushoufangwuOrder.getChushoufangwuId());
                if(chushoufangwu != null){
                    BeanUtils.copyProperties( chushoufangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChushoufangwuId(chushoufangwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chushoufangwuOrder.getYonghuId());
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
    public R add(@RequestBody ChushoufangwuOrderEntity chushoufangwuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chushoufangwuOrder:{}",this.getClass().getName(),chushoufangwuOrder.toString());
            ChushoufangwuEntity chushoufangwuEntity = chushoufangwuService.selectById(chushoufangwuOrder.getChushoufangwuId());
            if(chushoufangwuEntity == null){
                return R.error(511,"查不到该出售房屋");
            }
            // Double chushoufangwuNewMoney = chushoufangwuEntity.getChushoufangwuNewMoney();


        ChushoufangwuEntity chushoufangwuEntity1 = chushoufangwuService.selectById(chushoufangwuOrder.getChushoufangwuId());
        if(chushoufangwuEntity1 == null)
            return R.error("查不到出售房屋");
        else if (chushoufangwuEntity1.getChushoufangwuZhuangtaiTypes() == 2)
            return R.error("房屋已经出售了,没有必要再预约了");
        else if(chushoufangwuEntity1.getYonghuId().intValue() == chushoufangwuOrder.getYonghuId().intValue())
            return R.error("您无法预约自己的房子");

        ChushoufangwuOrderEntity chushoufangwuOrderEntity = chushoufangwuOrderService.selectOne(new EntityWrapper<ChushoufangwuOrderEntity>()
                .eq("chushoufangwu_id", chushoufangwuOrder.getChushoufangwuId())
                .eq("chushoufangwu_order_yesno_types", 1)
                .eq("yonghu_id", chushoufangwuOrder.getYonghuId())
        );
        if(chushoufangwuOrderEntity != null)
            return R.error("该出售房屋已有申请看房记录,请等待审核");

            if(false){
            }
            else if(chushoufangwuEntity.getChushoufangwuNewMoney() == null){
                return R.error(511,"出售房屋价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            chushoufangwuOrder.setYonghuId(userId); //设置订单支付人id
            chushoufangwuOrder.setChushoufangwuOrderUuidNumber(String.valueOf(new Date().getTime()));
            chushoufangwuOrder.setInsertTime(new Date());
            chushoufangwuOrder.setCreateTime(new Date());
                chushoufangwuOrderService.insert(chushoufangwuOrder);//新增订单
            return R.ok();
    }



}
