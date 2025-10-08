<?php
	include "includes/autentica.php";
?>

<?php

	 //Abre conexão com o MySQL
	 $conn = mysqli_connect("localhost", "root", "", "construcaoprodutos");

	 if($conn == false){
		 die("ERRO: Não conectou com o BD!");
	 }

	 $id = "";
	 $nome = "";
	 $cnpj = "";
	 $telefone = "";
	 
	 //Se existir GET de ID
	 //Se a tela esta sendo aberta para edição
	 if(isset($_GET['id'])){

		//Obtém o parametro ID que foi enviado via GET
		$id = $_GET['id'];

		//Monta o comando SQL para buscar as informações cadastradas
		$sql = "SELECT * FROM fornecedores WHERE id = $id";

		//Envio da consulta ao MySQL
		$res = mysqli_query($conn, $sql);
		//Armazena o registro encontrado
		$row = mysqli_fetch_assoc($res);

		//Guarda os valores nas variáveis
		$nome = $row['nome'];
		$cnpj = $row['cnpj'];
		$telefone = $row['telefone'];
		
	 }

?>
<!DOCTYPE html>
<html>
	<head>
		<title>Materiais de Construção - Área restrita - Cadastro de Fornecedores</title>
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
				<li><a href="cadastrar.php"class="active">Cadastrar</a></li>
                <li><a href="cadusuarios.php">Criar Usuários</a></li>
                <li><a href="cadfornecedores.php"class="activecad">Criar Fornecedores</a></li>
                <li><a href="cadprodutos.php">Criar Produtos</a></li>
			</ul>
		  </nav>
		  
		  <article>
		  
			<form action="recebefornecedores.php" method="post">
			
				<input type="hidden" name="id" value="<?php echo $id; ?>" />
			
				<label for="nome">Nome</label> 
				<input type="text" name="nome" value="<?php echo $nome; ?>" placeholder="Digite o nome" required>
				

				<label for="cnpj">CNPJ</label>
				<input type="text" name="cnpj" value="<?php echo $cnpj; ?>" placeholder="XX.XXX.XXX/0001-XX" pattern="\d{2}.\d{3}.\d{3}/0001-\d{2}" required>
				
				 
				
				<label for="telefone">Telefone | Celular</label>
				<input type="tel" name="telefone"  value="<?php echo $telefone; ?>" placeholder="(XX) XXXXX-XXXX" required>
				
				
				<input type="submit">
			
			</form>
			<a href="inicio.php">Voltar</a>
		  </article>
		</section>

		<footer>
			<p>© Todos direitos reservados.</p>
		    <p>Desenvolvido pelo grupo 46.</p>
		</footer>
		
		
	</body>
</html>