Step:

1. FROM java:8-jdk
    Tao 1 UBUNTU server co cai dat java san

2. COPY src/main/resources/apache-karaf-${KARAF_VERSION}.tar.gz ./
    Copy karaf vao trong container
    roi extract ra (tuong tu nhu chay karaf o local )
   
3. Install vno app on karaf

 docker-compose -f docker-compose.yml up -d
mvn:docker build
docker images
docker ps |grep vno
docker exec -it
docker logs -f 
~./bashrc