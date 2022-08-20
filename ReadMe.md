feature:repo-add mvn:vno-project/vno-feature/1.0-SNAPSHOT/xml/features
feature:repo-add mvn:<groupId>/<artifactId>/<version>/xml/features

feature:install vno-model
feature:install vno-service
feature:install vno-restful
feature:install vno-ui

curl GET http://localhost:8181/cxf/api/vno
Address: http://localhost:8181/cxf/api/vnos

--------------------------------------
