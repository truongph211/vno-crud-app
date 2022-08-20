FROM java:8-jdk
MAINTAINER tthiphuong

ENV KARAF_USER karaf
ENV KARAF_UID 8181
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV KARAF_VERSION 4.2.8

# copy karaf zip to docker
COPY src/main/resources/apache-karaf-${KARAF_VERSION}.tar.gz ./

# extract the karaf zip file
# Create deploy file

RUN mkdir /opt/karaf; \
    tar --strip-components=1 -C /opt/karaf -xzf apache-karaf-${KARAF_VERSION}.tar.gz; \
    rm -rf /opt/karaf/examples ;\
    rm apache-karaf-${KARAF_VERSION}.tar.gz;\
    mkdir /deploy;

COPY target/vno-feature-1.0-SNAPSHOT.kar /opt/karaf/deploy

#COPY src/main/resources/create-database.jar /opt/
COPY src/main/resources/startServer.sh /opt/
RUN chmod 755 /opt/startServer.sh
EXPOSE  5005 8181
ENTRYPOINT ["/opt/startServer.sh"]


