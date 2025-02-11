import {useState, useEffect} from 'react';
import StudentList from "./List";


export default function StudentPage() {
    const [data, setData] = useState([]);
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        let mount = true;
        const loadData = async () => {
            try {
                const rez = await fetch('http://localhost:8080/api/v1/students')
                if (!rez.ok) {
                    throw Error('Failed to fetch student data');
                }
                if (mount) {
                    const json = await rez.json();
                    setData(json);
                }
            } catch (err) {
                if (mount) {
                    setError(err.message);
                }
            }
        }

        setTimeout(loadData, 2000);
        return () => {
            mount = false;
        }
    }, []);

    const handleDelete = () => console.log('student deleted');

    let body = loading ? <div>Loading...</div> : null;
    if (data?.length > 0) {
        body = (
            <StudentList students={data} title="All student list" onDelete={handleDelete} />
        );
    } else if (error) {
        body = <p>{error}</p>
    }

    return body;
}