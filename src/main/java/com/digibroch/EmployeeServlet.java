package com.digibroch;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");
        String empDept = request.getParameter("empDept");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee Details</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Employee Registered Successfully</h2>");

        out.println("<table border='1'>");

        out.println("<tr>");
        out.println("<td>Employee ID</td>");
        out.println("<td>" + empId + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Employee Name</td>");
        out.println("<td>" + empName + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Department</td>");
        out.println("<td>" + empDept + "</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<br>");
        out.println("<a href='employee.jsp'>Register Another Employee</a>");

        out.println("</body>");
        out.println("</html>");
    }
}