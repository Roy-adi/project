import { Button, styled, Table, TableBody, TableCell, TableHead, TableRow } from "@mui/material";
import React from "react"
import { getUsers , deleteUser } from "../service/api";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";


const Thead =styled(TableRow)`
background: black;
& > th {
    color: palevioletred;
    font-size: 20px;
}
`
const Tbody =styled(TableRow)`
&> td{
    font-size: 20px;
}
`
const AllUser = ()=>{
   
    const[ user , setUser]= useState([])

    useEffect(() =>{
    getUserDetails()
    } ,[])
    const getUserDetails= async()=>{
     let response = await getUsers();
     setUser(response.data);

    }

    const deleteUserData  =async(id)=>{
        await deleteUser(id)
        getUserDetails();



    }

    return(
        <><p className="au">All User</p>
        <Table >
            <TableHead>
                <Thead>
                    <TableCell>Id</TableCell>
                    <TableCell>Name</TableCell>
                    <TableCell>Username</TableCell>
                    <TableCell>Email</TableCell>
                    <TableCell>Phone</TableCell>
                </Thead>
            </TableHead>
            <TableBody>
                {
                    user.map(user=>(
                       <Tbody>
                      <TableCell>{user.id}</TableCell>
                      <TableCell> {user.name} </TableCell>
                      <TableCell> {user.username} </TableCell>
                      <TableCell>{user.email} </TableCell>
                      <TableCell> {user.phone} </TableCell>
                      <TableCell>
                        <Button variant="contained" style={ {marginRight: 10}} LinkComponent ={Link} to ={`/edit/${user.id}`} >Edit</Button>
                        <Button  variant="contained" onClick={()=> deleteUserData(user.id)} >Delete</Button>
                      </TableCell>
                       </Tbody>
                    ))        
                }
            </TableBody>
        </Table></>
    
    )
}
export default AllUser;