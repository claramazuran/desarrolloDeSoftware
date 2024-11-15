import { ChangeEvent, useState } from "react"
export {useForm}
//interfaz generica para useForm
interface FormValues {
    [key:string]: string | number
}
const useForm = <T extends FormValues>(initialValues: T) => {
    const [values, setValues] = useState<T>(initialValues)

    const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value, type } = event.target;

        setValues({
            ...values,
            [name]: type === "number" ? Number(value) : value, // Convertir a número si es necesario
        });
    }

    const resetForm = () => {
        setValues(initialValues)
    }

    return{
        values,
        handleChange,
        resetForm,
    }
}