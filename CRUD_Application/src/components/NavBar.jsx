import React from "react";
import {AppBar, Toolbar, Typography , styled} from '@mui/material';
import { NavLink } from "react-router-dom";

const Header = styled(AppBar)`
background : black;
`
const Tabs = styled(NavLink)`
font-size:20px;
Margin-right: 20px;
color : inherit;
text-decoration: none;
&:hover,
&:focus {
  color: palevioletred;
}
&:active {
  color: red;
}
`
const NavBar = ()=>{
    return(
        <Header position="static">
            <Toolbar>
                <Tabs to="/home">Home</Tabs>
                <Tabs to="/all">All user</Tabs>
                <Tabs to='/add'>Add user</Tabs>
            </Toolbar>
        </Header>
    )
}
export default NavBar