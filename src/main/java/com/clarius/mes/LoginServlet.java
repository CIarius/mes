package com.clarius.mes;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            OracleConnector.getConnection(username, password);
            request.getSession().setAttribute("username", username);
            response.sendRedirect("dashboard");
            return;
        } catch (SQLException e) {
            response.sendRedirect("login.jsp?error=1");
        }

    }

}
