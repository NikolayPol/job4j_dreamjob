package ru.job4j.dream.servlet;

/**
 * Класс CandidateServletTest тестирует класс CandidateServlet
 * с использованием библиотеки Mockito.
 *
 * @author Nikolay Polegaev
 * @version 1.1 02.10.2021
 *
@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class CandidateServletTest {
    @Test
    public void whenDoGetThenForwardToJsp() throws ServletException, IOException {
        Store store = MemStore.instOf();
        String path = "/candidate/candidates.jsp";

        PowerMockito.mockStatic(PsqlStore.class);
        when(PsqlStore.instOf()).thenReturn(store);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getSession()).thenReturn(session);
        when(req.getRequestDispatcher(path)).thenReturn(dispatcher);

        new CandidateServlet().doGet(req, resp);

        verify(req, times(1)).getRequestDispatcher(path);
        verify(req, times(1)).getSession();
        verify(dispatcher).forward(req, resp);
    }

    @Test
    public void whenDoPostThenCreatePost() throws IOException {
        Store store = MemStore.instOf();

        PowerMockito.mockStatic(PsqlStore.class);
        when(PsqlStore.instOf()).thenReturn(store);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        when(req.getParameter("id")).thenReturn("4");
        when(req.getParameter("name")).thenReturn("SuperJunior Java");
        when(req.getParameter("city")).thenReturn("3");

        new CandidateServlet().doPost(req, resp);

        Candidate result = (Candidate) store.findAllCandidates().toArray()[3];
        Assert.assertEquals(result.getName(), "SuperJunior Java");
        verify(resp).sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
 */