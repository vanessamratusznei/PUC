import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Cadastro from '../paginas/Cadastro';
import Login from '../paginas/Login';
import Principal from '../paginas/Principal';

const Rotas = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Cadastro />} />
        <Route path="/login" element={<Login />} />
        <Route path="/principal" element={<Principal />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Rotas;
