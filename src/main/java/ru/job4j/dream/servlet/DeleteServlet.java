package ru.job4j.dream.servlet;

import ru.job4j.dream.store.Store;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Класс DeleteServlet удаляет кандидата
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.09.2021
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //удаляем кандидата из базы
        String id = req.getParameter("id");
        Store.instOf().deleteCandidate(Integer.parseInt(id));

        //удаляем картинку из базы
        String name = req.getParameter("id") + ".jpg";
        for (File file : Objects.requireNonNull(new File("C:\\images\\").listFiles())) {
            if (name.equals(file.getName())) {
                if (file.delete()) {
                    //переходим на страницу с кандидатами
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/index.do");
                    dispatcher.forward(req, resp);
                }
            }
        }
        //переходим на страницу с кандидатами
        RequestDispatcher dispatcher = req.getRequestDispatcher("/candidates.do");
        dispatcher.forward(req, resp);
    }
}
