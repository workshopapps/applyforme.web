import React from 'react'
import { Route } from 'react-router-dom'
import Body from '../components/Body'
import NewUser from '../components/NewUser'
import SideNav from '../components/SideNav'

function Dashboard() {
  return (
    <div className='dashboard'>
      <SideNav />
      <Route path='/' exact component={Body} />
      <Route path='/:newuser' component={NewUser} />
    </div>
  )
}

export default Dashboard
