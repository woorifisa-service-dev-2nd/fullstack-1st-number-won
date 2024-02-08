import React, { useState } from "react";
import Button from "../components/common/Button";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Bank = () => {
  const [branch, setBranch] = useState(null);
  const [department, setDepartment] = useState(null);
  const [myTicket, setMyTicket] = useState(false);

  const branches = [
    { id: "1", branch_code: "960605", name: "유은지점" },
    { id: "2", branch_code: "960117", name: "원섭지점" },
    { id: "3", branch_code: "001107", name: "이솔지점" },
    { id: "4", branch_code: "960612", name: "남혁지점" },
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
      const response = await axios.post(
        "/numberwon",
        ticket
      );
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const countTicket = (branchCode, departmentId) => {
    const ticket = {
      userId: 11,
      localDateTime: new Date(),
      status: 1,
      branchCode: branch.branch_code,
      departmentId: department.id,
    };
    
    try {
      const response = axios.get(
        `/numberwon/bank/${branchCode}/${departmentId}`,
        ticket
      );
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  }
  const navigate = useNavigate();
  const goMyBox = () => {
    navigate("/mybox");
  };

  return (
    <>
      <div>
        {branches.map((branch) => (
          <Button key={branch.id} onClick={() => setBranch(branch)}>
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
        <div>
          <span>대기자 수 : {}명</span>
          <Button onClick={orderTicket}>번호표 발급받기</Button>
        </div>
      )}
      {branch && department && myTicket && (
        <div>
          <span>번호표를 발급받았습니다!</span>
          <Button onClick={goMyBox}>번호표 보관함 가기</Button>
        </div>
      )}
    </>
  );
};

export default Bank;
