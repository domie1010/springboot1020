package com.entity.view;

import com.entity.ChushoufangwuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出售房屋留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chushoufangwu_liuyan")
public class ChushoufangwuLiuyanView extends ChushoufangwuLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 chushoufangwu
			/**
			* 出售房屋 的 用户
			*/
			private Integer chushoufangwuYonghuId;
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
				* 房屋类型的值
				*/
				private String chushoufangwuValue;
			/**
			* 新房旧房
			*/
			private Integer chushoufangwuXinjiuTypes;
				/**
				* 新房旧房的值
				*/
				private String chushoufangwuXinjiuValue;
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
				* 房屋状态的值
				*/
				private String chushoufangwuZhuangtaiValue;
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
			private Integer chushoufangwuDelete;

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

	public ChushoufangwuLiuyanView() {

	}

	public ChushoufangwuLiuyanView(ChushoufangwuLiuyanEntity chushoufangwuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, chushoufangwuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set chushoufangwu

					/**
					* 获取：出售房屋 的 用户
					*/
					public Integer getChushoufangwuYonghuId() {
						return chushoufangwuYonghuId;
					}
					/**
					* 设置：出售房屋 的 用户
					*/
					public void setChushoufangwuYonghuId(Integer chushoufangwuYonghuId) {
						this.chushoufangwuYonghuId = chushoufangwuYonghuId;
					}


					/**
					* 获取： 出售房屋名称
					*/
					public String getChushoufangwuName() {
						return chushoufangwuName;
					}
					/**
					* 设置： 出售房屋名称
					*/
					public void setChushoufangwuName(String chushoufangwuName) {
						this.chushoufangwuName = chushoufangwuName;
					}

					/**
					* 获取： 出售房屋编号
					*/
					public String getChushoufangwuUuidNumber() {
						return chushoufangwuUuidNumber;
					}
					/**
					* 设置： 出售房屋编号
					*/
					public void setChushoufangwuUuidNumber(String chushoufangwuUuidNumber) {
						this.chushoufangwuUuidNumber = chushoufangwuUuidNumber;
					}

					/**
					* 获取： 出售房屋照片
					*/
					public String getChushoufangwuPhoto() {
						return chushoufangwuPhoto;
					}
					/**
					* 设置： 出售房屋照片
					*/
					public void setChushoufangwuPhoto(String chushoufangwuPhoto) {
						this.chushoufangwuPhoto = chushoufangwuPhoto;
					}

					/**
					* 获取： 房屋类型
					*/
					public Integer getChushoufangwuTypes() {
						return chushoufangwuTypes;
					}
					/**
					* 设置： 房屋类型
					*/
					public void setChushoufangwuTypes(Integer chushoufangwuTypes) {
						this.chushoufangwuTypes = chushoufangwuTypes;
					}


						/**
						* 获取： 房屋类型的值
						*/
						public String getChushoufangwuValue() {
							return chushoufangwuValue;
						}
						/**
						* 设置： 房屋类型的值
						*/
						public void setChushoufangwuValue(String chushoufangwuValue) {
							this.chushoufangwuValue = chushoufangwuValue;
						}

					/**
					* 获取： 新房旧房
					*/
					public Integer getChushoufangwuXinjiuTypes() {
						return chushoufangwuXinjiuTypes;
					}
					/**
					* 设置： 新房旧房
					*/
					public void setChushoufangwuXinjiuTypes(Integer chushoufangwuXinjiuTypes) {
						this.chushoufangwuXinjiuTypes = chushoufangwuXinjiuTypes;
					}


						/**
						* 获取： 新房旧房的值
						*/
						public String getChushoufangwuXinjiuValue() {
							return chushoufangwuXinjiuValue;
						}
						/**
						* 设置： 新房旧房的值
						*/
						public void setChushoufangwuXinjiuValue(String chushoufangwuXinjiuValue) {
							this.chushoufangwuXinjiuValue = chushoufangwuXinjiuValue;
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
					public String getChushoufangwuXiaoqu() {
						return chushoufangwuXiaoqu;
					}
					/**
					* 设置： 所在小区
					*/
					public void setChushoufangwuXiaoqu(String chushoufangwuXiaoqu) {
						this.chushoufangwuXiaoqu = chushoufangwuXiaoqu;
					}

					/**
					* 获取： 所在详细位置
					*/
					public String getChushoufangwuWeizhi() {
						return chushoufangwuWeizhi;
					}
					/**
					* 设置： 所在详细位置
					*/
					public void setChushoufangwuWeizhi(String chushoufangwuWeizhi) {
						this.chushoufangwuWeizhi = chushoufangwuWeizhi;
					}

					/**
					* 获取： 房屋面积
					*/
					public Double getChushoufangwuMianji() {
						return chushoufangwuMianji;
					}
					/**
					* 设置： 房屋面积
					*/
					public void setChushoufangwuMianji(Double chushoufangwuMianji) {
						this.chushoufangwuMianji = chushoufangwuMianji;
					}

					/**
					* 获取： 原总价
					*/
					public Double getChushoufangwuOldMoney() {
						return chushoufangwuOldMoney;
					}
					/**
					* 设置： 原总价
					*/
					public void setChushoufangwuOldMoney(Double chushoufangwuOldMoney) {
						this.chushoufangwuOldMoney = chushoufangwuOldMoney;
					}

					/**
					* 获取： 现总价
					*/
					public Double getChushoufangwuNewMoney() {
						return chushoufangwuNewMoney;
					}
					/**
					* 设置： 现总价
					*/
					public void setChushoufangwuNewMoney(Double chushoufangwuNewMoney) {
						this.chushoufangwuNewMoney = chushoufangwuNewMoney;
					}

					/**
					* 获取： 房屋热度
					*/
					public Integer getChushoufangwuClicknum() {
						return chushoufangwuClicknum;
					}
					/**
					* 设置： 房屋热度
					*/
					public void setChushoufangwuClicknum(Integer chushoufangwuClicknum) {
						this.chushoufangwuClicknum = chushoufangwuClicknum;
					}

					/**
					* 获取： 出售房屋介绍
					*/
					public String getChushoufangwuContent() {
						return chushoufangwuContent;
					}
					/**
					* 设置： 出售房屋介绍
					*/
					public void setChushoufangwuContent(String chushoufangwuContent) {
						this.chushoufangwuContent = chushoufangwuContent;
					}

					/**
					* 获取： 房屋状态
					*/
					public Integer getChushoufangwuZhuangtaiTypes() {
						return chushoufangwuZhuangtaiTypes;
					}
					/**
					* 设置： 房屋状态
					*/
					public void setChushoufangwuZhuangtaiTypes(Integer chushoufangwuZhuangtaiTypes) {
						this.chushoufangwuZhuangtaiTypes = chushoufangwuZhuangtaiTypes;
					}


						/**
						* 获取： 房屋状态的值
						*/
						public String getChushoufangwuZhuangtaiValue() {
							return chushoufangwuZhuangtaiValue;
						}
						/**
						* 设置： 房屋状态的值
						*/
						public void setChushoufangwuZhuangtaiValue(String chushoufangwuZhuangtaiValue) {
							this.chushoufangwuZhuangtaiValue = chushoufangwuZhuangtaiValue;
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
					public Integer getChushoufangwuDelete() {
						return chushoufangwuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setChushoufangwuDelete(Integer chushoufangwuDelete) {
						this.chushoufangwuDelete = chushoufangwuDelete;
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















}
