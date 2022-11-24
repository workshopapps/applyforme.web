import React from 'react';
import "./Text.css"

const Text = (props) => {
  return <h1 className='text'>{props.child}</h1>
  
}

export default Text;