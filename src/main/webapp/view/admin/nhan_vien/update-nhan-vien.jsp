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
        <form action="/nhan-vien/update/${ nhanVien.id }"
                   method="post" >
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" value="${ nhanVien.ma}">
                </div>
                <div class="col-6">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" value="${ nhanVien.ho}">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" value="${ nhanVien.tenDem }">
                </div>
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" value="${ nhanVien.ten }">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Số điện thoại</label>
                    <input type="tel" class="form-control" name="sdt" value="${ nhanVien.sdt }">
                </div>
                <div class="col-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" value="${ nhanVien.ngaySinh }">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" value="${ nhanVien.diaChi }">
                </div>
                <div class="col-6">
                    <label class="form-label">Giới tính</label>
                    <input type="radio" name="gioiTinh" value="1" ${ nhanVien.gioiTinh == "1" ? "checked" : "" } checked>Nam
                    <input type="radio" name="gioiTinh" value="0" ${ nhanVien.gioiTinh == "0" ? "checked" : "" } >Nữ
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="password" value="${ nhanVien.password }">
                </div>
                <div class="col-6">
                    <label class="form-label">Trạng Thái</label>
                    <input type="radio" name="trangThai" value="0" ${ nhanVien.trangThai == "0" ? "checked" : "" } checked> Hoạt động
                    <input type="radio" name="trangThai" value="1" ${ nhanVien.trangThai == "1" ? "checked" : "" } > Không hoạt động
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Chức vụ</label>
                    <select name="chucVu">
                        <c:forEach items="${ chucVus }" var="cv">
                            <option value="${cv.id}" ${cv.id == nhanVien.chucVu.id ? 'selected="selected"' : ''}> ${cv.tenChucVu} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label class="form-label">Cửa hàng</label>
                    <select name="cuaHang">
                        <c:forEach items="${ cuaHangs }" var="ch">
                            <option value="${ch.id}" ${ch.id == nhanVien.cuaHang.id ? 'selected="selected"' : ''}> ${ch.tenCuaHang} </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3" style="justify-content: center">
                <button class="btn btn-success" type="submit">Update</button>
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