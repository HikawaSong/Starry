import './NavBar.css';
import { motion } from "motion/react"
import { Link } from "react-router-dom";
import { ROUTES } from '../routes/routes';

const navItems = [
    {label:'Live', path:ROUTES.LIVES},
    {label:'谷子', path:ROUTES.GOODS},
    {label:'新闻', path:ROUTES.NEWS},
    {label:'登录', path:ROUTES.SIGN_UP}
];

const NavBar = () =>{
    return (
        <motion.nav
            initial = {{ y: -60, opacity: 0 }}
            animate = {{ y: 0, opacity: 1 }}
            transition={{duration:0.6}}
            className="navbar"
        >
        <div className="navbar-container">
            <ul className="navbar-list">
                {renderNavItems(navItems)}
            </ul>
        </div>
        </motion.nav>
    )
}

function renderNavItems(items:{label:string, path:string}[]){
    return items.map((item, index) =>(
        <li
            key={index} className="navbar-item">
            <Link to={item.path}>
                {item.label}
            </Link>
        </li>
    ))
}
export default NavBar;