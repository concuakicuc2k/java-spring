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
    <h3 style="text-align: center;">Edit</h3>
</header>
<main class="container">
    <section>
        <form:form action="/chitiet-sp/update/${ chiTietSanPham.id }"
                   method="post" modelAttribute="chiTietSanPhamViewModel">

            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Màu sắc</label>
                    <select name="mauSac">
                        <c:forEach items="${ mauSacs }" var="ms">
                            <option value="${ms.id}" ${ms.id == chiTietSanPham.mauSac.id ? 'selected="selected"' : ''}> ${ms.tenMauSac} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                        <label class="form-label">Sản phẩm</label>
                        <select name="sanPham">
                            <c:forEach items="${ sanPhams }" var="sp">
                                <option value="${sp.id}" ${sp.id == chiTietSanPham.sanPham.id ? 'selected="selected"' : ''}> ${sp.tenSanPham} </option>
                            </c:forEach>
                        </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Dòng sản phẩm</label>
                    <select name="dongSP">
                        <c:forEach items="${ dongSPs }" var="dsp">
                            <option value="${dsp.id}" ${dsp.id == chiTietSanPham.dongSP.id ? 'selected="selected"' : ''}> ${dsp.tenDongSP} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label class="form-label">Nhà sản xuất</label>
                    <select name="nsx">
                        <c:forEach items="${ nsxList }" var="n">
                            <option value="${n.id}" ${n.id == chiTietSanPham.nsx.id ? 'selected="selected"' : ''}> ${n.tenNSX} </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="namBH">Năm bảo hành</form:label>
                    <form:input path="namBH" value="${ chiTietSanPham.namBH}" cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="soLuongTon">Số lượng tồn</form:label>
                    <form:input path="soLuongTon" value="${ chiTietSanPham.soLuongTon}"  cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="giaNhap">Giá nhập</form:label>
                    <form:input path="giaNhap" value="${ chiTietSanPham.giaNhap }" cssClass="form-control" ></form:input>
                </div>
                <div class="col-6">
                    <form:label path="giaBan">Giá bán</form:label>
                    <form:input path="giaBan" value="${ chiTietSanPham.giaBan }" cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:label path="moTa">Mô tả</form:label>
                    <form:input path="moTa" value="${ chiTietSanPham.moTa }" cssClass="form-control" ></form:input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <form:errors path="*" cssClass="text-danger" ></form:errors>
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
