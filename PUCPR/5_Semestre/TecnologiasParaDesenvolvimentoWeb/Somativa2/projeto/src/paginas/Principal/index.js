import React, { Component } from 'react';
import { getAuth, onAuthStateChanged, signOut } from 'firebase/auth';
import { getFirestore, doc, getDoc } from 'firebase/firestore';
import firebase from '../../Firebase'; // inicialização do app

class Principal extends Component {
  constructor(props) {
    super(props);
    this.state = {
      nome: '',
      sobrenome: '',
      dataNascimento: ''
    };
  }

  componentDidMount() {
    const auth = getAuth();
    const db = getFirestore();

    // Escuta a mudança de autenticação
    onAuthStateChanged(auth, async (user) => {
      if (user) {
        const userDoc = await getDoc(doc(db, 'usuarios', user.uid));
        if (userDoc.exists()) {
          this.setState({
            nome: userDoc.data().nome,
            sobrenome: userDoc.data().sobrenome,
            dataNascimento: userDoc.data().dataNascimento
          });
        }
      } else {
        // Se não tiver usuário logado, redireciona para login
        window.location.href = '/login';
      }
    });
  }

  // Função para sair (Logout)
  handleLogout = async () => {
    const auth = getAuth();
    await signOut(auth);
    window.location.href = '/login'; // Redireciona após logout
  }

  render() {
    return (
      <div>
        <h2>Dados do Usuário</h2>
        <p>Nome: {this.state.nome}</p>
        <p>Sobrenome: {this.state.sobrenome}</p>
        <p>Data de Nascimento: {this.state.dataNascimento}</p>

        <button onClick={this.handleLogout}>Logout</button> {/* Botão para sair */}
      </div>
    );
  }
}

export default Principal;
