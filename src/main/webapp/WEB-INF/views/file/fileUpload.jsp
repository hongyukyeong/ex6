<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		
		var count=0;
		var name=0;
		
		$("#add").click(function() {
	
			if(count<5){
				count++;
				name++;
				$("#file").append('<p class="test"><input type="file" name="f'+name+'"><span class="del">X</span></p>');
			}else{
				alert("최대 5개만 가능");
			}
		});
		
		$("#file").on("click",".del",function(){
			count--;
			$(this).parent().remove();
			
		});
		
	});


</script>
</head>
<body>
	<hr>
	<h2>단일 파일 업로드</h2>
	
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<button>UPLOAD</button>		
	</form>
	
	
	<hr>
	<h2>다중 파일 업로드 - 이름 일치</h2>
	
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f2">
		<button>UPLOAD</button>		
	</form>
	
	<hr>
	<h2>다중 파일 업로드 - 이름 불일치</h2>
	
	
	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f1">
		<button>UPLOAD</button>		
	</form>
	
	
	<hr>
	<h2>이름이 같고 갯수를 모를 때</h2>
	
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<div id="file">
		
		</div>
		<input type="button" id="add" value="ADD FILE">
		<button>UPLOAD</button>		
	</form>
	

</body>
</html>