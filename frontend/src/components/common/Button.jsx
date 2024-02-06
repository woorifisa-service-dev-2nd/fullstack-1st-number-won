import React from "react";

const Button = ({ onClick, children }) => (
  <button
    onClick={onClick}
    className="px-4 py-2 m-2 text-white bg-blue-500 rounded hover:bg-blue-400"
  >
    {children}
  </button>
);

export default Button;
