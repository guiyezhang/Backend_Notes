# ubuntu常用命令

1. ### Ubuntu遇到系统文件无法修改编辑的解决办法
    
    sudo gedit 文件目录/文件
    
2. 一般操作
    1> pwd(present working directory） 显示当前的工作目录/路径。
    2> cd (change directory)  改变目录，用于输入需要前往的路径/目录。
        cd .. //表示进入上层目录
        cd -  //表示返回上一次的目录
        cd ~  //进入主目录，即/home/用户名的简写
    3> ls (list)
        ls 显示当前目录下的文件（不包括隐藏文件和缓存文件等）；
        ll 以列表形式显示当前路径下的所有文件的详细信息（包括隐藏文件和缓存文件等）。  
    4> mkdir (make directory) 创建目录，后面接上directory的名字。
    5> rm (remove) 删除文件，后面接上要删除的文件名。如果要删除目录，需要这样写:
        rm -I <目录名>  //这样做会删除指定目录中的所有子目录和包含的文件
    6> touch 创建任意格式的文件，包括源代码、文本等等，通过后缀来决定。
        touch hello_world.cpp  //创建hello_world源代码
    7> cp (copy)
        cp -? <源文件/源目录> <目的目录>  //第一个"-?"表示参数，出发地在左，目的地在右
        cp -r cangjingkong/ xuexi    //将canjingkong目录下的所有资源都复制到xuexi目录中
    8> mv (move) 移动+重命名命令。格式类似于cp命令
        mv -? <源文件/源目录> <目的目录> //第一个"-?"表示参数，出发地在左，目的地在右
            以移动txt文件为例子,可以分为三种情况
            mv a.txt b.txt //出发地和目的地是同一路径，名称从a.txt变为b.txt，那仅仅是重命名
            mv ~/目录1/a.txt ~/目录2 //出发地和目的地是不同路径，没有指定新的名称，那仅仅是移动
            mv ~/目录1/a.txt ~/目录2/b.txt //出发地和目的地是不同路径，指定了新的名称，那就是移动+重命名   
    9> 加压,压缩
        .tar文件
            # 仅打包，并非压缩
            tar -xvf FileName.tar         # 解包
            tar -cvf FileName.tar DirName # 将DirName和其下所有文件（夹）打包 
        .gz文件
            # .gz
            gunzip FileName.gz  # 解压1
            gzip -d FileName.gz # 解压2
            gzip FileName       # 压缩，只能压缩文件
        .tar.gz文件、 .tgz文件
            # .tar.gz 和 .tgz
            tar -zxvf FileName.tar.gz               # 解压
            tar -zcvf FileName.tar.gz DirName       # 将DirName和其下所有文件（夹）压缩
            tar -C DesDirName -zxvf FileName.tar.gz # 解压到目标路径
        .zip文件
            # 感觉.zip占用空间比.tar.gz大
            unzip FileName.zip          # 解压
            zip FileName.zip DirName    # 将DirName本身压缩
            zip -r FileName.zip DirName # 压缩，递归处理，将指定目录下的所有文件和子目录一并压缩
        .rar文件
            # mac和linux并没有自带rar，需要去下载
            rar x FileName.rar      # 解压
            rar a FileName.rar DirName # 压缩    

