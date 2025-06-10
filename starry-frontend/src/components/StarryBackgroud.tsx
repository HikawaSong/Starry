
import { loadSlim } from "@tsparticles/slim";
import { useEffect, useState } from "react";
import Particles, { initParticlesEngine } from "@tsparticles/react";

const StarryBackground = () => {

  const [ init, setInit ] = useState(false);

  useEffect(() => {
    initParticlesEngine(async(engine)=>{
      await loadSlim(engine);
    }).then(() => {
              setInit(true);
          });
      }, []);

    const particlesOption = {
        fullScreen: {
          enable: true,
          zIndex: -1,
        },
        background: {
          color: {
            value: ["#000000"]
          }
        },
        particles: {
          number: {
            value: 200,
            density: {
              enable: true,
              area: 50,
            },
          },
          color: {
            value: ["#000000", "#ffffff"], // 可以指定多个颜色
            animation: {
              enable: true,   // 启用颜色变化动画
              speed: 10,      // 动画速度
              sync: true      // 是否同步变化
            }
          },
          shape: { type: "star" },
          opacity: {
            value: { min: 0, max: 0.9 }, // 增加变化范围
            animation: {
              enable: true,
              speed: 0.5, 
              minimumValue: 0.2,
              sync: false
            }
          },
          size: {
            value: {
              min:4,
              max:11
            },
            random: true,
          },
          move: {
            enable: true,
            speed: 0.2,
            direction: "none" as const,
            random: true,
            straight: false,
  
          },

        },
      };

    return(
        <Particles
           id="starfield"
           options= {particlesOption}
           />
    )
}

export default StarryBackground;

