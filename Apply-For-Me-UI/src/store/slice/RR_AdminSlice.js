/* eslint-disable no-unused-vars */
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { toast } from "react-toastify";

const url = "https://official-volunux.uc.r.appspot.com";

export const Fetch_RR_Admin = createAsyncThunk(
    "RRadmin/Fetch_RR_Admin",
    async () => {
        try {
            const response = await axios.get(
                `${url}/api/v1/super-admin/recruiter/entries`,
                {
                    pageNo: 0,
                    pageSize: 10,
                    sortBy: "id",
                    sortDir: "asc",
                    from: "from",
                    to: "to",
                    q: "q"
                }
            );
            return response?.data;
        } catch (error) {
            console.log(error);
            toast.error(
                "An error occured while fetching reverse recruiter list",
                {
                    position: "top-right"
                }
            );
        }
    }
);

const RR_Admin_Slice = createSlice({
    name: "RRadmin",
    initialState: {
        list: [],
        loadingStatus: "",
        errorStatus: ""
    },
    reducers: {},
    extraReducers: {
        [Fetch_RR_Admin.pending]: (state, action) => {
            state.loadingStatus = "pending";
        },
        [Fetch_RR_Admin.fulfilled]: (state, action) => {
            state.list = action.payload;
            state.loadingStatus = "success";
            console.log(state.list);
        },
        [Fetch_RR_Admin.rejected]: (state, action) => {
            state.loadingStatus = "rejected";
        }
    }
});

export const RR_Admin_Actions = RR_Admin_Slice.actions;
export default RR_Admin_Slice;
