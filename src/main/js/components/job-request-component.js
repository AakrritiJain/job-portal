import React from 'react';
import '../../resources/css/job-card.css';
import JobList from './job-list';
import JobRequests from './job-requests';

const getJobRequestCount = (jobRequests, jobId) => {
    return jobRequests.filter((jobRequest) => jobRequest.jobId === jobId).length

};

class JobRequestComponent extends React.Component {
    constructor(props) {
        super(props);
    }

    onClickHandler(id) {
        this.props.setSelectedJob(id)
    }

    render() {
        return (
            <div>
                {this.props.selectedJob
                    ? <JobRequests
                        jobRequests={this.props.jobRequests}
                        selectedJob={this.props.selectedJob}
                        candidates={this.props.candidates}
                        updateJobRequest={this.props.updateJobRequest}
                        setSelectedJob={this.props.setSelectedJob}
                    />
                    : <div className={'job-card'} style={{'marginLeft': '20%'}}>
                        {this.props.jobs.map((job, index) => {
                                return (<React.Fragment>
                                    <JobList
                                        key={index}
                                        job={job}
                                        setSelectedJob={this.props.setSelectedJob}
                                        shouldShowFooter={false}
                                    />
                                    <div>
                                        {getJobRequestCount(this.props.jobRequests, job.id)}{' Applications received.'}
                                    </div>
                                    <input
                                        key={index}
                                        className='btn btn-primary'
                                        type='button'
                                        style={{'marginBottom': '20px'}}
                                        value='View Applications'
                                        onClick={() => this.onClickHandler(job.id)}
                                    />
                                </React.Fragment>)
                            }
                        )}
                    </div>
                }
            </div>
        );
    }
}

export default JobRequestComponent;
