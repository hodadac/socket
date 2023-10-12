import React from 'react';
import TestPage from "./conponent/common/Navigation";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import SignInPage from "./conponent/page/content/member/SignInPage";
import SignUpPage from "./conponent/page/content/member/SignUpPage";
import Main from "./conponent/common/Main";


function App() {

  return(
      <>
          <BrowserRouter>
              <TestPage/>
                  <Routes>
                      <Route path="" element={<Main/>}></Route>
                      <Route path="/Login" element={<SignInPage/>}></Route>
                      <Route path="/SignUp" element={<SignUpPage/>}></Route>
                  </Routes>
              <SignUpPage/>
          </BrowserRouter>


      </>
  )
}

export default App;