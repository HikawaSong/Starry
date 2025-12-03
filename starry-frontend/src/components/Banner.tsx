import './Banner.css'

export type BannerProps = {
    imgUrl: string
    title: string
    info: string
}


const Banner = ({imgUrl,title,info}:BannerProps) => {
    return (
        <div className="banner-block">
            <img className="banner-image" src={imgUrl} alt={title}/>
            <h1 className="banner-title">{title}</h1>
            <p className="banner-info">{info}</p>
        </div>
    )

}

export default Banner