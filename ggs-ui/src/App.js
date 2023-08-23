import React from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import { AuthProvider } from './components/context/AuthContext'
import PrivateRoute from './utils/PrivateRoute'
import Navbar from './components/misc/Navbar'
import Login from './components/home/Login'
import Signup from './components/home/Signup'
import OAuth2Redirect from './components/home/OAuth2Redirect'

import UserHome from './components/user/home/userhome'
import AdminPage from './components/admin/AdminPage'


function App() {
  console.log("App")

  return (
    <AuthProvider>
      <Router>
        <Navbar />
        <Routes>
          <Route path='/' element={<PrivateRoute><UserHome /></PrivateRoute>} />
          <Route path='/AdminPage' element={<PrivateRoute><AdminPage /></PrivateRoute>} />
          <Route path='/login' element={<Login />} />
          <Route path='/signup' element={<Signup />} />
          <Route path='/oauth2/redirect' element={<OAuth2Redirect />} />

          <Route path="*" element={<Navigate to="/" />}/>
        </Routes>
      </Router>
    </AuthProvider>
  )
}

export default App
