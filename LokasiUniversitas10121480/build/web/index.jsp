<%-- 
    Document   : index
    Created on : Nov 18, 2021, 9:05:18 AM
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
        <h2>Cari Lokasi Universitas</h2>
        <form action="chekerlocation" method="GET">
            <label>Masukkan Nama Universitas</label>
            <input type="text" name="universitas" />
            <input type="submit" value="Cari Lokasi" />
        </form>
    </body>
</html>
