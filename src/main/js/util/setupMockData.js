import {candidates, jobs, jobRequests} from './mockData';
import {postCandidate} from '../services/candidate';
import {postJob} from '../services/jobs';
import {postJobRequest} from '../services/job-request';

export const setupMockData = () => {
    candidates.forEach(candidate => postCandidate(candidate));
    jobs.forEach(job => postJob(job));
    jobRequests.forEach(jobRequest => postJobRequest(jobRequest));
};
