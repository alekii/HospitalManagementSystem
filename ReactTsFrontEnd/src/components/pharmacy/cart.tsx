import { Box, Button } from "@chakra-ui/react";
import TableUtil from "../common/tableutil";
import TableProps from "../common/interface/tableprops";
import { FiX } from "react-icons/fi";
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { clearCart, removeFromCart } from "./features/actions";
import config from "../../config/config.json";
import httpService from "../../service/httpService";

function Cart() {
  const TableItems: Array<TableProps> = [
    {
      heading: ["Drug Name", "Amount", "Quantity", "SubTotal", "Action"],
      bodyvalues: [
        ["Amoxil", "30", "10", 300],
        ["Aspirin", "200", "3", 600],
        ["Mara Moja", "3", "10", 30],
      ],
      icon: FiX,
      tablecaption: "Drugs Shopping Cart",
    },
  ];
  const dispatch = useDispatch();
  const cart = useSelector((state) => state?.drugs);
  const [bodyValues, setBodyValues] = React.useState([]);
  let [cartTotal, setCartTotal] = React.useState(0);
  let [tableItems, setTableItems] = React.useState(TableItems);
  let [dataPresent, setDataPresent] = React.useState(false);
  let [receiptReady, setReceiptReady] = React.useState(false);

  if (!cart) {
    return NoItemsInCart();
  }
  React.useEffect(() => {
    let itemsInCart: any = [];
    let total = 0;
    let tableBodyValues: any = [];

    cart.map((drug: any, index: number) => {
      itemsInCart[0] = drug.drugName;
      itemsInCart[1] = drug.drugPrice;
      itemsInCart[2] = drug.drugQuantity;
      itemsInCart[3] = drug.drugPrice * drug.drugQuantity;
      total += itemsInCart[3];
      tableBodyValues[index] = itemsInCart;
      itemsInCart = []; 
    });
    setTableBodyValues(tableBodyValues, total);
    setDataPresent(true);
  }, []);

  function setTableBodyValues(tableBodyValues: any, total: number) {
    setCartTotal(total);
    setBodyValues(tableBodyValues);
  }
  const removeItem = (
    event: React.MouseEventHandler<HTMLTableColElement>,
    index: number
  ) => {
    dispatch(removeFromCart(bodyValues[index][0]));
    tableItems = bodyValues.splice(index, 1);
    setTableItems(tableItems);
    let totalAmount = 0;
    bodyValues.length === 0
      ? setDataPresent(false)
      : bodyValues.map((s) => {
          totalAmount += s[3];
          setCartTotal(totalAmount);
        });
  };
  if (dataPresent === false) {
    return NoItemsInCart();
  }

  async function processDrugSale() {
    let drugSaleList = { drugSaleList: cart };
    const endPoint = config.apiEndpoint + "/api/drugsalereceipt/find"
    await httpService
      .get(endPoint)
      .then((response) => {
        setReceiptReady(true);
        dispatch(clearCart());
      })
      .catch((error) => {
        console.log(error);
      });
  }
  if (receiptReady) {
    return showReceipt();
  }

  return (
    <Box w="80%" margin="50px 0 0 0">
      <TableUtil
        tablecaption={TableItems[0].tablecaption}
        handleClick={removeItem}
        icon={TableItems[0].icon}
        heading={TableItems[0].heading}
        bodyvalues={bodyValues}
      ></TableUtil>
      <Box as="p" textAlign="end" fontSize="17px">
        <strong>Total: </strong>Kshs {cartTotal}
      </Box>
      <Button
        onClick={processDrugSale}
        float="right"
        mt="30px"
        px="8"
        bg="#777873"
        color="white"
        _hover={{
          bg: "#757",
          color: "white",
        }}
      >
        Process Sale
      </Button>
    </Box>
  );
}

function NoItemsInCart() {
  return (
    <Box w="80%" margin="50px 0 0 0">
      <Box as="p" textAlign="center" fontSize="17px">
        <strong>INFO: </strong> No items in Cart
      </Box>
    </Box>
  );
}

function showReceipt() {
  //Show Receipt here to be printed/ Returned from server
  return (
    <Box w="80%" margin="50px 0 0 0">
      <Box as="p" textAlign="center" fontSize="17px">
        <strong>INFO: </strong> Receipt is ready to be printed
      </Box>
    </Box>
  );
}

export default Cart;
