export const getActivePage = active => {
    let initState = {
        dashboardPage: false,
        userPage: false
    };

    Object.keys(initState).forEach(key => {
        if (key === active) {
            initState[key] = true;
        }
    });

    return initState;
};
