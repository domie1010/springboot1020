package com.entity.model;

import com.entity.ChushoufangwuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约出售房屋看房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChushoufangwuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 看房编号
     */
    private String chushoufangwuOrderUuidNumber;


    /**
     * 出售房屋
     */
    private Integer chushoufangwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 申请看房人姓名
     */
    private String chushoufangwuOrderName;


    /**
     * 申请看房人联系电话
     */
    private String chushoufangwuOrderPhone;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 看房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kanfangTime;


    /**
     * 审核状态
     */
    private Integer chushoufangwuOrderYesnoTypes;


    /**
     * 回复内容
     */
    private String chushoufangwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chushoufangwuOrderShenheTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：看房编号
	 */
    public String getChushoufangwuOrderUuidNumber() {
        return chushoufangwuOrderUuidNumber;
    }


    /**
	 * 设置：看房编号
	 */
    public void setChushoufangwuOrderUuidNumber(String chushoufangwuOrderUuidNumber) {
        this.chushoufangwuOrderUuidNumber = chushoufangwuOrderUuidNumber;
    }
    /**
	 * 获取：出售房屋
	 */
    public Integer getChushoufangwuId() {
        return chushoufangwuId;
    }


    /**
	 * 设置：出售房屋
	 */
    public void setChushoufangwuId(Integer chushoufangwuId) {
        this.chushoufangwuId = chushoufangwuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：申请看房人姓名
	 */
    public String getChushoufangwuOrderName() {
        return chushoufangwuOrderName;
    }


    /**
	 * 设置：申请看房人姓名
	 */
    public void setChushoufangwuOrderName(String chushoufangwuOrderName) {
        this.chushoufangwuOrderName = chushoufangwuOrderName;
    }
    /**
	 * 获取：申请看房人联系电话
	 */
    public String getChushoufangwuOrderPhone() {
        return chushoufangwuOrderPhone;
    }


    /**
	 * 设置：申请看房人联系电话
	 */
    public void setChushoufangwuOrderPhone(String chushoufangwuOrderPhone) {
        this.chushoufangwuOrderPhone = chushoufangwuOrderPhone;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：看房时间
	 */
    public Date getKanfangTime() {
        return kanfangTime;
    }


    /**
	 * 设置：看房时间
	 */
    public void setKanfangTime(Date kanfangTime) {
        this.kanfangTime = kanfangTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getChushoufangwuOrderYesnoTypes() {
        return chushoufangwuOrderYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setChushoufangwuOrderYesnoTypes(Integer chushoufangwuOrderYesnoTypes) {
        this.chushoufangwuOrderYesnoTypes = chushoufangwuOrderYesnoTypes;
    }
    /**
	 * 获取：回复内容
	 */
    public String getChushoufangwuOrderYesnoText() {
        return chushoufangwuOrderYesnoText;
    }


    /**
	 * 设置：回复内容
	 */
    public void setChushoufangwuOrderYesnoText(String chushoufangwuOrderYesnoText) {
        this.chushoufangwuOrderYesnoText = chushoufangwuOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getChushoufangwuOrderShenheTime() {
        return chushoufangwuOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setChushoufangwuOrderShenheTime(Date chushoufangwuOrderShenheTime) {
        this.chushoufangwuOrderShenheTime = chushoufangwuOrderShenheTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
