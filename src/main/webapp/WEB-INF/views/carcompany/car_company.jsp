<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap, java.util.ArrayList, com.yojulab.study_springboot.utils.Paginations" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap 5 Template</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
</head>
<body>
<!-- Menu -->
<%@ include file="/WEB-INF/views/commons/header.jsp" %>

<% HashMap params = (HashMap) request.getAttribute("params");
    HashMap result = (HashMap) request.getAttribute("result"); %>
<!-- Main Content -->
<form action="" method="">
    <div class="container mt-4">
        <div class="row">
            <div class="col-md-8">

                <h2>Table</h2>
                <table class="table w-50">
                    <thead>
                    <tr>
                        <th>회사이름</th>
                        <th>자동차이름</th>
                        <th>연식</th>
                        <th>옵션 갯수</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody id="carTableBody">
                    <% ArrayList resultList = (ArrayList) result.get("resultList");
                        for (int i = 0; i < resultList.size(); i = i + 1) {
                            HashMap record = (HashMap) resultList.get(i); %>
                    <tr>
                        <td>
                            <a href="/carcompany/read/<%= record.get("CI_PK") %>"><%= record.get("회사이름") %></a>
                        </td>
                        <td>
                            <%= record.get("자동차이름") %>
                        </td>
                        <td>
                            <%= record.get("연식") %>
                        </td>
                        <td>
                            <%= record.get("옵션 갯수") %>
                        </td>
                        <td>
                            <button formaction='/carcompany/deleteAtList/<%= record.get("CI_PK") %>'
                                    formmethod="post">Del
                            </button>
                        </td>
                    </tr>
                    <% } %>
                    <!-- Empty -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>

<!-- Footer -->
<%@ include file="/WEB-INF/views/commons/footer.jsp" %>
</body>
</html>
