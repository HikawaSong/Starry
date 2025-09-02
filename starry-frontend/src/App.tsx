
import {BrowserRouter, Route,  Routes } from 'react-router-dom'
import './App.css'

import Homepage from './pages/Homepage'
import SignupPage from './pages/SignupPage'
import { ROUTES } from './routes/routes'
import { Toaster } from "react-hot-toast";

function App() {
  return (
     <BrowserRouter>
      <Toaster position="top-center" />
      <Routes>
        <Route path={ROUTES.HOME} element={<Homepage />} />
        <Route path={ROUTES.SIGN_UP} element={<SignupPage />} />
      </Routes>
      </BrowserRouter>
      
  )
}


export default App
