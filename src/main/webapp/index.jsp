<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body {
    background-image:
        url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PARCIALITO FINAL</title>
</head>
<body>
    <form action="NuevoCatalogServlet" method="GET" id="anadir">
        <tr>
            <td>
                Suplier ID: <input type="text" name="sID"><br><br>
                Product ID: <input type="text" name="pID"><br><br>
                Cost: <input type="number" name="cost"><br><br>
                <input type="submit" value="Añadir Catalogo"/>
            </td>
        </tr>
    </form>
    
    <form action="GraficoServlet" method="GET">
        <input type="submit" value="GRAFICO COSTOS"/>
    </form>
    
    <img src="ChartServlet" /><br/>
    <img src="BarServlet" /><br/>
    
</body>
</html>
