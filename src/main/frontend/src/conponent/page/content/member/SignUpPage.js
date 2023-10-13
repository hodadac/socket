import { useState } from "react";
import {signUp} from "./Auth/AuthAPI";

export default function SignUpPage() {
    const [values, setValues] = useState({
        name: "",
        password: "",
    });

    const handleChange = async (e) => {
        setValues({...values,
            [e.target.id]: e.target.value,
        });
    }

    const handleSubmit = async (e) => {
        signUp(values)
            .then((response) => {
                if (!response.data){
                    alert("이미 가입된 ID 입니다.")
                }else{
                    alert("가입 성공")
                    window.location.href = `/Login`;
                }
            }).catch((error) => {
            console.log(error);
        });
        e.preventDefault()
    }

    return (
        <div className="d-flex justify-content-center" style={{ minHeight: "100vh" }}>
            <div className="align-self-center">
                <form onSubmit={handleSubmit}>
                    <div className="form-group" style={{ minWidth: "25vw" }}>
                        <label htmlFor="username">아이디</label>
                        <input type="text" className="form-control" id="name" onChange={handleChange} value={values.name} />
                    </div>
                    <div className="form-group" style={{ minWidth: "25vw" }}>
                        <label htmlFor="password">비밀번호</label>
                        <input type="password" className="form-control" id="password" onChange={handleChange} value={values.password} />
                    </div>
                    <div className="form-group" style={{ minWidth: "25vw" }}>
                        <button type="button" onClick={handleSubmit} style={{ width: "100%"}}>회원가입</button>
                    </div>
                </form>
            </div>
        </div>
    );
}