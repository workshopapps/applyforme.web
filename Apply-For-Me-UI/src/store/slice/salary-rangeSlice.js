import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from 'axios';

const BAseUrl = "https://official-volunux.uc.r.appspot.com";

export const  deleteSalaryRange = createAsyncThunk(
    "salary-range/update",
    async(values)=>{
       const response = await axios.get(`${BAseUrl}/api/v1/salary-range/delete/${values.id}`);
       return response?.data;
    }
)

export const   getSalaryRangeDetails = createAsyncThunk(
    "salary-range/details",
    async(values)=>{
       const response = await axios.get(`${BAseUrl}/api/v1/salary-range/detail/${values.id}`);
       return response?.data;
    }
)
export const getSalaryRangeEntries = createAsyncThunk(
    "salary-range/update",
        async(values)=>{
        const response = await axios.get(`${BAseUrl}/api/v1/salary-range/entries`,{
        page:values.page

       });
       return response?.data;
    }
)
export const saveSalaryRange = createAsyncThunk(
    "salary-range/save",
    async(values)=>{
       const response = await axios.get(`${BAseUrl}/api/v1/salary-range/save`,{
                "salary_range": values.salary_range
       });
       return response?.data;
    }
)
export const removeAllSalary = createAsyncThunk(
    "salary-range/update",
    async()=>{
       const response = await axios.get(`${BAseUrl}/api/v1/salary-range/remove/all`);
       return response?.data;
    }
)
export const removeManySalary = createAsyncThunk(
    "salary-range/update",
    async(values)=>{
       const response = await axios.get(`${BAseUrl}/api/v1/salary-range/remove/many`,{
            "ids":values.ids
        });
       return response?.data;
    }
)

export const updateSalaryRange = createAsyncThunk(
    "salary-range/update",
    async({values})=>{
        try{
            const response = await axios.get(`${BAseUrl}/api/v1/salary-range/update/${values.id}`,
            {
            "salary_range": values.salary_range
        }
        );
        return response?.data;

       
    }catch(error){
        console.log(error)
    }
    }
)
const initialState = {
    salaryId:'',
    createdOn:'',
    updatedOn:'',
    salary_range:''
};


const salarySlice = createSlice({
    initialState,
    name: "user",
    reducers: {
        
    },
   

});
export const salaryActions = salarySlice.actions;
export default salarySlice;
