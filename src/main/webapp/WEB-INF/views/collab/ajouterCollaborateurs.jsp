<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"> <img src="logo-java.jpg"
			width="50" height="50" alt="LOGO">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
				    <a class="nav-link" href="listerCollaborateurs.jsp">Collaborateurs</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
        <h1 class="display-3">Nouveau Collaborateur</h1>
        <br>
        <form action="http://localhost:8080/sgp/collaborateurs/nouveau" method="post" class="container was-validated">
            <div class="form-group">
                <label for="nom">NOM :</label>
                <input type="text" class="form-control" id="nom" name="nom" placeholder="MARTY" required>
                <div class="invalid-feedback">
                    Le nom est obligatoire.
                </div>
                <div class="valid-feedback">Valide.</div>
            </div>
            <div class="form-group">
                <label for="prenom">Prénom :</label>
                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Nicolas" required>
                <div class="invalid-feedback">
                    Le prénom est obligatoire.
                </div>
                <div class="valid-feedback">Valide.</div>
            </div>
            <div class="form-group">
                <label for="date_naissance">Date de naissance :</label>
                <input type="date" class="form-control" id="date_naissance" name="date_naissance" placeholder="Nicolas" required>
                <div class="invalid-feedback">
                    La date de naissance est obligatoire.
                </div>
                <div class="valid-feedback">Valide.</div>
            </div>
            <div class="form-group">
                <label for="adresse">Adresse :</label>
                <textarea type="adresse" class="form-control" id="adresse" name="adresse" required></textarea>
                <div class="invalid-feedback">
                    L'adresse est obligatoire.
                </div>
                <div class="valid-feedback">Valide.</div>
            </div>
            <div class="form-group">
                <label for="num_secu">Numéro de sécurité sociale :</label>
                <input type="number" class="form-control" id="num_secu" name="num_secu" max="999999999999999" required>
                <div class="invalid-feedback">
                    Le numéro de sécurité sociale est obligatoire.
                </div>
                <div class="valid-feedback">Valide.</div>
            </div>
            <div class="container-fluid">
                <button id="valid" type="submit" class="btn btn-success float-right">Créer</button>
            </div>
        </form>
    </div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/js/bootstrap.bundle.js"></script>