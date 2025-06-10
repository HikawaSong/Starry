
import { API_PATHS } from "../constants/api";
import { httpPost } from "../utils/http";

export const signup = (data: any) =>httpPost(API_PATHS.signup, data);