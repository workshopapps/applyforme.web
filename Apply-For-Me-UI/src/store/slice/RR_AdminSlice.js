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
                `${url}/api/v1/super-admin/member/recruiter/all`
            );
            return response?.data;
        } catch (error) {
           return error.response.data;
        }
    }
);
export const getRRAdminProfile = createAsyncThunk(
    "RRadmin/getRRAdminProfile",
    async (values, { rejectWithValue }) => {
        try {
            const response = await axios.get(
                `${url}/api/v1/super-admin/member/detail/${values.id}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            return response?.data;
        } catch (error) {
            return rejectWithValue(error.response.data);
        }
    }
);

export const SuperAdminApplicants = createAsyncThunk(
    "RRadmin/SuperAdminApplicants",
    async () => {
        try {
            console.log(token);
            const response = await axios.get(
                `${url}/api/v1/super-admin/applicant/entries`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);
export const Delete_RR_Admin = createAsyncThunk(
    "RRadmin/Delete_RR_Admin",
    async params => {
        try {
            const token = localStorage.getItem("tokenHngKey");
            const response = await axios.delete(
                `${url}/api/v1/super-admin/recruiter/${params.id}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            return response?.data;
        } catch (error) {
            console.log(error.response.data);
        }
    }
);

export const SuperAdmin_changePassword = createAsyncThunk(
    "RRadmin/SuperAdmin_changePassword",
    async value => {
        try {
            const token = localStorage.getItem("tokenHngKey");
            const response = await axios.post(
                `${url}/api/v1/super-admin/change-password`,
                {
                    "existing_password": value.oldpassword,
                    "new_password": value.newpassword,
                    "confirmation_password": value.confirmpassword
                },

                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);

export const getSuperAdminProfileInfo = createAsyncThunk(
    "RRadmin/getSuperAdminProfileInfo",
    async () => {
        try {
            const response = await axios.get(
                `${url}/api/v1/super-admin/profile`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log("superadmin info", response);
            return response?.data;
        } catch (error) {
            console.log(error.response.data);
        }
    }
);

const RR_Admin_Slice = createSlice({
    name: "RRadmin",
    initialState: {
        list: [],
        superAdminProfileDetails: {},
        superAdminProfileDetailsLoadingStatus: "",
        superAdminApplicantsList: [],
        loadingStatus: "",
        applicantsloadingStatus: "",
        errorStatus: "",
        deleteError: "",
        deleteStatus: "",
        reverseRProfile: {},
        RRProfileloadingStatus: "",
        RRProfilerrorStatus: ""
    },
    reducers: {},
    extraReducers: {
        [Fetch_RR_Admin.pending]: state => {
            state.loadingStatus = "pending";
        },
        [Fetch_RR_Admin.fulfilled]: (state, action) => {
            state.loadingStatus = "success";
            if (action.payload) {
                state.list = action.payload;
            }
        },
        [Fetch_RR_Admin.rejected]: (state, action) => {
            state.loadingStatus = "rejected";
            state.errorStatus = action.payload;
        },
        [Delete_RR_Admin.pending]: state => {
            state.deleteStatus = "pending";
        },
        [Delete_RR_Admin.fulfilled]: (state, action) => {
            state.deleteStatus = "success";
            console.log(action.payload);
        },
        [Delete_RR_Admin.rejected]: (state, action) => {
            state.deleteStatus = "rejected";
            state.deleteError = action.payload;
            console.log(state.deleteError);
        },
        [SuperAdminApplicants.pending]: state => {
            state.applicantsloadingStatus = "pending";
        },
        [SuperAdminApplicants.fulfilled]: (state, action) => {
            state.applicantsloadingStatus = "success";
            if (action.payload) {
                state.superAdminApplicantsList = action.payload;
                console.log(state.superAdminApplicantsList.content);
            }
        },
        [SuperAdminApplicants.rejected]: state => {
            state.applicantsloadingStatus = "rejected";
        },
        [getRRAdminProfile.pending]: state => {
            state.RRProfileloadingStatus = "pending";
        },
        [getRRAdminProfile.fulfilled]: (state, action) => {
            state.RRProfileloadingStatus = "success";
            if (action.payload) {
                state.reverseRProfile = action.payload;
                console.log(state.reverseRProfile);
            }
        },
        [getRRAdminProfile.rejected]: (state, action) => {
            state.RRProfileloadingStatus = "rejected";
            state.RRProfilerrorStatus = action.payload;
        },
        [getSuperAdminProfileInfo.pending]: state => {
            state.superAdminProfileDetailsLoadingStatus = "pending";
        },
        [getSuperAdminProfileInfo.fulfilled]: (state, action) => {
            state.superAdminProfileDetailsLoadingStatus = "success";
            if (action.payload) {
                state.superAdminProfileDetails = action.payload;
            }
            console.log(state.superAdminProfileDetails);
        },
        [getSuperAdminProfileInfo.rejected]: state => {
            state.superAdminProfileDetailsLoadingStatus = "rejected";
        }
    }
});

export const RR_Admin_Actions = RR_Admin_Slice.actions;
export default RR_Admin_Slice;
