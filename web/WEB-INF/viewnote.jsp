<%-- 
    Document   : viewnote
    Created on : 2-Oct-2022, 5:14:53 PM
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
        <h1>View Note</h1>
        <p>
            Title: ${note.title}<br>
            Contents: ${note.contents}<br>
            <a href="NoteServlet?edit"> Edit</a>
        </p>
    </body>
</html>
