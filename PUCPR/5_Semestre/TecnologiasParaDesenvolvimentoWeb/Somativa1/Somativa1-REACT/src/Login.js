import React, { useState } from 'react';
import './App.css';

function Login() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [mensagem, setMensagem] = useState('');

  const handleLogin = () => {
    if (email === 'eduardo.lino@pucpr.br' && senha === '123456') {
      setMensagem('Acessado com sucesso!');
    } else {
      setMensagem('Usuário ou senha incorretos!');
    }
  };

  return (
    <div className="container">
      <h2>Login</h2>
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="password"
        placeholder="Senha"
        value={senha}
        onChange={(e) => setSenha(e.target.value)}
      />
      <button onClick={handleLogin}>Acessar</button>
      <label>{mensagem}</label>
    </div>
  );
}

export default Login;
