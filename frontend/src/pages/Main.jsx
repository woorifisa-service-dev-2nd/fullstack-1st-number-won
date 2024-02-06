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
      <h1 className="text-4xl mb-8">우리은행 모바일 번호표 발급 서비스</h1>
      <Button className="bg-blue-500 text-white px-4 py-2 rounded mb-4" onClick={goBank}>
        모바일 번호표 발급
      </Button>
      <Button className="bg-blue-500 text-white px-4 py-2 rounded" onClick={goMyBox}>
        번호표 보관함
      </Button>
    </div>
  );
};

export default Main;
