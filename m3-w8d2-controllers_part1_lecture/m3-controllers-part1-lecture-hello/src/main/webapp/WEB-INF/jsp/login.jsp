<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>${error}</h1>
	
		<c:url value="/doLogin" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="username">Username: </label>
			<input type="text" id="username" name="username" />
			<label for="password">Password: </label>
			<input type="text" id="password" name="password" />
			<input type="submit" value="Login" />
		</form>
	</body>
</html>