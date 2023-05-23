<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
    <h3 style="text-align: center;">Thêm</h3>
</header>
<main class="container">
    <section>
        <form:form action="/cua-hang/add"
                 method="POST" modelAttribute="cuaHangViewModel">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <form:input path="ma" />
                    <form:errors path="ma" class="text-danger" style="color:red"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên</label>
                    <form:input path="ten" />
                    <form:errors path="ten" class="text-danger" style="color:red"/>
                </div>
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <form:input path="diaChi" />
                    <form:errors path="diaChi" class="text-danger" style="color:red"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <form:select name="quocGia" path="quocGia">
                        <form:option value="vn">Việt Nam</form:option>
                        <form:option value="en">Anh</form:option>
                    </form:select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <form:select name="thanhPho" path="thanhPho">
                        <form:option value="hanoi">Hà Nội</form:option>
                        <form:option value="london">London</form:option>
                    </form:select>
                </div>
            </div>
            <div class="row mt-3">
                <button class="btn btn-success col-1 m-3" >
                    Add
                </button>
            </div>
        </form:form>
    </section>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
