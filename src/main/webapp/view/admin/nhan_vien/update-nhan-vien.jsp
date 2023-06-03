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
                    <form:label path="ma">Mã</form:label>
                    <form:input path="ma" value="${ nhanVien.ma}"  cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="ho">Họ</form:label>
                    <form:input path="ho" value="${ nhanVien.ho }" cssClass="form-control" ></form:input>
                    <form:errors path="ho" cssClass="text-danger" ></form:errors>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="tenDem">Tên đệm</form:label>
                    <form:input path="tenDem" value="${ nhanVien.tenDem }" cssClass="form-control" ></form:input>
                    <form:errors path="tenDem" cssClass="text-danger" ></form:errors>
                </div>
                <div class="col-6">
                    <form:label path="ten">Tên</form:label>
                    <form:input path="ten" value="${ nhanVien.ten}" cssClass="form-control" ></form:input>
                    <form:errors path="ten" cssClass="text-danger" ></form:errors>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="sdt">Số điện thoại</form:label>
                    <form:input path="sdt" type="tel" value="${ nhanVien.sdt }" cssClass="form-control" ></form:input>
                    <form:errors path="sdt" cssClass="text-danger" ></form:errors>
                </div>
                <div class="col-6">
                    <form:label path="ngaySinh">Ngày sinh</form:label>
                    <form:input path="ngaySinh" type="date" value="${ nhanVien.ngaySinh}" cssClass="form-control" ></form:input>
                    <form:errors path="ngaySinh" cssClass="text-danger" ></form:errors>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="diaChi">Địa chỉ</form:label>
                    <form:input path="diaChi" value="${ nhanVien.diaChi }" cssClass="form-control" ></form:input>
                    <form:errors path="diaChi" cssClass="text-danger" ></form:errors>
                </div>
                <div class="col-6">
                    <form:label path="gioiTinh">Giới tính</form:label>
<%--                    <form:radiobutton path="gioiTinh" value="1"/> <form:label path="gioiTinh" for="gioiTinh1"> Nam</form:label>--%>
<%--                    <form:radiobutton path="gioiTinh" value="0"/> <form:label path="gioiTinh" for="gioiTinh2">Nữ </form:label>--%>
                    <input type="radio" name="gioiTinh" value="1" ${ nhanVien.gioiTinh == "1" ? "checked" : "" } checked>Nam
                    <input type="radio" name="gioiTinh" value="0" ${ nhanVien.gioiTinh == "0" ? "checked" : "" } >Nữ
                </div>
            </div>
            <div class="row mt-3">
                <div class="row mt-3">
                    <div class="col-6">
                        <form:label path="password">Mật khẩu</form:label>
                        <form:password path="password" value="${ nhanVien.password }" cssClass="form-control" ></form:password>
                        <form:errors path="password" cssClass="text-danger" ></form:errors>
                    </div>
                </div>
                <div class="col-6">
                    <form:label path="trangThai">Trạng thái</form:label>
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