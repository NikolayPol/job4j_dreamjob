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
 * @version 1.1 17.09.2021
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        File downloadFile = null;
        for (File file : Objects.requireNonNull(new File("c:\\images\\").listFiles())) {
            if (name.equals(file.getName())) {
                downloadFile = file;
                break;
            }
        }
        //1. Мы выставляем заголовок ответа в протоколе.
        // Таким образом мы сообщаем браузеру, что будем отправлять файл.
        //resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=\""
                + Objects.requireNonNull(downloadFile).getName() + "\"");
        //2. Открываем поток и записываем его в выходной поток servlet.
        try (FileInputStream stream = new FileInputStream(downloadFile)) {
            resp.getOutputStream().write(stream.readAllBytes());
        }
    }

}
