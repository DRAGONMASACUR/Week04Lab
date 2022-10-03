package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 1drag
 */
//@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {
    Note note = new Note();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String line;
        String title = "";
        String contents = "";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            int i = 1;
            while ((line = br.readLine()) != null) {
                switch (i) {
                    case 1:
                        title = line;
                        break;
                    case 2:
                        contents = line;
                        break;
                    default:
                        contents = contents + "\n" + line;
                }
                i++;
            }
        }
        note.setTitle(title);
        note.setContents(contents);
        request.setAttribute("note", note);
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int portNumber = request.getServerPort();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String query = request.getQueryString();

        if (query != null){
            if(query.equals("edit")){
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        }
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title;
        String contents;

        title = request.getParameter("title");
        contents = request.getParameter("contents");

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) {
            pw.println(title + "\n" + contents);
        }

        
        //request.setAttribute("note", note);

        //getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
    }
}
