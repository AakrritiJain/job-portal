import React from 'react';
import PostJobForm from './post-job-form';
import {JobRequestConnector} from '../connectors/job-request-connector';

class AdminDashboard extends React.Component {
    render() {
        return (
            <div>
                {this.props.showPostJobForm
                    ? <PostJobForm
                        postJob={this.props.postJob}
                        toggleShowPostJobForm={this.props.toggleShowPostJobForm}
                    />
                    : <React.Fragment>
                        <button
                            type='button'
                            className='btn btn-primary'
                            onClick={() => this.props.toggleShowPostJobForm(true)}
                        >
                            {'Post Job'}
                        </button>
                        <JobRequestConnector/>
                    </React.Fragment>}
            </div>
        );
    }
}

export default AdminDashboard;
