<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">
	$(function() {
		getList(1, '%', '%');
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			
			memoWrite(writer, contents);
			
		});
		
		$("#btnView").click(function() {
			memoView(1);
		});
	});
	
	
	

</script>

</head>
<body>
	<div>
		<form action="">
			<p><input type="text" id="writer"></p>
			<p><textarea id="contents"></textarea></p>
			<p><input type="button" id="btn" value="WRITE"></p>
			
		</form>
	</div>
	<div id ="result"></div>
	<button id="btnView">VIEW</button>

</body>
</html>