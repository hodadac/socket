import React, {useState} from 'react';
import {Link} from "react-router-dom";


function Login(){
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleEmail = (e)=>{
        setEmail(e.target.value);
    };
    const handlePassword = (e)=>{
        setPassword(e.target.value);
    };



    const onClickLogin = async () => {
        console.log("ID: ", email);
        console.log("PW: ", password);
        const user = {
            email,
            password
        };
        try {
            const response: Response = await fetch('/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(user),
            });
            if(response.ok){
                alert('login success');
                response.json().then( data => {
                    console.log(data);
                    localStorage.setItem("member", data["idx"]);
                    document.location.href="/";
                })
            }else{
                alert('login fail')

            }
        }catch (error){
            console.error('Error',error)
        }

    }


    return (
        <>
            <div>
                <input
                    type="email"
                    name="input_id"
                    value={email}
                    onChange={handleEmail}
                />
                <input
                    type="password"
                    name="input_pw"
                    value={password}
                    onChange={handlePassword}
                />

                <button type="button" onClick={onClickLogin}>로그인</button>
                <Link  to="/signUp"><button>회원가입</button></Link>
            </div>
        </>

    );
}

export default Login;