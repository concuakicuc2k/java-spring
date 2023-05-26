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
    <h3 style="text-align: center;">Sửa</h3>
</header>
<main class="container">
    <section>
        <form:form action="/nhan-vien/update/${ nhanVien.id }"
                   method="post" modelAttribute="nhanVienViewModel">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <form:input path="ma" value="${nhanVien.ma}"/>
                    <form:errors path="ma" class="text-danger" style="color:red"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Họ</label>
                    <form:input path="ho" value="${nhanVien.ho}" />
                    <form:errors path="ho" class="text-danger" style="color:red"/>
                </div>
                <div class="col-6">
                    <label>Tên đệm</label>
                    <form:input path="tenDem" value="${nhanVien.tenDem}" />
                    <form:errors path="tenDem" class="text-danger" style="color:red"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên</label>
                    <form:input path="ten" value="${nhanVien.ten}" />
                    <form:errors path="ten" class="text-danger" style="color:red"/>
                </div>
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <form:input path="ngaySinh" value="${nhanVien.ngaySinh}" />
                    <form:errors path="ngaySinh" class="text-danger" style="color:red"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <form:input path="sdt" value="${nhanVien.sdt}" />
                    <form:errors path="sdt" class="text-danger" style="color:red"/>
                </div>
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <form:input path="diaChi" value="${nhanVien.diaChi}" />
                    <form:errors path="diaChi" class="text-danger" style="color:red"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Email</label>
                    <form:input path="email" value="${nhanVien.email}" />
                    <form:errors path="email" class="text-danger" style="color:red"/>
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <form:password name="password" path="password" value="${nhanVien.password}"/>
                    <form:errors path="password" class="text-danger" style="color:red"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Giới tính</label>
                    <form:radiobutton path="gioiTinh" value="1" label="Nam" />
                    <form:radiobutton path="gioiTinh" value="0" label="Nữ" />
                    <form:errors path="gioiTinh" class="text-danger" style="color:red"/>
                </div>
                <div class="col-6">
                    <label>Trạng thái</label>
                    <form:radiobutton path="trangThai" value="1" label="Hoạt động" />
                    <form:radiobutton path="trangThai" value="0" label="Không hoạt động" />
                    <form:errors path="trangThai" class="text-danger" style="color:red"/>
                </div>
            </div>

            <div class="row mt-3" style="justify-content: center">
                <button class="btn btn-success col-1 m-3" type="submit">
                    update
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