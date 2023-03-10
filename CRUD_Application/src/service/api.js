import axios from 'axios'

const API_URL ="http://localhost:3002/users";
export const  adduser = async(data)=>{
    try{
    return await axios.post(API_URL, data )
}catch(error){
    console.log("Exception", error.message);
}
}

export const getUsers = async()=>{
    try{
      return await axios.get(API_URL)

    }catch(error){
        console.log(error.message)
    }
}

export const fetchUser = async(data)=>{
    try{
      return await axios.get(`${API_URL}/${data}`);

    }catch(error){
        console.log(error.message)
    }
}

export const edituser = async (data, id)=>{
    try{
      return await axios.put(`${API_URL}/${id}`, data);

    } catch (error){
    console.log(error.message)
}
}

export const deleteUser = async(id)=>{
    try{
    return await axios.delete(`${API_URL}/${id}`)

    }catch(error){
        console.log(error.message)
    }
}