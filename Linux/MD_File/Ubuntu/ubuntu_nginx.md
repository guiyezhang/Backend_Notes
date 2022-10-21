# ubuntu中nginx的安装与配置
1. 安装命令
        sudo apt-get install nginx
2. 查看nginx版本
    nginx -v
3. 启动,查看,停止,重启nginx
    1> 开启nginx服务   service nginx start    或者 sudo systemctl start nginx.service
    2> 查看nginx状态   service nginx status   或者 sudo systemctl status nginx.service
    3> 停止nginx服务   service nginx stop     或者 sudo systemctl stop nginx.service
    4> 重启nginx服务   service nginx restart  或者 sudo systemctl restart nginx.service

4. 配置nginx代理

   1> cd/etc/nginx

   ![image-20220825112610147](D:\JAVA_Project_Test\md文件\Ubuntu\ubuntu_nginx\image-20220825112610147.png)

   2> 主要配置在nginx.conf文件中查看 cat nginx.conf

   ![image-20220825113013193](D:\JAVA_Project_Test\md文件\Ubuntu\ubuntu_nginx\image-20220825113013193.png)

   ​	看到配置指向了两个目录的配置文件 配置其中一个即可

   3>  配置/etc/nginx/sites-enabled目录下的default

   ```
   
   server {
       listen 80;
       server_name localhost;
   	
       # 打包好的dist目录文件，放置到这个目录下
       #root /opt/dist/;  
       location / {
           root /opt/dist/;
   	    index index.html index.htm;
        }
       location /api/  {
          proxy_pass http://localhost:8080/;
          #proxy_set_header Host $http_host;
          proxy_connect_timeout 15;
          proxy_send_timeout 15;
          proxy_read_timeout 15;
          proxy_set_header X-Real-IP $remote_addr;
          proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
       }
   }
   
   ```

   ![image-20220825113535790](D:\JAVA_Project_Test\md文件\Ubuntu\ubuntu_nginx\image-20220825113535790.png)

![image-20220825113621385](D:\JAVA_Project_Test\md文件\Ubuntu\ubuntu_nginx\image-20220825113621385.png)