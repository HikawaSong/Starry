import React from "react";
import './DisplaySection.css'

type SectionProps ={
    title:string;
    description?:string;
    actions?:React.ReactNode;
    children:React.ReactNode
 }

 const DisplaySection:React.FC<SectionProps> = ({title,description,actions,children})=>{
    return(
        <section className="section">
            <header className="section-header">
                 <div className="section-headings">
                    <h2 id="section-title" className="section-title">{title}</h2>
                    {description && <p className="section-desc">{description}</p>}
                 </div>
                  {actions && <div className="section-actions">{actions}</div>}
            </header>

             <div className="section-body">
                {children}
            </div>
        </section>
    )
 }

 export default DisplaySection