# 🎶 Starry — Live Events & Goods Platform

**Starry** is a full-stack web application for discovering and sharing information about **live music events**, **user impressions**, and **anime-related goods**.  
It provides a refined, cute, yet modern UI to browse events, read articles, and showcase fan merchandise.

---

## ✨ Features

- **Live Event Showcase**  
  - Top banner carousel for featured lives.  
  - Hot lives grid with event details, likes, and comments.  
  - Responsive design: desktop (4 cols), tablet (2 cols), mobile (1 col).

- **User Articles**  
  - Browse user impressions and reviews of live events.  
  - Article cards with title, excerpt, and author info.  

- **Goods Display**  
  - Showcase anime-related goods with images and details.  
  - Supports collection/exchange features (planned).  

- **UI/UX**  
  - Modern, clean, and cute aesthetic.  
  - Mobile-first responsive layout.  
  - Smooth animations and hover effects.  

---

## 🛠️ Tech Stack

- **Frontend Framework**: React + TypeScript  
- **UI**: CSS (modular styles), responsive grid/flexbox  
- **Components**:  
  - `Banner` + `BannerCarousel` (Swiper.js)  
  - `LiveCard` + `HotLives`  
  - `NavBar`, `Footer`, `StarryBackground`  
- **Libraries**:  
  - [Swiper.js](https://swiperjs.com/) for carousels  
  - React Hooks for state management  

---

## 📂 Project Structure

project-root/
├─ starry-frontend/ # Frontend (React + TypeScript)
│ ├─ src/
│ │ ├─ components/ # UI components (Banner, LiveCard, HotLives, ...)
│ │ ├─ pages/ # Page-level components (HomePage, ...)
│ │ ├─ styles/ # CSS files
│ │ └─ types/ # Shared TypeScript types
│ ├─ public/ # Static assets
│ └─ package.json
│
├─ starry-backend/ # Backend (Java + Spring Boot)
│ ├─ src/
│ │ ├─ main/java/ # Backend source code
│ │ │ └─ com/starry/ # Packages (controllers, services, entities, repos)
│ │ ├─ main/resources/ # Config (application.yml, schema.sql, ...)
│ │ └─ test/ # Unit & integration tests
│ └─ pom.xml
│
└─ README.md

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your-username/starry-frontend.git
cd starry-frontend
2. Install dependencies
bash
npm install
# or
yarn install
3. Run the development server
bash
npm run dev
# or
yarn dev
Visit http://localhost:5173 in your browser.

📸 Screenshots
Homepage
Header with navigation

Banner carousel with featured events

Hot Lives grid

User Articles and Goods sections

(Screenshots to be added)

📌 Roadmap
 Implement backend integration for lives & articles

 Add user authentication (login/register)

 Add CRUD features for articles

 Add goods marketplace features (exchange, wishlist)

🤝 Contributing
Contributions are welcome!
Please fork the repo, create a feature branch, and submit a pull request.

📜 License
This project is licensed under the MIT License.
