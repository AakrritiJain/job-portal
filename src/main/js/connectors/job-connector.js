import {connect} from 'react-redux';
import {postJobRequest} from '../services/job-request'
import JobComponent from '../components/job-component';
import {actions} from '../store/action-creator';
import {refresh} from '../util/refresh';

const mapStateToProps = (state) => {
    const selectedJob = state.selectedJobId ? state.jobs.filter((job) => job.id === state.selectedJobId)[0] : null;
    return {
        jobs: state.jobs,
        selectedJob,
        userId: state.userId
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        postJobRequest: (payload) => {
            postJobRequest(payload);
            dispatch(refresh());
        },
        setSelectedJob: (id) => dispatch(actions.setSelectedJob(id))
    }
};

export const JobConnector = connect(mapStateToProps, mapDispatchToProps)(JobComponent);
