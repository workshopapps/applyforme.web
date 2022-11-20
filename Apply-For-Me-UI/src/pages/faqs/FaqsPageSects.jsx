import React from 'react';
import './faqs.css';


const FaqsPageSects = ({head, context}) => {
  return (
    <div className='faqspage__context'>
      <h4>{head}</h4>
      <p>{context}</p>
    </div>
  )
}

export default FaqsPageSects