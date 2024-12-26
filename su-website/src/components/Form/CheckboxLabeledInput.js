import useUniqueId from "../../hooks/useUniqueId";
import {useFormContext} from "react-hook-form";
import {isInvalid} from "../../utils/formUtils";
import clsx from "clsx";
import PropTypes from "prop-types";

export const propTypes = {
    label: PropTypes.node.isRequired,
    name: PropTypes.string.isRequired,
    value: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    defaulChecked: PropTypes.bool,
    /** Disables input field. Will not submit */
    disabled: PropTypes.bool,
    className: PropTypes.string,
    inline: PropTypes.bool,
    onChange: PropTypes.func,
}
/**
 * Renders a checkbox input.
 *
 * Cannot support readOnly at this level!
 * Read-only for checkboxes in RHF must be set at fieldset level.
 */
export default function CheckboxLabeledInput({
    label, name, value, defaultChecked, validation, disabled, className, inline,
    onChange, ...inputAttribs
                                             }) {

    const labelId = useUniqueId();
    const {register, formState: {errors}} = useFormContext();

    const rhfProps = register(name, {disabled, ...validation});

    if (onChange) {
        if (disabled) {
            rhfProps.onChange = onChange;
        } else {
            const origOnChange = rhfProps.onChange;
            rhfProps.onChange = (event) => {
                origOnChange(event);
                onChange(event);
            }
        }
    }

    const invalid = isInvalid({disabled, errors, name});

    return (
        <div className={clsx('form-check', className, {'form-check-inline': inline, 'text-danger': invalid})}>
            <input
                id={labelId}
                type="checkbox"
                value={value}
                className="form-check-input"
                {...rhfProps}
                disabled={disabled}
                defaultChecked={defaultChecked}
                {...inputAttribs}
                />
            {' '}
            <label htmlFor={labelId} className="form-check-label">{label}</label>
        </div>
    );
}
CheckboxLabeledInput.prototypes = propTypes;