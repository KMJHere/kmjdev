<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
</head> 
<body>
	<table class="table table-bordered">
		<tr>
			<th style="width: 10px">BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th style="width: 40px">VIEWCNT</th>
		</tr>
	</table>
<script>
	var result = "${msg}";
	
	if(result = "success") {
		alert("정상적으로 등록되었습니다."); 
	} 
</script>
</body>
</html>