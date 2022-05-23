export const addDrugsToCart=(drugItem:any[])=>{ 
    return{
        type:"addDrugsToCart",
        payload:drugItem
    }
}

export const removeFromCart=(index:number)=>{
    return{
        type:"removeDrugFromCart",
        payload:index
    }
}