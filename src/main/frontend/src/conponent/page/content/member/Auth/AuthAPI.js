import axios from "axios";

const TOKEN_TYPE = localStorage.getItem("tokenType");
let ACCESS_TOKEN = localStorage.getItem("accessToken");

/** CREATE CUSTOM AXIOS INSTANCE */
export const AuthApi = axios.create({
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `${TOKEN_TYPE} ${ACCESS_TOKEN}`,
    },
});

export const login = async ({ name, password }) => {
    const data = { name, password };
    console.log(data)
    const response = await AuthApi.post(`/api/auth/login`, data);
    console.log(response.data);
    return response.data;
}

export const signUp = async ({ name, password }) => {
    const data = { name, password };
    console.log(data)
    const response = await AuthApi.post(`/api/auth/signup`, data);
    return response.data;
}