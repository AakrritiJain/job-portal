import {connect} from 'react-redux';
import AdminDashboard from '../components/admin-dashboard';
import {postJob} from '../services/jobs'
import {actions} from '../store/action-creator'
import {refresh} from '../util/refresh';

const mapStateToProps = (state) => {
    return {
        showPostJobForm: state.showPostJobForm
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        postJob: (payload) => {
            postJob(payload);
            dispatch(refresh());
        },
        toggleShowPostJobForm: (showPostJob) => dispatch(actions.showPostJobForm(showPostJob))
    }
};

export const AdminDashboardConnector = connect(mapStateToProps, mapDispatchToProps)(AdminDashboard);
