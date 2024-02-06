import React from 'react'

const LayoutContainer = ({ children }) => {
    return (
      <>
        {/* <Header /> */}
        <div className='flex items-center justify-center min-h-screen m-0 p-0 font-bold bg-blue-100 text-blue-900'>
        {children}
        </div>
  
      </>
    );
  };
  
  export default LayoutContainer;