# minio-spring-boot-starter

```
# 使用方式
## 0、安装minio服务
http://docs.minio.org.cn/docs/
## 1、添加maven坐标
​```
<dependency>
<groupId>cn.minio</groupId>
<artifactId>minio-spring-boot-starter</artifactId>
<version>1.1</version>
</dependency>
​```
## 2、增加配置
​```
cn:
  minio:
    endpoint: minio server ip&port
    accessKey: service account Access Key
    secretKey: service account Secret Key
​```
```