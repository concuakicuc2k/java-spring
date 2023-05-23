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
<body class="container">
<header>
    <h3 style="text-align: center;">Quản Lý Nhân viên</h3>
    <section>
        <a href="/nhan-vien/view-add" class="btn btn-info " tabindex="-1" role="button"
           aria-disabled="true">Add</a>
    </section>
</header>
<main>
    <section>
        <table class="table table-striped mt-3">
            <thead class="table-primary">
                <tr>
                    <th>Mã</th>
                    <th>Họ</th>
                    <th>Tên đệm</th>
                    <th>Tên</th>
                    <th>Email</th>
                    <th>Ngày Sinh</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                    <th>Mật khẩu</th>
                    <th>Giới tính</th>
                    <th>Trạng thái</th>
                    <th colspan="2">Thao tác</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${ nhanViens }" var="l">
                <tr>
                    <td> ${ l.ma } </td>
                    <td> ${ l.ho } </td>
                    <td> ${ l.tenDem } </td>
                    <td> ${ l.ten } </td>
                    <td> ${ l.email } </td>
                    <td> ${ l.ngaySinh } </td>
                    <td> ${ l.sdt } </td>
                    <td> ${ l.diaChi } </td>
                    <td> ${ l.matKhau } </td>
                    <td> ${ l.gioiTinh == 1 ? "Nam" :"Nữ"  } </td>
                    <td> ${ l.trangThai == 1 ? "Hoạt động" : "Không hoạt động" } </td>
                    <td>
                        <a href="/nhan-vien/detail/${l.id}" class="btn btn-primary " tabindex="-1" role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/nhan-vien/view-update/${l.id}" class="btn btn-info " tabindex="-1" role="button"
                           aria-disabled="true">Update</a>
                        <a href="/nhan-vien/delete/${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                           aria-disabled="true">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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