<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html> 
<html lang="ko">
<head>
	<meta charset="utf-8">
	<title>등록</title>
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="/assets/plugins/line-icons/line-icons.css">
    <link rel="stylesheet" href="/assets/plugins/font-awesome/css/font-awesome.min.css">

    <!-- CSS Page Style -->    
    <link rel="stylesheet" href="/assets/css/pages/blog.css">

    <!-- CSS Theme -->    
    <link rel="stylesheet" href="/assets/css/theme-colors/default.css">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="/assets/css/custom.css">
   <script src="//code.jquery.com/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<!--=== Header ===-->    
    <div class="header">
        <!-- Topbar -->
        <div class="topbar">
            <div class="container">
                <!-- Topbar Navigation -->
                <ul class="loginbar pull-right">
                    <li>
                        <i class="fa fa-globe"></i>
                        <a>Languages</a>
                        <ul class="languages">
                            <li class="active">
                                <a href="#">English <i class="fa fa-check"></i></a> 
                            </li>
                            <li><a href="#">Spanish</a></li>
                            <li><a href="#">Russian</a></li>
                            <li><a href="#">German</a></li>
                        </ul>
                    </li>
                    <li class="topbar-devider"></li>   
                    <li><a href="page_faq.html">Help</a></li>  
                    <li class="topbar-devider"></li>   
                    <li><a href="page_login.html">Login</a></li>   
                </ul>
                <!-- End Topbar Navigation -->
            </div>
        </div>
        <!-- End Topbar -->
        <!-- Navbar -->
        <div class="navbar navbar-default mega-menu" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="fa fa-bars"></span>
                    </button>
                    <a class="navbar-brand" href="/">
                        <img id="logo-header" src="/assets/img/oneday-logo.png" alt="Logo">
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-responsive-collapse">
                    <ul class="nav navbar-nav">
                        <!-- Blog -->
                        <li class="dropdown active">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                                Class
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="blog_page.html">Blog Page</a></li>
                                <li><a href="blog_large.html">Blog Large</a></li>
                                <li><a href="blog_medium.html">Blog Medium</a></li>
                                <li class="active"><a href="blog_full_width.html">Blog Full Width</a></li>
                            </ul>
                        </li>
                        <!-- End Blog -->
                        <!-- Search Block -->
                        <li>
                            <i class="search fa fa-search search-btn"></i>
                            <div class="search-open">
                                <div class="input-group animated fadeInDown">
                                    <input type="text" class="form-control" placeholder="Search">
                                    <span class="input-group-btn">
                                        <button class="btn-u" type="button">Go</button>
                                    </span>
                                </div>
                            </div>    
                        </li>
                        <!-- End Search Block -->
                    </ul>
                </div><!--/navbar-collapse-->
            </div>    
        </div>            
        <!-- End Navbar -->
    </div>
    <!--=== End Header ===--> 
    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">문의하기</h1>
            <ul class="pull-right breadcrumb">
                <li><a href="index.html">공지사항</a></li>
                <li><a href="">자주 묻는 질문</a></li>
                <li class="active">문의하기</li>
            </ul>
        </div>
    </div><!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->
    
    <div class="container content blog-full-width">	    
	<form role="form" action="modifyPage" method="post">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">BNO</label>
				<input type="text" name="bno" class="form-control" value="${boardVO.bno}" readonly="readonly"> 			
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label>
				<input type="text" name="title" class="form-control" value="${boardVO.title}"> 			
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">내용</label>
				<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea> 			
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				<input type="text" name="writer" class="form-control" value="${boardVO.writer}"> 			
			</div>
		</div>
	</form>
	
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="submit" class="btn btn-warning">CANCEL</button>
	</div>
	</div>
<script>
	var result = "${msg}";
	
	if(result == "success") {
		alert("정상적으로 등록되었습니다."); 
	}  

	
	$(function() {
		var formObj = $("form[role='form']");
		
		$(".btn-warning").on("click", function() {
			self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
		});
		
		$(".btn-primary").on("click", function() {
			formObj.submit();
		});		
	});
</script>
</div>
</body>
</html>