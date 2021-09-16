package ru.job4j.dream.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Класс DownloadServlet скачавает файл с сервера.
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.09.2021
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        File users = null;
        for (File file : Objects.requireNonNull(new File("c:\\images\\").listFiles())) {
            if ("users.txt".equals(file.getName())) {
                users = file;
                break;
            }
        }
        try (FileInputStream stream = new FileInputStream(Objects.requireNonNull(users))) {
            resp.getOutputStream().write(stream.readAllBytes());
            //Чтобы указать, что сервер отправляет файл нужно становить тип данных.
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=\""
                    + users.getName() + "\"");
        }
    }

}
