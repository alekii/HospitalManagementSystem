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
      return { ...state, drugs: state.drugs.concat(action.payload) };
    case "removeDrugFromCart":
      const filteredDrugs = state.drugs.filter(
        (drug) => drug.drugName !== action.payload
      );
      return { ...state, drugs: filteredDrugs };
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
