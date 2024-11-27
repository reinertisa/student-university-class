import PropTypes from 'prop-types';
import clsx from 'clsx';
import {useFormContext} from 'react-hook-form';
import {useMemo} from 'react';
import {buildCustomValidation, isInvalid} from "../../utils/formUtils";

const propTypes = {
    name: PropTypes.string.isRequired,
    defaultValue: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    validation: PropTypes.object,
    required: PropTypes.bool,
    /**Marks input field as read-only. Will submit. */
    readOnly: PropTypes.bool,
    disabled: PropTypes.bool,
    className: PropTypes.string,
}

/**
 * Renders a text input.
 */
export default function TextInput({name, defaultValue, validation, required, readOnly, disabled, className, ...inputAttribs}) {
    const {register, formState: {errors}} = useFormContext();
    const customValidation = useMemo(() => buildCustomValidation({validation, required}),
        [validation, required]);
    const invalid = isInvalid({disabled, errors, name});
    return (
        <input
            type="text"
            className={clsx('form-control', className, {'is-invalid': invalid})}
            {...register(name, {disabled, ...customValidation})}
            defaultValue={defaultValue}
            readOnly={readOnly}
            {...inputAttribs}
        />
    );
}
TextInput.propTypes = propTypes;