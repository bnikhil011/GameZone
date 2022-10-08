# GameZone
MicroService based design used for building registering game rooms 

The Project has 4 Mocroservice which interect with each other to build to fulfil User Requirements 
1) Gateway
2) UserRegisteration
3) GameRoomRegisteration
4) DataHandler

To have it simple No database is being used Data Handlere Service will be having all the data saved and later can we replaced with any JAP provide with small Changes 

One more Model Project is being created so that all the modeals can be easily transefered easily between microservices
-> Edurica Service Discovery is being used to discover the service and we r using clienst side Service Discovery which is being abstracted using LoadBalancer, IN future we will try to replace it with Zookeeper Service Discovery 

-------------------------------------------------------THANK YOU-------------------------------------------------------
 
