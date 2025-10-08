<?php

	$login = $_POST['login'];
	$senha = $_POST['senha'];
	
	//Abre conexão com o MySQL
	$conn = mysqli_connect("localhost", "root", "", "construcaoprodutos");
	if($conn == false){
		die("ERRO: Não conectou com o BD!");
	}

	$sql = "SELECT * FROM usuarios WHERE email = '$login' AND senha = '$senha'";
	$res = mysqli_query($conn, $sql);
	
	//Obtem quantidade de registros encontrados
	$qtdeRegistros = mysqli_num_rows($res);

	//Encontrou login e senha compativeis
	if($qtdeRegistros > 0) {

		//Inicia a sessão
		session_start();

		//Obtem dados do usuario
		$row = mysqli_fetch_assoc($res);

		//Armazena informacoes do usuario na sessao
		$_SESSION['id'] = $row['id'];
		$_SESSION['nome'] = $row['nome'];

		header("Location: inicio.php");
	}
	else{
		header("Location: index.php?erro=1");
	}

?>