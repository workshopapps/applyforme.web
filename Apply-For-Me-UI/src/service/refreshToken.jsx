import axios from "axios";

let baseUrl = "https://api.applyforme.hng.tech/api/v1/auth/refresh-token";
export const refreshToken = func => {
    const refreshToken = localStorage.getItem("refreshTokenHngKey");
    let data = {
        "refresh_token": `${refreshToken}`
    };

    axios
        .post(baseUrl, data)
        .then(res => {
            let token = "tokenHngKey";
            let refresh = "refreshTokenHngKey";
            localStorage.setItem(token, res.data.token);
            localStorage.setItem(refresh, res.data.refresh_token);
        })
        .catch(err => console.log("refresk err", err));
};
