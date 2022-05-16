import { Box, Flex, FormControl, Icon, Select, Text,} from "@chakra-ui/react";
import { FiDollarSign, FiUsers } from "react-icons/fi";
import { IconType } from 'react-icons';


interface RevenueProps {
    ItemName: string;
    icon: IconType;
    ItemNumber: number;
}


const QuickReport: Array<RevenueProps> = [
    { ItemName: "Revenue", icon: FiDollarSign, ItemNumber: 234104 },
    { ItemName: "Treatment Revenue", icon: FiDollarSign, ItemNumber: 20104 },
    { ItemName: "Drug Sales", icon: FiDollarSign, ItemNumber: 214104 },
    { ItemName: "Patients Treated", icon: FiUsers, ItemNumber: 22 },
]


const Revenue = () => {
    return (<>
    <Box  mb='4' float='right' mr='12'>
    <FormControl>
            <Select>
                <option>Today</option>
                <option>This Week</option>
                <option>This Month</option>
            </Select>
        </FormControl> 
    </Box>
    <Flex justifyContent="space-around" w="100%">

            {QuickReport.map(qr => {
                return (
                    <QBox
                        key={qr.ItemName}
                        ItemName={qr.ItemName}
                        icon={qr.icon}
                        ItemNumber={qr.ItemNumber}
                    ></QBox>
                );
            })}

        </Flex></>
    );
};


 
export default Revenue;

const QBox = ({ icon, ...rest }: RevenueProps) => {
    return (

        <Box h="200px" w="200px" bg="#f3f3f3">
            <Text fontSize="19px" fontWeight='600' textAlign='center' pt='40px' pb='20px' opacity='0.85'>{rest.ItemName}</Text>
            <Icon w='100%' fontSize='18px' alignContent='center' as={icon}></Icon>
            <Text pt='20px' textAlign='center' fontSize='18px'>Kshs {rest.ItemNumber}</Text>
        </Box>

    )
}