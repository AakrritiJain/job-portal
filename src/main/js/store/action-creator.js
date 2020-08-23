import {SET_CANDIDATES, SET_JOB, SET_JOB_REQUESTS, SET_USER, SHOW_POST_JOB_FROM, SHOW_SINGLE_JOB} from './reducer';

const setJobs = (jobs) => ({
    type: SET_JOB,
    jobs
});
const showPostJobForm = (showPostJobForm) => ({
    type: SHOW_POST_JOB_FROM,
    showPostJobForm
});
const setSelectedJob = (selectedJobId) => ({
    type: SHOW_SINGLE_JOB,
    selectedJobId
});
const setUser = (userId, role) => ({
    type: SET_USER,
    userId,
    role
});
const setJobRequests = (jobRequests) => ({
    type: SET_JOB_REQUESTS,
    jobRequests
});
const setCandidates = (candidates) => ({
    type: SET_CANDIDATES,
    candidates
});


export const actions = {
    setJobs,
    showPostJobForm,
    setSelectedJob,
    setUser,
    setJobRequests,
    setCandidates
};
