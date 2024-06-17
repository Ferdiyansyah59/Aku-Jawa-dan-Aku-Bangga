<%-- 
    Document   : hasil
    Created on : Nov 18, 2021, 9:29:04 AM
    Author     : ferdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String username, password;
        
            username = (String) request.getAttribute("username");
            password = (String) request.getAttribute("password");
            
            if(username == null || password == null){
                request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }else{
                out.println("Selamat Datang "+ username + "!");
            }
        %> 
    </body>
</html>
