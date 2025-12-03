import type { BannerProps } from "../components/Banner";
import BannerCarousel from "../components/BannerCarousel";
import NavBar from "../components/nav/NavBar";
import StarryBackground from "../components/StarryBackgroud";
import LiveCardList from "../components/LiveCardList";
import DisplaySection from "../components/DisplaySection";
import { hotlives } from "../api/auth";
import "./Homepage.css";
import type { LiveCardProps } from "../components/LiveCard";
import { useEffect, useState } from "react";

const Homepage = () =>{
    // 临时数据
     const banners: BannerProps[] = [
        { imgUrl: '/images/banner1.jpg', title: "Roselia-1", info: "Roselia-1" },
        { imgUrl: '/images/banner2.jpg', title: "Roselia-2", info: "Roselia-2" },
        { imgUrl: '/images/banner3.jpg', title: "Roselia-3", info: "Roselia-3" },
    ];
    

    const [hotlives, setHotLives] =useState<LiveCardProps[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect( ()=> {
        (async () => {
            try{
               const res =  await fetch('http://localhost:8080/api/lives/hot');
               if (!res.ok) throw new Error('网络错误');
                const data: LiveCardProps[] = await res.json();
                setHotLives(data);
            }catch(e){
                setError('热门Live加载失败');
            }finally{
                setLoading(false);
            }
        })();
    }, []
    )


    return(
        <div className="homepage">
        
        <div className="hp-navbar">
            <NavBar />
        </div>
        <div className="hp-background">
            <StarryBackground />
        </div>
        <div className="m-1 py-2">
            <BannerCarousel banners={banners} />
        </div>
        <div className="mx-auto px-1 md:px-4">
           <DisplaySection
            title="热门Live"
            actions={<a className="live-section-link" href="/lives/hot">查看全部</a>}
            >
                {loading && <div>加载中...</div>}
                {error && <div className="error">{error}</div>}
                {!loading && !error && <LiveCardList cards={hotlives} />}
            </DisplaySection>
        </div>

        </div>
    )

}

export default Homepage