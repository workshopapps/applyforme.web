/* eslint-disable no-unused-vars */
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

const url = "https://api.applyforme.hng.tech";
const token = localStorage.getItem("tokenHngKey");

export const Fetch_RR_Admin = createAsyncThunk(
    "RRadmin/Fetch_RR_Admin",
    async () => {
        try {
            const response = await axios.get(
                `${url}/api/v1/super-admin/member/recruiter/all`);
                console.log(response?.data);
            return response?.data;
           
        } catch (error) {
           console.log(error.response.data);

        }
    }
);
export const getRRAdminProfile = createAsyncThunk(
    "RRadmin/getRRAdminProfile",
    async (values,  { rejectWithValue }) => {
        try {
            const response = await axios.get(`${url}/api/v1/super-admin/recruiter/${values.id}`);
            console.log(response?.data)
            return response?.data;
        } catch (error) {
            return rejectWithValue(error.response.data);
        }
    }
)

export const SuperAdminApplicants = createAsyncThunk(
    "RRadmin/SuperAdminApplicants",
    async () => {
        try {
            console.log(token);
            const response = await axios.get(`${url}/api/v1/super-admin/applicant/entries`,{
                headers:{
                    "Authorization":`Bearer ${token}` 
                }
            });
            console.log(response?.data)
            return response?.data;
        } catch (error) {
            console.log(error);
        }
    }
)
export const Delete_RR_Admin = createAsyncThunk(
    "RRadmin/Delete_RR_Admin",
    async (params, { rejectWithValue }) => {
        try {
            const token = localStorage.getItem("tokenHngKey");
            console.log(token);
            const response = await axios.delete(`${url}/api/v1/super-admin/member/remove/${params.id}`, { 
                headers: { "Authorization": `Bearer ${token}` } 
            });
            console.log("deleted")
            return response?.data;
        } catch (error) {
            return rejectWithValue(error.response.data);
        }
    }
);
const RR_Admin_Slice = createSlice({
    name: "RRadmin",
    initialState: {
        list: [],
        superAdminApplicantsList:[],
        loadingStatus: "",
        applicantsloadingStatus:"",
        errorStatus: "",
        deleteError:"",
        deleteStatus:"",
        reverseRecruiterfirstName:'',
        reverseRecruiterLasttName:'',
        reverseRecruiterPhoneNumber:'',
        reverseRecruiterCurrentJobTitle:'',
        reverseRecruiteEemailAddress:'',
        reverseRecruiterAvatar:'',
        RRProfileloadingStatus:"",
        RRProfilerrorStatus: "",
    },
    reducers: {},
    extraReducers: {
        [Fetch_RR_Admin.pending]: (state) => {
            state.loadingStatus = "pending";
            console.log(state.loadingStatus )
        },
        [Fetch_RR_Admin.fulfilled]: (state, action) => {
            state.loadingStatus = "success";
            if(action.payload){
                state.list = action.payload;
            }
        },
        [Fetch_RR_Admin.rejected]: (state,action) => {
            state.loadingStatus = "rejected";
            state.errorStatus = action.payload;
            console.log(state.loadingStatus )
            console.log(state.errorStatus)
        },
        [Delete_RR_Admin.pending]: (state) => {
            state.deleteStatus = "pending";
        },
        [Delete_RR_Admin.fulfilled]: (state, action) => {
            state.deleteStatus = "success";
            console.log(action.payload)
            
        },
        [Delete_RR_Admin.rejected]: (state,action) => {
            state.deleteStatus = "rejected";
            state.deleteError = action.payload;
            console.log(state.deleteError);
        },
        [SuperAdminApplicants.pending]: (state) => {
            state.applicantsloadingStatus = "pending";
        },
        [SuperAdminApplicants.fulfilled]: (state, action) => {
            state.applicantsloadingStatus = "success";
            if(action.payload){
                state.superAdminApplicantsList = action.payload;
                console.log(state.superAdminApplicantsList.content);
            }
            
            
        },
        [SuperAdminApplicants.rejected]: (state) => {
            state.applicantsloadingStatus = "rejected";
        },
        [getRRAdminProfile.pending]: (state) => {
            state.RRProfileloadingStatus = "pending";
        },
        [getRRAdminProfile.fulfilled]: (state, action) => {
            state.RRProfileloadingStatus = "success";
            const details = action.payload;
            console.log(details);
            
        },
        [getRRAdminProfile.rejected]: (state,action) => {
            state.RRProfileloadingStatus = "rejected";
            state.RRProfilerrorStatus = action.payload;
            console.log(state.RRProfilerrorStatus);
        }
    }
});

export const RR_Admin_Actions = RR_Admin_Slice.actions;
export default RR_Admin_Slice;
