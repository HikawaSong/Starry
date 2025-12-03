export type BannerProps = {
    imgUrl: string
    title: string
    info: string
}


const Banner = ({imgUrl,title,info}:BannerProps) => {
    return (
        <div className="
            relative w-full overflow-hidden rounded-2xl
            h-[180px] sm:h-[220px] md:h-[360px] lg:h-[600px]
            max-w[1200px] mx-auto px-4 md:px-8
        ">
            <img className="w-full h-full object-cover block" src={imgUrl} alt={title}/>
            <p className="text-sm opacity-80">{info}</p>
        </div>
    )

}

export default Banner