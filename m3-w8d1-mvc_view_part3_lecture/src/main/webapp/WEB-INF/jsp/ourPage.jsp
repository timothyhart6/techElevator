<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<c:import url="/WEB-INF/jsp/header.jsp">
	    <c:param name="pageTitle" value="Our Page" />
	</c:import>
	
	<p>The ID is:  ${param.id}</p>
	
	<div>This is a DIV</div>
	
	 <c:import url="/WEB-INF/jsp/ourPartialPage.jsp" >
	 	<c:param name="user" value="${param.name}" />
	 </c:import>

	
	<c:import url="/WEB-INF/jsp/footer.jsp" />