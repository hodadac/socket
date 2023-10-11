import React, {useEffect, useState} from 'react';

function PythonText(){

    const [getPythonData, setGetPythonData] = useState("");

    useEffect(()=>{
        fetch("/api/memo",{
            method:"GET",
        }).then((res) => res.text())
            .then(data => {
                console.log(data)
                setGetPythonData(data)
            })

    },[])

    return(
        <>
            <div>

                <font>pythonResult: {getPythonData}</font>
            </div>
        </>
    )

}

export default PythonText;