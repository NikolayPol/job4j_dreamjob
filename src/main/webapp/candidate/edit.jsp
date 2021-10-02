<%--edit.jsp--%>
<%--Страница с формой ввода для нового кандидата--%>
<%--@author Nikolay Polegaev--%>
<%--@version 3.3 02.10.2021--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.store.MemStore" %>
<%@ page import="ru.job4j.dream.model.Post" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>
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
<%--    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"--%>
<%--            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"--%>
<%--            crossorigin="anonymous"></script>--%>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script>
        $(document).ready(function () {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/dreamjob/cities",
                dataType: "json",
                success: function (data) {
                    let cities = "";
                    for (let i = 0; i < data.length; i++) {
                        cities += "<option value=" + data[i]['id'] + ">" + data[i]['name'] + "</option>";
                    }
                    $('#city').html(cities);
                }
            })
        })

        function validate() {
            let res = true;
            let message = "Следующие поля не заполены:" + "\n";
            if ($('#name').val() === "") {
                message = message + "Имя" + "\n";
                res = false;
            }
            if (!res) {
                alert(message);
            }
            return res;
        }
    </script>
    <title>Работа мечты</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Candidate can = new Candidate(0, "", 0);
    if (id != null) {
        can = PsqlStore.instOf().findCandById(Integer.parseInt(id));
    }
%>
<div class="container pt-3">
    <div class="row">

        <div class="row">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Вакансии</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Кандидаты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Добавить вакансию</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.jsp">Добавить кандидата</a>
                </li>
                <c:if test="${user != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/logout.do"> <c:out
                                value="${user.name}"/> | Выйти</a>
                    </li>
                </c:if>
                <c:if test="${user == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> | Войти</a>
                    </li>
                </c:if>
            </ul>
        </div>


        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новый кандидат.
                <% } else { %>
                Редактирование кандидата.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=can.getId()%>" method="post">
                    <div class="form-group">
                        <label for="name">Имя</label>
                        <input type="text" class="form-control" id="name" name="name" value="<%=can.getName()%>">
                    </div>
                    <div class="form-group">
                        <label for="city">Город</label>
                        <select class="custom-select" id="city" name="city"></select>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="validate()">
                        Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
