import React, { useState, useEffect } from 'react';
import logo from './logo.svg';
import './App.scss';
import Home from "./scenes/Home";

function App() {

  // const [message, setMessage] = useState("");
  //
  // useEffect(() => {
  //     fetch('/api/hello')
  //         .then(response => response.text())
  //         .then((result) => {
  //             setMessage(result);
  //     });
  // });
  // let textInput = React.createRef();
  //
  // function handleClick() {
  //   window.alert(`Hello ${textInput.current.value}!`);
  // }

  return (
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reloadweweewew.
    //     </p>
    //     <wired-button onClick={handleClick}>Submit</wired-button>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
    <Home/>
  );
}

export default App;
