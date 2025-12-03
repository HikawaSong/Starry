import './LiveCard.css'

export type LiveCardProps = {
    id:string;
    title:string;
    place:string;
    venue:string;
    url:string;
    link:string;
}



const LiveCard = ({ id, title, place, venue, url,link}: LiveCardProps) => {
    return (
        <a href={link} className="live-card">
            <img src={url} alt={title} className="live-card-img"/>
            <div className="live-card-text">
                <h3>{title}</h3>
                <p>{place}/{venue}</p>
            </div>
        </a>

    )
}

export default LiveCard