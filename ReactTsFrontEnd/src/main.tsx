import React from 'react'
import { ChakraProvider } from '@chakra-ui/react' 
import * as ReactDOM from 'react-dom/client'
import App from './App'
import './index.css' 
import { BrowserRouter, Route, Routes } from 'react-router-dom'


ReactDOM.createRoot(document.getElementById('root')!).render(  
    <React.StrictMode>
      <ChakraProvider>
       <BrowserRouter>
         <App/>
       </BrowserRouter>
      </ChakraProvider>
    </React.StrictMode>,
  )
