import {fetchJobs} from '../services/jobs';
import {fetchJobRequest} from '../services/job-request';
import {fetchCandidates} from '../services/candidate';
import {actions} from '../store/action-creator';

export const refresh = () => {
    return async (dispatch) => {
        const jobs = await fetchJobs();
        const jobRequests = await fetchJobRequest();
        const candidates = await fetchCandidates();
        dispatch(actions.setJobs(jobs));
        dispatch(actions.setJobRequests(jobRequests));
        dispatch(actions.setCandidates(candidates));
    }
};
