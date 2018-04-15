# AndroidCoordinate
android 里面的各种Coordinate
#### 1. MotionEvent坐标：
- getX：触点相对于所在View左上角的坐标的x值
- getY：触点相对于所在View左上角的坐标的y值
- getRawX：触点相对于屏幕左上角的坐标的值
- getRawY：触点相对于屏幕左上角的坐标的y值
#### 2. View坐标
- getX()与getY()方法获取的是View**左上角**相对于父容器**左上角**的坐标，当View没有发生平移操作时，getX()，getLeft()、getY，getTop()。
- translationX与 translationY是View**左上角**相对于父容器的偏移量：translationX = getX() - getLeft(),当View未发生平移操作时，translationX 与translationY都为0。
- View.getTop()、View.getLeft()、View.getBottom()、View.getRight()表示的是View原始状态时**左上角**相对于父容器**左上角**的坐标，对View进行平移操作并不会改变着四个方法的返回值。
- View.getLocationInWindow(int[] position);获取View**左上角**相对于整个屏幕**左上角**的坐标。
- View.getLocationInWindow(int[] position);获取View左上角相对于Window**左上角**的坐标。跟getLocationOnScreen相比，只有弹出窗口才有区别，如下图所示：
View.getParent可以获取view的父容器，得到的是ViewParent这个接口

![image](https://github.com/wk1995/AndroidCoordinate/blob/master/image/clipboard.png)
#### 3. 总结：
- 对于View来说，除了getLocationInWindow，getLocationInWindow这两个方法，其他的都是相对于父容器**左上角**的坐标的相对坐标

![image](https://github.com/wk1995/AndroidCoordinate/blob/master/image/CoordinateOfView.png)
- 对于MotionEvent来说，加了Raw的就是相对屏幕左上角的坐标了

![image](https://github.com/wk1995/AndroidCoordinate/blob/master/image/CoordinateOfMotionEvent.png)
#### 4. 博客
- https://blog.csdn.net/qq_33882671/article/details/79902108
