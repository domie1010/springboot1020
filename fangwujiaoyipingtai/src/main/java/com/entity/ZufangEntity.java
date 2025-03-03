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
 * 租房
 *
 * @author 
 * @email
 */
@TableName("zufang")
public class ZufangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZufangEntity() {

	}

	public ZufangEntity(T t) {
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
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 房屋名称
     */
    @TableField(value = "zufang_name")

    private String zufangName;


    /**
     * 房屋编号
     */
    @TableField(value = "zufang_uuid_number")

    private String zufangUuidNumber;


    /**
     * 租房照片
     */
    @TableField(value = "zufang_photo")

    private String zufangPhoto;


    /**
     * 出租房屋类型
     */
    @TableField(value = "zufang_types")

    private Integer zufangTypes;


    /**
     * 区域
     */
    @TableField(value = "quyu_types")

    private Integer quyuTypes;


    /**
     * 所在小区
     */
    @TableField(value = "zufang_xiaoqu")

    private String zufangXiaoqu;


    /**
     * 所在详细位置
     */
    @TableField(value = "zufang_weizhi")

    private String zufangWeizhi;


    /**
     * 房屋面积
     */
    @TableField(value = "zufang_mianji")

    private Double zufangMianji;


    /**
     * 原价/月
     */
    @TableField(value = "zufang_old_money")

    private Double zufangOldMoney;


    /**
     * 现加/月
     */
    @TableField(value = "zufang_new_money")

    private Double zufangNewMoney;


    /**
     * 房屋热度
     */
    @TableField(value = "zufang_clicknum")

    private Integer zufangClicknum;


    /**
     * 房屋介绍
     */
    @TableField(value = "zufang_content")

    private String zufangContent;


    /**
     * 房屋状态
     */
    @TableField(value = "zufang_zhuangtai_types")

    private Integer zufangZhuangtaiTypes;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "zufang_delete")

    private Integer zufangDelete;


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
	 * 设置：房屋名称
	 */
    public String getZufangName() {
        return zufangName;
    }
    /**
	 * 获取：房屋名称
	 */

    public void setZufangName(String zufangName) {
        this.zufangName = zufangName;
    }
    /**
	 * 设置：房屋编号
	 */
    public String getZufangUuidNumber() {
        return zufangUuidNumber;
    }
    /**
	 * 获取：房屋编号
	 */

    public void setZufangUuidNumber(String zufangUuidNumber) {
        this.zufangUuidNumber = zufangUuidNumber;
    }
    /**
	 * 设置：租房照片
	 */
    public String getZufangPhoto() {
        return zufangPhoto;
    }
    /**
	 * 获取：租房照片
	 */

    public void setZufangPhoto(String zufangPhoto) {
        this.zufangPhoto = zufangPhoto;
    }
    /**
	 * 设置：出租房屋类型
	 */
    public Integer getZufangTypes() {
        return zufangTypes;
    }
    /**
	 * 获取：出租房屋类型
	 */

    public void setZufangTypes(Integer zufangTypes) {
        this.zufangTypes = zufangTypes;
    }
    /**
	 * 设置：区域
	 */
    public Integer getQuyuTypes() {
        return quyuTypes;
    }
    /**
	 * 获取：区域
	 */

    public void setQuyuTypes(Integer quyuTypes) {
        this.quyuTypes = quyuTypes;
    }
    /**
	 * 设置：所在小区
	 */
    public String getZufangXiaoqu() {
        return zufangXiaoqu;
    }
    /**
	 * 获取：所在小区
	 */

    public void setZufangXiaoqu(String zufangXiaoqu) {
        this.zufangXiaoqu = zufangXiaoqu;
    }
    /**
	 * 设置：所在详细位置
	 */
    public String getZufangWeizhi() {
        return zufangWeizhi;
    }
    /**
	 * 获取：所在详细位置
	 */

    public void setZufangWeizhi(String zufangWeizhi) {
        this.zufangWeizhi = zufangWeizhi;
    }
    /**
	 * 设置：房屋面积
	 */
    public Double getZufangMianji() {
        return zufangMianji;
    }
    /**
	 * 获取：房屋面积
	 */

    public void setZufangMianji(Double zufangMianji) {
        this.zufangMianji = zufangMianji;
    }
    /**
	 * 设置：原价/月
	 */
    public Double getZufangOldMoney() {
        return zufangOldMoney;
    }
    /**
	 * 获取：原价/月
	 */

    public void setZufangOldMoney(Double zufangOldMoney) {
        this.zufangOldMoney = zufangOldMoney;
    }
    /**
	 * 设置：现加/月
	 */
    public Double getZufangNewMoney() {
        return zufangNewMoney;
    }
    /**
	 * 获取：现加/月
	 */

    public void setZufangNewMoney(Double zufangNewMoney) {
        this.zufangNewMoney = zufangNewMoney;
    }
    /**
	 * 设置：房屋热度
	 */
    public Integer getZufangClicknum() {
        return zufangClicknum;
    }
    /**
	 * 获取：房屋热度
	 */

    public void setZufangClicknum(Integer zufangClicknum) {
        this.zufangClicknum = zufangClicknum;
    }
    /**
	 * 设置：房屋介绍
	 */
    public String getZufangContent() {
        return zufangContent;
    }
    /**
	 * 获取：房屋介绍
	 */

    public void setZufangContent(String zufangContent) {
        this.zufangContent = zufangContent;
    }
    /**
	 * 设置：房屋状态
	 */
    public Integer getZufangZhuangtaiTypes() {
        return zufangZhuangtaiTypes;
    }
    /**
	 * 获取：房屋状态
	 */

    public void setZufangZhuangtaiTypes(Integer zufangZhuangtaiTypes) {
        this.zufangZhuangtaiTypes = zufangZhuangtaiTypes;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZufangDelete() {
        return zufangDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setZufangDelete(Integer zufangDelete) {
        this.zufangDelete = zufangDelete;
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
        return "Zufang{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", zufangName=" + zufangName +
            ", zufangUuidNumber=" + zufangUuidNumber +
            ", zufangPhoto=" + zufangPhoto +
            ", zufangTypes=" + zufangTypes +
            ", quyuTypes=" + quyuTypes +
            ", zufangXiaoqu=" + zufangXiaoqu +
            ", zufangWeizhi=" + zufangWeizhi +
            ", zufangMianji=" + zufangMianji +
            ", zufangOldMoney=" + zufangOldMoney +
            ", zufangNewMoney=" + zufangNewMoney +
            ", zufangClicknum=" + zufangClicknum +
            ", zufangContent=" + zufangContent +
            ", zufangZhuangtaiTypes=" + zufangZhuangtaiTypes +
            ", shangxiaTypes=" + shangxiaTypes +
            ", zufangDelete=" + zufangDelete +
            ", createTime=" + createTime +
        "}";
    }
}
