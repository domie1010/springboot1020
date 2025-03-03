package com.entity.vo;

import com.entity.ChushoufangwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出售房屋
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chushoufangwu")
public class ChushoufangwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 出售房屋名称
     */

    @TableField(value = "chushoufangwu_name")
    private String chushoufangwuName;


    /**
     * 出售房屋编号
     */

    @TableField(value = "chushoufangwu_uuid_number")
    private String chushoufangwuUuidNumber;


    /**
     * 出售房屋照片
     */

    @TableField(value = "chushoufangwu_photo")
    private String chushoufangwuPhoto;


    /**
     * 房屋类型
     */

    @TableField(value = "chushoufangwu_types")
    private Integer chushoufangwuTypes;


    /**
     * 新房旧房
     */

    @TableField(value = "chushoufangwu_xinjiu_types")
    private Integer chushoufangwuXinjiuTypes;


    /**
     * 区域
     */

    @TableField(value = "quyu_types")
    private Integer quyuTypes;


    /**
     * 所在小区
     */

    @TableField(value = "chushoufangwu_xiaoqu")
    private String chushoufangwuXiaoqu;


    /**
     * 所在详细位置
     */

    @TableField(value = "chushoufangwu_weizhi")
    private String chushoufangwuWeizhi;


    /**
     * 房屋面积
     */

    @TableField(value = "chushoufangwu_mianji")
    private Double chushoufangwuMianji;


    /**
     * 原总价
     */

    @TableField(value = "chushoufangwu_old_money")
    private Double chushoufangwuOldMoney;


    /**
     * 现总价
     */

    @TableField(value = "chushoufangwu_new_money")
    private Double chushoufangwuNewMoney;


    /**
     * 房屋热度
     */

    @TableField(value = "chushoufangwu_clicknum")
    private Integer chushoufangwuClicknum;


    /**
     * 出售房屋介绍
     */

    @TableField(value = "chushoufangwu_content")
    private String chushoufangwuContent;


    /**
     * 房屋状态
     */

    @TableField(value = "chushoufangwu_zhuangtai_types")
    private Integer chushoufangwuZhuangtaiTypes;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "chushoufangwu_delete")
    private Integer chushoufangwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：出售房屋名称
	 */
    public String getChushoufangwuName() {
        return chushoufangwuName;
    }


    /**
	 * 获取：出售房屋名称
	 */

    public void setChushoufangwuName(String chushoufangwuName) {
        this.chushoufangwuName = chushoufangwuName;
    }
    /**
	 * 设置：出售房屋编号
	 */
    public String getChushoufangwuUuidNumber() {
        return chushoufangwuUuidNumber;
    }


    /**
	 * 获取：出售房屋编号
	 */

    public void setChushoufangwuUuidNumber(String chushoufangwuUuidNumber) {
        this.chushoufangwuUuidNumber = chushoufangwuUuidNumber;
    }
    /**
	 * 设置：出售房屋照片
	 */
    public String getChushoufangwuPhoto() {
        return chushoufangwuPhoto;
    }


    /**
	 * 获取：出售房屋照片
	 */

    public void setChushoufangwuPhoto(String chushoufangwuPhoto) {
        this.chushoufangwuPhoto = chushoufangwuPhoto;
    }
    /**
	 * 设置：房屋类型
	 */
    public Integer getChushoufangwuTypes() {
        return chushoufangwuTypes;
    }


    /**
	 * 获取：房屋类型
	 */

    public void setChushoufangwuTypes(Integer chushoufangwuTypes) {
        this.chushoufangwuTypes = chushoufangwuTypes;
    }
    /**
	 * 设置：新房旧房
	 */
    public Integer getChushoufangwuXinjiuTypes() {
        return chushoufangwuXinjiuTypes;
    }


    /**
	 * 获取：新房旧房
	 */

    public void setChushoufangwuXinjiuTypes(Integer chushoufangwuXinjiuTypes) {
        this.chushoufangwuXinjiuTypes = chushoufangwuXinjiuTypes;
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
    public String getChushoufangwuXiaoqu() {
        return chushoufangwuXiaoqu;
    }


    /**
	 * 获取：所在小区
	 */

    public void setChushoufangwuXiaoqu(String chushoufangwuXiaoqu) {
        this.chushoufangwuXiaoqu = chushoufangwuXiaoqu;
    }
    /**
	 * 设置：所在详细位置
	 */
    public String getChushoufangwuWeizhi() {
        return chushoufangwuWeizhi;
    }


    /**
	 * 获取：所在详细位置
	 */

    public void setChushoufangwuWeizhi(String chushoufangwuWeizhi) {
        this.chushoufangwuWeizhi = chushoufangwuWeizhi;
    }
    /**
	 * 设置：房屋面积
	 */
    public Double getChushoufangwuMianji() {
        return chushoufangwuMianji;
    }


    /**
	 * 获取：房屋面积
	 */

    public void setChushoufangwuMianji(Double chushoufangwuMianji) {
        this.chushoufangwuMianji = chushoufangwuMianji;
    }
    /**
	 * 设置：原总价
	 */
    public Double getChushoufangwuOldMoney() {
        return chushoufangwuOldMoney;
    }


    /**
	 * 获取：原总价
	 */

    public void setChushoufangwuOldMoney(Double chushoufangwuOldMoney) {
        this.chushoufangwuOldMoney = chushoufangwuOldMoney;
    }
    /**
	 * 设置：现总价
	 */
    public Double getChushoufangwuNewMoney() {
        return chushoufangwuNewMoney;
    }


    /**
	 * 获取：现总价
	 */

    public void setChushoufangwuNewMoney(Double chushoufangwuNewMoney) {
        this.chushoufangwuNewMoney = chushoufangwuNewMoney;
    }
    /**
	 * 设置：房屋热度
	 */
    public Integer getChushoufangwuClicknum() {
        return chushoufangwuClicknum;
    }


    /**
	 * 获取：房屋热度
	 */

    public void setChushoufangwuClicknum(Integer chushoufangwuClicknum) {
        this.chushoufangwuClicknum = chushoufangwuClicknum;
    }
    /**
	 * 设置：出售房屋介绍
	 */
    public String getChushoufangwuContent() {
        return chushoufangwuContent;
    }


    /**
	 * 获取：出售房屋介绍
	 */

    public void setChushoufangwuContent(String chushoufangwuContent) {
        this.chushoufangwuContent = chushoufangwuContent;
    }
    /**
	 * 设置：房屋状态
	 */
    public Integer getChushoufangwuZhuangtaiTypes() {
        return chushoufangwuZhuangtaiTypes;
    }


    /**
	 * 获取：房屋状态
	 */

    public void setChushoufangwuZhuangtaiTypes(Integer chushoufangwuZhuangtaiTypes) {
        this.chushoufangwuZhuangtaiTypes = chushoufangwuZhuangtaiTypes;
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
    public Integer getChushoufangwuDelete() {
        return chushoufangwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChushoufangwuDelete(Integer chushoufangwuDelete) {
        this.chushoufangwuDelete = chushoufangwuDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
