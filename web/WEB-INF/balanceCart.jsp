<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../res/img/favicon.ico">

	<!-- 章节标题 -->
    <title>购物车结算</title>

    <!-- Bootstrap core CSS -->
    <link href="../res/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	body {
    		background-color:#E5E4DB;
    	}
    	.content {
    		font-size:16px;
    		background-color:#F6F4EC;
    		color:#333;
    		padding:20px;
    		border-radius:5px;
    		-webkit-border-radiu:5px;
    	}
    	.jumbotron {
    		padding-top:10px;
    		padding-bottom:10px;
    		background-color:#F5F5F5;
    	}
    </style>
  </head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<a href="./">回到首页</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<h3 style="text-align:center;">购物车结算</h3>
		<!-- 章节内容区域 -->
		<div class="container no-table-responsive">
			<table
					class="table table-striped table-bordered table-condensed table-hover">
				<thead>
				<tr style="text-align:center;font-style:800;">
					<th>品牌</th>
					<td>产品名称</td>
					<td>数量</td>
					<td>金额</td>
				</tr>
				</thead>
				<tbody id="list">
				</tbody>
			</table>
		</div>
		<!-- 前一章 章节列表 后一章 链接区域 -->
		<div style="text-align:center;">
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../res/js/1.11.3jquery.min.js"></script>
    <script src="../res/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="../res/js/base64.js"></script>
</body>
</html>