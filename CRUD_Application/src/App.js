import NavBar from './components/NavBar';
import './App.css';
import Home from './components/Home';
import AddUser from './components/AddUser';
import AllUser from './components/AllUser';
import EditUser from './components/EditUser';
import{BrowserRouter, Routes  , Route}from 'react-router-dom'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (

    <BrowserRouter>
      <NavBar/>
      <Routes>
      <Route path='/add'element={<AddUser/>}/>
      <Route path='/all' element ={<AllUser/>}/>
      <Route path='/home' element= {<Home/>}/>
      <Route path='edit/:id'element={<EditUser/>}/>
      </Routes>
    </BrowserRouter>

  );
}

export default App;
