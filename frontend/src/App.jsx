import React, { useEffect, useState } from "react";
import axios from "axios";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Main from "./pages/Main";
import MyBox from "./pages/MyBox";
import Bank from "./pages/Bank";

function App() {
  const [hello, setHello] = useState("");
  const [data, setData] = useState([]);

  useEffect(() => {
    axios
      .get("/numberwon")
      .then((response) => setHello(response.data))
      .catch((error) => console.log(error));
  }, []);

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />}></Route>
        <Route path="/bank" element={<Bank />}></Route>
        <Route path="/mybox" element={<MyBox />}></Route>
        {/* <div>백엔드에서 가져온 데이터입니다 : {hello}</div>; */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
