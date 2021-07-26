# spring-elastic-search
spring-elastic-group-search

Go to master branch to checkout the code.

Download elastic search 7.8.0 zip folder from officical site of elastic search.

After unzipping, go to config, edit elasticsearch.yml

add cluster name which you want and path where data need to be stored. e.g : cluster.name: poc-group-search path.data: D:\workspace\manualsearch

Before running the project make sure elastic search is up first and then run your application.

postman - localhost:9090/rest/search/all/{text} - all matched text will be searched. localhost:9090/rest/search/all/linda
