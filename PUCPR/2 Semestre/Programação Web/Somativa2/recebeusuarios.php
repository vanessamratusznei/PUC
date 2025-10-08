<?php

    //Abre conexão com o MySQL
    $conn = mysqli_connect("localhost", "root", "", "construcaoprodutos");

    if($conn == false){
        die("ERRO: Não conectou com o BD!");
    }

    //Recebe os dados enviados via POST pelo formulário
    $id = $_POST['id'];
    $nome = $_POST['nome'];
	$email = $_POST['email'];
	$senha = $_POST['senha'];

	
    //INSERÇÃO
    if(empty($id)){

        //Monta o código SQL para inserir o fornecedor
        $sql = "INSERT INTO usuarios (nome, email, senha) 
                VALUES 
                ('$nome', '$email', '$senha')";

        //Envia o código SQL ao MySQL
        $res = mysqli_query($conn, $sql);

        //Se a inserção deu certo
        if($res){
            header("Location: listausuarios.php");
        }
        else{
            echo "ERRO AO INSERIR!";
        }

    }
    //ATUALIZAÇÃO
    else{

        //Monta o SQL com os campos enviados pelo usuário
		$sql = "UPDATE usuarios SET 
            nome = '$nome',
            email = '$email',
            senha = '$senha'
        WHERE
            id = $id";
        
        //Envia código SQL ao MySQL (enviando sql para atualizar fornecedor)
        $res = mysqli_query($conn, $sql);

        //Se SQL executou sem erros (se atualizou no BD)
        if($res){
        header("Location: listausuarios.php");
        //echo "SUCESSO!";
        }
        else{
        echo "ERRO!";
        }

    }
