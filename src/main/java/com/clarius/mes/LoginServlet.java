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
            request.getSession().setAttribute("user", username);
            response.sendRedirect("dashboard.jsp");
            return;
        } catch (SQLException e) {
            response.sendRedirect("login.jsp?error=1");
        }

    }

}
