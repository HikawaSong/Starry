import { ROUTES } from '../../routes/routes';

export const navItems = [
    { label: 'Live', path: ROUTES.LIVES },
    { label: '谷子', path: ROUTES.GOODS },
    { label: '新闻', path: ROUTES.NEWS },
    { label: '登录', path: ROUTES.SIGN_UP },
    { label: '上传', path: ROUTES.IMPORT }
];

export const NAV_HEIGHT= {
    base: "h-14",
    sm: "sm:h-16",
    lg: "lg:h-20",
    wrapper: "h-14 sm:h-16 lg:h-20"
}