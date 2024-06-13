package com.saad.controller;

import com.saad.model.Note;
import com.saad.model.NoteRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoteController extends HttpServlet {
    private NoteRepository noteRepository;

    public void init() {
        noteRepository = new NoteRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/notes":
                showAllNotes(request, response);
                break;
            case "/notes/add":
                showAddForm(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/notes");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);

        noteRepository.addNote(newNote);

        response.sendRedirect(request.getContextPath() + "/notes");
    }

    private void showAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("notes", noteRepository.getAllNotes());
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
    }
}
