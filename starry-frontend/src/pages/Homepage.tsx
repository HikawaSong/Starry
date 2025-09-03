import type { BannerProps } from "../components/Banner";
import BannerCarousel from "../components/BannerCarousel";
import NavBar from "../components/NavBar";
import StarryBackground from "../components/StarryBackgroud";
import LiveCardList from "../components/LiveCardList";
import DisplaySection from "../components/DisplaySection";

import "./Homepage.css";
import type { LiveCardProps } from "../components/LiveCard";

const Homepage = () =>{
    // 临时数据
     const banners: BannerProps[] = [
        { imgUrl: '/public/images/banner1.jpg', title: "Roselia-1", info: "Roselia-1" },
        { imgUrl: '/public/images/banner2.jpg', title: "Roselia-2", info: "Roselia-2" },
        { imgUrl: '/public/images/banner3.jpg', title: "Roselia-3", info: "Roselia-3" },
    ];
    
    const cards: LiveCardProps[] = [
        { id:'0001', title: 'Rosenlied', place: "東京", venue:'shibuya duo MUSIC EXCHANGE', url: "/public/images/Rosenlied_1.jpg",link:'/' },
        { id:'0002', title: 'Poppin\'Canvas 〜芸術の秋、音楽の秋！〜', place: "山梨県", venue:'河口湖ステラシアター', url: "/public/images/Poppin'Canvas 〜芸術の秋、音楽の秋！〜_1.jpg",link:'/' },
        { id:'0003', title: 'Stille Nacht, Rosen Nacht', place: "東京都", venue:'武蔵野の森総合スポーツプラザ', url: "/public/images/Stille Nacht, Rosen Nacht_1.png",link:'/' },
        { id:'0004', title: '星空の夜想曲', place: "東京都", venue:'有明アリーナ', url: "/public/images/Roselia_11th.jpg",link:'/' },

    ]


    return(
        <div className="homepage">
        
        <div className="hp-navbar">
            <NavBar />
        </div>
        <div className="hp-background">
            <StarryBackground />
        </div>
        <div className="banner-section">
            <BannerCarousel banners={banners} />
        </div>
        <div className="live-card-list-section">
           <DisplaySection
            title="热门Live"

            actions={<a className="live-section-link" href="/lives/hot">查看全部</a>}
            >
                <LiveCardList cards={cards} />
            </DisplaySection>
        </div>

        </div>
    )

}

export default Homepage