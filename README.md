# BaseModule
插件化 基类库
由于使用VirtualApk插件化开发方案 抽离出公共组件

----------记录过程----------</br>
1、修改gradle版本 </br>
2、rxJava rxAndroid rxPermissions rxLifecycle </br>
3、baseActivity baseFragment basePresenter IPresenter IView </br>
4、SoLoaderUtil </br>
5、Retrofit 网络请求框架封装（已完成 90%）</br>
---Log显示   </br>
---GET/POST请求</br>
---文件下载回调监听</br>
---修复无法接受到下载回调</br>
---修复Retrofit无法显示打印日志问题</br>
---修复下载无法关闭导致内存泄露问题</br>
6、RxSchedulers 线程调度</br>
7、RxBus(基于Blankj 的RxBus 修改)</br>
