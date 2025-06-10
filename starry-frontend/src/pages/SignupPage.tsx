import './SignupPage.css'
import { type FormData,signupSchema } from "../validations/SignupValidation";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { signup } from "../api/auth";
import toast from "react-hot-toast";
import { useNavigate } from 'react-router-dom';

const SignupPage = () => {
    const {
        register,
        handleSubmit,
        formState: { errors , isSubmitting},
    } = useForm<FormData>({
        resolver: yupResolver(signupSchema), 
    });

    const onsubmit= async(data:FormData) =>{
        try{
            await signup(data)
            toast.success("注册成功！")
        }catch(error:any){
            toast.error(error.message || "注册失败！")
        };
        
    }

    const navigate = useNavigate();

    return (
        <div className='signup-page'>
        <form onSubmit={handleSubmit(onsubmit)} className='signup-form'>
            <div className='signup-component'>
                <label>账号名:</label>
                <input {...register('name')} />
                {errors.name && <p>{errors.name.message}</p>}
            </div>

            <div className='signup-component'>
                <label>邮箱:</label>
                <input {...register('email')} />
                {errors.email && <p>{errors.email.message}</p>}
            </div>

             <div className='signup-component'>
                <label>密码：</label>
                <input type="password" {...register('password')} />
                {errors.password && <p>{errors.password.message}</p>}
            </div>

            <div className='signup-component'>
                <label>性别:</label>
                <select {...register('gender')}>
                    <option value="">秘密</option>
                    <option value="male">男</option>
                    <option value="female">女</option>
                </select>
                {errors.gender && <p>{errors.gender.message}</p>}
            </div>

            <div className='signup-component'>
                <label>生日:</label>
                <input type="date" 
                {...register('birthday', {setValueAs: v => v? new Date(v):null})} />
            </div>

            <div className='form-buttons'>
                <button type='submit' disabled={isSubmitting} className='form-confirm-button'>
                    {isSubmitting?"提交中...":"注册"}
                </button>

                <button type = 'button' onClick={()=>navigate(-1)} 
                    className='form-return-button'>
                    返回
                </button>
            </div>
           
        </form>
        </div>
    )
}

export default SignupPage