<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<center>
		<form method="POST" action="uploadFile" enctype="multipart/form-data">
			File to upload: <input type="file" name="file"><br /> <br />
			<input type="submit" value="Upload"> Press here to upload the file!
		</form>
	</center>
</body>
</html>