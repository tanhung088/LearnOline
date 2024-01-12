<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Employee</title>
        <!-- Import CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

        <!-- Import JS -->
        <script src="https://code.jquery.com/jquery-3.7.0.js"
        integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
                integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
    </head>

    <body>
        <div class="container">
            <div class="col-12">
                <div class="col-12">
                    <h3>List Employee</h3>
                </div>
                <div class="col-12 text-right mt-2">
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <a href="Emps?action=create" class="btn btn-primary me-md-2" type="button">Create User</a>
                    </div>
                </div>

                <div class="col-12 mt-2">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>EMail</th>
                                <th>Image</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <c:choose>
                            <c:when test="${not empty emps}">
                                <tbody>
                                    <c:forEach items="${emps}" var="emp">
                                        <tr
                                            <td>${emp.getId()}</td>
                                            <td>${emp.getName()}</td>
                                            <td>${emp.getEmail()}</td>
                                            <td>
                                                <img src="/luyenthi1/${emp.getImage()}" />
                                            </td>
                                            <td>
                                            <td>
                                                <a class="btn btn-primary edit" href="javascript:void(0);" onClick="fncEdit('${user.getId()}')">Edit</a>
                                                <button class="btn btn-danger delete" href="javascript:void(0);" onClick="fncDelete('${user.getId()}')" data-id="'${user.getId()}'" >Delete</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </c:when>
                            <c:otherwise>
                                <p>Not Data</p>
                            </c:otherwise>
                        </c:choose>
                    </table>
                </div>
            </div>

        </div>
    </body>

</html>