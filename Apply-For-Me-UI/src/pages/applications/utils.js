export const renderDate = date => {
    const newDate = new Date(date);
    return `${newDate.getDate()}, ${monnth(
        newDate.getMonth() + 1
    )} ${newDate.getFullYear()} `;
};

const monnth = number => {
    if (number === 1) return "Jan";
    if (number === 2) return "Feb";
    if (number === 3) return "Mar";
    if (number === 4) return "Apr";
    if (number === 5) return "May";
    if (number === 6) return "Jun";
    if (number === 7) return "Jul";
    if (number === 8) return "Aug";
    if (number === 9) return "Sep";
    if (number === 10) return "Oct";
    if (number === 11) return "Nov";
    if (number === 12) return "Dec";
};

export const sortBy = (data, path, order) => {
    console.log("obi");
    return data.sort((a, b) => {
        if (order === "desc") {
            if (typeof a[path] === "string" && typeof b[path] === "string") {
                if (a[path] < b[path]) {
                    return 1;
                } else if (a[path] > b[path]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        } else {
            if (typeof a[path] === "string" && typeof b[path] === "string") {
                if (
                    typeof a[path] === "string" &&
                    typeof b[path] === "string"
                ) {
                    if (a[path] < b[path]) {
                        return -1;
                    } else if (a[path] > b[path]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    });
};
