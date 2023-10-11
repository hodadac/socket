import React, {useState, useEffect} from 'react';
import MemoInsert from "./MemoInsert";

function MemoList(){
    const [memoList , setMemoList] = useState("");
    const memberId = localStorage.getItem('member');
    const memoGet = {
        memberId
    }

    useEffect(()=>{
        fetch("/api/memo",{
            method:"POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(memoGet),
        }).then((res) => res.json())
            .then(data => {
                console.log(data)
                console.log(typeof data);
                setMemoList(data);
            })

    },[])

    return(
        <>

            <font>memoLists</font>
            <div>
                {Array.isArray(memoList)
                    ? memoList.map(element => {
                        return<ul key={element["memoIdx"]}>
                                <li>{element["content"]}</li>
                            </ul>;
                    })
                    : null
                }
            </div>
            <MemoInsert/>
        </>
    )
}

export default MemoList;