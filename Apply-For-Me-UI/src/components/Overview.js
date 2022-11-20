import React from 'react'
import { useParams } from 'react-router-dom'

function Overview() {
  const params = useParams()
  const data = [
    {
      number: 72,
      text: 'Total Applications'
    },
    {
      number: 11,
      text: 'Completed Interviews'
    },
    {
      number: 4,
      text: 'Active Applications'
    }
  ]
  return (
    <div className='overview'>
      <p className='over'>Overview</p>
      <div className='overview-grid'>
        {
          data?.map((item, i) => <div key={i}>
            <h1>{params?.newuser === 'newuser' ? '0' : item?.number}</h1>
            <p>{item?.text}</p>
            </div>)
        }
      </div>
    </div>
  )
}

export default Overview
