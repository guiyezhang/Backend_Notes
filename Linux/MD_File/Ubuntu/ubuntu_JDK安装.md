# Ubuntu中安装JDK
1.下载JDK(这里是Linux版本的)

> https://www.oracle.com/java/technologies/downloads/

![image-20220825144010570](C:\Users\烨小贵\AppData\Roaming\Typora\typora-user-images\image-20220825144010570.png)

​		下载tar.gz格式的文件

2. 将下载好的JDK压缩包拖进tmp文件夹

3. 创建目录

   ```shell
   sudo mkdir /usr/lib/jvm
   ```

4. 将tmp文件中的jdk移动到/usr/lib/jvm中

   ```shell
   sudo mv jdk       /usr/lib/jvm
   ```

   

5. 设置环境变量等值 

   ```sh
   sudo vim ~/.bashrc 
   ```

   ​	在文本末尾添加

   ```shell
   export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_131  
   export JRE_HOME=${JAVA_HOME}/jre
   export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
   export PATH=${JAVA_HOME}/bin:$PATH
    
   
```
   
   

6. 使环境变量马上生效

   ```shell
   source ~/.bashrc
   ```

7. 设置默认JDK

   ```shell
   sudo update-alternatives --install /usr/bin/java java/usr/lib/jvm/jdk1.8.0_131/bin/java 300
   
   sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.8.0_131/bin/javac 300  
   
   sudo update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/jdk1.8.0_131/bin/jar 300   
   
   sudo update-alternatives --install /usr/bin/javah javah /usr/lib/jvm/jdk1.8.0_131/bin/javah 300   
   
   sudo update-alternatives --install /usr/bin/javap javap /usr/lib/jvm/jdk1.8.0_131/bin/javap 300  
   ```

   

8.查看JDK版本输入命令:

```shell
java -version
```

​		出现版本号表示安装配置成功


