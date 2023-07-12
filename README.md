Project template uses AWS SQS service as message broker.
This web application connects AWS SQS and polls messages from AWS queue 
and save them to the r2dbc database using postgesql server from the docker container.
All saved messages are avaible on simple rest controller.

Used technologies:

Spring Boot
Spring Web Flux
R2DBC
FlyWay
MapStruct

