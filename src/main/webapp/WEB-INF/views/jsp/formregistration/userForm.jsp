<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
        <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>User Registration Form</h2>
	<mvc:form modelAttribute="user" action="result">
	      <div class="form-group">
	            <label>First Name</label>
	            <mvc:input path="name" class="form-control" required="true" placeholder="First Name"/>
          </div>
	      <div class="form-group">
	            <label>Last Name</label>
	            <mvc:input path="lastname" class="form-control" required="true" placeholder="Last Name"/>
          </div>
	      <div class="form-group">
	            <label>Password</label>
	            <mvc:password path="password" class="form-control" required="true" placeholder="Password"/>
          </div>
	      <div class="form-group">
	            <label>Detail</label>
	            <mvc:textarea path="detail" class="form-control" placeholder="Detail information"/>
          </div>
	      <div class="form-group">
	            <label>Birth Date</label>
	            <mvc:input path="birthDate" class="form-control" type="Date"/>
          </div>
	      <div class="form-check">
	            <label>Gender</label>
	            <mvc:radiobuttons path="gender" class="form-check-input" items="${gender}"/>
          </div>
	      <div class="form-group">
	            <label>Country</label>
	            <mvc:select path="country" class="form-control" items="${countries}"/>
          </div>
	      <div class="form-check">
                <label class="form-check-label" for="exampleCheck1">NonSmoking</label>
                <mvc:checkbox path="nonSmoking" class="form-check-input" checked="true"/>
          </div>
                <button type="submit" class="btn btn-primary">Submit</button>
    </mvc:form>
</body>
</html>
<style>
body {
margin-left:25%;
width : 50%;
}
</style>