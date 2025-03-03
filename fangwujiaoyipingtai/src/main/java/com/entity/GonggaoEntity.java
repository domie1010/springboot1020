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
 * 公告
 *
 * @author 
 * @email
 */
@TableName("gonggao")
public class GonggaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GonggaoEntity() {

	}

	public GonggaoEntity(T t) {
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
     * 公告名称
     */
    @TableField(value = "gonggao_name")

    private String gonggaoName;


    /**
     * 公告图片
     */
    @TableField(value = "gonggao_photo")

    private String gonggaoPhoto;


    /**
     * 公告类型
     */
    @TableField(value = "gonggao_types")

    private Integer gonggaoTypes;


    /**
     * 公告发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 公告详情
     */
    @TableField(value = "gonggao_content")

    private String gonggaoContent;


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
	 * 设置：公告名称
	 */
    public String getGonggaoName() {
        return gonggaoName;
    }
    /**
	 * 获取：公告名称
	 */

    public void setGonggaoName(String gonggaoName) {
        this.gonggaoName = gonggaoName;
    }
    /**
	 * 设置：公告图片
	 */
    public String getGonggaoPhoto() {
        return gonggaoPhoto;
    }
    /**
	 * 获取：公告图片
	 */

    public void setGonggaoPhoto(String gonggaoPhoto) {
        this.gonggaoPhoto = gonggaoPhoto;
    }
    /**
	 * 设置：公告类型
	 */
    public Integer getGonggaoTypes() {
        return gonggaoTypes;
    }
    /**
	 * 获取：公告类型
	 */

    public void setGonggaoTypes(Integer gonggaoTypes) {
        this.gonggaoTypes = gonggaoTypes;
    }
    /**
	 * 设置：公告发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：公告发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：公告详情
	 */
    public String getGonggaoContent() {
        return gonggaoContent;
    }
    /**
	 * 获取：公告详情
	 */

    public void setGonggaoContent(String gonggaoContent) {
        this.gonggaoContent = gonggaoContent;
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
        return "Gonggao{" +
            "id=" + id +
            ", gonggaoName=" + gonggaoName +
            ", gonggaoPhoto=" + gonggaoPhoto +
            ", gonggaoTypes=" + gonggaoTypes +
            ", insertTime=" + insertTime +
            ", gonggaoContent=" + gonggaoContent +
            ", createTime=" + createTime +
        "}";
    }
}
