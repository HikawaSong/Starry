import 'swiper/css'
import 'swiper/css/pagination'
import 'swiper/css/autoplay'

import Banner from "../components/Banner";
import { Swiper, SwiperSlide } from 'swiper/react'
import { Autoplay, Pagination } from 'swiper/modules'
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
            className="carousel"
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