import axios from "axios";

const DEVURL = "https://api.applyforme.hng.tech/"; //Testing
const LIVEURL = "https://api.applyforme.hng.tech/"; // live Env
const tokenKey = "tokenHngKey";
const client = axios.create({
    baseURL: process.env.NODE_ENV == "development" ? DEVURL : LIVEURL,
    headers: {
        "Accept": "*/*",
        "Content-Type": "application/json"
    },
    transformRequest: [
        function (data, headers) {
            headers["Content-Type"] = "application/json";
            headers["Authorization"] = `Bearer ${localStorage.getItem(
                tokenKey
            )}`;
            return JSON.stringify(data);
        }
    ]
});

export default client;

// Usages
// await client
//   .post('/Account/emaillogin', data)
//   .then((res) => { })
//   .catch(e => {
//     toast.error(e?.response?.data?.Message ?? e?.message);
//   })
