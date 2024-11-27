import {uniqueId} from "lodash";
import {useRef} from 'react';

export default function useUniqueId(params) {
    const id = params?.id;
    const prefix = params?.prefix;
    const idRef = useRef(id);
    if (!idRef.current) {
        idRef.current = uniqueId(prefix);
    }
    return idRef.current;
}