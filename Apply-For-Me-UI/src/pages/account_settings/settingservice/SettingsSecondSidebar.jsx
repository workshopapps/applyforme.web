export const getActiveLink = active => {
    let initState = {
        profile: false,
        password: false,
        preference: false,
    };

    Object.keys(initState).forEach(key => {
        if (key === active) {
            initState[key] = true;
        }
    });

    return initState;
};
