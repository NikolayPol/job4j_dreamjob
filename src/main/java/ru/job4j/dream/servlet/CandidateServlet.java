package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс CandidateServlet сохраняет нового кандидата и возвращает ответ.
 *
 * @author Nikolay Polegaev
 * @version 1.4 02.10.2021
 */
public class CandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("cands", new ArrayList<>(PsqlStore.instOf().findAllCandidates()));
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("/candidate/candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().save(new Candidate(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("city"))));
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
