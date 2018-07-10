<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Adult</th>
			</tr>
			<c:forEach var="person" items="${personList}">
				<tr>
					<td><c:out value="${person.firstName}" /></td>
					<td>${person.lastName}</td>
					<td>${person.age}</td>
					<td>${person.adult}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div>
			This is a single Person object:  ${mike.firstName} ${mike.lastName} ${mike.age}
		
		</div>
		<br />
		<br />
		<br />
		<div>
			<c:forEach var="herd" items="${herds}">
				${herd.key} :::: ${herd.value}<br />
			</c:forEach>
			<br />
			<br />
			<h1>A group of Lions is a ${herds.Lion}</h1>
		</div>
	</body>
</html>