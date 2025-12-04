import { Link } from "react-router-dom"
import { navItems } from "./navConfig"
import { motion, AnimatePresence } from 'framer-motion';

export function MobileNav({ open, onClose }: { open: boolean, onClose: () => void }) {
    return (
        <AnimatePresence>
            {open && (
                <motion.div
                    initial={{ opacity: 0 }}
                    animate={{ opacity: 1 }}
                    exit={{ opacity: 0 }}
                    transition={{ duration: 0.2 }}
                    className="fixed inset-0 z-40 sm:hidden"
                >
                    {/* 背景蒙层 */}
                    <div
                        className="absolute inset-0 bg-black/90 backdrop-blur-sm"
                        onClick={onClose}
                    />

                    {/* 右侧抽屉菜单内容 */}
                    <motion.div
                        initial={{ x: '100%' }}
                        animate={{ x: 0 }}
                        exit={{ x: '100%' }}
                        transition={{ type: "spring", stiffness: 300, damping: 30 }}
                        className="
                                absolute inset-0 
                                bg-gradient-to-br
                                 from-slate-900/90
                                 backdrop-blur-md
                                 pt-20 
                                items-center      
                                justify-center  
                                 
                            "
                    >

                        <ul className="w-full space-y-6">
                            {renderMobileNavItems(navItems, onClose)}
                        </ul>
                    </motion.div>
                </motion.div>
            )}
        </AnimatePresence>
    )

}

function renderMobileNavItems(
    items: { label: string; path: string }[],
    onItemClick?: () => void
) {
    return items.map((item, index) => (
        <li key={index}>
            <Link
                to={item.path}
                onClick={onItemClick}
                className="
                    block
                    text-sm font-bold
                    tracking-widest
                    text-white
                    hover:text-purple-400 transition-colors
                    py-1.5
                "
            >
                {item.label}
            </Link>

            <span className="block h-[1px] w-full bg-pink-500 mt-1 ml" />
        </li>
    ));
}