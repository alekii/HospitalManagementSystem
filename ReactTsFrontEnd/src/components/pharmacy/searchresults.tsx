import { Box } from "@chakra-ui/react";
import React from "react";
import { FiShoppingCart } from "react-icons/fi";
import TableProps from "../common/interface/tableprops";
import TableUtil from "../common/tableutil";
import { useLocation, useParams } from "react-router-dom";
import httpService from "../../service/httpService";
import config from "../../config/config.json";
import { useDispatch, useSelector } from "react-redux";
import { addDrugsToCart } from "./features/actions";

const SearchResults=( )=> {
  const param = useParams(); 
  const dispatch = useDispatch();
  const searchTerm = param.searchTerm;
  const [bodyValues, setBodyValues] = React.useState([[]]);
  const [dataPresent, setDataPresent] = React.useState(false);
  let cart = useSelector(state=>state?.drugs)
  if(!cart){
      cart=[]
  }
  const [message, setMessage] = React.useState("");
  const location = useLocation()
  React.useEffect(() => { 
    fetchDrugByName();
  }, [location.key]);

  async function fetchDrugByName() {
    const endPoint = config.apiEndpoint + "/drugs/find/" + searchTerm;
    const res = await httpService
      .get(endPoint)
      .then((response) => {
         // console.log(cart)
        let tableBodyValues: any[] = [];
        let drugArr: any[] = [];
        response.data.map((res: any, index: number) => {
          drugArr[0] = res.drugName;
          drugArr[1] = res.price;
          tableBodyValues[index]=drugArr;
          drugArr = [];
        });
        setBodyValues(tableBodyValues);
        setDataPresent(true);
      })
      .catch((error) => {
        setMessage(error);
      });
  }

  if (dataPresent === false) {
    return (
      <Box w="80%" margin="50px 0 0 0">
        <p>No Such Drug exists </p>
      </Box>
    );
  }
  const TableItems: Array<TableProps> = [
    {
      heading: ["Drug Name", "Price", "Quantity"],
      bodyvalues: [],
      icon: FiShoppingCart,
      tablecaption: "Listing all drugs by name",
    },
  ];

  function handleAddToCart(values: any) {
    const drugCart =  []
    const drugItem: any = { drugName: "", drugPrice: "", drugQuantity: "" };
    const index = values.index;
    drugItem.drugName = bodyValues[index][0];
    drugItem.drugPrice = bodyValues[index][1];
    drugItem.drugQuantity = Number(values.drugQuantity);
    drugCart.push(drugItem) 
    dispatch(addDrugsToCart(drugCart));
   // handleItemsInCartChange()
  }

  return (
    <Box w="80%" margin="50px 0 0 0">
      <TableUtil
        addToCart={true}
        handleAddToCart={handleAddToCart}
        tablecaption={TableItems[0].tablecaption}
        heading={TableItems[0].heading}
        bodyvalues={bodyValues}
      ></TableUtil>
    </Box>
  );
}

export default SearchResults;
