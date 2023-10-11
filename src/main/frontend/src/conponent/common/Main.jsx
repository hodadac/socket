import React from 'react';
import {Route, Routes} from "react-router-dom";
import MemoList from "../page/content/memo/MemoList";
import NotFound from "../page/content/NotFound";
import Chat from "../page/content/chat/Chat";

function Main(){

    return(
        <>
            <Routes>
                <Route path="/" element={<MemoList/>}></Route>
                <Route path="*" element={<NotFound/>}></Route>
                <Route path="/chat" element={<Chat/>}></Route>
            </Routes>
        </>
    );
}

export default Main;