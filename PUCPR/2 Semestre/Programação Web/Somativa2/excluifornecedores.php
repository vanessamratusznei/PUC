<?php

	//Abrindo conexão com o banco de dados MySQL e acessando database construcaoprodutos
	$conn = mysqli_connect("localhost", "root", "", "construcaoprodutos"); 
	if($conn == false){
		die("ERRO: Não conseguiu conectar com o BD. ");
	}
	
	$id = $_GET['id'];
	
	$sql = "SELECT * FROM produtos WHERE idFornecedor = '$id'";
    $res = mysqli_query($conn, $sql);
        
    //Obtem quantidade de registros encontrados
    $qtdeRegistros = mysqli_num_rows($res);

    //Encontrou registro compativel
    if($qtdeRegistros > 0) {
			header("Location: listafornecedores.php?erro=1");
		}
	else{

			//Obter o ID enviado via GET
			$id = $_GET['id'];
			
			//Montar o SQL de exclusão
			$sql = "DELETE FROM fornecedores WHERE id = $id";
			
			//Envia o código SQL para o BD
			$res = mysqli_query($conn, $sql);
			
			//Redireciona para a listagem de fornecedores
			header("Location: listafornecedores.php");

		}


?>