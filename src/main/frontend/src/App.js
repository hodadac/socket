import React from 'react';
import TestPage from "./conponent/common/Navigation";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import SignInPage from "./conponent/page/content/member/SignInPage";
import SignUpPage from "./conponent/page/content/member/SignUpPage";
import Main from "./conponent/common/Main";
import NotFound from "./conponent/page/content/NotFound";
import Chat from "./conponent/page/content/chat/Chat";


function App() {

  return(
      <>
          <BrowserRouter>
              <TestPage/>
                  <Routes>
                      <Route path="" element={<Main/>}></Route>
                      <Route path="/Login" element={<SignInPage/>}></Route>
                      <Route path="/SignUp" element={<SignUpPage/>}></Route>
                      <Route path="*" element={<NotFound/>}></Route>
                  </Routes>
          </BrowserRouter>


      </>
  )
}

export default App;