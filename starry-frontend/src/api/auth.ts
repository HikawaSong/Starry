
import { data } from "react-router-dom";
import { API_PATHS } from "../constants/api";
import { httpPost } from "../utils/http";

export const signup = (data: any) =>httpPost(API_PATHS.signup, data);
export const hotlives = () => fetch(API_PATHS.hotlive);
export const excelImport = (data:any) =>httpPost(API_PATHS.excelImport, data);