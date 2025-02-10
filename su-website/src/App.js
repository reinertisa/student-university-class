import Navbar from "./components/Navbar";
import Home from "./components/Home";
import ThemeContextProvider from "./contexts/ThemeContext";

function App() {
  return (
      <div className="App">
          <ThemeContextProvider>
              <Navbar />
              <div className="content">
                  <Home />
              </div>
          </ThemeContextProvider>
      </div>
  );
}

export default App;
