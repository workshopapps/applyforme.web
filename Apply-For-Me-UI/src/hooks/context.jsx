import { createContext, useContext, useState } from "react";

const AppContext = createContext();

const AppProvider =({children}) => {
    const [userRole, setUserRole] = useState('admin');
    return (
        <AppContext.Provider value={{userRole, setUserRole}}>
            {children}
        </AppContext.Provider>
    );
}

const useGlobalContext = () => {
    return useContext(AppContext);
}

export {
    AppProvider,
    AppContext,
    useGlobalContext
}