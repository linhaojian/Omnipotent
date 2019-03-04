# Omnipotent
![](https://upload-images.jianshu.io/upload_images/10018045-3a1d916e0af2d37b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

# 1.前言
   - 开发中，类与类之间交互又以下几种方式：
![类之间交互方式.png](https://upload-images.jianshu.io/upload_images/10018045-2a8510cd05bf4314.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

   - 上述那么多种方式都具备各种缺点，是否有一种方式能解决上述的大部分缺点呢？
   - **Omnipotent  库**（万能接口库），它就是解决**样式重复代码、类之间交互耦合**而诞生，还具备**使用简单、链式调用**的特点。
   - 本文特点：**图片多，字体少**
   - 文章中实例  **[linhaojian的Github](https://github.com/linhaojian)**
   _______________________________________________________________________________
 # 2.目录
![目录.png](https://upload-images.jianshu.io/upload_images/10018045-0dba7d4e7d612010.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
 _______________________________________________________________________________
# 3.简介
![介绍.png](https://upload-images.jianshu.io/upload_images/10018045-74e9c3e8f10001b6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
_______________________________________________________________________________
# 4.原理
## 4.1 举个例子
- Activity与Fragment接口交互（Fragment需要把自己的数据发送至Activity）
![类与类接口交互.png](https://upload-images.jianshu.io/upload_images/10018045-1a7fdf935ba58fa4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- 上面的例子，在正常使用是没有任何问题，假如遇到以下情况：
> 1）**因业务需求变换/迭代，需要修改接口的函数为无参有返回**。
> 2）**新增多个Fragment时，需要创建多个不同接口类**。
> 3）**接口函数中参数类型变换或者参数数量增多**。
- 这些问题都会让你的代码增加**修改成本**与**难度**，而且不便于维护、迭代。
## 4.2 结合Omnipotent
那Omnipotent是如何解决这样的问题呢？我们通过上图例子结合解析如下图：
![Omnipotent原理.png](https://upload-images.jianshu.io/upload_images/10018045-1c2c932c7e535ea6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 从上图可视，Omnipotent充当**接口的管理者同时，也是接口函数调用者，触发回调**。
- Omnipotent还是类之间交互的**桥梁**，把它们之间进行**解耦**。
_______________________________________________________________________________
# 5.使用
## 5.1 API使用
![API.png](https://upload-images.jianshu.io/upload_images/10018045-d5c31bd655fe8f22.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 5.2 如何在项目使用Omnipotent?
- `第一步：`
```Android
 allprojects {
  repositories {
   ...
   maven { url 'https://jitpack.io' }
  }
 }
```
- `第二步：`
```Android
 dependencies {
         implementation 'com.github.linhaojian:Omnipotent:1.2'
 }
```
## 5.3 示例
![omnipotent.gif](https://upload-images.jianshu.io/upload_images/10018045-d48400e661d290cd.gif?imageMogr2/auto-orient/strip)

- **[Omnipotent示例传送门](https://github.com/linhaojian/Omnipotent)**
_______________________________________________________________________________

# 6.设计思想
![设计思想.png](https://upload-images.jianshu.io/upload_images/10018045-549009f9c295ca95.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

_______________________________________________________________________________
# 7.总结
- 到此，`Omnipotent`库就介绍完毕，希望能在开发过程中帮助大家。
- 如果喜欢我的分享，可以点击  **关注**  或者  **赞**，你们支持是我分享的最大动力 。
-  **[linhaojian的Github](https://github.com/linhaojian)**
### 欢迎关注[linhaojian_CSDN博客](https://blog.csdn.net/qwe851023)或者[linhaojian_简书](https://www.jianshu.com/u/ef9bd53a8cbe)！
### 不定期分享关于安卓开发的干货。
_______________________________________________________________________________
#### 写技术文章初心
> - 技术知识积累
> - 技术知识巩固
> - 技术知识分享
> - 技术知识交流






