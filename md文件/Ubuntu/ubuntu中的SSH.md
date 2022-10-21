# 关于ubuntu中SSH中的无法连接的解决办法
### 关于ubuntu中遇到SSH无法连接的问题
    1> 检查是否开启SSH服务      
            ps -e|grep ssh  输出的结果ssh-agent表示ssh-client启动,sshd表示
        
        ssh-server启动.我们是需要安装服务端所以应该看是否有sshd,如果没有则说明没有安装.
    2> 安装SSH服务
        通过以下命令安装SSH服务
            sudo apt-get install openssh-client  客户端
            sudo apt-get install openssh-server  服务端
            或者 sudo apt-get install ssh
    3> 启动SSH服务
        sudo /etc/init.d/ssh start
    4> 修改配置文件
        可以通过SSH配置文件更改包括端口、是否允许root登录等设置,配置文件位置:/etc/ssh/sshd_config
            sudo vim /etc/ssh/sshd_config
                因为root默认是不允许远程登录的,但是可以通过配置文件修改允许root远程登录参数
                    第一种情况没有PermitRootLogin yes:找到 PermitRootLogin without-password在下面一行添加PermitRootLogin yes
                    第二种情况有PermitRootLogin no:把PermitRootLogin no改为PermitRootLogin yes
    5> 重启SSH服务
        /etc/init.d/ssh restart 或者 service ssh restart