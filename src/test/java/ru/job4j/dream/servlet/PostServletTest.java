//package ru.job4j.dream.servlet;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import ru.job4j.dream.model.Post;
//import ru.job4j.dream.store.MemStore;
//import ru.job4j.dream.store.PsqlStore;
//import ru.job4j.dream.store.Store;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//import static org.mockito.Mockito.*;
//import static org.powermock.api.mockito.PowerMockito.when;
//
///**
// * Класс PostServletTest тестирует класс PostServlet
// * с использованием библиотеки Mockito.
// * 1) Чтобы запуск теста производился за счет библиотеки PowerMock,
// * необходимо указать аннотации ниже:
// * RunWith(PowerMockRunner.class)
// * PrepareForTest(PsqlStore.class)
// * 2) Сначала мы создаем хранилище для работы с памятью:
// * Store<Post> store = MemStore.instOf();
// * 3) Далее мы "глушим" статику. Первый метод позволяет создать объект,
// * не подтягивания статические зависимости. Второй указывает, что при вызове
// * статического метода для получения хранилища нужно вернуть хранилище MemStore:
// * PowerMockito.mockStatic(PsqlStore.class);
// * PowerMockito.when(PsqlStore.getStore()).thenReturn(store);
// * 4) Создаем заглушки для ответа и запроса:
// * HttpServletRequest req = mock(HttpServletRequest.class);
// * HttpServletResponse resp = mock(HttpServletResponse.class);
// * 5) Указываем, что возвращать при вызове методов заглушки запроса:
// * PowerMockito.when(req.getParameter("id")).thenReturn("0");
// * PowerMockito.when(req.getParameter("name")).thenReturn("n");
// * PowerMockito.when(req.getParameter("description")).thenReturn("d");
// * 6) Выполняем запрос:
// * new PostServlet().doPost(req, resp);
// * 7) Проверяем результат:
// * Post result = store.findAll().iterator().next();
// * Assert.assertThat(result.getName(), Is.is("n"));
// * Assert.assertThat(result.getDescription(), Is.is("d"));
// *
// * verify-проверка.
// * verify(req, times(1)).getRequestDispatcher(path); - проверяет,
// * что вызов 1 раз request установит
// * у объекта RequestDispatcher параметр path - "/post/posts.jsp".
// *
// * verify(req, times(1)).getSession(); - проверка,
// * что вызывается объект сессии 1 раз.
// *
// * verify(dispatcher).forward(req, resp); - проверка, что
// * у dispatcher вызван метод forward с объектами req и resp.
// *
// * verify(resp).sendRedirect(req.getContextPath() + "/posts.do"); - проверка, что
// * redirect вызывается с заданным адресом.
// *
// * @version 1.0 22.09.2021
// * @author Nikolay Polegaev
// */
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(PsqlStore.class)
//public class PostServletTest {
//    @Test
//    public void whenDoGetThenForwardToJsp() throws ServletException, IOException {
//        Store store = MemStore.instOf();
//        String path = "/post/posts.jsp";
//
//        PowerMockito.mockStatic(PsqlStore.class);
//        when(PsqlStore.instOf()).thenReturn(store);
//
//        HttpServletRequest req = mock(HttpServletRequest.class);
//        HttpServletResponse resp = mock(HttpServletResponse.class);
//        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
//        HttpSession session = mock(HttpSession.class);
//
//        when(req.getSession()).thenReturn(session);
//        when(req.getRequestDispatcher(path)).thenReturn(dispatcher);
//
//        new PostServlet().doGet(req, resp);
//
//        verify(req, times(1)).getRequestDispatcher(path);
//        verify(req, times(1)).getSession();
//        verify(dispatcher).forward(req, resp);
//    }
//
//    @Test
//    public void whenDoPostThenCreatePost() throws IOException {
//        Store store = MemStore.instOf();
//
//        PowerMockito.mockStatic(PsqlStore.class);
//        when(PsqlStore.instOf()).thenReturn(store);
//
//        HttpServletRequest req = mock(HttpServletRequest.class);
//        HttpServletResponse resp = mock(HttpServletResponse.class);
//
//        when(req.getParameter("id")).thenReturn("4");
//        when(req.getParameter("name")).thenReturn("SuperJunior Java Job");
//
//        new PostServlet().doPost(req, resp);
//
//        Post result = (Post) store.findAllPosts().toArray()[3];
//        Assert.assertEquals(result.getName(), "SuperJunior Java Job");
//        verify(resp).sendRedirect(req.getContextPath() + "/posts.do");
//    }
//}