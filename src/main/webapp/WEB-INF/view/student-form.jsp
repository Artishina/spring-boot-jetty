<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>Student Registration Form</title>

    <style>
        .error {
            color: red;
        }
    </style>
</head>

<body>

<form:form action="processForm" modelAttribute="student">

    First name*: <form:input path="firstName" />
                <form:errors path="firstName" cssClass="error"></form:errors>

    <br><br>

    Last name: <form:input path="lastName" />              

    <br><br>

    Free passes: <form:input path="freePasses" />
                <form:errors path="freePasses" cssClass="error"></form:errors>

    <br><br>

    Postal code: <form:input path="postalCode" />
                <form:errors path="postalCode" cssClass="error"></form:errors>

    <br><br>

    	Country:
		
		<form:select path="country"> 
        <form:options items="${theCountryOptions}" />
        </form:select>
				
        <br><br>
        
        Favorite Language:
		
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />

		<br><br>

        Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Window" />

		<br><br>

    <input type="submit" value="Submit" />

</form:form>

</body>

</html>












