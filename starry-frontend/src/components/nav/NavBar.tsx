
import { motion } from "motion/react"
import { NAV_HEIGHT } from './navConfig';
import {  useState } from "react";
import { DesktopNav } from './DesktopNav';
import { HamburgerBotton } from './HamburgerBotton';
import { MobileNav } from './MobileNav';

const NavBar = () => { 
    const [open, setOpen] = useState(false);
    return (
        <> 
        <motion.nav 
            initial={{ y: -60, opacity: 0 }} 
            animate={{ y: 0, opacity: 1 }} 
            transition={{ duration: 0.6 }}
            className={`
                fixed inset-x-0 top-0 z-50 
                w-full 
                transition-colors 
                ${open ? 
                    "bg-transparent border-none" 
                    : "bg-white/80 border-b border-black/10"} 
                `} 
        > 
            
        
            <div className={`${NAV_HEIGHT.wrapper} 
                mx-auto flex items-center justify-between 
                max-w-5xl px-4 sm:px-6`}
            > 
            {/* 大屏：横向菜单 */} 
            <DesktopNav /> 
            
            {/* 小屏：汉堡按钮 */} 
            <HamburgerBotton open={open} onClose={() => setOpen(!open)} /> 
        
            </div> 
        </motion.nav> 
        
        {/* 汉堡菜单-手机导航栏*/} 
        <MobileNav open={open} onClose={() => setOpen(false)} />

        {/* 占位元素 */} 
        <div className={`${NAV_HEIGHT.wrapper}`}>
        </div> 
        </>
    )     
}

export default NavBar;