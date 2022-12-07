import axios from "axios";
const instance = axios.create({
    baseURL: "https://api.applyforme.hng.tech"
});
export default instance;
