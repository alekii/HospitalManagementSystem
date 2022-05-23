import { createSlice } from "@reduxjs/toolkit";
import { addDrugsToCart } from "./actions";

interface drugsState {
  drugs: any[];
}

const initialState: drugsState = {
  drugs: [],
};

export const drugsCartReducer = (state = initialState, action: any) => {
  switch (action.type) {
    case "addDrugsToCart":
      //No mutation?
      //find Index  
      const index = state.drugs.findIndex(drug=>drug.drugName ===action.payload[0].drugName) 
      if(index<0) return { ...state, drugs: state.drugs.concat(action.payload) };
      let newArr= [...state.drugs] //new Array
      newArr[index].drugQuantity += action.payload[0].drugQuantity //assign new value
       return {...state,drugs:newArr}; 
    case "removeDrugFromCart":
      const filteredDrugs = state.drugs.filter(
        (drug) => drug.drugName !== action.payload
      );
      return { ...state, drugs: filteredDrugs };

    case "clearCart":
      return {...state,drugs:[]}  
    default: {
      return { ...state };
    }
  }
};
// const cartSlice = createSlice({
//    name:"cart",
//    initialState:[] as drugsState[],
//    reducers:{
//        addItem:(state,action)=>{
//          state.push(action.payload)
//          console.log(state)
//        }
//    }
// })

// export const cart = (state:any) => state.cart.drugs
// export const {addItem} = cartSlice.actions
// export default cartSlice.reducer;
