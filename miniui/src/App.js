import logo from './logo.svg';
import './App.css';
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import {useEffect} from 'react';

let stompClient;

const connect = () => {
    const socket = new SockJS("/minilasocket");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("Connected " + frame);
        stompClient.subscribe("/topic/greetings", function (greeting) {
        console.log(greeting);
        });
    });
};

function App() {


  useEffect(() => {
    connect();
  });



  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
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
