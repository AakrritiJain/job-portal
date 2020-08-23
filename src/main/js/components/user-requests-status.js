import React from 'react';
import JobList from './job-list';

class UserRequestsStatus extends React.Component {
    render() {
        return (
            <div>
                <h5>Track Status of Applications</h5>
                {this.props.jobRequests.map((jobRequest) => {
                    const job = this.props.jobs.filter((job) => job.id == jobRequest.jobId)[0];
                    return (<div>
                        <JobList
                            job={job}
                            setSelectedJob={this.props.setSelectedJob}
                            shouldShowFooter={false}
                        />{jobRequest.status == 'APPLIED'
                        ? <button className='btn btn-primary' style={{'marginBottom': '20px', 'width': '400px'}}>Application Status: Applied</button>
                        : jobRequest.status == 'SHORTLISTED'
                            ? <button className='btn btn-success' style={{'marginBottom': '20px', 'width': '400px'}}>Application Status: Shortlisted by
                                Recruiter</button>
                            : <button className='btn btn-danger' style={{'marginBottom': '20px', 'width': '400px'}}>Application Status: Rejected by
                                Recruiter</button>}
                    </div>)
                })}
            </div>
        );
    }
}

export default UserRequestsStatus;
