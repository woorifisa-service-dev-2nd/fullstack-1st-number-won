import React from "react";

const Button = ({ onClick, children, color }) => {
  const backgroundColor = color ? `bg-${color}-500` : "bg-blue-500";
  return (
    <button
      onClick={onClick}
      className={`${backgroundColor} px-4 py-2 m-2 text-white rounded`}
    >
      {children}
    </button>
  );
};

export default Button;
