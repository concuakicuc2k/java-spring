<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
        <form action="/nhan-vien/update/${ nhanVien.id }" method="post">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" class="form-control" name="ma" value="${nhanVien.ma}" />
                </div>
                <div class="col-6">
                    <label>Họ</label>
                    <input type="text" class="form-control"  name="ho" value="${nhanVien.ho}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên đệm</label>
                    <input type="text" name="tenDem" class="form-control" value="${nhanVien.tenDem}" />
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" value="${nhanVien.ten}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <input type="date" name="ngaySinh" class="form-control" value="${nhanVien.ngaySinh}" />
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <input type="tel" name="sdt" class="form-control" value="${nhanVien.sdt}" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <input type="text" name="diaChi" class="form-control" value="${nhanVien.diaChi}" />
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <input type="password" name="matKhau" class="form-control" />
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-6">
                    <label>Giới tính</label>
                    <select name="gioiTinh" class="form-select ">
                        <option value="1" ${nhanVien.gioiTinh == "1" ? "selected" : "" } >Nam</option>
                        <option value="0" ${nhanVien.gioiTinh  == "0" ? "selected" : "" } >Nữ</option>
                    </select>
                </div>
                <div class="col-6">
                    <label>Trạng thái</label>
                    <select name="trangThai" class="form-select ">
                        <option value="1" ${nhanVien.trangThai  == "1" ? "selected" : "" }>Hoạt động</option>
                        <option value="0" ${nhanVien.trangThai  == "0" ? "selected" : "" }>Không hoạt động</option>
                    </select>
                </div>
            </div>

            <div class="row mt-3" style="justify-content: center">
                <button class="btn btn-success col-1 m-3" type="submit">
                    update
                </button>
            </div>
        </form>
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