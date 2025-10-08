import React, { useState } from 'react';
import { auth } from '../../Firebase';
import { signInWithEmailAndPassword } from 'firebase/auth'; 
import { Link, useNavigate } from 'react-router-dom';

function Login() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const navigate = useNavigate(); // Para redirecionar

  const logar = async () => {
    try {
      await signInWithEmailAndPassword(auth, email, senha);
      navigate('/principal'); // Redirecionar para a página principal
    } catch (error) {
      // Tratamento dos erros conforme o código do Firebase
      if (error.code === 'auth/invalid-email') {
        alert('Credenciais inválidas. Verifique email e senha.');
      } else if (error.code === 'auth/invalid-credential') {
        alert('Credenciais inválidas. Verifique email e senha.');
      }  else if (error.code === 'auth/wrong-password') {
        alert('Senha incorreta. Tente novamente.');
      } else if (error.code === 'auth/missing-password') {
        alert('Favor inserir senha.');
      }  else {
        alert('Erro ao tentar fazer login: ' + error.message);
      }
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input 
        type="text" 
        placeholder="Email" 
        onChange={(e) => setEmail(e.target.value)} 
      /><br />
      <input 
        type="password" 
        placeholder="Senha" 
        onChange={(e) => setSenha(e.target.value)} 
      /><br />
      <button onClick={logar}>Entrar</button><br />
      <Link to="/">Ir para Cadastro</Link>
    </div>
  );
}

export default Login;
