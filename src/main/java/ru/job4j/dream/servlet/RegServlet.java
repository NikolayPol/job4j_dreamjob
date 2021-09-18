package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс RegServlet регистрирует нового пользователя.
 * Сохраняет его в базу данных.
 *
 * @author Nikolay Polegaev
 * @version 1.0 18.09.2021
 */
public class RegServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setId(0);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        PsqlStore.instOf().save(user);
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
