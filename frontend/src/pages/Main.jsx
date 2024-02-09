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
        <Button
          className="px-4 py-2 mb-4 text-white bg-blue-500 rounded"
          onClick={goBank}
        >
          모바일 번호표 발급
        </Button>
        <Button
          className="px-4 py-2 text-white bg-blue-500 rounded"
          onClick={goMyBox}
        >
          번호표 보관함
        </Button>
      </div>
    </div>
  );
};

export default Main;
