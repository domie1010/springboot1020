const base = {
    get() {
        return {
            url : "http://localhost:8080/fangwujiaoyipingtai/",
            name: "fangwujiaoyipingtai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/fangwujiaoyipingtai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "房屋交易平台"
        } 
    }
}
export default base
