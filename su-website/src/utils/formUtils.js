import {forEach, get, isArray, map} from "lodash";

export function requiredValidator(value) {
    return value?.length > 0 ? true : 'This field is required.';
}

/**
 * Builds a custom validation object for RHF.
 *
 * @param {object} params
 * @param {object} [params.validation]
 * @param {boolean} [params.required]
 */
export function buildCustomValidation({validation = {}, required = false}) {

    if (required) {
        return {
            validate: {
                required: requiredValidator,
                ...validation,
            },
        };
    }

    if (!validation) {
        return undefined;
    }
    return {
        validate: validation,
    };
}

export function isInvalid({disabled, errors, name}) {
    return getErrors({disabled, errors, name}).length > 0;
}

export function getErrors({disabled, errors, name}) {
    if (disabled) {
        return [];
    }

    const errs = [];
    const names = isArray(name) ? name : [name];
    forEach(names, (n) => {
        if (get(errors, n)) {
            errs.push(get(errors, n));
        }
    })

    return errs;
}

export function checkErrors({disabled, errors, name}) {
    const errs = getErrors({disabled, errors, name});
    if (errs.length === 0) {
        return {invalid: false, errorMsh: null}
    }
    return {
        invalid: errs?.length > 0,
        errorMsg: _renderErrors(errs),
    }
}

function _renderErrors(errs) {
    if (errs?.length === 0) {
        return null;
    }
    return (
        <div className="invalid-feedback">
            <ul className={"list-unstyled"}>
                {map(errs, (err, index) => <li key={index}>{err.message}</li>)}
            </ul>
        </div>
    )
}

export function renderLabel(label, helpLink) {
    if (helpLink) {
        return (
            <>
                {label}{' '}
            </>
        );
    }
    return label;
}