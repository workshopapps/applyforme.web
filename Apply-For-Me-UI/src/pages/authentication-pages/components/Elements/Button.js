import React from 'react'
import "./Button.css"

const Button = (props) => {
    return (
        <label>
            <input type="submit" name="submit" value={props.child} className="btn"/>
        </label>
        )
}

export default Button