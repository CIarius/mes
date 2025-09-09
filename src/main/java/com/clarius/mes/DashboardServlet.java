package com.clarius.mes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DashboardServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if ( session == null || session.getAttribute("username") == null ) {
            response.sendRedirect("login.jsp");
            return;
        }else {
            response.getWriter().println(session.getAttribute("username"));
        }

    }


}
