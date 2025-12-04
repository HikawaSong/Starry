import { Swiper, SwiperSlide } from "swiper/react";
import { Pagination, Autoplay } from "swiper/modules";
import "swiper/swiper-bundle.css";

import Banner from "../components/Banner";
import type { BannerProps } from './Banner'

type BannerCarouselProps = {
  banners: BannerProps[]
}


const BannerCarousel =({ banners }: BannerCarouselProps) =>{
    if(!banners || banners.length == 0){
        return null
    }

    return (
         <Swiper 
            className="w-full rounded-lg overflow-hidden"
            modules={[Autoplay, Pagination]}
            autoplay={{delay:4000}}
            pagination={{clickable:true}}
            spaceBetween={20}
            slidesPerView={1}
            loop
            >
                {banners.map((banner, index) =>(
                    <SwiperSlide key={index}>
                        <Banner {...banner} />
                    </SwiperSlide>
                ))}
            </Swiper>
    )
}

export default BannerCarousel