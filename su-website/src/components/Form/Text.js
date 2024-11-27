import PropTypes from 'prop-types';
import TextInput from './TextInput';
import FormGroup from "./Group";


const propTypes = {
    label: PropTypes.string.isRequired,
    name: PropTypes.string.isRequired,
    value: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    help: PropTypes.string,
    helpLink: PropTypes.string,
    /** Marks input fiels as read-only. Will submit. */
    readOnly: PropTypes.bool,
    /** Disables input field. Will not submit. */
    disabled: PropTypes.bool,
    validation: PropTypes.object,
    required: PropTypes.bool,
    className: PropTypes.string,
    style: PropTypes.object,
};
/**
 * Input element to use with react-hook-form.
 */
export default function FormText({label, name, value, help, helpLink, readOnly = false, disabled = false,
                                     validation, required = false, className, style, ...inputAttribs}) {
    return (
        <FormGroup
            label={label}
            name={name}
            help={help}
            helpLink={helpLink}
            readOnly={readOnly}
            disasble={disabled}
            className={className}
            style={style}
            render={(id) => (
                <TextInput
                    id={id}
                    name={name}
                    defaultValue={value}
                    validation={validation}
                    required={required}
                    readOnly={readOnly}
                    disabled={disabled}
                    {...inputAttribs}
                />
            )}
        />
    );
}