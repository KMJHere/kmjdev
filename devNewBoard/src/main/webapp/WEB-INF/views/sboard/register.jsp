<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" href="/Unify1.6/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/Unify1.6/assets/css/style.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="/Unify1.6/assets/plugins/line-icons/line-icons.css">
    <link rel="stylesheet" href="/Unify1.6/assets/plugins/font-awesome/css/font-awesome.min.css">

    <!-- CSS Page Style -->    
    <link rel="stylesheet" href="/Unify1.6/assets/css/pages/blog.css">

    <!-- CSS Theme -->    
    <link rel="stylesheet" href="/Unify1.6/assets/css/theme-colors/default.css">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="/Unify1.6/assets/css/custom.css">
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
                    <a class="navbar-brand" href="index.html">
                        <img id="logo-header" src="/Unify1.6/assets/img/oneday-logo.png" alt="Logo">
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
    <div class="container content blog-full-width">	       
		<form role="form" method="post">
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					<input type="text" name='title' class="form-control" placeholder="Enter Title">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Content</label>
					<textarea class="form-control" name="content" rows="3" placeholder="Enter"></textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Writer</label>
					<input type="text" name='writer' class="form-control" placeholder="Enter Writer">
				</div>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>