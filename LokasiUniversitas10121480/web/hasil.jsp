<%-- 
    Document   : hasil
    Created on : Nov 18, 2021, 9:06:47 AM
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
            String lokasi, universitas;
            
            lokasi = (String) request.getAttribute("lokasi");
            universitas = (String) request.getAttribute("universitas");
        %>
        <h3>Lokasi Universitas</h3>
        <p><% out.println(universitas);%> Berada Pada <% out.println(lokasi); %></p>
    </body>
</html>
