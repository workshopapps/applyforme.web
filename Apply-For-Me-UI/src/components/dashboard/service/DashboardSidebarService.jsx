export const getActiveLink = active => {
    let initState = {
        dashboard: false,
        user: false
    };

    Object.keys(initState).forEach(key => {
        if (key === active) {
            initState[key] = true;
        }
    });

    return initState;
};
