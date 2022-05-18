import {
  Box, 
} from "@chakra-ui/react"; 
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";

const doctors = [
  {name:"Doctor one", room:"Lab"},
  {name:"Doctor two", room:"Clinic"},
  {name:"Doctor three", room:"Emergency"},
  {name:"Doctor four", room:"Nutririon"},
]

const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "name", type: "text", label: "Customer Name" }, 
    ],
    select: [
      { id: "room",label:"Room",options:  [] }, 
    ], 
  },
   
];

const rooms:string[] = [] 

doctors.map(d=>{
  rooms.push(d.room)
})

FormItems.map((f:any)=>{
   f.select[0].options = rooms;
})

function AddNewAppointment() {

  function getFormData(values:any){ 
    return new Promise<void>((resolve)=>{
        setTimeout(()=>{
            console.log(JSON.stringify(values,null,2))
            resolve()
        },100)
    })
  }

  return (  <Box
    w="50%"
    mt="50px"  
  > 
        <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
    
  </Box>
  )
}

export default AddNewAppointment;