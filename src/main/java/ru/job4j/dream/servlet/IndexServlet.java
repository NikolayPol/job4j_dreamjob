package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс IndexServlet - контроллер для index.jsp
 *
 * @author Nikolay Polegaev
 * @version 1.1 18.09.2021
 */
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession s = req.getSession();
        User user = (User) s.getAttribute("user");
        if (user != null) {
            req.setAttribute("user", user);
            req.setAttribute("p", new ArrayList<>(PsqlStore.instOf().findTodayPosts()));
            req.setAttribute("c", new ArrayList<>(PsqlStore.instOf().findTodayCandidates()));
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Пользователь не авторизован");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
