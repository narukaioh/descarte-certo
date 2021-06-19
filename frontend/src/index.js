import React from 'react';
import ReactDOM from 'react-dom';
import { Switch, Route, HashRouter } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './index.css';
import App from './App';
import LoginPage from './components/Login/LoginPage';
import OrderListComponent from './components/OrderList';

ReactDOM.render(
  <HashRouter>
    <Switch>
      <Route exact path="/" component={App} />
      <Route exact path="/login" component={LoginPage} />
      <Route exact path="/orcamentos" component={OrderListComponent} />
    </Switch>

  </HashRouter>,
  document.getElementById('root'));

