import MenuCSS from "./DropdownMenu.module.css";

const DropdownMenu = () => {
    return (
        <div className={MenuCSS.menu_wrapper}>
            <div className={MenuCSS.menu}>
                <a href="/about">About us</a>
                <a href="/pricing">Pricing plans</a>
                <a href="/blog/:id">Blogs</a>
                <a href="/faqs">FAQs</a>
                <a href="/contact">Contact us</a>
            </div>
            <div className={MenuCSS.signs}>
                <button className={MenuCSS.sign_in}>Sign in</button>
                <button className={MenuCSS.sign_up}>Get Started</button>
            </div>
        </div>
    );
};

export default DropdownMenu;
