import React, { useState, useEffect } from "react";
import axios from "axios";
import Button from "../components/common/Button";

function MyBox() {
  const [data, setData] = useState(null);
  useEffect(() => {
    axios
      .get("/numberwon/mybox")
      .then((response) => setData(response.data))
      .catch((error) => console.log(error));
  }, []);

  console.log(data);

  const deleteTicket = (orderId) => async () => {
    try {
      const response = await axios.delete(`/numberwon/mybox/${orderId}`);
      console.log(response.data);
      const newData = await axios.get("/numberwon/mybox");
      setData(newData.data);
    } catch (error) {
      console.error(error);
    }
  };

  const updateTicket = (orderId) => async () => {
    console.log(orderId);
  };

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

  const branchMap = branches.reduce((map, branch) => {
    map[branch.branch_code] = branch.name;
    return map;
  }, {});

  const departmentMap = departments.reduce((map, department) => {
    map[department.id] = department.name;
    return map;
  }, {});

  return (
    <div className="flex flex-col items-center justify-center p-10 ">
      <h2 className="flex justify-center">번호표 목록</h2>
      {data ? (
        data.map((ticket, index) => (
          <div key={index} className="w-1/3 p-5 mt-5 bg-white rounded-lg ">
            <div>주문 ID: {ticket.orderId}</div>
            <div>사용자 ID: {ticket.userId}</div>
            <div>지점명: {branchMap[ticket.branchCode]}</div>
            <div>부서명: {departmentMap[ticket.departmentId]}</div>
            <div>시간: {ticket.localDateTime}</div>
            <Button onClick={deleteTicket(ticket.orderId)}>삭제</Button>
            <Button onClick={updateTicket(ticket.orderId)} color="yellow">
              갱신
            </Button>
          </div>
        ))
      ) : (
        <div>Loading...</div>
      )}
    </div>
  );
}

export default MyBox;
