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

  return (
    <>
      {data ? (
        data.map((ticket, index) => (
          <div key={index} className="p-5" >
            <div>사용자 ID: {ticket.userId}</div>
            <div>지점 코드: {ticket.branchCode}</div>
            <div>부서 ID: {ticket.departmentId}</div>
            <div>시간: {ticket.localDateTime}</div>
            <div>상태: {ticket.status}</div>
            {/* <Button onClick={deleteTicket}>삭제</Button> */}
          </div>
        ))
      ) : (
        <div>Loading...</div>
      )}
    </>
  );
}

export default MyBox;
