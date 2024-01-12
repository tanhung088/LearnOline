<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.7.0.js"
integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit Form</h1>
        <form action="products?action=edit" method="post" enctype="multipart/form-data" class="align-items-center">
            <div class="col-12">
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" value="${data.getId()}" class="form-control" name="id" id="id" />
                    <div class="invalid-feedback"></div>
                </div>
            </div>
            <div class="col-12">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" value="${data.getProduct_name()}" class="form-control" name="name" id="name" />
                    <div class="invalid-feedback"></div>
                </div>
            </div>
            <div class="col-12">
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" value="${data.getPrice()}" class="form-control" name="price" id="price" />
                    <div class="invalid-feedback"></div>
                </div>
            </div>
            <div class="col-12">
                <div class="form-group">
                    <label>Image</label>
                    <img src="/luyenthi3${data.getImage()}" width="200px"/>
                </div>
            </div>        
            <div class="col-12">
                <div class="form-group">
                    <label>Update Image</label>
                    <input type="file" class="form-control" name="file" id="file"/>
                    <input name="image" id="image" hidden />
                    <div class="invalid-feedback"></div>
                </div>
            </div>
            <div class="mt-3 text-center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </body>
    <script>
            $(document).ready(function () {
                $('input[type=text]').on('keyup', () => {
                    $(this).closest('.form-group').find('.invalid-feedback').css("display", "none");
                    $(this).closest('.form-group').find('.invalid-feedback').removeClass("is-invalid")
                });
            <c:if test="${not empty errors}">
                <c:forEach items="${errors}" var="err">
                var pKey = "${err.key}";
                $("#" + pKey).closest('.form-group').find('.invalid-feedback').css("display", "block");
                $("#" + pKey).closest('.form-group').find('.invalid-feedback').text('${err.getValue()}');
                $("#" + pKey).closest('.form-group').find('.form-control').addClass('is-invalid');
                </c:forEach>
                $("#userModal").modal("show");
            </c:if>
            });
        </script>
</html>