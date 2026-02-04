import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Layout from "../components/Layout";
import Home from "../components/Home";
import Counter from "../components/Counter";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="home" element={<Home />} />
          <Route path="counter" element={<Counter />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
