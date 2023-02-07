# Hyperledger-Fabric-Trace

#### 介绍
简单的食品区块链溯源vue+springboot
毕业设计

#### 软件架构
vue + springboot + mysql + Hyperledger Fabric


#### 安装教程

1.  centos7 fabric 1.4 安装步骤 https://blog.csdn.net/xu710263124/article/details/116644845  可能会各种报错自行百度解决就行
2.  安装完成之后 xshell cd /home/go/src/fabric-samples/first-network 将crypto-config文件夹拷贝到自己的电脑上
3.  将代码中resources下面crypto-config文件夹替换为你自己刚刚生成的crypto-config文件夹
4.  添加映射关系 修改C:\Windows\System32\drivers\etc下面的hosts文件添加  0.0.0.0 peer0.org1.example.com peer1.org1.example.com peer0.org2.example.com peer1.org2.example.com orderer.example.com
并保存，保存需要文件写的权限，自行百度。上面0.0.0.0 换成你虚拟机的ip就是刚刚安装fabric 1.4机子的ip
5.  将代码中的所有keyFileName的值修改为keyFolderPath目录下面的文件名
6.  可以开启自己电脑上的telnet功能测试区块链网络通不通，做完ip和节点的映射之后 cmd 输入 telnet peer0.org1.example.com 7051 正常的话会通的
7.  fabric学习 https://edu.51cto.com/center/course/lesson/index?id=438090
8.  安装部署有问题可以联系qq2252365338备注来意
9.  电脑要有vue的开发环境。没有的百度安装一下下
10. 登录注册界面借鉴了b站up用户：小河酱呀
11. 记得创建数据库和修改数据库连接用户名和密码,保证注册的时候food里面的用户是唯一的不然登录会报错不要重复注册
12. 每次重新启动fabric网络都需要重复上面第二、三、五步骤
13. https://www.bilibili.com/video/BV1qB4y1g7Fi/?vd_source=b30edb6636b2e8dc2974da1b6b1f7fb1
14. E:\projectgo\chaincode\src\eight\eight.go 智能合约路径 在代码Sdk Main中安装、触发智能合约

#### 使用说明

1.  启动fabric网络
2.  启动springboot
3.  启动vue npm run serve

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
