import Navbar from "./components/Navbar";
import Home from "./components/Home";
import ThemeContextProvider from "./contexts/ThemeContext";
import {BrowserRouter, Route, Routes} from "react-router";
import StudentForm from "./pages/edit/Student/Form";

function App() {
  return (
      <div className="App">
          <BrowserRouter>
          <ThemeContextProvider>
              <Navbar />
              <div className="content">
                  <Routes>
                      <Route path="/" element={<Home />} />
                      <Route path="/createStudent" element={<StudentForm />} />
                  </Routes>
              </div>
          </ThemeContextProvider>
          </BrowserRouter>
      </div>
  );
}

export default App;
