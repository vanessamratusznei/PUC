<?php
	include "includes/autentica.php";
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Materiais de Construção - Área restrita - Cadastro de Produtos</title>
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
            <li><a href="listausuarios.php">Usuários Cadastrados</a></li>
            <li><a href="listafornecedores.php">Fornecedores Cadastrados</a></li>
            <li><a href="listaprodutos.php"class="activecad">Produtos Cadastrados</a></li>
        </ul>
		  </nav>
		  
		  <article>

            <?php

            //Se não autenticou - enviado parametro de erro
            if(isset($_GET['erro'])) {
                echo '<p style="text-align:center;color: rgb(190, 19, 19)">Erro ao gravar registro. Código de Fornecedor não encontrado.</p>';
            }

            ?>
		  
            <table class="tabela">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Cod. Barras</th>
                    <th>Quantidade</th>
                    <th>Und. Medida</th>
                    <th>Fornecedor</th>
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
                    $sql = "SELECT 
                                Produtos.id, 
                                Produtos.nome, 
                                Produtos.codBarras, 
                                Produtos.quantidade, 
                                Produtos.undMedida, 
                                Fornecedores.nome AS nome_fornecedor
                            FROM Produtos
                            JOIN Fornecedores ON Produtos.idFornecedor = Fornecedores.id;";

                    //Envia código SQL ao MySQL (enviando sql para consultar produtos)
					          $res = mysqli_query($conn, $sql);

                    //Se deu certo e encontrou registros
                    if($res){

                        //Percorre os fornecedores encontrados
                        while($row = mysqli_fetch_assoc($res)){
                            
                            echo " <tr>
                                        <td>" . $row['id'] . "</td>
                                        <td>" . $row['nome'] . "</td>
                                        <td>" . $row['codBarras'] . "</td>
                                        <td>" . $row['quantidade'] . "</td>
                                        <td>" . $row['undMedida'] . "</td>
                                        <td>" . $row['nome_fornecedor'] . "</td>
                                        <td><a href='cadprodutos.php?id=" . $row['id'] . "'>Editar</a></td>
                                        <td><a href='excluiprodutos.php?id=".$row['id']."'>Excluir</a></td>
                                    </tr>";

                        }

                    }

                ?>
            </table>


			<a href="inicio.php">Voltar</a>
		  </article>
		</section>

		<footer>
		  <p>Todos direitos reservados.</p>
		</footer>
		
		
	</body>
</html>