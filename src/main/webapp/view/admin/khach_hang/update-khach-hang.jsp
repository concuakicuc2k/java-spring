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
        <form:form action="/khach-hang/update/${ khachHang.id }"
                   method="post" modelAttribute="khachHangViewModel">
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="ma">Mã</form:label>
                    <form:input path="ma" value="${ khachHang.ma}"  cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="ho">Họ</form:label>
                    <form:input path="ho" value="${ khachHang.ho }" cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="tenDem">Tên đệm</form:label>
                    <form:input path="tenDem" value="${ khachHang.tenDem }" cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="ten">Tên</form:label>
                    <form:input path="ten" value="${ khachHang.ten}" cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="sdt">Số điện thoại</form:label>
                    <form:input path="sdt" type="tel" value="${ khachHang.sdt }" cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="ngaySinh">Ngày sinh</form:label>
                    <form:input path="ngaySinh" type="date" value="${ khachHang.ngaySinh}" cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="diaChi">Địa chỉ</form:label>
                    <form:input path="diaChi" value="${ khachHang.diaChi}" cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="password">Mật khẩu</form:label>
                    <form:password path="password" value="${ khachHang.password}" cssClass="form-control" ></form:password>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Quốc gia</label>
                    <form:select name="quocGia" path="quocGia">
                        <option value="vn" ${khachHang.quocGia  == "vn" ? "selected" : "" } >Việt Nam</option>
                        <option value="en" ${khachHang.quocGia  == "en" ? "selected" : "" } >Anh</option>
                    </form:select>
                </div>
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <form:select name="thanhPho" path="thanhPho">
                        <option value="hanoi" ${khachHang.thanhPho  == "hanoi" ? "selected" : "" }>Hà Nội</option>
                        <option value="london" ${khachHang.thanhPho  == "london" ? "selected" : "" }>London</option>
                    </form:select>
                </div>
            </div>
            <div class="row mt-3">
                    <form:errors path="*" cssClass="text-danger" ></form:errors>
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