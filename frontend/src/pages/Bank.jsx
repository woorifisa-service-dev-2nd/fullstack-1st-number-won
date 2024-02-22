import React, { useState } from "react";
import Button from "../components/common/Button";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Bank = () => {
  const [branch, setBranch] = useState(null);
  const [department, setDepartment] = useState(null);
  const [myTicket, setMyTicket] = useState(false);

  const branches = [
    { branch_code: "960605", name: "유은지점" },
    { branch_code: "960117", name: "원섭지점" },
    { branch_code: "001107", name: "이솔지점" },
    { branch_code: "960612", name: "남혁지점" },
  ];

  const departments = [
    { id: "100", name: "예금팀" },
    { id: "200", name: "종합상담팀" },
  ];

  const orderTicket = async () => {
    const ticket = {
      userId: 11,
      localDateTime: new Date(),
      status: 1,
      branchCode: branch.branch_code,
      departmentId: department.id,
    };

    console.log(ticket);
    setMyTicket(true);

    try {
      const response = await axios.post("/numberwon", ticket);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const navigate = useNavigate();
  const goMyBox = () => {
    navigate("/mybox");
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <div>
        {branches.map((branch) => (
          <Button key={branch.branch_code} onClick={() => setBranch(branch)}>
            {branch.name}
          </Button>
        ))}
      </div>
      {branch && (
        <div>
          {departments.map((department) => (
            <Button
              key={department.id}
              onClick={() => setDepartment(department)}
            >
              {department.name}
            </Button>
          ))}
        </div>
      )}
      {branch && department && (
        <div className="flex flex-col items-center justify-center mt-8">
          <span>대기자 수 : 0명</span>
          <Button onClick={orderTicket}>번호표 발급받기</Button>
        </div>
      )}
      {branch && department && myTicket && (
        <div className="flex flex-col items-center justify-center mt-8">
          <span>번호표를 발급받았습니다!</span>
          <Button onClick={goMyBox}>번호표 보관함 가기</Button>
        </div>
      )}
    </div>
  );
};

export default Bank;
