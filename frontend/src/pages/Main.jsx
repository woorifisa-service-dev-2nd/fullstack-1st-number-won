import React from "react";
import { useNavigate } from "react-router-dom";
import Button from "../components/common/Button";

const Main = () => {
  const navigate = useNavigate();

  const goBank = () => {
    navigate("/bank");
  };

  const goMyBox = () => {
    navigate("/mybox");
  };

  return (
    <div>
      <h1>우리은행 모바일 번호표 발급 서비스</h1>
      <Button onClick={goBank}>모바일 번호표 발급</Button>
      <Button onClick={goMyBox}>번호표 보관함</Button>
    </div>
  );
};

export default Main;
