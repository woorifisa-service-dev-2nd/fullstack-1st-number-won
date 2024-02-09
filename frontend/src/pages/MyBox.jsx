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

  return (
    <>
      {data ? (
        data.map((ticket, index) => (
          <div key={index} className="p-5">
            <div>주문 ID: {ticket.orderId}</div>
            <div>사용자 ID: {ticket.userId}</div>
            <div>지점명: {ticket.branchCode}</div>
            <div>부서명: {ticket.departmentId}</div>
            <div>시간: {ticket.localDateTime}</div>
            <Button onClick={deleteTicket(ticket.orderId)}>삭제</Button>
          </div>
        ))
      ) : (
        <div>Loading...</div>
      )}
    </>
  );
}

export default MyBox;
