import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import chushoufangwu from '@/views/modules/chushoufangwu/list'
    import chushoufangwuCollection from '@/views/modules/chushoufangwuCollection/list'
    import chushoufangwuLiuyan from '@/views/modules/chushoufangwuLiuyan/list'
    import chushoufangwuOrder from '@/views/modules/chushoufangwuOrder/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zufang from '@/views/modules/zufang/list'
    import zufangCollection from '@/views/modules/zufangCollection/list'
    import zufangLiuyan from '@/views/modules/zufangLiuyan/list'
    import zufangOrder from '@/views/modules/zufangOrder/list'
    import config from '@/views/modules/config/list'
    import dictionaryChushoufangwu from '@/views/modules/dictionaryChushoufangwu/list'
    import dictionaryChushoufangwuCollection from '@/views/modules/dictionaryChushoufangwuCollection/list'
    import dictionaryChushoufangwuOrderYesno from '@/views/modules/dictionaryChushoufangwuOrderYesno/list'
    import dictionaryChushoufangwuXinjiu from '@/views/modules/dictionaryChushoufangwuXinjiu/list'
    import dictionaryChushoufangwuZhuangtai from '@/views/modules/dictionaryChushoufangwuZhuangtai/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryQuyu from '@/views/modules/dictionaryQuyu/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryZufang from '@/views/modules/dictionaryZufang/list'
    import dictionaryZufangCollection from '@/views/modules/dictionaryZufangCollection/list'
    import dictionaryZufangOrderYesno from '@/views/modules/dictionaryZufangOrderYesno/list'
    import dictionaryZufangZhuangtai from '@/views/modules/dictionaryZufangZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryChushoufangwu',
        name: '出售房屋类型',
        component: dictionaryChushoufangwu
    }
    ,{
        path: '/dictionaryChushoufangwuCollection',
        name: '收藏表类型',
        component: dictionaryChushoufangwuCollection
    }
    ,{
        path: '/dictionaryChushoufangwuOrderYesno',
        name: '审核状态',
        component: dictionaryChushoufangwuOrderYesno
    }
    ,{
        path: '/dictionaryChushoufangwuXinjiu',
        name: '新房旧房',
        component: dictionaryChushoufangwuXinjiu
    }
    ,{
        path: '/dictionaryChushoufangwuZhuangtai',
        name: '房屋状态',
        component: dictionaryChushoufangwuZhuangtai
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryQuyu',
        name: '区域',
        component: dictionaryQuyu
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryZufang',
        name: '出租房屋类型',
        component: dictionaryZufang
    }
    ,{
        path: '/dictionaryZufangCollection',
        name: '收藏表类型',
        component: dictionaryZufangCollection
    }
    ,{
        path: '/dictionaryZufangOrderYesno',
        name: '审核状态',
        component: dictionaryZufangOrderYesno
    }
    ,{
        path: '/dictionaryZufangZhuangtai',
        name: '房屋状态',
        component: dictionaryZufangZhuangtai
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/chushoufangwu',
        name: '出售房屋',
        component: chushoufangwu
      }
    ,{
        path: '/chushoufangwuCollection',
        name: '出售房屋收藏',
        component: chushoufangwuCollection
      }
    ,{
        path: '/chushoufangwuLiuyan',
        name: '出售房屋留言',
        component: chushoufangwuLiuyan
      }
    ,{
        path: '/chushoufangwuOrder',
        name: '预约出售房屋看房',
        component: chushoufangwuOrder
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zufang',
        name: '租房',
        component: zufang
      }
    ,{
        path: '/zufangCollection',
        name: '租房收藏',
        component: zufangCollection
      }
    ,{
        path: '/zufangLiuyan',
        name: '租房留言',
        component: zufangLiuyan
      }
    ,{
        path: '/zufangOrder',
        name: '预约租房看房',
        component: zufangOrder
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
