import ListEmployeeComponent from './Components/ListEmployeeComponent';
import './App.css';
import HeaderComponent from './Components/HeaderComponent';
import FooterComponent from './Components/FooterComponent';
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import { AddEmployeeComponent } from './Components/AddEmployeeComponent';

function App() {
  return (
   
    <div>
      <BrowserRouter>
        <HeaderComponent/>
        <div className=''>
          <Routes>
            localhost:3000/
            <Route exact path='/' Component={ListEmployeeComponent}></Route>
            <Route path='/employees' Component={ListEmployeeComponent}></Route>
            <Route path='/add-employee' Component={AddEmployeeComponent}></Route>
            <Route path='/edit-employee/:id' Component={AddEmployeeComponent}></Route>

          </Routes>
         </div>
         <FooterComponent/>
         </BrowserRouter>
    </div>
  );
}

export default App;
