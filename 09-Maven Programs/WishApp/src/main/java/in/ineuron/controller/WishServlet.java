package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.App;

@WebServlet("/wish")
public class WishServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("    <title>Welcome</title>");
        out.println("    <style>");
        out.println("        body {");
        out.println("            font-family: Arial, sans-serif;");
        out.println("            background-color: #f4f4f9;");
        out.println("            margin: 0;");
        out.println("            padding: 0;");
        out.println("            display: flex;");
        out.println("            justify-content: center;");
        out.println("            align-items: center;");
        out.println("            height: 100vh;");
        out.println("        }");
        out.println("        .container {");
        out.println("            text-align: center;");
        out.println("            background: #ffffff;");
        out.println("            padding: 20px;");
        out.println("            border-radius: 10px;");
        out.println("            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);");
        out.println("        }");
        out.println("        h1 {");
        out.println("            color: #333;");
        out.println("        }");
        out.println("        p {");
        out.println("            color: #666;");
        out.println("        }");
        out.println("        .sum {");
        out.println("            font-size: 24px;");
        out.println("            color: #007BFF;");
        out.println("            font-weight: bold;");
        out.println("            margin-top: 20px;");
        out.println("        }");
        out.println("        .button {");
        out.println("            display: inline-block;");
        out.println("            margin-top: 20px;");
        out.println("            padding: 10px 20px;");
        out.println("            color: #fff;");
        out.println("            background-color: #007BFF;");
        out.println("            text-decoration: none;");
        out.println("            border-radius: 5px;");
        out.println("        }");
        out.println("        .button:hover {");
        out.println("            background-color: #0056b3;");
        out.println("        }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class='container'>");
        
        App app = new App();
        // Display the sum with added styling
        out.println("<div class='sum'>The sum is: " + app.add(10, 20) + "</div>");
        
        out.println("        <h1>Welcome to Our Website!</h1>");
        out.println("        <p>We are glad to have you here. Explore our services and feel free to reach out to us.</p>");
        out.println("        <a href='#' class='button'>Learn More</a>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
