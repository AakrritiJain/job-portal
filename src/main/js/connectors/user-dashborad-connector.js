import {connect} from 'react-redux';
import UserDashboard from '../components/user-dashboard';
import {actions} from '../store/action-creator';

const mapStateToProps = (state) => {
    const jobRequests = state.jobRequests.filter((jobRequest) => jobRequest.candidateId == state.userId);
    const jobIds = jobRequests.map((jr) => jr.jobId);
    const jobs = state.jobs.filter((job) => jobIds.includes(job.id));
    return {
        jobs,
        jobRequests
    }
};
const mapDispatchToProps = {
    setSelectedJob: actions.setSelectedJob
};


export const UserDashboardConnector = connect(mapStateToProps, mapDispatchToProps)(UserDashboard);
