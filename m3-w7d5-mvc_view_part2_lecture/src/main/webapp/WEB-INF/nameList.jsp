<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
			<c:forEach var="name" items="${requestScope.nameList}">
				<li>${name}</li>
			</c:forEach>
		</ol>
	</body>
</html>