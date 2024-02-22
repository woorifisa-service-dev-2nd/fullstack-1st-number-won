import React from "react";

const LayoutContainer = ({ children }) => {
  return (
    <>
      {/* <Header /> */}
      <div className="min-h-screen p-0 m-0 font-bold text-blue-900 bg-blue-100 ">
        {children}
      </div>
    </>
  );
};

export default LayoutContainer;
