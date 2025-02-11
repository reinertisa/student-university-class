
export default function StudentList({students, title, onDelete}) {

    return (
        <div className="student-list">
            {students.map(student => (
                <div className="student-preview" key={student.id}>
                    <h2>{student.studentId}</h2>
                    <p>Written by {student.studentName}</p>
                    <button onClick={onDelete}>Delete student</button>
                </div>
            ))}
        </div>
    )
}