package com.entity.model;

import com.entity.ZufangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 租房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZufangModel implements Serializable {
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
     * 房屋名称
     */
    private String zufangName;


    /**
     * 房屋编号
     */
    private String zufangUuidNumber;


    /**
     * 租房照片
     */
    private String zufangPhoto;


    /**
     * 出租房屋类型
     */
    private Integer zufangTypes;


    /**
     * 区域
     */
    private Integer quyuTypes;


    /**
     * 所在小区
     */
    private String zufangXiaoqu;


    /**
     * 所在详细位置
     */
    private String zufangWeizhi;


    /**
     * 房屋面积
     */
    private Double zufangMianji;


    /**
     * 原价/月
     */
    private Double zufangOldMoney;


    /**
     * 现加/月
     */
    private Double zufangNewMoney;


    /**
     * 房屋热度
     */
    private Integer zufangClicknum;


    /**
     * 房屋介绍
     */
    private String zufangContent;


    /**
     * 房屋状态
     */
    private Integer zufangZhuangtaiTypes;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer zufangDelete;


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
	 * 获取：房屋名称
	 */
    public String getZufangName() {
        return zufangName;
    }


    /**
	 * 设置：房屋名称
	 */
    public void setZufangName(String zufangName) {
        this.zufangName = zufangName;
    }
    /**
	 * 获取：房屋编号
	 */
    public String getZufangUuidNumber() {
        return zufangUuidNumber;
    }


    /**
	 * 设置：房屋编号
	 */
    public void setZufangUuidNumber(String zufangUuidNumber) {
        this.zufangUuidNumber = zufangUuidNumber;
    }
    /**
	 * 获取：租房照片
	 */
    public String getZufangPhoto() {
        return zufangPhoto;
    }


    /**
	 * 设置：租房照片
	 */
    public void setZufangPhoto(String zufangPhoto) {
        this.zufangPhoto = zufangPhoto;
    }
    /**
	 * 获取：出租房屋类型
	 */
    public Integer getZufangTypes() {
        return zufangTypes;
    }


    /**
	 * 设置：出租房屋类型
	 */
    public void setZufangTypes(Integer zufangTypes) {
        this.zufangTypes = zufangTypes;
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
    public String getZufangXiaoqu() {
        return zufangXiaoqu;
    }


    /**
	 * 设置：所在小区
	 */
    public void setZufangXiaoqu(String zufangXiaoqu) {
        this.zufangXiaoqu = zufangXiaoqu;
    }
    /**
	 * 获取：所在详细位置
	 */
    public String getZufangWeizhi() {
        return zufangWeizhi;
    }


    /**
	 * 设置：所在详细位置
	 */
    public void setZufangWeizhi(String zufangWeizhi) {
        this.zufangWeizhi = zufangWeizhi;
    }
    /**
	 * 获取：房屋面积
	 */
    public Double getZufangMianji() {
        return zufangMianji;
    }


    /**
	 * 设置：房屋面积
	 */
    public void setZufangMianji(Double zufangMianji) {
        this.zufangMianji = zufangMianji;
    }
    /**
	 * 获取：原价/月
	 */
    public Double getZufangOldMoney() {
        return zufangOldMoney;
    }


    /**
	 * 设置：原价/月
	 */
    public void setZufangOldMoney(Double zufangOldMoney) {
        this.zufangOldMoney = zufangOldMoney;
    }
    /**
	 * 获取：现加/月
	 */
    public Double getZufangNewMoney() {
        return zufangNewMoney;
    }


    /**
	 * 设置：现加/月
	 */
    public void setZufangNewMoney(Double zufangNewMoney) {
        this.zufangNewMoney = zufangNewMoney;
    }
    /**
	 * 获取：房屋热度
	 */
    public Integer getZufangClicknum() {
        return zufangClicknum;
    }


    /**
	 * 设置：房屋热度
	 */
    public void setZufangClicknum(Integer zufangClicknum) {
        this.zufangClicknum = zufangClicknum;
    }
    /**
	 * 获取：房屋介绍
	 */
    public String getZufangContent() {
        return zufangContent;
    }


    /**
	 * 设置：房屋介绍
	 */
    public void setZufangContent(String zufangContent) {
        this.zufangContent = zufangContent;
    }
    /**
	 * 获取：房屋状态
	 */
    public Integer getZufangZhuangtaiTypes() {
        return zufangZhuangtaiTypes;
    }


    /**
	 * 设置：房屋状态
	 */
    public void setZufangZhuangtaiTypes(Integer zufangZhuangtaiTypes) {
        this.zufangZhuangtaiTypes = zufangZhuangtaiTypes;
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
    public Integer getZufangDelete() {
        return zufangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setZufangDelete(Integer zufangDelete) {
        this.zufangDelete = zufangDelete;
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
