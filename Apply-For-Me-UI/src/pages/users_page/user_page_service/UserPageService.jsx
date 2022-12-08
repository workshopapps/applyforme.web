import client from "../../../../src/service/index";

client.get("v1/super-admin/applicant/entries").then(data => {
    // Users.push(data.data.content)
    console.log(data.data);
});

export const Users = [
    // {
    //     id: 1,
    //     name: "Sharon Sunday",
    //     email: "sharon@gmail.com",
    //     plan: "Basic",
    //     applicationDone: "8 of 15",
    //     interviews: 15
    // },

    // {
    //     id: 2,
    //     name: "Sharon Sunday",
    //     email: "sharon@gmail.com",
    //     plan: "Basic",
    //     applicationDone: "8 of 15",
    //     interviews: 15
    // },
    // {
    //     id: 3,
    //     name: "Sharon Sunday",
    //     email: "sharon@gmail.com",
    //     plan: "Premium",
    //     applicationDone: "8 of 15",
    //     interviews: 15
    // },
    // {
    //     id: 4,
    //     name: "Michael Anu",
    //     email: "michael@gmail.com",
    //     plan: "Standard",
    //     applicationDone: "8 of 15",
    //     interviews: 15
    // },
    // {
    //     id: 5,
    //     name: "Michael Anu",
    //     email: "michael@gmail.com",
    //     plan: "Basic",
    //     applicationDone: "27 of 40",
    //     interviews: 22
    // },
    // {
    //     id: 6,
    //     name: "Michael Anu",
    //     email: "michael@gmail.com",
    //     plan: "Basic",
    //     applicationDone: "4 of 15",
    //     interviews: 2
    // }
];
