import React from 'react'
import { Link } from 'react-router-dom';

const FaqsBox = ({ text }) => {
  return (
    <div className='faqsbox'>
      <h3>{text}</h3>
      <p>A reverse recruiting platform, puts your cv and profile ahead of other job applicants, all you have to do is attend your interview </p>
      <h5>4 months ago</h5>
      <Link to="/faqs/faqspage">Learn more</Link>
    </div>
  )
}

export default FaqsBox