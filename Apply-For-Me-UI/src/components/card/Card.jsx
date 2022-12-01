import React from 'react'
import { Link } from 'react-router-dom'
import classes from './Card.module.css'
const Card = (props) => {
  return (
    <>
        <article>
            <h3 className={classes.article_header}>
               {props.header}
            </h3>
            <p className={classes.article_para}>
                {props.para}
            </p>
            <Link to= {`${props.link}`} className={classes.article_link}> 
                Learn more 
            </Link>
        </article>
    </>
  )
}

export default Card