## NewQQSlideMenu
QQ6.0侧边栏滑动效果

qq6.0侧边栏滑动效果, 其实和旧版实现原理一样,都是使用ViewDragHelper实现的, 所以仍然有老问题,在ViewDragHelper控制View滑动中, 界面上的所有view不能进行状态改变(比如textView设置文字,imageView显示图片,viewpager切换界面),
都会造成ViewDragHelper的滑动失败,所有控件回到原处,所以还是不可以在滑动中进行view的状态改变

在界面中同时存在viewpager的时候,事件分发我们可以使用判断y轴坐标,来让触摸事件传递到viewpager上面

ps: 代码只提供思路

![image](https://github.com/Zhaoss/NewQQSlideMenu/blob/master/image/1.jpg?raw=true)
![image](https://github.com/Zhaoss/NewQQSlideMenu/blob/master/image/2.jpg?raw=true)
