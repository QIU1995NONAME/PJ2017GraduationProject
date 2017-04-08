<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/Required/zui-1.6.0/css/zui.min.css" rel="stylesheet" />
<script src="/Required/zui-1.6.0/lib/jquery/jquery.js"></script>
<script src="/Required/zui-1.6.0/js/zui.min.js"></script>
<title>QP-Control</title>
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse-qpcontrol">
					<span class="sr-only">切换导航</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="./">QP-Control</a>
			</div>
			<div class="collapse navbar-collapse navbar-collapse-qpcontrol">
				<ul class="nav navbar-nav">
					<li><a href="mgr-hardware.jsp">站点管理</a></li>
					<li><a href="mgr-data.jsp">数据管理</a></li>
					<li><a href="mgr-back.jsp">后台管理</a></li>
					<li><a href="view-data.jsp">数据展示</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="help.jsp">帮助</a></li>
					<li><a href="about.jsp">关于</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">欢迎使用QP-Control！</div>
			<div class="panel-body">
				<div class="cards">
					<div class="col-md-4 col-sm-6 col-lg-2">
						<a class="card" href="mgr-hardware.jsp"><h1 align='center'>站点管理</h1></a>
					</div>
					<div class="col-md-4 col-sm-6 col-lg-2">
						<a class="card" href="mgr-data.jsp"><h1 align='center'>数据管理</h1></a>
					</div>
					<div class="col-md-4 col-sm-6 col-lg-2">
						<a class="card" href="mgr-back.jsp"><h1 align='center'>后台管理</h1></a>
					</div>
					<div class="col-md-4 col-sm-6 col-lg-2">
						<a class="card" href="view-data.jsp"><h1 align='center'>数据展示</h1></a>
					</div>
					<div class="col-md-4 col-sm-6 col-lg-2">
						<a class="card" href="help.jsp"><h1 align='center'>帮助</h1></a>
					</div>
					<div class="col-md-4 col-sm-6 col-lg-2">
						<a class="card" href="about.jsp"><h1 align='center'>关于</h1></a>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<i class="icon icon-github"></i> 
				<a href="https://github.com/QIU1995NONAME/Q2017_GraduationProject/tree/V0.00-dev">QP-Control Version 0.00</a>
			</div>
		</div>
	</div>
</body>
</html>
