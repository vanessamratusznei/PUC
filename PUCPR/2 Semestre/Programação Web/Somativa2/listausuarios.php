<?php
	include "includes/autentica.php";
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Materiais de Construção - Área restrita - Cadastro de Usuários</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/estilo.css?v=<?= time() ?>">
	</head>
	<body>
	
		<header>
		  <h2>Materiais de Construção</h2>
		</header>
		
		<section>
		  <nav>
        <ul id="menu">
            <li><a href="listar.php"class="active">Listar</a></li>
            <li><a href="listausuarios.php"class="activecad">Usuários Cadastrados</a></li>
            <li><a href="listafornecedores.php">Fornecedores Cadastrados</a></li>
            <li><a href="listaprodutos.php">Produtos Cadastrados</a></li>
        </ul>
		  </nav>
		  
		  <article>
		  
            <table class="tabela">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>  </th>
                    <th>  </th>
                </tr>
                <?php

                    //Abre conexão com o MySQL
                    $conn = mysqli_connect("localhost", "root", "", "construcaoprodutos");

                    if($conn == false){
                        die("ERRO: Não conectou com o BD!");
                    }

                    //Monta o comando SQL para buscar as informações cadastradas
                    $sql = "SELECT id, nome, email, senha FROM usuarios";

                    //Envia código SQL ao MySQL (enviando sql para consultar usuarios)
					          $res = mysqli_query($conn, $sql);

                    //Se deu certo e encontrou registros
                    if($res){

                        //Percorre os fornecedores encontrados
                        while($row = mysqli_fetch_assoc($res)){
                            
                            echo " <tr>
                                        <td>" . $row['id'] . "</td>
                                        <td>" . $row['nome'] . "</td>
                                        <td>" . $row['email'] . "</td>
                                        <td>" . $row['senha'] . "</td>
                                        <td><a href='cadusuarios.php?id=" . $row['id'] . "'>Editar</a></td>
                                        <td><a href='excluiusuarios.php?id=".$row['id']."'>Excluir</a></td>
                                    </tr>";

                        }

                    }

                ?>
            </table>


			<a href="inicio.php">Voltar</a>
		  </article>
		</section>

		<footer>
            <p>© Todos direitos reservados.</p>
		    <p>Desenvolvido pelo grupo 46.</p>
		</footer>
		
		
	</body>
</html>