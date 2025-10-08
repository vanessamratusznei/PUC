<?php
	
    session_start();

    //Apaga da memoria os valores armazenados na sessao
    unset($_SESSION['id']);
    unset($_SESSION['nome']);

    header("Location: index.php");

?>