import axios from 'axios';

export const fetchJobRequest = () => {
    return axios.get('/job-requests').then((res) => res.data);
};

export const updateJobRequest = (payload, id) => {
    return axios.put(`/job-requests/${id}`, payload).then((res) => res.data);
};
export const postJobRequest = (payload) => {
    return axios.post('/job-requests', payload).then((res) => res.data);
};
