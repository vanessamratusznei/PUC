import React, { Component } from 'react';
import { auth, db } from '../../Firebase';
import { createUserWithEmailAndPassword } from 'firebase/auth';
import { doc, setDoc } from 'firebase/firestore';
import { Link } from 'react-router-dom';

class Cadastro extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      senha: '',
      nome: '',
      sobrenome: '',
      dataNascimento: ''
    };
  }

  cadastrar = async () => {
    const { email, senha, nome, sobrenome, dataNascimento } = this.state;

    // Validação para que todos os campos sejam preenchidos
    if (!email.trim() || !senha.trim() || !nome.trim() || !sobrenome.trim() || !dataNascimento) {
      alert('Por favor, preencha todos os campos antes de cadastrar.');
      return;
    }

    try {
      const userCredential = await createUserWithEmailAndPassword(auth, email, senha);
      const uid = userCredential.user.uid;

      await setDoc(doc(db, 'usuarios', uid), {
        nome: nome.trim(),
        sobrenome: sobrenome.trim(),
        dataNascimento: dataNascimento,
        email: email.trim()
      });

      alert('Usuário cadastrado com sucesso!');

      // Limpar os campos após o cadastro
      this.setState({
        email: '',
        senha: '',
        nome: '',
        sobrenome: '',
        dataNascimento: ''
      });

    } catch (error) {
      if (error.code === 'auth/email-already-in-use') {
        alert('Este e-mail já está em uso. Tente outro e-mail.');
      } else if (error.code === 'auth/missing-password') {
        alert('Favor cadastrar uma senha.');
      } else if (error.code === 'auth/invalid-email') {
        alert('E-mail inválido. Tente outro e-mail.');
      } else if (error.code === 'auth/weak-password') {
        alert('Senha deve conter no mínimo 6 caracteres.');
      } else {
        alert('Erro ao cadastrar: ' + error.message);
      }
    }
  };

  render() {
    return (
      <div>
        <h2>Cadastro</h2>
        <input 
          type="text" 
          placeholder="Email" 
          value={this.state.email}
          onChange={(e) => this.setState({ email: e.target.value })} 
        /><br />
        <input 
          type="password" 
          placeholder="Senha" 
          value={this.state.senha}
          onChange={(e) => this.setState({ senha: e.target.value })} 
        /><br />
        <input 
          type="text" 
          placeholder="Nome" 
          value={this.state.nome}
          onChange={(e) => this.setState({ nome: e.target.value })} 
        /><br />
        <input 
          type="text" 
          placeholder="Sobrenome" 
          value={this.state.sobrenome}
          onChange={(e) => this.setState({ sobrenome: e.target.value })} 
        /><br />
        <input 
          type="date" 
          placeholder="Data de Nascimento" 
          value={this.state.dataNascimento}
          onChange={(e) => this.setState({ dataNascimento: e.target.value })} 
        /><br />
        <button onClick={this.cadastrar}>Cadastrar</button><br />
        <Link to="/login">Ir para Login</Link>
      </div>
    );
  }
}

export default Cadastro;
