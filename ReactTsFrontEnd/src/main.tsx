import React from 'react'
import { ChakraProvider } from '@chakra-ui/react' 
import * as ReactDOM from 'react-dom/client'
import App from './App'
import './index.css' 
import { Provider } from 'react-redux';
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import {store} from './store/store'

ReactDOM.createRoot(document.getElementById('root')!).render(  
    <React.StrictMode>
      <Provider store={store}>
      <ChakraProvider>
       <BrowserRouter>
         <App/>
       </BrowserRouter>
      </ChakraProvider>
      </Provider>
    </React.StrictMode>,
  )

