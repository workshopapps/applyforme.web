import axios from "axios";

let baseUrl = "https://api.applyforme.hng.tech/api/v1/auth/refresh-token";

const refreshToken = localStorage.getItem("refreshTokenHngKey");
let data = {
    "refresh_token": `${refreshToken}`
};

axios.interceptors.response.use((response) => response, async (error) => {
    if(error?.response?.status === 401){
        await axios
        .post(baseUrl, data)
        .then(res => {
            let token = "tokenHngKey";
            let refresh = "refreshTokenHngKey";
            localStorage.setItem(token, res.data.token);
            localStorage.setItem(refresh, res.data.refresh_token);
            return axios(error?.config);
        })
        .catch(err => console.log("refresk err", err));
    }
})