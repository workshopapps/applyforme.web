import React from "react";
import "./Details.css";
import facebook from "../../../../assets/facebook-2.png";
import twitter from "../../../../assets/twitter-2.png";
import instagram from "../../../../assets/instagram-2.png";

import like from "../../../../assets/like.png";
import dislike from "../../../../assets/dislike.png";
import { Link } from "react-router-dom";

const Details = () => {
	return (
		<div className='details'>
			<div className='content'>
				<div>
					Are you tired of applying for jobs via email and never getting a response?
					What do you think you are doing wrong? In the digital age we are right now,
					it is not uncommon for businesses, establishments, and corporations to
					advertise job openings, schedule interviews online, and allow working
					remotely.
					<br />
					<br />
					You see a job advertised online, i) it fits your profile, ii) the pay is
					good, iii) the location is near you, but you are discouraged that it would
					be like your other applications, with no response till now. Read and smile
					because help has come.
					<br />
					<br />
					Take note of these things before you send your next application. (An
					example is added at the end of the article)
					<br />
					<br />
					<ul className='ml-4'>
						<li className='bold'>Use a compelling subject line</li>
						<p>
							More often than not, it will be stated in the job posting what should be
							the subject of the mail. Try as much as possible to do just that. E.g.
							"Digital Marketing Intern"
						</p>
						<br />
						<li className='bold'>Address the hiring manager by name.</li>
						<p>
							If the name is not stated in the job posting, research and get the hiring
							manager's name.
						</p>
						<br />
						<li className='bold'>Say who you are.</li>
						<p>
							In the first paragraph, tell the hiring manager who you are and why you
							are contacting them. You can include who referred you or where you saw
							the job posting.
						</p>
						<br />
						<li className='bold'>Say what you have to offer</li>
						<p>
							In the second paragraph, say what value you bring to the company. Talk
							about how you can help them optimize resources, save costs, or contribute
							to achieving the organizational vision.
						</p>
						<br />
						<li className='bold'>The close</li>
						<p>
							Close the resume email body with you look forward to meeting in person
						</p>
						<br />
						<li className='bold'>
							Add a professional signature with your contact details.
						</li>
						<p>
							Contact details like phone number, email address, and relevant links like
							GitHub or Behance link.
						</p>
						<br />
						<li className='bold'>
							Attach your resume and a cover letter saved in PDF with professional file
							names.
						</li>
						<p>
							You can have your resume saved on your device with whatever you like but
							for the documents you send, save them with your name and job title.
						</p>
						<br />
						<li className='bold'>Proofread your work.</li>
						<p>
							Check for grammatical errors and incorrect spellings, correct them, and
							also check that you have attached the appropriate documents and the
							correct links.
						</p>
					</ul>
					<br />
					<span className='bold'>N.B:</span> Do ensure you use an official email
					address that carries your first-time name and second name only. , E.g.
					judejames@gmail.com rather than jude1980@gmail.com.
					<br />
					<br />
					<span className='bold'>PS:</span> you can save yourself from the stress of
					applying for a job when you register on ApplyForMe, the application process
					is done for you, and you can wait to kill your interviews.
					<br />
					<br />
					<p className='bold'>Sample Email:</p>
					<br /> Email subject: [Job Title] – [Your Full Name]
					<br />
					Email body: Dear [Hiring Manager’s Name],
					<br />
					<br />
					My name is Jude James, and I came across the digital marketing position you
					have available at [Company name]. [Name], a friend who works with you, sent
					it to me, and I feel I am an excellent fit for the job. With [X] years of
					experience in [areas of expertise and skills] and a proven record of [list
					three key achievements], my goal is to leverage my expertise to help
					[Company Name] succeed in achieving [company vision/team goals].
					<br />
					<br />
					Please find attached a copy of my resume and a cover letter for the [Job
					Reference Number and/or Job Title] position at [Company Name], as
					advertised on [Job Ad Source].
					<br />
					<br />
					Thank you so much for your time and consideration for this position, and I
					look forward to hearing from you soon.
					<br />
					<br />
					Yours sincerely,
					<br />
					[Your Name]
					<br />
					[Your Email and Phone Number]
					<br />
					[Additional links, such as your LinkedIn profile or online portfolio URL]
					<br />
					<br />
					<br />
				</div>

				<div className='review-container'>
					<div className='first'>
						Did you enjoy this post?
						<div>
							<img src={like} alt='like' />
							Yes
						</div>
						<div>
							<img src={dislike} alt='dislike' />
							No
						</div>
					</div>

					<div className='second'>
						Share this article on:
						<div>
							<Link to='/'>
								<img src={facebook} alt='facebook' />
							</Link>
							<Link to='/'>
								<img src={twitter} alt='twitter' />
							</Link>
							<Link to='/'>
								<img src={instagram} alt='instagram' />
							</Link>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default Details;
