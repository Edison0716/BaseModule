# BaseModule
插件化 基类库
由于使用VirtualApk插件化开发方案 抽离出公共组件</br>

```
implementation 'com.github.Jack1995:BaseModule:1.2.5.4'
```

----------记录过程----------</br>
1、修改gradle版本</br>
2、rxJava rxAndroid rxPermissions rxLifecycle</br>
3、baseActivity baseFragment basePresenter IPresenter  IView</br>
4、SoLoaderUtil</br>
5、Retrofit 网络请求框架封装</br>
---Log显示</br>
---GET/POST请求</br>
---文件下载回调监听</br>
---修复无法接受到下载回调</br>
---修复Retrofit无法显示打印日志问题</br>
---修复下载无法关闭导致内存泄露问题</br>
---认证后的RetrofitClient</br>
---修改请求失败回调逻辑</br>
---插件开发模式 网络请求切换</br>
---账号过期 RxBus 推送</br>
6、RxSchedulers 线程调度</br>
7、RxBus(基于Blankj 的RxBus 修改)</br>
---使用范例</br>
8、颜色值</br>
9、Glide 封装 加载进度回调</br>
10、theme style 文件</br>
11、状态栏工具类</br>
12、安装插件工具类（InstallPlugComponentUtil.kt）</br>
13、SmartRefreshLayout</br>
14、Lottie</br>
15、CircleImageView</br>
16、BaseRecyclerViewAdapter</br>
17、cardview</br>
18、圆角Banner、DeleteEditText</br>
19、BannerImageLoaderManager</br>
20、加载弹窗 加载动画 .json 文件</br>
21、共享属性Manager</br>
22、空布局</br>
23、弹窗动画</br>
24、行间距 ItemDecoration DividerItemDividerDecoration</br>
25、字体对齐的textview</br>
26、ReboundScrollView</br>
27、BitmapConvertUtil</br>
28、分享图片 .svg文件</br>
29、集成Unity ads</br>
30、移除弹窗毛玻璃背景（UI不喜欢）</br>
31、update utilcode to 1.19.4 </br>
32、适配屏幕 </br>
33、集成rxBinding </br>
