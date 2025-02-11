import {FormProvider, useForm} from "react-hook-form";
import FormText from "../../../components/Form/Text";
import {useState} from "react";


export default function StudentForm() {
    const [error, setError] = useState('');

    const formMethods = useForm({
        defaultValues: {
            name: '',
            studentId: ''
        }
    })

    const {handleSubmit} = formMethods;

    const onSubmit = async (values) => {
        try {
            const rez = await fetch('http://localhost:8080/api/v1/students', {
                headers: {
                    'Content-Type': 'application/json',
                },
                method: 'POST',
                body: JSON.stringify(values),
            })
            const json = rez.json();
            console.log(json);
        } catch (err) {
            setError(err);
        }
    };

    return (
        <FormProvider {...formMethods}>
            <form onSubmit={handleSubmit(onSubmit)} className="create-student">
                <FormText name="studentName" label="Name" required={true} />
                <FormText name="studentId" label="Id" required={true} />
                <FormText name="studentEmail" label="email" required={true} />
                <button>Save</button>
                {error && <p>{error}</p>}
            </form>
        </FormProvider>
    )

}