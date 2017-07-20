# RobotStore
Authentication and Authorization:
 
 Configure two Access roles Admin and user:
 Admin : search/edit/delete/add Robots 
 User : view/Find Robots

************Start  Rest API Exposed for Robot Store **********************

Return all List of robots :
input:
GET : https://robotshppoingcenter.herokuapp.com/findAllRobots/
or 
GET : https://robotshppoingcenter.herokuapp.com/robot
output :
[{"id":1,"name":"R-1"},{"id":2,"name":"R-2"},{"id":3,"name":"R-3"}]

Add new Robot entry in cart:
POST:https://robotshppoingcenter.herokuapp.com/robot/
 Request Payload:
 {"id":null,"name":"parth-1"}
 

Update robot name entry:

Put:https://robotshppoingcenter.herokuapp.com/robot/1
Request payload : {"id":1,"name":"R-1-updated"}

Delete Robot entry:

DELETE:https://robotshppoingcenter.herokuapp.com/robot/1

*********** End  Rest API Exposed for Robot Store ********************

Develper Guideline:

   
   Robot.java as a model object.
   WebSecurityConfig.java to give authorization and authentication
   CustomSuccessHandler.java which will decide page redirection based on role after successfullly login.
   RobotStoreService.java to provide service layer for Robot Store.
   RobotRepository.java to provide crud operation of Robots.
   user_controller.js to handle request and response.
   user_service.js to call rest service for manage crud operation of Robot store.
   application-scratch.properties provide embeded database url.	 

   Integration Test:
	RobotIntegrationTests:
	ControllerTests:
	
  Points:
   Used in momemory database hsql DB .

 
 
 
 


	






