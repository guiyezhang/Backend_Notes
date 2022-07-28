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

4.1 使用镜像新建一个容器

docker run

1.创建并运行一个java容器 ,打印helloworld!

docker run java:8 /bin/echo 'Hello World!'











### centos分布

#### centos7  1中有docker

docker中有
    tomcat镜像  
    jdk1.8
    nginx
    mysql
