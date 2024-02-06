import React, { useState, useEffect } from "react";
import axios from "axios";
import Button from "../components/common/Button";

function MyBox() {
  const [data, setData] = useState(null); 
  console.log(data);
  useEffect(() => {
    axios
      .get("/numberwon/mybox")
      .then((response) => setData(response.data))
      .catch((error) => console.log(error));
  }, []);


  const deleteTicket = (orderId) => async () => {
    try {
      const response = await axios.delete(
        `/numberwon/mybox/${orderId}`
      );
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
          <div key={index} className="p-5" >
            <div>주문 ID: {ticket.orderId}</div>
            <div>사용자 ID: {ticket.userId}</div>
            <div>지점 코드: {ticket.branchCode}</div>
            <div>부서 ID: {ticket.departmentId}</div>
            <div>시간: {ticket.localDateTime}</div>
            <div>상태: {ticket.status}</div>
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
