<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
    <title>Student Confirmation</title>
</head>

<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

Free passess: ${student.freePasses}

<br><br>

Favorite Language: ${student.favoriteLanguage}

<br><br>

Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">

		<li> ${temp} </li>

	</c:forEach>
</ul>

<br><br>

Postal Code: ${student.postalCode}

<br><br>

Course Code: ${student.courseCode}

<br><br>

</body>

</html>







