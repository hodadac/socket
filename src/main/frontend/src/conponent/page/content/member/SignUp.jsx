import React, {useState} from 'react';

function SignUp() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [name, setName] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");

    const handleEmail = (e) => {
        setEmail(e.target.value);
    };
    const handlePassword = (e) => {
        setPassword(e.target.value);
    };
    const handleName = (e) => {
        setName(e.target.value);
    };
    const handlePhoneNumber = (e) => {
        setPhoneNumber(e.target.value);
    };
    const onClickSignUp = async () => {
        console.log("ID: ", email);
        console.log("PW: ", password);
        console.log("NAME: ", name)
        console.log("PhoneNumber: ", phoneNumber)
        const userInfo = {
            email,
            password,
            name,
            phoneNumber
        };

        try {
            const response: Response = await fetch('/api/signUp', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userInfo),
            });
            if (response.ok) {
                alert('SignUp success');
                response.text().then(data => {
                    console.log(data);
                })
                document.location.href="/login"
            } else {
                alert('SignUp fail')
            }
        } catch (error) {
            console.error('Error', error)
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
                <input
                    type="text"
                    name="input_name"
                    value={name}
                    onChange={handleName}
                />
                <input
                    type="text"
                    name="input_phoneNumber"
                    value={phoneNumber}
                    onChange={handlePhoneNumber}
                />


                <button type="button" onClick={onClickSignUp}>제출</button>

            </div>
        </>
    )

}
export default SignUp;