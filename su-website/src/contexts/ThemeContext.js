import {createContext, useState} from 'react';

export const ThemeContext = createContext(null);

export default function ThemeContextProvider({children}) {
    const [isLightMode, setIsLightMode] = useState(true);

    const darkMode = {syntax: '#eee', ui: '#333', bg: '#ddd'};
    const lightMode = {syntax: '#fff', ui: '#ddd', bg: 'eee'};

    const toggleTheme = () => setIsLightMode(!isLightMode);

    return (
        <ThemeContext.Provider value={{isLightMode, darkMode, lightMode, toggleTheme}}>
            {children}
        </ThemeContext.Provider>
    );
}