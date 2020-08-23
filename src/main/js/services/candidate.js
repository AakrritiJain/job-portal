import axios from 'axios';

export const postCandidate = (payload) => {
    return axios.post('/candidates', payload).then((res) => res.data);
};

export const fetchCandidates = () => {
    return axios.get('/candidates').then((res) => res.data);
};
