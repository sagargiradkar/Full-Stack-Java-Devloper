# Differemnt types of application built using java
===================================================
  ###  a.standalone applications (JSE)
         1.CUI Applications
         2.GUI Applications
 ###   b.Enterprise applications (JEE and Frameworks)
         1.Web Applications
         2.Distributed Applications
    
Difference b/w web application and Distrubuted applications?

# Web Application
===============

WebApplication is a server side application,it will be designed without distrubuting logicc over multiple no of jvms.
To build webapplication we need to use technologies like CGI , Servelet ,JSP and so on ,....
Thae meain purpose of webapplication is to generate dynamic response from server machine
WebApplication provides services to webclients only (using the browser we need to send a request)
        eg:BMS(webApp) -----> to send the request to this application u need to used browser + intyernet mobile based app(internet)
        WebApp => Client to server model

In case of webApplication to execute the progrtam we need "webApplication"

# Distrubuted applications
========================

Distributed application is a server side application , it wioll be designed by distributed application logic over muiltiple no of jvms 
To build Distrubuted application  we need to use technologies like RMI(remote method invocation ),EJB's ,Web Services ..
The main purpose of distributed application is to establed the communication b/w local machine and remote machine to access the remote services .
Distribuuted app will provide service to any type of clients.
        Distributed App => bussiness to bussiness model.
In case of DA to execute the program we need "application servers".

client => A program which sends the request is called "client".
server => A program process the request and the send the response is called "server".


# WebApplication
=================

        The application which is devloed only using web base technologies like html.css,js,servelet,jsp etc is called "webApplication."


application ====> Collection of many programs

WebServer
=========
If we want these application to execute , we need one special software only we called as "webServer'.
webserver provides envirnment to run webapplications
        eg:tomcat.resin,jetty,glassfish ,jboss,


Devlopment and UnDeployment
===========================
The process of placing the webapplicatiobn inside webserver is called "Deployment".
The process of removing webApplication from the webserver is called "UnDeployment".

WebClient
==========
To send the requewst from the user we need to have special software installed in the client machine .
The special software is only called as "browser".
eg:Mozilla , crome , safari ......

web programming for static response
===================================
static response 
===============
        The response which won't be changed from person to person and time to time , such type of response is called as "static response".
        eg : login page of gmail
                home page oof icci banc

dynamic response
=================
The response which is valid from person to person and tinme to time such type of response is called as "dynamic response."
        eg:Inbox page of gmail
           balance information of icic bank
Flow diagram of static page
=============================
1.clients send the request for static file to the server
2.Serever searches whether the requested resourse is available or not.
3.If the request resouse is available then server will provide that files as response .
4.If the requesr=ted resourse is not available then we will get 404 status code saying requested resource not available

Note : To server static files , no processig is required at the server side , hence webserever always loves to server static files.

web programming for dynamic response
===================================

1.client send the request for webserver
2.webserver will checks whether the request is for static resourse or dynamic resourse (based on url).
3.If it is static resourse , then webserver only will reserch for static resourse , if it is available serevre will provide the static files content (copy and paste) as the response the client.
If it is not available , then 404 status code will be sent as the response to the client saying the requested resourse is not available.

4.If the requested resourses is dynamic informatiob , then webserver will forward the request to webcontainer.
5.webconatiner will serach the helper application , which needs to be executed .
If it is not available , then 404 status code will be sent as the response to the client saying the requested resourse is not available.
6.The requested helper application will be executed and it will be sent as the response to the webserver and webserver inreturns will send as the response to the end user.
7.During the execution if any problem occurs then it would result in execution and status code 500 would be sent as a response toi the end user by the server

Note:
        To generate the dynamic response at the server side we need some helper applications .To build these applications which are capable of generationg dynamic response we need to ;earn technologies like 
        A.CGI
        B.SERVLET
        C.JSP

To design a webapp , we already have CGI then what is the nedd to go for servlet ?
CGI => It stands for common Gateway Interface 
CGI is a server side web tech it buit on top of c language c languge is a process based lanuage , which intern make CGI as Process based tech
If we deoploy any CGI app then container woill create seperate process for every request 
Process is heavy weight component , to handle single process sysytem has to consume a lot of memmory and execution time.
Due to the above reason , more the request comes server would be getting a butden of creating a process which intern reduce the system performance abd increase the response time for the client.

To reduce the burden on server and to increase the performance we need to use server side called "Servelet"

Servelet is a server side rechnology which is build on top of "JAVA Lainguage";
java is Thread based tech
If we deployed Sevlete app at the server side then for every request servlet container will generate a seperate thread on thr respective Servlet Object .
In the above context , if we increse no of requests contain er will creaste a seperate thread instead of process.
When compared to process threads are lioght weight , since it is light weight , server would not be burdernded.
Server would provide quick response for client request which increase the performance of the request response 

To design a webapp , we already have Servelet then what is the nedd to go for JSP 


Sevlet 
        1.To buld web application we need to have a knowledge of Java Properly
        2.Servelet mainly meant for Processing logic(Pick the request and process the request.)
        3.Any modification done in the Servlet , we need to perform compilation and reloading on server explicitly.
        4.If we build webApp using MVC design pattern , then Servlet will placed inside Controller logic.
        5.In case of Servlet , we are unable to seperate both presentatiion logic and bussiness logic.



JSP 
        1.To build web application using JSP , it is not required to have any java Knowledge only presentation skills are enoufgh.
        2.JSP is maily meant for providing dynamic response to the client with good look and feel (only prsentation).
        3.Any modification done in the JSP , then it is not required to do compilation and realoding bz jsp pages are "AutoCompiled".
        4.If we build webApps using MVC design pattern , then JSP will placed inside View Logic.
        5.In case of JSP , there will be a clear cut seperation b/w presentation logic and bussiness logic bz presentation logic deals with html and bussiness logic deals with "JSP tags".

Architecture of WEBSERVER (TOMCAT)
==================================

        Tomcat
1.It is a webserver provided by apache foundation.
2.Every Webserver will have webcontainer
        a.webcontainer  is responsible to manage and execute servelet and jsps.
        b.jsper container (jsp container)
4.ServletContainer 
        It is also known as ServletEngine.
        It is responsible for managing and executing servlete components.
        Tomcat servlet container name id "CATALINA".

5.JSP Container
        It is also known as JSP Engine
        It is responsible for managing and executing jsp componets
        Tomcat jsp containe namse is "JASPER".