<%-- 
    Document   : index
    Created on : Jul 13, 2024, 1:15:52 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
        <img src="<c:url value="http://localhost:8080/SpringSaleApp/dist/img/AdminLTELogo.png" />" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">Quản trị bãi đổ xe</span>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <s:authorize access="hasAnyRole('ADMIN')">

            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="http://localhost:8080/SpringSaleApp/dist/img/AdminLTELogo.png" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="<c:url value="/" />" class="d-block text-decoration-none ">
                        <s:authentication property="principal.username" />
                    </a >
                     <a  class="d-block text-decoration-none mt-2" href="<c:url value="/logout" />">
                    Đăng xuất
                </a>
                </div>
            </div>
        </s:authorize>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item has-treeview menu-open">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Dashboard
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="<c:url value="/"/>" class="nav-link">
                                <p>User</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value="/baido"/>" class="nav-link">
                                <p>Bãi đậu xe</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value="/khudoxeView"/>" class="nav-link">
                                <p>Khu đổ xe</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value="/chodoxe"/>" class="nav-link">
                                <p>Chổ đổ xe</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value="/chiTietKhuDoXeView"/>" class="nav-link">
                                <p>Chi tiết khu đổ xe</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value="/hoadon"/>" class="nav-link">
                                <p>Hóa đơn</p>
                            </a>
                        </li>
                    </ul>
                </li>
              

                <li class="nav-item has-treeview">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-chart-pie"></i>
                        <p>
                            Charts
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="<c:url value="/stats"/>" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Stats</p>
                            </a>
                        </li>
                    </ul>
                </li>

                
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>

    <!-- /.sidebar -->
</aside>
