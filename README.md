# docker安装fastdfs，springboot照片上传
#### fastdfs文件服务器
以照片为例，照片上传到服务器上以后，如果想通过浏览器访问照片，就必须在fastdfs上搭建nginx，是的，  nginx不光可以搭建tomcat集群，还可以管理静态文件

#### 为什么使用docker？
服务器上搭建fastdfs与nginx，步骤繁琐，容易出错，不易管理，而docker解决了所有的痛点，通过docker搭建fastdfs直接展示了docker为何如此流行

上面说到，服务器搭建fastdfs步骤繁琐，那如果有人已经安装好了，你直接换一下端口，就能使用，是不是特别爽，就跟导入一个jar包，直接调用方法一样，这一点docker做到了，这里可以理解为docker的fastdfs镜像是一个mini操作系统，这个系统里面已经搭建好了fastdfs，使用docker run 命令直接运行即可，不需要担心配置，不需要担心冲突

#### 本项目如何使用？
启动项目之后，直接访问127.0.0.1:8080/upload.html就可以看到页面了，打开F12，在控制台会看到自己上传的图片的地址是什么，浏览器中直接访问就可以
