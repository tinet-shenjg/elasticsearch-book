<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-2.0.2-blue.svg" alt="Downloads">
  <img src="https://img.shields.io/badge/elasticsearch--book-1.0.0-green.svg">
</p>  

---
# elasticsearch-book 

**基于Elasticsearch的图书检索系统**  
---
1. 图书类别检索功能 （待开发）   
2. 图书内容检索  （已完成）   
---
启动前配置：
1. 安装好Elasticsearch
2. 添加文档
```javascript
POST /books/_doc/
{
  "bookId":91,
  "name":"三国演义",
  "content":"三国演义是一本四大名著",
  "categoryId":1,
  "url":"http://www.baidu.com"
}
```
项目启动： 
1. 修改application.yml中Elasticsearch配置中的host和port
2. 启动ApplicationStart类 
---
搜索界面图：  
![avatar](https://github.com/tinet-shenjg/elasticsearch-book/blob/master/src/main/resources/static/image/index.png)  
搜索结果展示界面图：  
![avatar](https://github.com/tinet-shenjg/elasticsearch-book/blob/master/src/main/resources/static/image/main.png)