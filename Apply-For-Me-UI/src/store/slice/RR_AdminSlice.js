/* eslint-disable no-unused-vars */
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { useSelector } from "react-redux";
import { toast } from "react-toastify";
const url = "https://api.applyforme.hng.tech";
const token = localStorage.getItem("tokenHngKey");

export const Fetch_RR_Admin = createAsyncThunk(
    "RRadmin/Fetch_RR_Admin",
    async values => {
        try {
            const response = await axios.get(
                `${url}/api/v1/super-admin/member/recruiter/all`,
                {
                    params: {
                        "pageNo": values.pageNo,
                        "pageSize": values.pageSize
                    }
                }
            );
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);
export const getRRAdminProfile = createAsyncThunk(
    "RRadmin/getRRAdminProfile",
    async values => {
        try {
            console.log(values);
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
            return error.response.data;
        }
    }
);

export const SuperAdminApplicants = createAsyncThunk(
    "RRadmin/SuperAdminApplicants",
    async values => {
        try {
            const response = await axios.get(
                `${url}/api/v1/super-admin/applicant/entries`,
                {
                    params: {
                        "pageNo": values.pageNo,
                        "pageSize": values.pageSize
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log("super", response?.data);
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);

export const get_rr_applicants_list = createAsyncThunk(
    "RRadmin/SuperAdminApplicants",
    async values => {
        try {
            const response = await axios.get(
                `${url}/api/v1/super-admin/applicant/entries`,
                {
                    params: {
                        "pageNo": values.pageNo,
                        "pageSize": values.pageSize
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log("Recruiter", response?.data);
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);

export const Delete_RR_Admin = createAsyncThunk(
    "RRadmin/Delete_RR_Admin",
    async values => {
        console.log("fix-top");
        console.log(values);
        console.log(typeof values);
        console.log("fix-bottom");
        try {
            const response = await axios.delete(
                `${url}/api/v1/super-admin/recruiter/${values.id.id}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log(response);
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);

export const SuperAdmin_changePassword = createAsyncThunk(
    "RRadmin/SuperAdmin_changePassword",
    async value => {
        try {
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
            toast.success("password changed Successfully");
            return response?.data;
        } catch (error) {
            if (error.response.data) {
                toast.error(error.response.data.error);
            } else {
                toast.error(error.response.data.message);
            }
            console.log(error.response.data);
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
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);

export const updateSuperAdminProfileInfo = createAsyncThunk(
    "RRadmin/getSuperAdminProfileInfo",
    async values => {
        try {
            console.log(values);
            const response = await axios.put(
                `${url}/api/v1/super-admin/update`,
                values,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            toast.success("Profile updated Successfully!");
            return response?.data;
        } catch (error) {
            toast.error("something went wrong, please try again");
            return error.response.data;
        }
    }
);

export const updateReverseRecruiterProfileInfo = createAsyncThunk(
    "RRadmin/updateReverseRecruiterProfileInfo",
    async (values, id) => {
        console.log("user id:", id);
        try {
            const response = await axios.put(
                `${url}/api/v1/member/update`,
                values,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    },
                    params: { "id": id }
                }
            );
            toast.success("Profile updated Successfully!");
            return response?.data;
        } catch (error) {
            toast.error("something went wrong, please try again");
            return error.response.data;
        }
    }
);

export const getRRApplications = createAsyncThunk(
    "RRadmin/getRRApplications",
    async () => {
        try {
            const response = await axios.get(
                `${url}/api/v1/recruiter/application/entries`
            );
            console.log("rrApplication info", response?.data);
            return response?.data;
        } catch (error) {
            return error.response.data;
        }
    }
);

const RR_Admin_Slice = createSlice({
    name: "RRadmin",
    initialState: {
        list: [],
        recruiterApplicants: [],
        recruiterApplicantsLoading: "",
        recruiterApplicantsError: "",
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
        [get_rr_applicants_list.pending]: state => {
            state.recruiterApplicantsLoading = "pending";
            console.log(state.recruiterApplicantsLoading);
        },
        [get_rr_applicants_list.fulfilled]: (state, action) => {
            state.recruiterApplicantsLoading = "success";
            state.recruiterApplicants = action.payload;
        },
        [get_rr_applicants_list.rejected]: (state, action) => {
            state.recruiterApplicantsLoading = "rejected";
            state.recruiterApplicantsError = action.payload;
        },
        [Fetch_RR_Admin.pending]: state => {
            state.loadingStatus = "pending";
        },
        [Fetch_RR_Admin.fulfilled]: (state, action) => {
            state.loadingStatus = "success";
            if (action.payload) {
                state.list = action.payload;
                console.log(state.list);
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
            toast.success("deleted request successful");
            window.location.replace("/user-page");
        },
        [Delete_RR_Admin.rejected]: (state, action) => {
            state.deleteStatus = "rejected";
            toast.error("deleted request failed");
            state.deleteError = action.payload;
            console.log(state.deleteError);
        },
        [SuperAdminApplicants.pending]: state => {
            state.applicantsloadingStatus = "pending";
        },
        [SuperAdminApplicants.fulfilled]: (state, action) => {
            state.applicantsloadingStatus = "success";
            state.superAdminApplicantsList = action.payload;
        },
        [SuperAdminApplicants.rejected]: state => {
            state.applicantsloadingStatus = "rejected";
        },
        [getRRAdminProfile.pending]: state => {
            state.RRProfileloadingStatus = "pending";
            console.log(state.RRProfileloadingStatus);
        },
        [getRRAdminProfile.fulfilled]: (state, action) => {
            state.RRProfileloadingStatus = "success";
            state.reverseRProfile = action.payload;
        },
        [getRRAdminProfile.rejected]: (state, action) => {
            state.RRProfileloadingStatus = "rejected";
            console.log(state.RRProfileloadingStatus);
            state.RRProfilerrorStatus = action.payload;
        },
        [getSuperAdminProfileInfo.pending]: state => {
            state.superAdminProfileDetailsLoadingStatus = "pending";
            //console.log(state.superAdminProfileDetailsLoadingStatus);
        },
        [getSuperAdminProfileInfo.fulfilled]: (state, action) => {
            state.superAdminProfileDetailsLoadingStatus = "success";

            state.superAdminProfileDetails = action.payload;
            //console.log(state.superAdminProfileDetailsLoadingStatus);
        },
        [getSuperAdminProfileInfo.rejected]: state => {
            state.superAdminProfileDetailsLoadingStatus = "rejected";
            //console.log(state.superAdminProfileDetailsLoadingStatus);
        }
    }
});

export const RR_Admin_Actions = RR_Admin_Slice.actions;
export default RR_Admin_Slice;
