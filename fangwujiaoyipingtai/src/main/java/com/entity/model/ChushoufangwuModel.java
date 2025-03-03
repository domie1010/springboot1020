package com.entity.model;

import com.entity.ChushoufangwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出售房屋
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChushoufangwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 出售房屋名称
     */
    private String chushoufangwuName;


    /**
     * 出售房屋编号
     */
    private String chushoufangwuUuidNumber;


    /**
     * 出售房屋照片
     */
    private String chushoufangwuPhoto;


    /**
     * 房屋类型
     */
    private Integer chushoufangwuTypes;


    /**
     * 新房旧房
     */
    private Integer chushoufangwuXinjiuTypes;


    /**
     * 区域
     */
    private Integer quyuTypes;


    /**
     * 所在小区
     */
    private String chushoufangwuXiaoqu;


    /**
     * 所在详细位置
     */
    private String chushoufangwuWeizhi;


    /**
     * 房屋面积
     */
    private Double chushoufangwuMianji;


    /**
     * 原总价
     */
    private Double chushoufangwuOldMoney;


    /**
     * 现总价
     */
    private Double chushoufangwuNewMoney;


    /**
     * 房屋热度
     */
    private Integer chushoufangwuClicknum;


    /**
     * 出售房屋介绍
     */
    private String chushoufangwuContent;


    /**
     * 房屋状态
     */
    private Integer chushoufangwuZhuangtaiTypes;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer chushoufangwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：出售房屋名称
	 */
    public String getChushoufangwuName() {
        return chushoufangwuName;
    }


    /**
	 * 设置：出售房屋名称
	 */
    public void setChushoufangwuName(String chushoufangwuName) {
        this.chushoufangwuName = chushoufangwuName;
    }
    /**
	 * 获取：出售房屋编号
	 */
    public String getChushoufangwuUuidNumber() {
        return chushoufangwuUuidNumber;
    }


    /**
	 * 设置：出售房屋编号
	 */
    public void setChushoufangwuUuidNumber(String chushoufangwuUuidNumber) {
        this.chushoufangwuUuidNumber = chushoufangwuUuidNumber;
    }
    /**
	 * 获取：出售房屋照片
	 */
    public String getChushoufangwuPhoto() {
        return chushoufangwuPhoto;
    }


    /**
	 * 设置：出售房屋照片
	 */
    public void setChushoufangwuPhoto(String chushoufangwuPhoto) {
        this.chushoufangwuPhoto = chushoufangwuPhoto;
    }
    /**
	 * 获取：房屋类型
	 */
    public Integer getChushoufangwuTypes() {
        return chushoufangwuTypes;
    }


    /**
	 * 设置：房屋类型
	 */
    public void setChushoufangwuTypes(Integer chushoufangwuTypes) {
        this.chushoufangwuTypes = chushoufangwuTypes;
    }
    /**
	 * 获取：新房旧房
	 */
    public Integer getChushoufangwuXinjiuTypes() {
        return chushoufangwuXinjiuTypes;
    }


    /**
	 * 设置：新房旧房
	 */
    public void setChushoufangwuXinjiuTypes(Integer chushoufangwuXinjiuTypes) {
        this.chushoufangwuXinjiuTypes = chushoufangwuXinjiuTypes;
    }
    /**
	 * 获取：区域
	 */
    public Integer getQuyuTypes() {
        return quyuTypes;
    }


    /**
	 * 设置：区域
	 */
    public void setQuyuTypes(Integer quyuTypes) {
        this.quyuTypes = quyuTypes;
    }
    /**
	 * 获取：所在小区
	 */
    public String getChushoufangwuXiaoqu() {
        return chushoufangwuXiaoqu;
    }


    /**
	 * 设置：所在小区
	 */
    public void setChushoufangwuXiaoqu(String chushoufangwuXiaoqu) {
        this.chushoufangwuXiaoqu = chushoufangwuXiaoqu;
    }
    /**
	 * 获取：所在详细位置
	 */
    public String getChushoufangwuWeizhi() {
        return chushoufangwuWeizhi;
    }


    /**
	 * 设置：所在详细位置
	 */
    public void setChushoufangwuWeizhi(String chushoufangwuWeizhi) {
        this.chushoufangwuWeizhi = chushoufangwuWeizhi;
    }
    /**
	 * 获取：房屋面积
	 */
    public Double getChushoufangwuMianji() {
        return chushoufangwuMianji;
    }


    /**
	 * 设置：房屋面积
	 */
    public void setChushoufangwuMianji(Double chushoufangwuMianji) {
        this.chushoufangwuMianji = chushoufangwuMianji;
    }
    /**
	 * 获取：原总价
	 */
    public Double getChushoufangwuOldMoney() {
        return chushoufangwuOldMoney;
    }


    /**
	 * 设置：原总价
	 */
    public void setChushoufangwuOldMoney(Double chushoufangwuOldMoney) {
        this.chushoufangwuOldMoney = chushoufangwuOldMoney;
    }
    /**
	 * 获取：现总价
	 */
    public Double getChushoufangwuNewMoney() {
        return chushoufangwuNewMoney;
    }


    /**
	 * 设置：现总价
	 */
    public void setChushoufangwuNewMoney(Double chushoufangwuNewMoney) {
        this.chushoufangwuNewMoney = chushoufangwuNewMoney;
    }
    /**
	 * 获取：房屋热度
	 */
    public Integer getChushoufangwuClicknum() {
        return chushoufangwuClicknum;
    }


    /**
	 * 设置：房屋热度
	 */
    public void setChushoufangwuClicknum(Integer chushoufangwuClicknum) {
        this.chushoufangwuClicknum = chushoufangwuClicknum;
    }
    /**
	 * 获取：出售房屋介绍
	 */
    public String getChushoufangwuContent() {
        return chushoufangwuContent;
    }


    /**
	 * 设置：出售房屋介绍
	 */
    public void setChushoufangwuContent(String chushoufangwuContent) {
        this.chushoufangwuContent = chushoufangwuContent;
    }
    /**
	 * 获取：房屋状态
	 */
    public Integer getChushoufangwuZhuangtaiTypes() {
        return chushoufangwuZhuangtaiTypes;
    }


    /**
	 * 设置：房屋状态
	 */
    public void setChushoufangwuZhuangtaiTypes(Integer chushoufangwuZhuangtaiTypes) {
        this.chushoufangwuZhuangtaiTypes = chushoufangwuZhuangtaiTypes;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChushoufangwuDelete() {
        return chushoufangwuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setChushoufangwuDelete(Integer chushoufangwuDelete) {
        this.chushoufangwuDelete = chushoufangwuDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
