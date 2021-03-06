<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Se connecter</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
		media="screen">
	<!-- Style-->
	<style type="text/css">
		body {
			padding-top: 40px;
			padding-bottom: 40px;
			background-color: #f5f5f5;
		}
		
		.form-signin {
			width: 450px;
			padding: 19px 19px 29px;
			margin: 0 auto 20px;
			background-color: #fff;
			border: 1px solid #e5e5e5;
			-webkit-border-radius: 5px;
			-moz-border-radius: 5px;
			border-radius: 5px;
			-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
			-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
			box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
		}
		
		.form-signin .form-signin-heading {
			margin-bottom: 10px;
			align: center;
		}
		
		.form-signin input[type="text"],.form-signin input[type="password"] {
			font-size: 16px;
			height: 20px;
			margin-bottom: 15px;
			padding: 7px 9px;
		}
		
		.form-signin p {
			padding-top: 5px;
			height: 37px;
		}
	</style>
</head>
<body>

	<form class="form-signin" method="POST"
		action="<%=request.getContextPath()%>/SignUp">

		<h2 class="form-signin-heading">Enregistrez vous</h2>

		<!--  Affichage de l'erreur si elle existe -->
		<c:if test="${error != null}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<!-- Formulaire d'inscription -->
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span5">
					<p>Identifiant* :</p>
					<p>Mot de passe* :</p>
					<p>Confirmation MDP* :</p>
					<p>Nom* :</p>
					<p>Pr&eacute;nom* :</p>
					<p>Adresse :</p>
					<p>Code Postal :</p>
					<p>Ville :</p>
					<p>Pays :</p>
				</div>
				<div class="span7">
					<input name="login" id="login" type="text" class="input-block"
						pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required> 
					<input
						name="password" id="password" type="password" class="input-block"
						pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
						placeholder="8 caractères et une majuscule" required> 
					<input name="passwordConfirm" 
						id="passwordConfirm" type="password" class="input-block"
						pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
						placeholder="8 caractères et une majuscule" required> 
					<input name="nom" id="nom" type="text" value ="${nom}"
						class="input-block" required> 
					<input name="prenom" value ="${prenom}"
						id="prenom" type="text" class="input-block" required> 
					<input value ="${adresse}"
						name="adresse" id="adresse" type="text" class="input-block">
					<input name="codePostal" id="codePostal" type="text" value ="${codePostal}"
						class="input-block" pattern="[0-9]{5}"> 
					<input value ="${ville}"
						name="ville" id="ville" type="text" class="input-block"> 
					<select
						id="pays" name="pays">
						<c:forEach var="pays" items="${requestScope['paysAll']}">
							<option value="${pays.paId}">${pays.paNom}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div align="center">
			<button class="btn btn-large btn-primary" type="submit">S'enregistrer</button>
		</div>
		<p>* Champs obligatoires </p>

	</form>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>