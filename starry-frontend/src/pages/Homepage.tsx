import type { BannerProps } from "../components/Banner";
import BannerCarousel from "../components/BannerCarousel";
import NavBar from "../components/NavBar";
import StarryBackground from "../components/StarryBackgroud";

import "./Homepage.css";

const Homepage = () =>{
     const banners: BannerProps[] = [
        { imgUrl: '/public/images/banner1.jpg', title: "Roselia-1", info: "Roselia-1" },
        { imgUrl: '/public/images/banner2.jpg', title: "Roselia-2", info: "Roselia-2" },
        { imgUrl: '/public/images/banner3.jpg', title: "Roselia-3", info: "Roselia-3" },
    ];

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
        
        </div>
    )

}

export default Homepage