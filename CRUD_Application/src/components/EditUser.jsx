import { Button, FormControl, FormGroup, Input, InputLabel, styled } from "@mui/material";
import React from "react"
import { useState , useEffect } from "react";
import { fetchUser , edituser } from "../service/api";
import { useNavigate , useParams} from "react-router-dom";

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
const EditUser = ()=>{
    const [user, setUser]= useState(intialvalues)
    const onValueChange =(e)=>{
        console.log(e.target.name ,e.target.value)
        setUser({...user , [e.target.name]: e.target.value})
    }
    const edituserdetails = async()=>{
     await edituser(user , id)
     alert("User Updated");
     Navigate("/all");
    }

    useEffect(()=>{
      fetchUserData();
    },[]);
    const fetchUserData =async ()=>{
        let response= await fetchUser(id)
        console.log(response)
        setUser(response.data);
    }

    const Navigate = useNavigate();
    const { id } =useParams();

    return(
        <><p className="au">Edit User</p>
        <Container>
            
            <FormControl>
                <InputLabel>Name</InputLabel>
                <Input onChange={(e)=>onValueChange(e)} name="name" value={user.name}/>
            </FormControl>
            <FormControl>
                <InputLabel>Username</InputLabel>
                <Input onChange={(e)=>onValueChange(e)}name="username" value={user.username} />
            </FormControl>
            <FormControl>
                <InputLabel>Email</InputLabel>
                <Input onChange={(e)=>onValueChange(e)}name="email" value={user.email} />
            </FormControl>
            <FormControl>
                <InputLabel>Phone</InputLabel>
                <Input onChange={(e)=>onValueChange(e)}name="phone" value={user.phone} />
            </FormControl>
            <FormControl>
                <Button onClick={()=> edituserdetails()} variant="contained" >Edit User</Button>
            </FormControl>
        </Container></>
    
    )
}
export default EditUser;
