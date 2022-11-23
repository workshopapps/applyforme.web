import React from 'react';
import Footer from "../../components/footer/Footer";
import Nav from '../../components/nav/Nav';
import './faqs.css';
import FaqsPageSects from './FaqsPageSects';
import { Link } from 'react-router-dom';

const FaqsPage = () => {
  let content = '100% Professional reverse recruiter, we pride ourselves on our success rate in the industry,  we make your job search easy and all you have to do is attend your interview';
  let head_1 = '1. Manage your profile and help you apply for jobs';
  let head_2 = '2. We help With your cover letter and cv';
  return (
    <div  className="faqses">
      <Nav />
      <div className='faqspage'>
        <div className='faqspage__hero'>
        <Link to="/faqs">&#8592; Go back to the questions </Link>
          <h2> What is afm?</h2>
          <p>Find below all you need to know about afm</p>
        </div>
        <div className='faqspage__section'>
          <FaqsPageSects head={head_1} context={content} />
          <FaqsPageSects head={head_2} context={content} />
        </div>
      </div>
      <Footer />
    </div>
  )
}

export default FaqsPage