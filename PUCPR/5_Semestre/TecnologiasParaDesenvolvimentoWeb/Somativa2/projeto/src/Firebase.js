// Importações certas para Firebase v9+
import { initializeApp } from 'firebase/app';
import { getFirestore } from 'firebase/firestore';
import { getAuth } from 'firebase/auth';

// Sua configuração do Firebase
const firebaseConfig = {
  apiKey: "AIzaSyD00zUl3NQTIDQIV74rScwQfZAZaWfAkUI",
  authDomain: "projeto-f9901.firebaseapp.com",
  projectId: "projeto-f9901",
  storageBucket: "projeto-f9901.appspot.com",
  messagingSenderId: "964448099257",
  appId: "1:964448099257:web:038ecd4b5517e40c89f468",
  measurementId: "G-JRDYZ291PM"
};

// Inicializa o Firebase
const app = initializeApp(firebaseConfig);

// Exporte o Firestore e Auth separados
const db = getFirestore(app);
const auth = getAuth(app);

export { db, auth };

