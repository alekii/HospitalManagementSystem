import {configureStore} from '@reduxjs/toolkit'
import {drugsCartReducer} from '../components/pharmacy/features/cartSlice' 

export const store = configureStore({
    reducer: drugsCartReducer 
})