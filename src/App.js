import React from 'react';
import { Routes, Route } from "react-router-dom";
import { Home, About, Blog, Contact, Faqs, GetStarted, Pricing, SignIn } from './Pages';
import './App.css';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/contact" element={<Contact />} />
      <Route path="/about" element={<About />} />
      <Route path="/blog" element={<Blog/>} />
      <Route path="/faqs" element={<Faqs/>} />
      <Route path="/getstarted" element={<GetStarted/>} />
      <Route path="/pricing" element={<Pricing/>} />
      <Route path="/signin" element={<SignIn/>} />
    </Routes>
  );
}

export default App;
