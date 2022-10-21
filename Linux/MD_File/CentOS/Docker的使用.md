# Docker的使用

### 1.docker的安装

#### 1.1 安装docker

首先先上传docker-ce-18.06.0.ce-3.el7.x86_64.rpm到opt

执行命令： yum install -y docker-ce-18.06.0.ce-3.el7.x86_64.rpm

注意：确保服务器处于联网状态

#### 1.2 启动与停止docker

启动docker： systemctl start docker

停止docker： systemctl stop docker

重启docker： systemctl restart docker

查看docker状态： systemctl status docker

设置docker状态： systemctl enable docker

#### 1.3验证docker是否安装成功

执行命令：docker info

查看返回信息：能否查看到Docker相关信息

#### 

### 2.docker配置镜像加速器

国内访问Docker Hub的速度很不稳定，有时甚至出现连接不上的情况。我们来为Docker配置镜像加速器，从而解决这个问题。目前国内很多云服务商都提供了镜像加速的服务。

常用的镜像加速器有：阿里云加速器DaoCloud加速器等。各厂商镜像加速器的使用方式大致类似，笔者以阿里云加速器为例进行讲解。

注册阿里云账号后，即可在阿里云控制台(https://cr.console.aliyun.com/#/accelerator)看到类似如下的页面

#### 2.1 新建编辑： /etc/docker/daemon.json

```json
{

 "registry-mirrors": ["https://ksc53x4t.mirror.aliyuncs.com"]

 }
```

#### 2.2 修改保存后输入如下命令重启Docker守护进程和服务

重启docker守护程序： systemctl daemon-reload

重启docker服务: systemctl restart docker

查看docker容器信息： docker info

查看最后倒数两行出现如下结果说明配置成功

```
Registry Mirrors:
 https://j4pan1gm.mirror.aliyuncs.com/
```

### 3.docker镜像操作的常用指令

#### 3.1 通过镜像仓库搜索

docker镜像仓库网址：https://hub.docker.com/search?q=&type=image

#### 3.2 下载镜像

docker pull 镜像名称  //查询最近的版本

docekr pull 镜像名称 ：版本标签

如： 

docker pull tomcat

docker pull tomcat:8.5.57-jdk8-openjdk-slim

#### 3.3 查看本地镜像

docker images

#### 3.4 删除镜像

docker rmi tomcat：8.5.57-jdk8-openjdk-slim  //通过镜像名：版本号

或

docker rmi b1a27cee0cec  // 通过image ID删除

#### 3.5 保存镜像为文件

docker save -o /root/tomcat：8.5.57-jdk8-openjdk-slim

// -o /root/tomcat.tar  保存为文件地址

#### 3.6 把保存的镜像备份文件恢复成镜像

docker load -i /root/tomcat.tar

### 4.Docker容器操作常用指令

#### 4.1 使用镜像新建一个容器

#### docker run

1. 创建并运行一个java容器 ,打印helloworld!

docker run java:8 /bin/echo 'Hello World!'
2. 创建一个CentOS容器
docker run -dti --name=cl centos:centos7/bin/bash
    -d: 表示守护式容器(用户退出容器后,容器依然可以正常运行)
    -i: 运行容器
    -t: 交互 后面跟交互shell脚本 /bin/bash cetos:centos7 颈项名称
3. 创建一个有网络使用容器
    如:创建一个容器nginx端口为80
    -p 端口映射 宿主机端口:容器端口

#### 4.2 列出容器

1. 列出当前正在运行的容器 docker ps

2. 列出当前全部容器 docker ps -a

3. 列出当前容器 docker ps -a

   ### 4.3停止容器

   docker stop 容器的names

   docekr stop 容器的CONTAINER ID

   如:

   doceker stop c1

   docker stop 36bee7calcf4

   ### 4.4启动容器

   docker start 容器名称或容器编号

   docker start n1

   ### 4.5 强制停止容器

   docker kill  容器名称或容器编号

   ### 4.6 重启容器

   docker restart  容器名称或者容器编号

   ### 4.7 如何进入到容器

    docker exec -it c1 /bin/bash

   ### 4.8 退出容器

   exit

   ### 4.9 从宿主机拷贝文件到容器

   在宿主机上创建文件并编辑

   touch  java511.txt

   vi  java511.txt

   拷贝到容器中

   docker cp /java511.txt c1:/root/

   ### 4.10  从容器拷贝文件到宿主机

   docker cp c1:/1.java  /root/2.java

   ### 4.11 挂载宿主机的制定目录到容器(其中 --privileged 是可选的)

   （如果你共享的是多级的目录，可能会出现权限不足的提示。这是因为CentOS7中的安全模块selinux把权限禁掉了，我们需要添加参数  --privileged=true  来解决挂载的目录没有权限的问题）

    docker run -di --name=c2 -v /root/html:/test0722 --privileged=true centos:centos7

   ### 4.12 删除容器

   docker rm  容器名称或者编号   //注意 不能删除正在运行中容器， 需要停掉才可以删除

   docker rm -f  容器名称或者编号 // -f 强制删除

   ### 4.13 查看容器ip

   docker inspect n1  //输出的内容较多

   docker inspect --format='{{.NetworkSettings.IPAddress}}' n1  //只输出ip

   ### 4.14 查看容器日志输出

    docker logs n1   查看日志

    docker logs --tail="2" n1  查看日志 左后2行。

   ### 4.15、设置容器随着docker服务器启动就自动启动

   docker update --restart=always 容器名称






### centos分布

#### centos7  1中有docker

docker中有
    tomcat镜像  
    jdk1.8
    nginx
    mysql
