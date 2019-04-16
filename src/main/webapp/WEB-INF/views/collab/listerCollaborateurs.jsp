<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
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
				<li class="nav-item active"><a class="nav-link" href="lister">Collaborateurs</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="stats">Statistiques</a>
				</li>
			</ul>
		</div>
	</nav>
	<main>
	<section class="container-fluid">
		<div class="container-fluid m-2">
			<a href="nouveau" class="btn btn-primary float-right">Ajouter
				un nouveau collaborateur</a><br>
		</div>
		<h1 class="display-3">Les Collaborateurs</h1>
		<form action="#" type="post" class="mt-3 mb-5">
			<div class="row m-2 form-group">
				<label for="search"
					class="col-lg-3 col-md-12 col-form-label text-right">Rechercher
					un nom ou un prénom qui commence par :</label>
				<div class="col-lg-3 col-md-12">
					<input type="search" class="form-control" id="search" name="search">
				</div>
				<div class="col-lg-1 col-md-12">
					<div class="d-lg-none">
						<br>
					</div>
					<button type="submit" class="btn btn-primary">Rechercher</button>
					<div class="d-lg-none">
						<br>
					</div>
				</div>
				<div class="col-lg-2 col-md-12"></div>
				<div class="col-lg-3 col-md-12 form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="collab_desactive"> <label class="form-check-label"
						for="collab_desactive"> Voir les collaborateurs désactivés
					</label>
				</div>
			</div>
			<div class="row m-2 form-group">
				<label for="filtre"
					class="col-lg-3 col-md-12 col-form-label text-right">Filtrer
					par département :</label>
				<div class="col-lg-3 col-md-12">
					<select class="custom-select custom-select">
						<option selected>Tous</option>
						<option value="1">Comptabilité</option>
						<option value="2">Ressources Humaines</option>
						<option value="3">Informatique</option>
					</select>
				</div>
				<div class="col-lg-8 col-md-12"></div>
			</div>
		</form>
	</section>
	<section class="container-fluid">
		<div class="card-deck mt-5 mb-3">
			<%
	            List<Collaborateur> listeCollaborateurs = (List<Collaborateur>) request.getAttribute("collaborateurs");
	            for (Collaborateur collab : listeCollaborateurs) {
	        %>
			<div class="card bg-light">
				<div class="card-header"><%=collab.getNom().toUpperCase() + " "%><%=collab.getPrenom()%></div>
				<div class="card-body">
					<div class="row">
						<div class="col-md-4">
							<img class="rounded" src="<%=request.getContextPath()%>/img/img1.jpg" height="150" width="150">
						</div>
						<div class="col-lg-8 col-md-12">
							<div class="row">
								<div class="col-md-6 card-text">
									<p>Date de Naissance:</p>
									<p>Email:</p>
									<p>Matricule:</p>
								</div>
								<div class="col-md-6">
									<p><%=collab.getDateDeNaissance()%></p>
									<p><%=collab.getEmailPro()%></p>
									<p><%=collab.getMatricule()%></p>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer bg-lignt">
						<button class="btn btn-primary float-right">Editer</button>
					</div>
				</div>
			</div>
			<%
	            }
	        %>
		</div>
	</section>
	</main>	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/js/bootstrap.bundle.js"></script>
</body>
</html>