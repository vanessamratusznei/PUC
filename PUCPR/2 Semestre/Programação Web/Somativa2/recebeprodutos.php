<?php

    //Abre conexão com o MySQL
    $conn = mysqli_connect("localhost", "root", "", "construcaoprodutos");

    if($conn == false){
        die("ERRO: Não conectou com o BD!");
    }

    //Recebe os dados enviados via POST pelo formulário
    $id = $_POST['id'];
    $nome = $_POST['nome'];
	$codBarras = $_POST['codBarras'];
	$quantidade = $_POST['quantidade'];
    $undMedida = $_POST['undMedida'];
	$idFornecedor = $_POST['idFornecedor'];

    	
    //INSERÇÃO
    if(empty($id)){

        $sql = "SELECT * FROM fornecedores WHERE id = '$idFornecedor'";
        $res = mysqli_query($conn, $sql);
        
        //Obtem quantidade de registros encontrados
        $qtdeRegistros = mysqli_num_rows($res);

        //Encontrou registro compativel
        if($qtdeRegistros > 0) {
            
            //Monta o código SQL para inserir o produto
            $sqll = "INSERT INTO produtos (nome, codBarras, quantidade, undMedida, idFornecedor) 
                    VALUES 
                    ('$nome', '$codBarras', '$quantidade', '$undMedida', '$idFornecedor')";

            //Envia o código SQL ao MySQL
            $ress = mysqli_query($conn, $sqll);

            //Se a inserção deu certo
            if($ress){
                header("Location: listaprodutos.php");
            }
            else{
                echo "ERRO AO INSERIR!";
            }
        }
        else {
            header("Location: cadprodutos.php?erro=1");
        }
    }
    //ATUALIZAÇÃO
    else{

        $sql = "SELECT * FROM fornecedores WHERE id = '$idFornecedor'";
        $res = mysqli_query($conn, $sql);
        
        //Obtem quantidade de registros encontrados
        $qtdeRegistros = mysqli_num_rows($res);

        //Encontrou registro compativel
        if($qtdeRegistros > 0) {
            //Monta o SQL com os campos enviados pelo usuário
            $sql = "UPDATE produtos SET 
                nome = '$nome',
                codBarras = '$codBarras',
                quantidade = '$quantidade',
                undMedida = '$undMedida',
                idFornecedor = '$idFornecedor'
            WHERE
                id = $id";
        
            //Envia código SQL ao MySQL (enviando sql para atualizar produtos)
            $res = mysqli_query($conn, $sql);

            //Se SQL executou sem erros (se atualizou no BD)
            if($res){
            header("Location: listaprodutos.php");
            //echo "SUCESSO!";
            }
            else{
            echo "ERRO!";
            }
        }
        else {
            header("Location: listaprodutos.php?erro=1");
        }
    }