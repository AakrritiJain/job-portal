import React from 'react';
import {JobConnector} from '../connectors/job-connector';
import UserRequestsStatus from './user-requests-status';

class UserDashboard extends React.Component {
    render() {
        return (
            <div style={{'display':'flex'}}>
                <UserRequestsStatus
                    jobRequests={this.props.jobRequests}
                    jobs={this.props.jobs}
                    setSelectedJob={this.props.setSelectedJob}
                />
                <JobConnector/>
            </div>
        );
    }
}

export default UserDashboard;
