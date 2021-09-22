//package ru.job4j.dream.servlet;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import ru.job4j.dream.model.Candidate;
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
// * Класс CandidateServletTest тестирует класс CandidateServlet
// * с использованием библиотеки Mockito.
// *
// * @author Nikolay Polegaev
// * @version 1.0 22.09.2021
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(PsqlStore.class)
//public class CandidateServletTest {
//    @Test
//    public void whenDoGetThenForwardToJsp() throws ServletException, IOException {
//        Store store = MemStore.instOf();
//        String path = "/candidate/candidates.jsp";
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
//        new CandidateServlet().doGet(req, resp);
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
//        when(req.getParameter("name")).thenReturn("SuperJunior Java");
//
//        new CandidateServlet().doPost(req, resp);
//
//        Candidate result = (Candidate) store.findAllCandidates().toArray()[3];
//        Assert.assertEquals(result.getName(), "SuperJunior Java");
//        verify(resp).sendRedirect(req.getContextPath() + "/candidates.do");
//
//    }
//}