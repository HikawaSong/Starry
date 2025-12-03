import type { LiveCardProps } from "./LiveCard"
import LiveCard from "./LiveCard"

import './LiveCardList.css'


type LiveCards={
    cards:LiveCardProps[]
}

const LiveCardList = ({cards}:LiveCards) =>{
    return (
        <div className="live-card-list">
        {cards.map((card) => (
            <LiveCard key={card.id} {...card} />
        ))}
        </div>
  );
}

export default LiveCardList