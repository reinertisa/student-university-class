

export default function Navbar() {
    return (
        <nav className="navbar">
            <h1>Student - Class Management</h1>
            <div className="links">
                <a href="/">Home</a>
                <a href="/createStudent">New Student</a>
                <a href="/createClass">New Class</a>
            </div>
        </nav>
    )
}