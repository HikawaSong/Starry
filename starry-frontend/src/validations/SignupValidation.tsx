import * as yup from 'yup'

export type FormData = {
    name: string;
    email: string;
    password: string;
    gender: 'malemal' | 'female' | null ;
    birthday: Date | null ;
}

export const signupSchema = yup.object({
    name: yup.string().required('请填写账号名').min(2,'账号名称不能小于2位').max(10,'账号名称不能大于10位'),
    password: yup.string().required('请填写密码').min(6,'密码不能小于6位').max(20,'密码啊不能大于20位'),
    email: yup.string().required('请填写邮箱').email('请输入正确的邮箱格式'),
    gender: yup.string().transform((v) => v==""? null: v).oneOf(['male','female']).nullable().default(null),
    birthday: yup.date().nullable().default(null)
})