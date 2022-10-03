<%-- 
    Document   : editnote
    Created on : 2-Oct-2022, 4:15:49 PM
    Author     : 1drag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Edit Note</h1>
        Title: <input type="text" name="title" value="${title}"><br>
        Contents: <input type="text" name="contents" value="${contents}">
        <input type="submit" value="Save">
    </body>
</html>
