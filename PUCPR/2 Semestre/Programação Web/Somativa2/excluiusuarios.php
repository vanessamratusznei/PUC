<?php

	//Abrindo conexão com o banco de dados MySQL e acessando database construcaoprodutos
	$conn = mysqli_connect("localhost", "root", "", "construcaoprodutos"); 
	if($conn == false){
		die("ERRO: Não conseguiu conectar com o BD. ");
	}
	
	//Obter o ID enviado via GET
	$id = $_GET['id'];
	
	//Montar o SQL de exclusão
	$sql = "DELETE FROM usuarios WHERE id = $id";
	
	//Envia o código SQL para o BD
	$res = mysqli_query($conn, $sql);
	
	//Redireciona para a listagem de usuarios
	header("Location: listausuarios.php");
?>