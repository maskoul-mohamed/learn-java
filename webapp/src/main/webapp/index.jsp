<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire</title>
</head>
<body bgcolor="orange" text="yellow">
    <div align="center">
        <h1>EEnregistrement de vos coordonnees</h1>
        <hr>
        <form action="formulaire" method="get">
            <h3>
                Civilit&ecute:<select name="civilite">
                    <option>Monsieur</option>
                    <option>Madame</option>
                    <option>Mademoiselle</option>
                </select>



           </h3>
            <h3>
                Nom:<input type="text" name="nom" size="24">
            </h3>
            <h3>
                Pr&eacute:<input type="text" name="Prenom" size="24">
            </h3>
            <h3>
                Age:<input type="text" name="age" size="5">
            </h3>
            <hr>
            <input type="submit" value="Envoyer le formulaire" /> <input
                type="reset" value="Tout effacer" />
        </form>
    </div>
</body>
</html>