export const getActiveLink = active => {
    let initState = {
        dashboard: false,
        profile: false,
        application: false,
        users: false,
        messages: false,
        help: false
    };

    Object.keys(initState).forEach(key => {
        if (key === active) {
            initState[key] = true;
        }
    });

    return initState;
};
