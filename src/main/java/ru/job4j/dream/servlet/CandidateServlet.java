package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс CandidateServlet сохраняет нового кандидата и возвращает ответ.
 *
 * @author Nikolay Polegaev
 * @version 1.1 16.09.2021
 */
public class CandidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Store.instOf().save(new Candidate(Integer.parseInt(req.getParameter("id")),
                req.getParameter("name")));
        resp.sendRedirect(req.getContextPath() + "/candidate/candidates.jsp");
    }
}
