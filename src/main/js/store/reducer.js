export const SET_JOB = 'setJob';
export const SHOW_POST_JOB_FROM = 'showPostJobForm';
export const SHOW_SINGLE_JOB = 'showSingleJob';
export const SET_USER = 'setUser';
export const SET_JOB_REQUESTS = 'setJobRequests';
export const SET_CANDIDATES = 'setCandidates';

const reduce = {
    [SET_JOB]: (state = {jobs: []}, action) => ({
        ...state,
        jobs: action.jobs
    }),
    [SHOW_POST_JOB_FROM]: (state = {showPostJobForm: false}, action) => ({
        ...state,
        showPostJobForm: action.showPostJobForm
    }),
    [SHOW_SINGLE_JOB]: (state, action) => ({
        ...state,
        selectedJobId: action.selectedJobId
    }),
    [SET_USER]: (state, action) => ({
        ...state,
        userId: action.userId,
        role: action.role
    }),
    [SET_JOB_REQUESTS]: (state, action) => ({
        ...state,
        jobRequests: action.jobRequests
    }),
    [SET_CANDIDATES]: (state, action) => ({
        ...state,
        candidates: action.candidates
    })

};

export const reducer = (state, action) => {
    if (reduce[action.type]) {
        return reduce[action.type](state, action);
    }
    return state;
};
export default reducer;
