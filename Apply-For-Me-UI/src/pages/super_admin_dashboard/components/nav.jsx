import classes from "./nav.css";

export const NavBar =()=>{
    return(
        <div className="nav_bg">
            <div>
                <img src="https://res.cloudinary.com/hamskid/image/upload/v1670374365/Frame_qmqtm3.svg" alt="object not found" className="nav_logo"/>
            </div>
            <form>
                <input type="text" placeHolder="Search For Users and recruiters"/>
                <button>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670374366/Frame_51202_dbdtxv.svg" alt="object not found"/>
                </button>
            </form>
            <div>
                <div  className="nav_notification">
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670374550/Vector_cy9dgq.svg" alt="object not found"/>
                </div>
                <div  className="nav_profile">
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670374366/Frame_51202_dbdtxv.svg" alt="object not found"/>
                </div>
            </div>

        </div>
    )
}