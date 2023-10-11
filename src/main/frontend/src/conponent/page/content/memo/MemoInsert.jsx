import React, {useState} from 'react';

function MemoInsert(){
    const [content,setContent] = useState("");
    const memberId = localStorage.getItem('member');
    const handleContent = (e) => {
        setContent(e.target.value);
    };


    const onClickText = async () => {
        console.log("Content: ", content);
        console.log("memberId:", memberId);
        const memo = {
            memberId,
            content
        };
        try {
            const response: Response = await fetch('/api/memo/insert', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(memo),
            });
            if(response.ok){
                alert('Registration success');
                document.location.href="/";
            }else{
                alert('Registration fail')
            }
        }catch (error){
            console.error('Error',error)
        }

    }

    return(
        <>
            <div>
                <font>memoInsert</font>
                <br/>
                <textarea
                    name="input_text"
                    value={content}
                    onChange={handleContent}
                />
                <button type="button" onClick={onClickText}>등록</button>
            </div>
        </>
    )
}

export default MemoInsert;