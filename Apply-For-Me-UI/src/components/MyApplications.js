import React from 'react'
import { useParams } from 'react-router-dom'
import myApplicationData from '../data'

function MyApplications() {
  const data = myApplicationData
  const params = useParams()
  if (params?.newuser === 'newuser') {
    return (
      <div className='newuser'>
        <p>Nothing to see here <button>Create a job profile <img src="./images/plus-icon.svg" alt="" /></button> to get started </p>
      </div>
    )
  } else {
    return (
      <div className='container'>
        <div className='myapplication'>
          <div className="myapplication-head">
          <p>My Applications</p>
          <p>See all</p>
          </div>
          <div className='applications'>
          {
            data?.map((item, i) => <div className={item?.id > 5 ? 'hide application' : 'application'} key={i}>
              <div className='application-title'>
                <div className="img-div"><img src={item?.image} alt="" /></div>
                <div>
                  <h1>{item?.title}</h1>
                  <p>{item?.description}</p>
                </div>
              </div>
  
                <p>{item?.type}</p>
  
                <p>{item?.time}</p>
            </div>)
          }
          </div>
        </div>
      </div>
    )
  }
}

export default MyApplications
