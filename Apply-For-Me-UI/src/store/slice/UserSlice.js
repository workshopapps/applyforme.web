/* eslint-disable no-unused-vars */
import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const BAseUrl = "";

const initialState = {
    user: {}
};

const UserSlice = createSlice({
    initialState,
    name: "user",
    reducers: {}
});

export default UserSlice.reducer;
