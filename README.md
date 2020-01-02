Volley请求框架+MVP框架契约类+Glide框架实现圆角,圆形+RecyclerView布局

需要添加的依赖: 
    //Volley请求框架依赖
    implementation 'com.android.volley:volley:1.1.1'
    //Glide依赖
    implementation 'com.github.bumptech.glide:glide:4.9.0'
    //RecyclerView 依赖
    implementation 'com.android.support:recyclerview-v7:28.0.0'
    //Gson解析依赖
    implementation 'com.google.code.gson:gson:2.8.5'
    
    
从0开始实现一个网络接口:
    1、创建一个hello word 项目，运行，保证项目没问题
    2、添加所需要的依赖，运行，保证依赖没问题
    3、封装并使用baseactivity，运行，保证baseactivity的封装没问题
    4、封装mvp
          ---封装网络工具类
          ---封装base mvp
    5、改造baseactivity，结合base mvp使用
    6、写mvp的实现类
    7、使用mvp


reyclerView的使用:
      1、设置布局管理器
      2、setadapter
      adapter的创建：
          1、继承RecyclerView.Adapter
          2、创建内部类，继承RecyclerView.ViewHolder
          3、明确viewhodler的泛型
      onCreateViewHolder（）：创建viewHolder
      onBindViewHolder（）：展示视图
