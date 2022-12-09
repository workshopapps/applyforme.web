/* eslint-disable no-unused-vars */
import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const BaseUrl = "https://api.applyforme.hng.tech";

const initialState = {
    user: '',
isLoading: false
};

const UserSlice = createSlice({
    initialState,
    name: "user",
    reducers: {
        userInfo: (state, { payload }) => {
            state.isLoading = false;
            state.user = payload;
        }
    },
    extraReducers(builder) {
        builder
            .addCase(postUserAuth.pending, (state, { payload }) => {
                state.isLoading = true;
            })
            .addCase(postUserAuth.fulfilled, (state, { payload }) => {
                state.user = payload;
                console.log(state.user);
                state.isLoading = false;
            })
            .addCase(postUserAuth.rejected, (state, { payload }) => {
                state.isLoading = false;
                state.error = payload;
            });
    }
});

export const postUserAuth = createAsyncThunk(
    "post/UserAuth",
    async (data, thunkApi) => {
        try {
            const res = await axios.post(`${BaseUrl}`, data);
            return res.data;
        } catch (error) {
            return thunkApi.rejectWithValue(error.response.data);
        }
    }
);

export const ForgetPassword = createAsyncThunk(
    "post/password",
    async(values)=>{
        try{
            const response = await axios.get(`${BaseUrl}/api/v1/auth/forgot-password,`,{
                "email_address": values.email
          });
           return response?.data;
        }catch(error){
        console.log(error)
    }
    }
)

export const { userInfo } = UserSlice.actions;
export default UserSlice.reducer;
