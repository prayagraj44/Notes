/*
Servlets don’t have a main() method.
They’re under the control of another Java
application called a Container */
/* 
When a request comes in, somebody has to
instantiate the servlet or at least make a new thread to handle the request.
Somebody has to call the servlet’s doPost() or doGet() method. And, oh yes,
those methods have crucial arguments—the HTTP request and HTTP response
objects. Somebody has to get the request and the response to the servlet.
Somebody has to manage the life, death, and resources of the servlet. That
somebody is the web Container(tomcat). */

/*Steps how container handles web request
1.User clicks a link that has a URL to a servlet  */

/* 2. The container “sees” that the request is for a servlet, so the container creates two objects:
a) HttpServletResponse
b) HttpServletRequest */

/* 3 The container finds the correct servlet based on the URL in the request, creates or allocates a 
thread for that request, and passes the request and response objects to the servlet thread.*/

/* 4 The container calls the servlet’s service() method. Depending on the type of request, the service() 
method calls either the doGet() ordoPost() method. */

/*5 The doGet() method generates the dynamic page and stuffs the page into the response object.
Remember, the container still has a reference to the response object! */

/*6 The thread completes, the container converts the responseobject into an HTTP response,
sends it back to the client, thendeletes the request and response objects. */
/* 
Your servlet inherited it from HttpServlet,
which inherited it from GenericServlet which
inherited it from...  thats how you get servelt method */

/* tomcat deployment structure of webapp
tomcat->webapps->"app-name"->WEB-INF->classes
                                    ->web.xml
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Ch1Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        java.util.Date today = new java.util.Date();
        out.println("<html>" + "<body>" + "<h1 align=center>Chapter1 Servlet</h1>" + "<br>" + today + "</body>"
                + "</html>");
    }
}