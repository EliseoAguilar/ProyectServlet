<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador de Contactos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">Bienvenido ${sessionScope.user.email}</div>
		</div>
		<div class="row">

			<div class="col-md-4">


				<form action="ContacServlet" method="post">
					
					<c:if test="${ con != null }">
						<input type="hidden" value="UPDATE" name="opt" id="opt">
						<input type="hidden" value="${con.id}" name="id" id="id">
					</c:if>
					<c:if test="${ con == null }">
						<input type="hidden" value="CREATE" name="opt" id="opt">
					</c:if>
					
					<div class="form-group">
						<label for="email">Nombre</label> <input type="text"
							class="form-control" id="name" name="name" value="${con.name}">
					</div>
					<div class="form-group">
						<label for="pwd">Tel.</label> <input type="text"
							class="form-control" id="number" name="number"
							value="${con.number}">
					</div>
					<button type="submit" class="btn btn-default">Guardar</button>
				</form>
			</div>
			<div class="col-md-8">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nombre</th>
							<th scope="col">Tel.</th>
							<th scope="col">Acción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="contac" items="${contacsList}">
							<tr>
								<th scope="row">${contac.id}</th>
								<td>${contac.name}</td>
								<td>${contac.number}</td>
								<td>
									<form action="ContacServlet" method="get">
										<input type="hidden" value="UPDATE" name="opt" id="opt">
										<input type="hidden" value="${contac.id}" name="id" id="id">
										<button type="submit" class="btn btn-outline-primary">Edit</button>
									</form>
									<form action="ContacServlet" method="post">
										<input type="hidden" value="DELETE" name="opt" id="opt">
										<input type="hidden" value="${contac.id}" name="id" id="id">
										<button type="submit" class="btn btn-outline-danger">Delete</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>


</html>