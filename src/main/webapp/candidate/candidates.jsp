<%--candidates.jsp--%>
<%--HTML в выводом Кандидатов в виде карточек со скриплетом--%>
<%--  @author Nikolay Polegaev.--%>
<%--  @version 4.0 17.09.2021--%>

<%--Импоритруем java классы--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.store.Store" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="java.util.Collection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Работа мечты</title>
</head>
<body>
<div class="container pt-3">

    <div class="row">
        <%--Сделаем таблицу в виде карточек card-body--%>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Кандидаты
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Позиция кандидата</th>
                        <th scope="col">Фото</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="candidate" items="${cands}" varStatus="status">
                        <tr valign="top">

                            <td>
                                    <%--Добавили иконку в таблицу и ссылку на страницу edit--%>
                                <a href="<%=request.getContextPath()%>/candidate/edit.jsp?id=${candidate.id}">
                                    <i class="fa fa-edit mr-3">
                                    </i>
                                </a>
                                    <%--Имя кандидата--%>
                                <a>${candidate.name}</a>

                            </td>

                            <td>
                                    <%--Фото кандидата--%>
                                <a>
                                    <img src="<c:url value='/download?name=${candidate.id}.jpg'/>" width="100px"
                                         height="100px"/>
                                </a>

                                    <%--Скачать фото кандидата--%>
                                <a href="<c:url value='/download?name=${candidate.id}.jpg'/>">Download</a>

                                    <%--Кнопка добавить--%>
                                <a href="<%=request.getContextPath()%>/upload.jsp?id=${candidate.id}">
                                    Добавить
                                </a>
                                    <%--Кнопка удалить--%>
                                <a href="<%=request.getContextPath()%>/delete?id=${candidate.id}">
                                    Удалить
                                </a>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>

                    <%--                    <tbody>--%>
                    <%--                    &lt;%&ndash;Выводим кандидатов из класса Store&ndash;%&gt;--%>
                    <%--                    <% for (Candidate can : (Collection<Candidate>) request.getAttribute("cands")) { %>--%>
                    <%--                    <%String id = String.valueOf(can.id+".jpg");%>--%>
                    <%--                    <tr>--%>
                    <%--                        <td>--%>
                    <%--                            &lt;%&ndash;Добавили иконку в таблицу и ссылку на страницу edit&ndash;%&gt;--%>
                    <%--                            <a href="<%=request.getContextPath()%>/candidate/edit.jsp?id=<%=can.getId()%>">--%>
                    <%--                                <i class="fa fa-edit mr-3">--%>
                    <%--                                </i>--%>
                    <%--                            </a>--%>
                    <%--                            &lt;%&ndash;Имя кандидата&ndash;%&gt;--%>
                    <%--                            <%= can.getName() %>--%>
                    <%--                            &lt;%&ndash;Фото кандидата&ndash;%&gt;--%>
                    <%--                            <img src="<c:url value='/download?name=${can.id}'/>" width="100px" height="100px"/>--%>
                    <%--                            &lt;%&ndash;Скачать фото кандидата&ndash;%&gt;--%>
                    <%--                            <a1 href="<c:url value='/download?name=${"1.jpg"}'/>">Download</a1>--%>

                    <%--                            &lt;%&ndash;Кнопка добавить&ndash;%&gt;--%>
                    <%--                            <a href="<%=request.getContextPath()%>/upload.jsp?id=<%=can.getId()%>">--%>
                    <%--                                Добавить--%>
                    <%--                            </a>--%>
                    <%--                            &lt;%&ndash;Кнопка удалить&ndash;%&gt;--%>
                    <%--                            <a href="<%=request.getContextPath()%>>">--%>
                    <%--                                Удалить--%>
                    <%--                            </a>--%>
                    <%--                        </td>--%>
                    <%--                    </tr>--%>
                    <%--                    <% } %>--%>
                    <%--                    </tbody>--%>

                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
