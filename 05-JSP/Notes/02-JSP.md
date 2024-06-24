
# The Page directive in JSP (JavaServer Pages)

The Page directive in JSP (JavaServer Pages) provides instructions specific to the entire JSP page, such as importing classes, handling errors, specifying the content type, etc. Here are explanations of key attributes of the Page directive, each accompanied by 10 examples:

### 1. **import**
Specifies the Java packages or classes to be imported for use in the JSP page.

**Examples:**
```jsp
<%@ page import="java.util.Date" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*, javax.servlet.jsp.*" %>
<%@ page import="com.example.MyClass" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.nio.file.Files" %>
```

### 2. **contentType**
Defines the MIME type and character encoding for the JSP response.

**Examples:**
```jsp
<%@ page contentType="text/html" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="application/json" %>
<%@ page contentType="text/xml" %>
<%@ page contentType="text/plain;charset=UTF-8" %>
<%@ page contentType="application/pdf" %>
<%@ page contentType="application/vnd.ms-excel" %>
<%@ page contentType="image/jpeg" %>
<%@ page contentType="audio/mpeg" %>
<%@ page contentType="video/mp4" %>
```

### 3. **session**
Indicates whether the JSP page participates in an HTTP session.

**Examples:**
```jsp
<%@ page session="true" %>
<%@ page session="false" %>
// Using true to enable session
<%@ page session="true" %>
// Using false to disable session
<%@ page session="false" %>
// Ensuring session data can be used
<%@ page session="true" %>
// For a stateless page, disabling session
<%@ page session="false" %>
// Enabling session management
<%@ page session="true" %>
// No session required for static content
<%@ page session="false" %>
// Default is true, but can explicitly state it
<%@ page session="true" %>
```

### 4. **buffer**
Specifies the buffer size for the JSP page output.

**Examples:**
```jsp
<%@ page buffer="8kb" %>
<%@ page buffer="16kb" %>
<%@ page buffer="32kb" %>
<%@ page buffer="64kb" %>
<%@ page buffer="128kb" %>
<%@ page buffer="256kb" %>
<%@ page buffer="none" %>
// Setting a specific buffer size
<%@ page buffer="8kb" %>
// Disabling buffering
<%@ page buffer="none" %>
// Using a larger buffer size
<%@ page buffer="64kb" %>
```

### 5. **autoFlush**
Indicates whether the buffer should be flushed automatically when it is full.

**Examples:**
```jsp
<%@ page autoFlush="true" %>
<%@ page autoFlush="false" %>
// Enabling auto flush
<%@ page autoFlush="true" %>
// Disabling auto flush
<%@ page autoFlush="false" %>
// Default setting, can state explicitly
<%@ page autoFlush="true" %>
// Preventing auto flush to manage output manually
<%@ page autoFlush="false" %>
// Allowing buffer to flush automatically
<%@ page autoFlush="true" %>
// Controlling output flow by disabling auto flush
<%@ page autoFlush="false" %>
// Ensuring buffer is flushed as needed
<%@ page autoFlush="true" %>
```

### 6. **isThreadSafe**
Specifies whether the JSP page is thread-safe.

**Examples:**
```jsp
<%@ page isThreadSafe="true" %>
<%@ page isThreadSafe="false" %>
// Indicating thread safety
<%@ page isThreadSafe="true" %>
// Indicating thread unsafety
<%@ page isThreadSafe="false" %>
// Default is true, but can state explicitly
<%@ page isThreadSafe="true" %>
// Marking page as not thread-safe
<%@ page isThreadSafe="false" %>
// Enabling thread safety for concurrent access
<%@ page isThreadSafe="true" %>
// Ensuring single-thread access
<%@ page isThreadSafe="false" %>
// Allowing multiple threads safely
<%@ page isThreadSafe="true" %>
```

### 7. **errorPage**
Specifies a JSP page to handle errors occurring in the current page.

**Examples:**
```jsp
<%@ page errorPage="error.jsp" %>
<%@ page errorPage="/errors/generalError.jsp" %>
<%@ page errorPage="404.jsp" %>
<%@ page errorPage="/errors/500.jsp" %>
<%@ page errorPage="customError.jsp" %>
<%@ page errorPage="/errorPages/errorHandler.jsp" %>
<%@ page errorPage="exception.jsp" %>
<%@ page errorPage="/errors/databaseError.jsp" %>
<%@ page errorPage="errorPage.jsp" %>
<%@ page errorPage="/errorPages/generalError.jsp" %>
```

### 8. **isErrorPage**
Indicates whether the current JSP page is an error page.

**Examples:**
```jsp
<%@ page isErrorPage="true" %>
<%@ page isErrorPage="false" %>
// Indicating this page is an error handler
<%@ page isErrorPage="true" %>
// This page is not an error handler
<%@ page isErrorPage="false" %>
// Marking a page explicitly as error handler
<%@ page isErrorPage="true" %>
// Ensuring this page doesn't handle errors
<%@ page isErrorPage="false" %>
// Making a dedicated error handling page
<%@ page isErrorPage="true" %>
// Default setting can be stated
<%@ page isErrorPage="false" %>
// Allowing exception objects in this page
<%@ page isErrorPage="true" %>
```

### 9. **language**
Defines the scripting language used in the JSP page.

**Examples:**
```jsp
<%@ page language="java" %>
<%@ page language="groovy" %>
<%@ page language="javascript" %>
<%@ page language="ruby" %>
// Default is Java, can be stated explicitly
<%@ page language="java" %>
// Using Java as scripting language
<%@ page language="java" %>
// Specifying Groovy as scripting language
<%@ page language="groovy" %>
// Utilizing JavaScript in JSP
<%@ page language="javascript" %>
// Declaring Ruby as the language
<%@ page language="ruby" %>
// Ensuring Java for compatibility
<%@ page language="java" %>
```

### 10. **extends**
Defines the superclass of the generated servlet class.

**Examples:**
```jsp
<%@ page extends="com.example.BaseServlet" %>
<%@ page extends="org.example.CustomJspServlet" %>
<%@ page extends="javax.servlet.http.HttpServlet" %>
<%@ page extends="com.custom.MyServlet" %>
<%@ page extends="com.company.ExtendedServlet" %>
<%@ page extends="org.project.BaseJsp" %>
<%@ page extends="my.package.SuperJspServlet" %>
<%@ page extends="custom.BaseHttpServlet" %>
<%@ page extends="example.MyBaseServlet" %>
<%@ page extends="company.servlet.CustomServlet" %>
```

These examples demonstrate the flexibility and configurability provided by the Page directive in JSP to manage various aspects of the JSP page behavior and functionality.