# DouyinDemo
1.界面搭建
+ item_view_pager.xml负责播放视频的控件以及头像，播放量，评论等
+ activity_main.xml负责界面首页的布局
+ PlayVideoManager是音频管理类，负责播放音视频
+ MyAdapter适配器，负责布局资源的绑定
+ MyLayoutManager2继承于LinearLayoutManager，实现了RecyclerView.OnChildAttachStateChangeListener接口，负责子控件状态的监听和滑动格式的设置
