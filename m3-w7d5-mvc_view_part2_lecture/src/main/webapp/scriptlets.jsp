<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>JSTL Lecture examples</title>
	</head>
	<body>
	
		<% pageContext.setAttribute("theLight", "green"); %>
		
		<h1>Using scriptlets</h1>
		<%
			String theLight = (String)pageContext.getAttribute("theLight");
			if(theLight.equals("green")) {
		%>
			<h1>Go!</h1>
		<%  } else if(theLight.equals("red")) { %>
			<h1>Stop!</h1>
		<%  } else { %>
			<h1>Go Faster!</h1>
		<%  } %>
		
		
		<h1>Using JSTL</h1>
		<c:choose>
			<c:when test="${theLight == 'green'}">
				<h1>Go!</h1>
			</c:when>
			<c:when test="${theLight == 'red'}">
				<h1>Stop!</h1>
			</c:when>
			<c:otherwise>
				<h1>Go Faster!</h1>
			</c:otherwise>
		</c:choose>
	</body>
</html>