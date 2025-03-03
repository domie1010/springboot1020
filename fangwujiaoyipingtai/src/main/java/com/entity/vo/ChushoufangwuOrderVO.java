package com.entity.vo;

import com.entity.ChushoufangwuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预约出售房屋看房
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chushoufangwu_order")
public class ChushoufangwuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 看房编号
     */

    @TableField(value = "chushoufangwu_order_uuid_number")
    private String chushoufangwuOrderUuidNumber;


    /**
     * 出售房屋
     */

    @TableField(value = "chushoufangwu_id")
    private Integer chushoufangwuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 申请看房人姓名
     */

    @TableField(value = "chushoufangwu_order_name")
    private String chushoufangwuOrderName;


    /**
     * 申请看房人联系电话
     */

    @TableField(value = "chushoufangwu_order_phone")
    private String chushoufangwuOrderPhone;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
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

    @TableField(value = "chushoufangwu_order_yesno_types")
    private Integer chushoufangwuOrderYesnoTypes;


    /**
     * 回复内容
     */

    @TableField(value = "chushoufangwu_order_yesno_text")
    private String chushoufangwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chushoufangwu_order_shenhe_time")
    private Date chushoufangwuOrderShenheTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
    public String getChushoufangwuOrderUuidNumber() {
        return chushoufangwuOrderUuidNumber;
    }


    /**
	 * 获取：看房编号
	 */

    public void setChushoufangwuOrderUuidNumber(String chushoufangwuOrderUuidNumber) {
        this.chushoufangwuOrderUuidNumber = chushoufangwuOrderUuidNumber;
    }
    /**
	 * 设置：出售房屋
	 */
    public Integer getChushoufangwuId() {
        return chushoufangwuId;
    }


    /**
	 * 获取：出售房屋
	 */

    public void setChushoufangwuId(Integer chushoufangwuId) {
        this.chushoufangwuId = chushoufangwuId;
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
    public String getChushoufangwuOrderName() {
        return chushoufangwuOrderName;
    }


    /**
	 * 获取：申请看房人姓名
	 */

    public void setChushoufangwuOrderName(String chushoufangwuOrderName) {
        this.chushoufangwuOrderName = chushoufangwuOrderName;
    }
    /**
	 * 设置：申请看房人联系电话
	 */
    public String getChushoufangwuOrderPhone() {
        return chushoufangwuOrderPhone;
    }


    /**
	 * 获取：申请看房人联系电话
	 */

    public void setChushoufangwuOrderPhone(String chushoufangwuOrderPhone) {
        this.chushoufangwuOrderPhone = chushoufangwuOrderPhone;
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
    public Integer getChushoufangwuOrderYesnoTypes() {
        return chushoufangwuOrderYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setChushoufangwuOrderYesnoTypes(Integer chushoufangwuOrderYesnoTypes) {
        this.chushoufangwuOrderYesnoTypes = chushoufangwuOrderYesnoTypes;
    }
    /**
	 * 设置：回复内容
	 */
    public String getChushoufangwuOrderYesnoText() {
        return chushoufangwuOrderYesnoText;
    }


    /**
	 * 获取：回复内容
	 */

    public void setChushoufangwuOrderYesnoText(String chushoufangwuOrderYesnoText) {
        this.chushoufangwuOrderYesnoText = chushoufangwuOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getChushoufangwuOrderShenheTime() {
        return chushoufangwuOrderShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setChushoufangwuOrderShenheTime(Date chushoufangwuOrderShenheTime) {
        this.chushoufangwuOrderShenheTime = chushoufangwuOrderShenheTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
