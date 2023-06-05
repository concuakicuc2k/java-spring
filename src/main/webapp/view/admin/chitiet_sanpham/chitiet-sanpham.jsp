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
    <h3 style="text-align: center;">Quản Lý chi tiết sản phẩm</h3>
    <section>
        <a href="/chitiet-sp/view-add" class="btn btn-info">Add</a>
    </section>
</header>
<main>
    <section>
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th scope="col">Màu sắc</th>
                <th scope="col">Sản Phẩm</th>
                <th scope="col">Dòng Sản Phẩm</th>
                <th scope="col">Nhà Sản Xuất</th>
                <th scope="col">Năm BH</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Số lượng tồn</th>
                <th scope="col">Giá nhập</th>
                <th scope="col">Giá bán</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listCTSP.content }" var="l">
                <tr>
                    <td> ${ l.mauSac.tenMauSac } </td>
                    <td> ${ l.sanPham.tenSanPham } </td>
                    <td> ${ l.dongSP.tenDongSP } </td>
                    <td> ${ l.nsx.tenNSX } </td>
                    <td> ${ l.namBH } </td>
                    <td> ${ l.moTa } </td>
                    <td> ${ l.soLuongTon } </td>
                    <td> ${ l.giaNhap } </td>
                    <td> ${ l.giaBan } </td>
                    <td>
                        <a href="/chitiet-sp/view-update/${l.id}" class="btn btn-success">Update</a>
                        <a href="/chitiet-sp/delete/${l.id}" class="btn btn-danger">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${ listCTSP.totalPages -1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/nhan-vien/hien-thi?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count }
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
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