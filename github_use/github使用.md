# github使用

## 查找github仓库（Repository）

https://github.com/guiyezhang/Backend-Notes

一般是由github的域名：https://github.com

仓库主人：guiyezhang

仓库本身的名字:Backend-Notes

## 仓库管理

创建仓库：     New repository     

​						Owner: 选择仓库主人       Repository name:  仓库的名称（特殊符号只能包含横杠、下斜线和英文句号，其他的字符都会被github转义为横杠）

   					Descripition：填写仓库的简介

​						public：公开的所有人都可以看到

​						private：私有的，只有自己能看到 

添加文件：点击Add file---Upload files  添加一个文件

​         		  点击Add file -----Create new file添加一个空文件  -----  点击choose your files -----选择要添加的文件-----等待添加完成之后--------Commite changes 添加提交信息

提交一个lssue： 点击lssue----newlssue  ----写lssue的标题和内容   ---------  Submit new issue





## 如何使用git命令
### 先创建密钥SSH
1. Settings
2. SSH and GPG keys
3. generating SSH keys
4. 生成新的SSH密钥并添加到SSH密钥并添加到ssh-agent
5. 生成新SSH密钥 
6. 打开 Git Bash  粘贴后面的文本引号中的是github中的电子邮件  $ ssh-keygen -t ed25519 -C "github电子邮件" 
7. 注意：如果您使用的是不支持 Ed25519 算法的旧系统，请使用以下命令：$ ssh-keygen -t rsa -b 4096 -C "github电子邮件" 
8. 这将以提供的电子邮件地址为标签创建新SSH密钥: > Generating public/private algorithm key pair.
9. 提示您“Enter a file in which to save the key（输入要保存密钥的文件）”时，按 Enter 键。 这将接受默认文件位置。:> Enter a file in which to save the key (/c/Users/you/.ssh/id_algorithm):[Press enter]
10. 在提示时输入安全密码。
		> Enter passphrase (empty for no passphrase): [Type a passphrase]
		> Enter same passphrase again: [Type passphrase again]New SSH key
11. 将SSH公钥复制到剪切板：$ clip < ~/.ssh/id_ed25519.pub    # Copies the contents of the id_ed25519.pub file to your clipboard
12. 回到首页找到Settings找SSH和GPS密钥
13. 点击New SSH key（新 SSH 密钥）或 Add SSH key（添加 SSH 密钥）
14. 在 "Title"（标题）字段中，为新密钥添加描述性标签并将密钥粘贴到 "Key"（密钥）字段。然后点击Add SSH key
15. $ git clone SSH密钥地址    方法：找到仓库例如  Backend_Notes  打开找code 找到SSH密钥  复制
16. $ git status  查看状态
17. $ git add .  添加当前所有文件
18. $ git commit -m "解释" 
19. $ git push origin main    提交错误
