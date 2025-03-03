package com.entity.view;

import com.entity.ChushoufangwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出售房屋
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chushoufangwu")
public class ChushoufangwuView extends ChushoufangwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 房屋类型的值
		*/
		private String chushoufangwuValue;
		/**
		* 新房旧房的值
		*/
		private String chushoufangwuXinjiuValue;
		/**
		* 区域的值
		*/
		private String quyuValue;
		/**
		* 房屋状态的值
		*/
		private String chushoufangwuZhuangtaiValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



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

	public ChushoufangwuView() {

	}

	public ChushoufangwuView(ChushoufangwuEntity chushoufangwuEntity) {
		try {
			BeanUtils.copyProperties(this, chushoufangwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
