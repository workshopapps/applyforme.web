import React from 'react'
import "./Select.css"

const Select = ({children, ...props}) => {
    return (
        <select name="cars" id="cars"
        style={{backgroundColor: props.backgroundColor,
        padding: props.padding
        }}>
            <option value="" disabled selected hidden>Nationality</option>
            <option value="volvo">Volvo</option>
            <option value="saab">Saab</option>
            <option value="opel">Opel</option>
            <option value="audi">Audi</option>
        </select>
        )
}

export default Select