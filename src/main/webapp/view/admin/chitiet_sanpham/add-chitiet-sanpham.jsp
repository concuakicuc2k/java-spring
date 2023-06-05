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
        <form:form action="/chitiet-sp/add"
                   method="POST" modelAttribute="chiTietSanPhamViewModel">

            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="mauSac">Màu sắc</form:label>
                    <form:select path="mauSac">
                        <c:forEach items="${ mauSacs }" var="ms">
                            <form:option value="${ms.id}">${ms.tenMauSac}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="col-6">
                    <form:label path="sanPham">Sản phẩm</form:label>
                    <select name="sanPham">
                        <c:forEach items="${ sanPhams }" var="sp">
                            <option value="${sp.id}">${sp.tenSanPham}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="dongSP">Dòng sản phẩm</form:label>
                    <form:select path="dongSP">
                        <c:forEach items="${ dongSPS }" var="dsp">
                            <form:option value="${dsp.id}">${dsp.tenDongSP}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="col-6">
                    <form:label path="nsx">Nhà sản xuất</form:label>
                    <select name="nsx">
                        <c:forEach items="${ nsxList }" var="n">
                            <option value="${n.id}">${n.tenNSX}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="namBH">Năm bảo hành</form:label>
                    <form:input path="namBH" cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="soLuongTon">Số lượng tồn</form:label>
                    <form:input path="soLuongTon"  cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="giaNhap">Giá nhập</form:label>
                    <form:input path="giaNhap" cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="giaBan">Giá bán</form:label>
                    <form:input path="giaBan" cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="moTa">Mô tả</form:label>
                    <form:textarea path="moTa" cssClass="form-control" ></form:textarea>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:errors path="*" cssClass="text-danger" ></form:errors>
                </div>
            </div>

            <div class="row mt-3">
                <button class="btn btn-success col-1 m-3" type="submit">
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
