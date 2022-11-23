import style from "./deleteuser.module.css";

const DeleteUser = () => {
    return (
        <div className={style.container}>
            <h2 className={style.heading}>Delete User</h2>
            <p className={style.text_content}>
                Are you sure you want to delete your account.
            </p>
            <p className={style.text_content2}>You can't undo this action</p>

            <div className={style.wrapper}>
                <button type="button" className={style.cancel}>
                    Cancel
                </button>
                <button type="button" className={style.delete}>
                    Delete
                </button>
            </div>
        </div>
    );
};

export default DeleteUser;
