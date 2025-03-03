package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 预约租房看房
 *
 * @author 
 * @email
 */
@TableName("zufang_order")
public class ZufangOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZufangOrderEntity() {

	}

	public ZufangOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 看房编号
     */
    @TableField(value = "zufang_order_uuid_number")

    private String zufangOrderUuidNumber;


    /**
     * 租房
     */
    @TableField(value = "zufang_id")

    private Integer zufangId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请看房人姓名
     */
    @TableField(value = "zufang_order_name")

    private String zufangOrderName;


    /**
     * 申请看房人联系电话
     */
    @TableField(value = "zufang_order_phone")

    private String zufangOrderPhone;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 看房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "kanfang_time")

    private Date kanfangTime;


    /**
     * 审核状态
     */
    @TableField(value = "zufang_order_yesno_types")

    private Integer zufangOrderYesnoTypes;


    /**
     * 回复内容
     */
    @TableField(value = "zufang_order_yesno_text")

    private String zufangOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "zufang_order_shenhe_time")

    private Date zufangOrderShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：看房编号
	 */
    public String getZufangOrderUuidNumber() {
        return zufangOrderUuidNumber;
    }
    /**
	 * 获取：看房编号
	 */

    public void setZufangOrderUuidNumber(String zufangOrderUuidNumber) {
        this.zufangOrderUuidNumber = zufangOrderUuidNumber;
    }
    /**
	 * 设置：租房
	 */
    public Integer getZufangId() {
        return zufangId;
    }
    /**
	 * 获取：租房
	 */

    public void setZufangId(Integer zufangId) {
        this.zufangId = zufangId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请看房人姓名
	 */
    public String getZufangOrderName() {
        return zufangOrderName;
    }
    /**
	 * 获取：申请看房人姓名
	 */

    public void setZufangOrderName(String zufangOrderName) {
        this.zufangOrderName = zufangOrderName;
    }
    /**
	 * 设置：申请看房人联系电话
	 */
    public String getZufangOrderPhone() {
        return zufangOrderPhone;
    }
    /**
	 * 获取：申请看房人联系电话
	 */

    public void setZufangOrderPhone(String zufangOrderPhone) {
        this.zufangOrderPhone = zufangOrderPhone;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：看房时间
	 */
    public Date getKanfangTime() {
        return kanfangTime;
    }
    /**
	 * 获取：看房时间
	 */

    public void setKanfangTime(Date kanfangTime) {
        this.kanfangTime = kanfangTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getZufangOrderYesnoTypes() {
        return zufangOrderYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setZufangOrderYesnoTypes(Integer zufangOrderYesnoTypes) {
        this.zufangOrderYesnoTypes = zufangOrderYesnoTypes;
    }
    /**
	 * 设置：回复内容
	 */
    public String getZufangOrderYesnoText() {
        return zufangOrderYesnoText;
    }
    /**
	 * 获取：回复内容
	 */

    public void setZufangOrderYesnoText(String zufangOrderYesnoText) {
        this.zufangOrderYesnoText = zufangOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getZufangOrderShenheTime() {
        return zufangOrderShenheTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setZufangOrderShenheTime(Date zufangOrderShenheTime) {
        this.zufangOrderShenheTime = zufangOrderShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ZufangOrder{" +
            "id=" + id +
            ", zufangOrderUuidNumber=" + zufangOrderUuidNumber +
            ", zufangId=" + zufangId +
            ", yonghuId=" + yonghuId +
            ", zufangOrderName=" + zufangOrderName +
            ", zufangOrderPhone=" + zufangOrderPhone +
            ", insertTime=" + insertTime +
            ", kanfangTime=" + kanfangTime +
            ", zufangOrderYesnoTypes=" + zufangOrderYesnoTypes +
            ", zufangOrderYesnoText=" + zufangOrderYesnoText +
            ", zufangOrderShenheTime=" + zufangOrderShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
