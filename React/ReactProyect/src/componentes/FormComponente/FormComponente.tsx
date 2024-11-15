import { useForm } from "../../hooks/useForm";

export const FormComponente = () => {
    const {values, handleChange, resetForm} = useForm ({
        email:"",
        nombre:"",
        edad: 0
    })
    const {email, nombre, edad} = values

    const handleSubmitForm = () =>{
        console.log(values)
    }
    const handleResetForm = () =>{
        resetForm();
    }
    return (
        <div>
            <div>
                <h2>Formulario</h2>
            </div>

            <div style={{display: "flex", flexDirection: "column", gap: "2vh"}}>
                <input name="email" value={email} onChange={handleChange} type="email" placeholder="email"/>
                <input name="nombre" value={nombre} onChange={handleChange} type="text" placeholder="Nombre"/>
                <input name="edad" value={edad} onChange={handleChange} type="number" placeholder="Edad"/>
            </div>
            <div>
                <button onClick={handleSubmitForm}>Enviar</button>
                <button onClick={handleResetForm}>Borrar todo</button>
            </div>
        </div>
    )
}
