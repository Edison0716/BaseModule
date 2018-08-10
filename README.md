# BaseModule
插件化 基类库
由于使用VirtualApk插件化开发方案 抽离出公共组件</br>

```
implementation 'com.github.Jack1995:BaseModule:1.1.8'
```

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
8、颜色值</br>
9、Glide 封装 加载进度回调</br>
10、theme style 文件</br>
11、状态栏工具类</br>
12、账号相关 （移除在BaseApplication中保存个人信息 不知道什么原因 在其他插件中获取不到个人信息）</br>
13、安装插件工具类（InstallPlugComponentUtil.kt）</br>
