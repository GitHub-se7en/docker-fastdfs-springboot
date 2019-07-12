# docker 安装fastdfs步骤
- 确保本机已经安装了docker
- docker pull delron/fastdfs      
使用上面的命令拉取fastdfs镜像，这个镜像里面已经安装好了nginx了，不需要担心nginx的事情
- docker run -d --network=host --name tracker -v /docker/fastdfs/tracker:/var/fdfs delron/fastdfs tracker     
构建tracker容器
- docker run -d --network=host --name storage -e TRACKER_SERVER=192.168.1.56:22122 -v /docker/fastdfs/storage:/var/fdfs -e GROUP_NAME=group1 delron/fastdfs storage     
构建storage容器，这里需要修改TRACKER_SERVER=192.168.1.56:22122中的IP地址为你的虚拟机的IP地址
- docker exec -it storage  /bin/bash
进入容器，这里的意思是进入安装storage的系统
- vi /etc/fdfs/storage.conf
修改storage的服务端口为91 
```
# the port of the web server on this storage server
http.server_port=91
```      
- vi /usr/local/nginx/conf/nginx.conf             
修改nginx的监听端口为91     
![](https://oscimg.oschina.net/oscnet/5c4c78ce1f9de2ec6aac9b6deaea17f624e.jpg)
- exit
- docker restart storage            
退出并重启
+ 可能遇到的坑
    - 如果你和我一样使用阿里云的话，记得一定开启端口，22122和23000和91，三个端口必须都需要开启
