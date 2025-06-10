
import {BrowserRouter, Route,  Routes } from 'react-router-dom'
import './App.css'

import Homepage from './pages/Homepage'
import SignupPage from './pages/SignupPage'
import { ROUTES } from './routes/routes'

function App() {
  return (
     <BrowserRouter>
      <Routes>
        <Route path={ROUTES.HOME} element={<Homepage />} />
        <Route path={ROUTES.SIGN_UP} element={<SignupPage />} />
      </Routes>
      </BrowserRouter>
  )
}


export default App
