package com.entity.view;

import com.entity.ZufangLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 租房留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zufang_liuyan")
public class ZufangLiuyanView extends ZufangLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

		//级联表 zufang
			/**
			* 租房 的 用户
			*/
			private Integer zufangYonghuId;
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
				* 出租房屋类型的值
				*/
				private String zufangValue;
			/**
			* 区域
			*/
			private Integer quyuTypes;
				/**
				* 区域的值
				*/
				private String quyuValue;
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
				* 房屋状态的值
				*/
				private String zufangZhuangtaiValue;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer zufangDelete;

	public ZufangLiuyanView() {

	}

	public ZufangLiuyanView(ZufangLiuyanEntity zufangLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zufangLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


























				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}


				//级联表的get和set zufang

					/**
					* 获取：租房 的 用户
					*/
					public Integer getZufangYonghuId() {
						return zufangYonghuId;
					}
					/**
					* 设置：租房 的 用户
					*/
					public void setZufangYonghuId(Integer zufangYonghuId) {
						this.zufangYonghuId = zufangYonghuId;
					}


					/**
					* 获取： 房屋名称
					*/
					public String getZufangName() {
						return zufangName;
					}
					/**
					* 设置： 房屋名称
					*/
					public void setZufangName(String zufangName) {
						this.zufangName = zufangName;
					}

					/**
					* 获取： 房屋编号
					*/
					public String getZufangUuidNumber() {
						return zufangUuidNumber;
					}
					/**
					* 设置： 房屋编号
					*/
					public void setZufangUuidNumber(String zufangUuidNumber) {
						this.zufangUuidNumber = zufangUuidNumber;
					}

					/**
					* 获取： 租房照片
					*/
					public String getZufangPhoto() {
						return zufangPhoto;
					}
					/**
					* 设置： 租房照片
					*/
					public void setZufangPhoto(String zufangPhoto) {
						this.zufangPhoto = zufangPhoto;
					}

					/**
					* 获取： 出租房屋类型
					*/
					public Integer getZufangTypes() {
						return zufangTypes;
					}
					/**
					* 设置： 出租房屋类型
					*/
					public void setZufangTypes(Integer zufangTypes) {
						this.zufangTypes = zufangTypes;
					}


						/**
						* 获取： 出租房屋类型的值
						*/
						public String getZufangValue() {
							return zufangValue;
						}
						/**
						* 设置： 出租房屋类型的值
						*/
						public void setZufangValue(String zufangValue) {
							this.zufangValue = zufangValue;
						}

					/**
					* 获取： 区域
					*/
					public Integer getQuyuTypes() {
						return quyuTypes;
					}
					/**
					* 设置： 区域
					*/
					public void setQuyuTypes(Integer quyuTypes) {
						this.quyuTypes = quyuTypes;
					}


						/**
						* 获取： 区域的值
						*/
						public String getQuyuValue() {
							return quyuValue;
						}
						/**
						* 设置： 区域的值
						*/
						public void setQuyuValue(String quyuValue) {
							this.quyuValue = quyuValue;
						}

					/**
					* 获取： 所在小区
					*/
					public String getZufangXiaoqu() {
						return zufangXiaoqu;
					}
					/**
					* 设置： 所在小区
					*/
					public void setZufangXiaoqu(String zufangXiaoqu) {
						this.zufangXiaoqu = zufangXiaoqu;
					}

					/**
					* 获取： 所在详细位置
					*/
					public String getZufangWeizhi() {
						return zufangWeizhi;
					}
					/**
					* 设置： 所在详细位置
					*/
					public void setZufangWeizhi(String zufangWeizhi) {
						this.zufangWeizhi = zufangWeizhi;
					}

					/**
					* 获取： 房屋面积
					*/
					public Double getZufangMianji() {
						return zufangMianji;
					}
					/**
					* 设置： 房屋面积
					*/
					public void setZufangMianji(Double zufangMianji) {
						this.zufangMianji = zufangMianji;
					}

					/**
					* 获取： 原价/月
					*/
					public Double getZufangOldMoney() {
						return zufangOldMoney;
					}
					/**
					* 设置： 原价/月
					*/
					public void setZufangOldMoney(Double zufangOldMoney) {
						this.zufangOldMoney = zufangOldMoney;
					}

					/**
					* 获取： 现加/月
					*/
					public Double getZufangNewMoney() {
						return zufangNewMoney;
					}
					/**
					* 设置： 现加/月
					*/
					public void setZufangNewMoney(Double zufangNewMoney) {
						this.zufangNewMoney = zufangNewMoney;
					}

					/**
					* 获取： 房屋热度
					*/
					public Integer getZufangClicknum() {
						return zufangClicknum;
					}
					/**
					* 设置： 房屋热度
					*/
					public void setZufangClicknum(Integer zufangClicknum) {
						this.zufangClicknum = zufangClicknum;
					}

					/**
					* 获取： 房屋介绍
					*/
					public String getZufangContent() {
						return zufangContent;
					}
					/**
					* 设置： 房屋介绍
					*/
					public void setZufangContent(String zufangContent) {
						this.zufangContent = zufangContent;
					}

					/**
					* 获取： 房屋状态
					*/
					public Integer getZufangZhuangtaiTypes() {
						return zufangZhuangtaiTypes;
					}
					/**
					* 设置： 房屋状态
					*/
					public void setZufangZhuangtaiTypes(Integer zufangZhuangtaiTypes) {
						this.zufangZhuangtaiTypes = zufangZhuangtaiTypes;
					}


						/**
						* 获取： 房屋状态的值
						*/
						public String getZufangZhuangtaiValue() {
							return zufangZhuangtaiValue;
						}
						/**
						* 设置： 房屋状态的值
						*/
						public void setZufangZhuangtaiValue(String zufangZhuangtaiValue) {
							this.zufangZhuangtaiValue = zufangZhuangtaiValue;
						}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getZufangDelete() {
						return zufangDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setZufangDelete(Integer zufangDelete) {
						this.zufangDelete = zufangDelete;
					}













}
