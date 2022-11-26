import { useRef, useState } from 'react'
import myApplicationData from '../data'

function MyApplications() {
  const messagesEndRef = useRef(null)

  const scrollToBottom = () => {
    messagesEndRef.current?.scrollIntoView({ behavior: "smooth" })
  }

  const [seeMore, setSeeMore] = useState(false)
  const [dataToShow, setDataToShow] = useState(myApplicationData.slice(0, 5))

  const handleClick = () => {
    if (!seeMore) {
      setSeeMore(true)
      setDataToShow(myApplicationData)
      scrollToBottom()
    } else {
      setSeeMore(false)
      setDataToShow(myApplicationData.slice(0, 5))
      scrollToBottom()
    }
  }

    return (
      <div className='dashboard__container' ref={messagesEndRef}>
        <div className='myapplication'>
          <div className="myapplication-head">
          <p>My Applications</p>
          <p onClick={handleClick}>{!seeMore ? 'See all' : 'See less'}</p>
          </div>
          <div className='applications'>
          {
            dataToShow?.map((item, i) => <div className='application' key={i}>
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

export default MyApplications
