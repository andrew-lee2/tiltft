import React, { useState, useEffect } from 'react';
import logo from './logo.svg';
import './App.scss';


function App() {

  const [message, setMessage] = useState("");

  useEffect(() => {
      fetch('/hello')
          .then(response => response.text())
          .then((result) => {
              setMessage(result);
      });
  });

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <p>
          { message }
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
