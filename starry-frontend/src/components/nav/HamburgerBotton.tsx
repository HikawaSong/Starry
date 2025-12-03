import { Bars3Icon, XMarkIcon } from "@heroicons/react/24/outline";

export function HamburgerBotton({open,onClose}:{open:boolean,onClose:()=>void}){
    return (
         <button
            className="sm:hidden p-2 "
            onClick={onClose}
          >
            {open ? (
              <XMarkIcon className="h-7 w-7 text-purple-500" />
            ) : (
              <Bars3Icon className="h-7 w-7 text-purple-500" />
            )}
          </button>
    )
}