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
    <div className="flex flex-col items-center justify-center min-h-screen ">
      <h1 className="mb-8 text-4xl">우리은행 모바일 번호표 발급 서비스</h1>
      <div>
        <Button onClick={goBank}>모바일 번호표 발급</Button>
        <Button onClick={goMyBox}>번호표 보관함</Button>
      </div>
    </div>
  );
};

export default Main;
