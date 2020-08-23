import axios from 'axios';

export const fetchJobs = () => {
    return axios.get('/jobs').then((res) => res.data);
};
export const postJob = (payload) => {
    return axios.post('/jobs', payload).then((res) => res.data);
};
