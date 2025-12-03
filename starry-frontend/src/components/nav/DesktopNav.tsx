import { Link } from "react-router-dom"
import { navItems } from "./navConfig"

export const DesktopNav = () =>{
    return (
        <div className="hidden sm:flex justify-center flex-auto"> 
            <ul className=" flex items-center gap-5 
                sm:gap-7 md:gap-10 text-base md:text-lg lg:text-3xl 
                font-medium text-slate-800 whitespace-nowrap"> 
                {renderRowNavItems(navItems)} 
            </ul> 
        </div>
    )
}

function renderRowNavItems(items:{label:string, path:string}[]){
    return items.map((item, index) =>(
        <li key={index} className="shrink-0"> 
        <Link to={item.path} 
            className=" inline-flex items-center 
                rounded-2xl px-3 sm:px-4 py-1.5 
                transition hover:text-indigo-600 
                hover:bg-indigo-50 active:scale-95"
        > {item.label} 
        </Link> 
        </li> 
    )) 
}