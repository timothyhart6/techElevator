<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<c:url var="actorSearchUrlWeb" value="/actorSearch" />
<form action="${actorSearchUrlWeb}" method="GET" id="actorSearchForm">
	<label for="lastName">Last Name:</label>
	<input type="text" name="lastName" id="lastName" />
	<input type="submit" id="actorSearchBtn" value="Search" />
</form>

<c:url var="addActorUrl" value="/addActor" />
<form action="${actorSearchUrl}" method="GET" id="addActor">
	<label for="addFirstName">First Name:</label>
	<input type="text" name="addFirstName" id="addFirstName" />
	<label for="addlastName">Last Name:</label>
	<input type="text" name="addlastName" id="addlastName" />
	<input type="button" id="addActorBtn" value="Add" />
</form>


<table class="table" id="actorTable">
<tr>
<th>Name</th>
</tr>

<c:forEach items="${actors}" var="actor">
<tr>
    <td>${actor.firstName} ${actor.lastName}</td>
</tr>
</c:forEach>

</table>

<%@include file="common/footer.jspf"%>