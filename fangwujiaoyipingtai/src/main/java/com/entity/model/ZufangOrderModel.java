package com.entity.model;

import com.entity.ZufangOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约租房看房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZufangOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 看房编号
     */
    private String zufangOrderUuidNumber;


    /**
     * 租房
     */
    private Integer zufangId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 申请看房人姓名
     */
    private String zufangOrderName;


    /**
     * 申请看房人联系电话
     */
    private String zufangOrderPhone;


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
    private Integer zufangOrderYesnoTypes;


    /**
     * 回复内容
     */
    private String zufangOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zufangOrderShenheTime;


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
    public String getZufangOrderUuidNumber() {
        return zufangOrderUuidNumber;
    }


    /**
	 * 设置：看房编号
	 */
    public void setZufangOrderUuidNumber(String zufangOrderUuidNumber) {
        this.zufangOrderUuidNumber = zufangOrderUuidNumber;
    }
    /**
	 * 获取：租房
	 */
    public Integer getZufangId() {
        return zufangId;
    }


    /**
	 * 设置：租房
	 */
    public void setZufangId(Integer zufangId) {
        this.zufangId = zufangId;
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
    public String getZufangOrderName() {
        return zufangOrderName;
    }


    /**
	 * 设置：申请看房人姓名
	 */
    public void setZufangOrderName(String zufangOrderName) {
        this.zufangOrderName = zufangOrderName;
    }
    /**
	 * 获取：申请看房人联系电话
	 */
    public String getZufangOrderPhone() {
        return zufangOrderPhone;
    }


    /**
	 * 设置：申请看房人联系电话
	 */
    public void setZufangOrderPhone(String zufangOrderPhone) {
        this.zufangOrderPhone = zufangOrderPhone;
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
    public Integer getZufangOrderYesnoTypes() {
        return zufangOrderYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setZufangOrderYesnoTypes(Integer zufangOrderYesnoTypes) {
        this.zufangOrderYesnoTypes = zufangOrderYesnoTypes;
    }
    /**
	 * 获取：回复内容
	 */
    public String getZufangOrderYesnoText() {
        return zufangOrderYesnoText;
    }


    /**
	 * 设置：回复内容
	 */
    public void setZufangOrderYesnoText(String zufangOrderYesnoText) {
        this.zufangOrderYesnoText = zufangOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getZufangOrderShenheTime() {
        return zufangOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setZufangOrderShenheTime(Date zufangOrderShenheTime) {
        this.zufangOrderShenheTime = zufangOrderShenheTime;
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
