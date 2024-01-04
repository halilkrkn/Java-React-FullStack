import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Dashboard from "./layouts/Dashboard";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h1 className="text-center bg-green-300">E-Commerce React Project</h1>
      <Dashboard />
    </div>
  );
}

export default App;
