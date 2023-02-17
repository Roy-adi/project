import { Button, FormControl, FormGroup, Input, InputLabel, styled } from "@mui/material";
import React from "react"
import { useState } from "react";
import { adduser } from "../service/api";
import { useNavigate } from "react-router-dom";

const Container =styled(FormGroup)`
width: 50%;
margin:5% auto 0 auto;
& > div {
    margin-top: 20px;
`
const intialvalues= {
 name:" ",
 username : " ",
 email: " ",
 phone:""

}
const AddUser = ()=>{
    const [user, setUser]= useState(intialvalues)
    const onValueChange =(e)=>{
        console.log(e.target.name ,e.target.value)
        setUser({...user , [e.target.name]: e.target.value})
    }
    const adduserdetails = async()=>{
     await adduser(user)
     alert("User Added");
     Navigate("/all");
    }

    const Navigate = useNavigate();

    return(
        <><p className="au">Add User</p>
        <Container>
            
            <FormControl>
                <InputLabel>Name</InputLabel>
                <Input onChange={(e)=>onValueChange(e)} name="name"/>
            </FormControl>
            <FormControl>
                <InputLabel>Username</InputLabel>
                <Input onChange={(e)=>onValueChange(e)}name="username" />
            </FormControl>
            <FormControl>
                <InputLabel>Email</InputLabel>
                <Input onChange={(e)=>onValueChange(e)}name="email" />
            </FormControl>
            <FormControl>
                <InputLabel>Phone</InputLabel>
                <Input onChange={(e)=>onValueChange(e)}name="phone" />
            </FormControl>
            <FormControl>
                <Button onClick={()=> adduserdetails()} variant="contained">Add User</Button>
            </FormControl>
        </Container></>
    
    )
}
export default AddUser;
