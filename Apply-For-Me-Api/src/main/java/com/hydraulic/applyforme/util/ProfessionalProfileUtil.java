package com.hydraulic.applyforme.util;

import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;

public class ProfessionalProfileUtil {

    public static final EmploymentType getEmploymentType(String employmentType) {

        switch (employmentType.toUpperCase()) {
            case "FULL_TIME":
                return EmploymentType.FULL_TIME;

            case "PART_TIME":
                return EmploymentType.PART_TIME;

            case "CONTRACT":
                return EmploymentType.CONTRACT;

            default:
                return null;
        }
    }

    public static final JobLocationType getJobLocationType(String jobLocationType) {

        switch (jobLocationType.toUpperCase()) {
            case "HYBRID":
                return JobLocationType.HYBRID;

            case "REMOTE":
                return JobLocationType.REMOTE;

            case "ONSITE":
                return JobLocationType.ONSITE;

            default:
                return null;
        }
    }

    public static final JobSeniority getJobSeniority(String jobSeniority) {

        switch (jobSeniority.toUpperCase()) {

            case "SENIOR":
                return JobSeniority.SENIOR;

            case "MID_LEVEL":
                return JobSeniority.MID_LEVEL;

            case "TRAINEE":
                return JobSeniority.TRAINEE;

            case "INTERN":
                return JobSeniority.INTERN;

            case "JUNIOR":
                return JobSeniority.JUNIOR;

            default:
                return null;
        }
    }

}
