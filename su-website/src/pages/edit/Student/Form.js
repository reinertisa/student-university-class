import {FormProvider, useForm} from "react-hook-form";
import FormText from "../../../components/Form/Text";


export default function StudentForm() {

    const formMethods = useForm({
        defaultValues: {
            name: '',
            studentId: ''
        }
    })

    const {handleSubmit} = formMethods;

    const onSubmit = () => console.log("Data sumitted");

    return (
        <FormProvider {...formMethods}>
            <form onSubmit={handleSubmit(onSubmit)}>
                <FormText name="name" label="name" />
                <FormText name="studentId" label="studentId" />
            </form>
        </FormProvider>
    )

}