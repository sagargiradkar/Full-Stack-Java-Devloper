### Different Types of Applications Built Using Java
===================================================

Java, as a versatile and powerful programming language, enables the development of various types of applications. These applications can be broadly categorized into two main types: standalone applications and enterprise applications. Each category serves different purposes and is built using specific Java editions and frameworks.

#### a. Standalone Applications (JSE)
-----------------------------------

Standalone applications are programs that run independently on a user's desktop or laptop without needing any external support like web servers or application servers. They utilize Java Standard Edition (JSE) and can be further divided into two types:

##### 1. CUI (Character User Interface) Applications
These applications operate in a console or command line interface, accepting input and providing output as text. Examples include simple utility programs like file managers, text editors, and command-line tools.

##### 2. GUI (Graphical User Interface) Applications
GUI applications feature graphical elements like windows, buttons, and menus to interact with users. Java provides libraries such as AWT (Abstract Window Toolkit), Swing, and JavaFX to build these applications. Examples include desktop software like media players, graphic editors, and IDEs (Integrated Development Environments).

#### b. Enterprise Applications (JEE and Frameworks)
-----------------------------------

Enterprise applications are large-scale, distributed, and typically business-oriented applications. They are built using Java Enterprise Edition (JEE) and various frameworks to meet complex requirements. They are divided into two main types:

##### 1. Web Applications
Web applications run on web servers and are accessed through web browsers over a network. Technologies like Servlets, JSP (JavaServer Pages), and frameworks such as Spring MVC are used to build these applications. Examples include e-commerce sites, online banking portals, and content management systems.

##### 2. Distributed Applications
Distributed applications are designed to run on multiple JVMs (Java Virtual Machines) across different networked computers. They involve complex interactions and communication between different components. Technologies like RMI (Remote Method Invocation), EJB (Enterprise JavaBeans), and Web Services are used to build these applications. Examples include large-scale enterprise systems, cloud-based services, and integrated business applications.

### Difference Between Web Application and Distributed Applications
----------------------------------------------------------------

Although both web and distributed applications are enterprise-level solutions, they differ significantly in their architecture and purposes.

#### Web Application
Web applications are designed to generate dynamic responses and provide services to web clients using a client-server model. They are server-side applications that do not distribute their logic across multiple JVMs. They utilize technologies like CGI, Servlet, JSP, and modern frameworks to handle client requests and produce dynamic content. A typical example is an online booking system where users interact through a web browser.

**Key Characteristics:**
- Runs on a single server or cluster.
- Uses web servers like Apache Tomcat, Jetty.
- Serves web clients only (browsers).
- Generates dynamic responses.

#### Distributed Applications
Distributed applications, on the other hand, distribute their logic across multiple JVMs and systems to ensure scalability and robustness. They enable communication between different local and remote systems to access services and resources. Technologies like RMI, EJB, and Web Services facilitate the building of these applications. An example is a banking system where different services (e.g., account management, transaction processing) run on different servers.

**Key Characteristics:**
- Runs on multiple servers/JVMs.
- Uses application servers like JBoss, WebLogic.
- Serves various types of clients (web, desktop, mobile).
- Ensures communication between local and remote services.

### Web Application
=================

Web applications are server-side applications designed using web-based technologies to generate dynamic responses. They are accessed by clients through web browsers and run on web servers. The primary purpose is to serve dynamic content based on user requests.

#### WebServer
A web server provides an environment to run web applications. It handles HTTP requests from clients and serves them with the appropriate web content. Examples include Apache Tomcat, Jetty, GlassFish, and JBoss.

#### Development and UnDeployment
- **Deployment**: The process of placing a web application inside a web server to make it available for users.
- **UnDeployment**: The process of removing a web application from the web server.

#### WebClient
A web client, typically a web browser (like Mozilla Firefox, Google Chrome, or Safari), sends requests to the web server and displays the server's responses.

### Web Programming for Static and Dynamic Responses
================================================

#### Static Response
A static response does not change based on user input or over time. Examples include the login page of Gmail or the homepage of a bank. 

**Flow Diagram for Static Page:**
1. Client sends a request for a static file to the server.
2. Server searches for the requested resource.
3. If found, the server provides the file as a response.
4. If not found, a 404 status code is returned.

#### Dynamic Response
A dynamic response varies based on user input and other factors. Examples include the inbox page of Gmail or the balance information page of a bank.

**Flow Diagram for Dynamic Page:**
1. Client sends a request to the web server.
2. Web server determines if the request is for a static or dynamic resource.
3. For static resources, the server handles the request; for dynamic resources, the request is forwarded to a web container.
4. Web container searches for the appropriate helper application.
5. If found, the helper application is executed, and the response is sent back to the server and then to the client.
6. If not found, a 404 status code is returned.
7. Any execution issues result in a 500 status code.

#### Technologies for Dynamic Responses
To generate dynamic responses, web developers use technologies such as:
- **CGI (Common Gateway Interface)**: A server-side technology built on top of C language, which is process-based and can be resource-intensive.
- **Servlet**: A Java-based, thread-based technology that creates threads instead of processes, improving server performance.
- **JSP (JavaServer Pages)**: A technology for presenting dynamic content with a focus on separating presentation logic from business logic.

### Architecture of WebServer (Tomcat)
=================================

Apache Tomcat is a popular web server with specific components for handling different aspects of web applications:

1. **WebContainer**: Manages and executes Servlets and JSPs.
2. **ServletContainer**: Known as ServletEngine, manages and executes Servlets. Tomcat's Servlet container is named "Catalina."
3. **JSPContainer**: Known as JSP Engine, manages and executes JSPs. Tomcat's JSP container is named "Jasper."

**Starting Tomcat Server:**
- Open the bin folder.
- Run the "tomcat9" executable.
- Access the server through a web browser at `http://localhost:9999`.

### Servlet
========

Servlet is a Java API for building web applications, providing the following packages:

#### javax.servlet.*;
- **Servlet(I)**
- **GenericServlet(AC)**
- **ServletConfig(I)**
- **ServletContext(I)**
- **RequestDispatcher(I)**
- **ServletRequest(I)**
- **ServletResponse(I)**

#### javax.servlet.http.*;
- **HttpServletRequest(I)**
- **HttpServletResponse(I)**
- **HttpSession**
- **HttpServlet(AC)**

These components form the backbone of building, deploying, and managing Java-based web and distributed applications.