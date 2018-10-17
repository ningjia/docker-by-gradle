# 基于Gradle的SpringBoot与Docker集成
## 
> 添加依赖

修改build.gradle文件

```
buildscript {
   ...
    dependencies {
        //添加gradle-docker 依赖，版本1.2
        classpath 'se.transmode.gradle:gradle-docker:1.2'
    }
}
```

> 应用插件

修改build.gradle文件

```
apply plugin: 'docker'
```

> 配置镜像构建信息

- 配置Group
```
group = 'jianing0'
```

- 配置镜像名字和版本号
```
jar {
    baseName = 'docker-by-gradle'
    version = 'latest'
}
```

> 添加task任务

- 添加Dockerfile文件
    - 在src/main/docker目录中，添加Dockerfile文件。
    - Dockerfile文件的详细内容，参见[基于Maven的SpringBoot与Docker集成 - 一、程序修改(创建Dockerfile)](https://github.com/ningjia/docker-by-maven#一程序修改)部分的详细说明。

- 编辑build.gradle

```
task buildDocker(type: Docker) {
    applicationName = jar.baseName
    tagVersion = jar.version
    dockerfile = file('src/main/docker/Dockerfile')
    doFirst {
        copy {
            from jar
            into stageDir
        }
    }
}
```

按如上信息配置，之后构建生成的Docker镜像名就是：jianing0/docker-by-gradle:latest

##
> 生成jar文件
Tasks -> build -> bootRepackage

> 生成docker镜像文件
Tasks -> other -> buildDocker

## Refer
[使用 Gradle 构建 Spring-Boot 的 Docker 镜像](https://www.jianshu.com/p/02f5ace76539)
