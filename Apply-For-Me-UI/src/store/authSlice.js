import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
const auth_Slice = createSlice({
    name:'auth',
    initialState:{
        token:"",
        first_name:"",
        last_name:"",
        email_address:"",
        phone_number:"",
        _id:'',
        registerStatus:'',
        registerError:'',
       LoginStatus:'',
       LoginError:'',
       userLoaded:false,

    },
    reducers:{},
    extraReducers:{}
})
export default auth_Slice;