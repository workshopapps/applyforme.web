/* eslint-disable no-unused-vars */
import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const BaseUrl = "";

const initialState = {
    user: "",
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
                state.loading = true;
            })
            .addCase(postUserAuth.fulfilled, (state, { payload }) => {
                state.user = payload;
                state.loading = false;
            })
            .addCase(postUserAuth.rejected, (state, { payload }) => {
                state.loading = false;
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

export const { userInfo } = UserSlice.actions;
export default UserSlice.reducer;
