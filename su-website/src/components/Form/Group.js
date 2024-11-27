import clsx from "clsx";
import {useFormContext} from "react-hook-form";
import useUniqueId from "../../hooks/useUniqueId";
import {checkErrors, renderLabel} from "../../utils/formUtils";

export default function FormGroup({id: origId, label, name, help, helpLink,
                                  readOnly = false, disabled = false, className, style, render}) {

    const id = useUniqueId({id: origId, prefix: `${name}-`});
    const {formState: {errors}} = useFormContext();
    if (readOnly && disabled) {
        return (
            <div className="text-danger">
                error - check console
            </div>
        );
    }

    const {invalid, errorMsg} = checkErrors({disabled, errors, name});

    return (
        <div
            className={clsx('form-group', className, {'is-invalid': invalid, 'text-muted': disabled || readOnly})}
            style={style}
        >
            <label htmlFor={id} className={clsx({'text-danger': invalid})}>{renderLabel(label, helpLink)}</label>
            {render(id, invalid)}
            {help && <small className="form-text text-muted">{help}</small>}
            {errorMsg}
        </div>
    )
}