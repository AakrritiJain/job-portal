import {connect} from 'react-redux';
import {updateJobRequest} from '../services/job-request'
import {actions} from '../store/action-creator';
import JobRequestComponent from '../components/job-request-component';
import {refresh} from "../util/refresh";

const mapStateToProps = (state) => {
    const selectedJob = state.selectedJobId ? state.jobs.filter((job) => job.id === state.selectedJobId)[0] : null;

    return {
        jobs: state.jobs,
        jobRequests: state.jobRequests,
        selectedJob,
        candidates: state.candidates
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        updateJobRequest: (payload, id) => {
            updateJobRequest(payload, id);
            dispatch(refresh());
        },
        setSelectedJob: (id) => dispatch(actions.setSelectedJob(id))
    }
};

export const JobRequestConnector = connect(mapStateToProps, mapDispatchToProps)(JobRequestComponent);
