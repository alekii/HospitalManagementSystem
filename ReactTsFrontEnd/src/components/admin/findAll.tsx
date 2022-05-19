import { Box } from "@chakra-ui/react";
import TableUtil from "../common/tableutil";
import TableProps from "../common/interface/tableprops";
import { FiEdit } from "react-icons/fi";
import React from "react";
import { useNavigate, useLocation } from "react-router-dom";
import config from "../../config/config.json";
import httpService from "../../service/httpService";

const linkToPatientDetail = "/doctor/patients/details";

function FindAllEmployeesByCareerName() {
    const [bodyValues, setBodyValues] = React.useState([[]]);
    const [dataPresent, setDataPresent] = React.useState(false);
    const location = useLocation();
    const navigate = useNavigate();

    const allowedUrls = ["doctors", "receptionists", "pharmacists"]
    console.log(typeof(location.state))
    if(!location.state) navigate("/pagenotfound")
    //I know the type, right TypeScript? It is a String by now!
    const jobFunction: string = location.state.toLowerCase();
    //Avoiding calling api on a non-existent url 
    //declare table header names and columns 
    const TableItems: Array<TableProps> = [
        {
            heading: [
                "FirstName",
                "Last Name",
                "Age",
                "Gender",
                "Email",
                "Action",
            ],
            bodyvalues: [],
            icon: FiEdit,
            tablecaption: "Listing all " + jobFunction,
        },
    ];

    React.useEffect(() => {
        fetchEmployee();
    }, []);

    async function fetchEmployee() {
        //endpoint changes as per the data you want to fetch
        const endPoint = config.apiEndpoint + "/admin/employees/" + jobFunction + "/find/all";
        const response = await httpService.get(endPoint);
        if (response.data.length > 0) {
            let bodyValues: any[] = [];
            let values: any[] = [];
            response.data.map((data: any, index: number) => {
                values[0] = data.firstName;
                values[1] = data.lastName;
                values[2] = data.age;
                values[3] = data.gender;
                values[4] = data.email;
                //We are using one table to render. If rendering Doctors add two body columns 
                if (jobFunction === "doctors") {
                    values[5] = data.speciality;
                    values[6] = data.room;
                }
                bodyValues[index] = values;
                values = [];
            });

            setBodyValues(bodyValues);
            setDataPresent(true);
        }
    }

    //We are using one table to render. If rendering Doctors add two header columns 
    if (jobFunction === "doctors") {
        TableItems[0].heading.pop()
        TableItems[0].heading.push("Speciality")
        TableItems[0].heading.push("Room Assigned")
        TableItems[0].heading.push("Action")
    }

    const edit = (
        event: React.MouseEventHandler<HTMLTableColElement>,
        index: number
    ) => {
        navigate(linkToPatientDetail, { state: { id: index } });
    };

    if (dataPresent === false) {
        return (
            <Box w="80%" margin="50px 0 0 0">
                <p>No Data</p>
            </Box>
        );
    }
    return (
        <Box w="80%" margin="50px 0 0 0">
            <TableUtil
                icon={TableItems[0].icon}
                tablecaption={TableItems[0].tablecaption}
                handleClick={edit}
                heading={TableItems[0].heading}
                bodyvalues={bodyValues}
            ></TableUtil>
        </Box>
    );
}

export default FindAllEmployeesByCareerName;
