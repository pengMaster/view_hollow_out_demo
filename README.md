### 应用场景：高级UI绘制 - 镂空

- 1.Paint.ANTI_ALIAS_FLAG 设置抗锯齿
- 2.getWidth()/ getHeight() 需要在布局测量完毕使用 例如onSizeChanged ,如果在初始化方法中使用为0
- 3.Path.Direction.CCW 逆时针 Path.Direction.CW 顺时针
> 从最内部图形发射一条射线穿过所有嵌套图形。
- 4 镂空两种方式
  -  4.1  默认path.fileType = WINDING  （需要看方向）
        - 4.1.1 如果方向相同，全部内部，带有涂色
         -  4.1.2 如果方向相反的穿插次数相等则为内部，不等则为外部
    - 4.2 path.fileType = EVEN_ODD （常用）
         - 4.2.1 不考虑方向。穿插奇数次则为内部，偶数次则为外部：
         