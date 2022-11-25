import React, { useState } from "react";
import styles from "./Applications.module.css";
import ApplicationsListCard from "./components/ApplicationsListCard";
import ApplicationsListHeader from "./components/ApplicationsListHeader";
import Table from "./components/Table";
import TopNav from "./components/topNav/TopNav";
import { applications } from "./applicationsMock";

const Applications = () => {
    const [pageSize, setPageSize] = useState(10);
    const [sortColumn, setSortColumn] = useState({
        path: "location",
        order: "desc"
    });
    const [searchQuery, setSearchQuery] = React.useState("");
    const [sortApplications, setSortApplications] =
        React.useState("Oldest to Newest");

    const handleSort = sortColumn => {
        setSortColumn({ sortColumn });
    };
    let data = applications;
    if (searchQuery) {
        data = data.filter(
            d =>
                d.company.toLowerCase().startsWith(searchQuery.toLowerCase()) ||
                d.location
                    .toLowerCase()
                    .startsWith(searchQuery.toLowerCase()) ||
                d.jobTitle.toLowerCase().startsWith(searchQuery.toLowerCase())
        );
    }

    if (sortApplications === "Oldest to Newest") {
        data = data.sort(function (a, b) {
            return new Date(a.date) - new Date(b.date);
        });
    }
    if (sortApplications === "Newest to Oldest") {
        data = data.sort(function (a, b) {
            return new Date(b.date) - new Date(a.date);
        });
    }

    return (
        <div className={styles.applications_container}>
            <TopNav title={"Applications"} />
            <section className={styles.application_main}>
                <ApplicationsListHeader
                    setSearch={setSearchQuery}
                    searchQuery={searchQuery}
                    sortApplications={sortApplications}
                    setSortApplications={setSortApplications}
                />
                <Table
                    applications={data}
                    sortColumn={sortColumn}
                    handleSort={handleSort}
                    pageSize={pageSize}
                    setPageSize={setPageSize}
                />
                <ApplicationsListCard applications={data} />
            </section>
        </div>
    );
};

export default Applications;
