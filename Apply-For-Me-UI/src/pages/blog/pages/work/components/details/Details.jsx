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
					There is this famous saying that says “Work Smarter, not Harder”.
					<br />
					You could work hard and be busy here and there but still be unproductive.
					What you want to do is work smart, spend a little time and achieve great
					results.
					<br />
					<br />
					How do you work smart and be productive in this era of social media
					interactions, virtual meetings, and email notifications and why should you
					work smart?
					<br />
					<br />
					<ul className='ml-4'>
						<li>
							You get time to rest, and taking breaks and naps strengthens memory and
							increases creativity.
						</li>
						<li>
							Working here and there can make you burn out, lose energy and be
							disinterested. You reduce burnout when you work smart.
						</li>
						<li>
							You get better motivation to work. You enjoy it when you spend less time
							and have massive results. It makes you more willing to work.
						</li>
						<li>
							Effective time management. You can have time for other things, hang out
							with friends, spend time with family, and meet up with deadlines.
						</li>
					</ul>
					<br />
					<p className='bold'>
						Then, how do you work smarter and get your shit done?
					</p>
					<br />
					Take note of what distracts you and push them aside. Sit down and write
					what you do that makes you unproductive, take note of what you do that does
					not contribute to any sound output, and stay away from it deliberately.
					<br />
					<br />
					<ul className='ml-4'>
						<li>
							Have a working time. During this time, block out interactions, stay away
							from your phone, do not check your emails, concentrate and achieve your
							aim.
						</li>
						<li>
							Arrange your tasks in order of importance, take your essential goals one
							by one and achieve them.
						</li>
						<li>
							Use an accountability technique. Set metrics for yourself to measure your
							performance over time. Review your progress regularly (weekly or monthly,
							as you decide).
						</li>
						<li>
							Keep a to-do list but make it manageable; write down essential tasks you
							can complete and tick them off as you are done. Do not overload the day
							with plenty and unnecessary tasks that do not add to your productivity.
						</li>
						<li>
							{" "}
							Learn to say no. There are times you should put yourself first; you have
							a tight schedule, a deadline to meet, work to do, but if someone reaches
							out to you for help, you should be able to say no or at least tell the
							person you are busy right now and would be available later. Do not push
							yourself aside to support another person.
						</li>
					</ul>
					<br />
					Implementing these practical steps will take time but start one day,
					continue for seven days, fourteen days, and before you know it, you will
					see a change as you become more focused and productive. <br />
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
