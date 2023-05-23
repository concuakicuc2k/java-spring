<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h3 style="text-align: center;">Thông Tin Chi Tiết</h3>
</header>
<main class="container">
    <section>
        <div class="row mt-4">
            <div class="col-6">
                <label>Mã</label>
                <span>${ nhanVien.ma }</span>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <span>${ nhanVien.ho }</span>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Tên đệm</label>
                <span>${ nhanVien.tenDem }</span>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <span>${ nhanVien.ten }</span>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Giới tính</label>
                <span>${ nhanVien.gioiTinh }</span>
            </div>
            <div class="col-6">
                <label>Ngày sinh </label>
                <span>${ nhanVien.ngaySinh }</span>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Địa chỉ</label>
                <span>${ nhanVien.diaChi }</span>
            </div>
            <div class="col-6">
                <label>Số điện thoại </label>
                <span>${ nhanVien.sdt }</span>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Mật khẩu</label>
                <span>${ nhanVien.password }</span>
            </div>
            <div class="col-6">
                <label>Trạng thái </label>
                <span>${ nhanVien.trangThai }</span>
            </div>
        </div>
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
