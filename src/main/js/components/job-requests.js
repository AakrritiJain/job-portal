import React from 'react';
import JobList from './job-list';
import '../../resources/css/candidate-card.css';

class JobRequests extends React.Component {
    async updateRequest(jobRequest, jobId, status) {
        await this.props.updateJobRequest({
            'id': jobRequest.id,
            'candidateId': jobRequest.candidateId,
            'jobId': jobId,
            'status': status,
            'email': jobRequest.email,
            'candidateName': jobRequest.candidateName,
            'contact': jobRequest.contact,
            'headline': jobRequest.headline
        }, jobRequest.id);
    }

    goBack() {
        this.props.setSelectedJob(null);
    }

    render() {
        const getJobRequests = this.props.jobRequests.filter((jobRequest) => jobRequest.jobId === this.props.selectedJob.id);
        return (
            <div style={{'marginLeft': '20%'}}>
                <input
                    className='btn btn-primary'
                    type='button'
                    value='Back'
                    onClick={() => this.goBack()}
                />
                <JobList
                    job={this.props.selectedJob}
                    setSelectedJob={this.props.setSelectedJob}
                    shouldShowFooter={false}
                />
                {getJobRequests.map((jobRequest, index) => {
                    return (
                        <div key={index} className={'candidate-card'}>
                            <h5>Candidate Information</h5>
                            <span>Name: {jobRequest.candidateName}</span><br/>
                            <span>Summary: {jobRequest.headline}</span><br/>
                            <span>Email: {jobRequest.email}</span><br/>
                            <span>Contact: {jobRequest.contact}</span><br/>
                            <div className={'footer'}>
                                <input
                                    class='btn btn-success'
                                    type='button'
                                    value='Shortlist'
                                    disabled={jobRequest.status === 'SHORTLISTED'}
                                    onClick={() => this.updateRequest(jobRequest, this.props.selectedJob.id, 'SHORTLISTED')}
                                />
                                <input
                                    class='btn btn-danger'
                                    type='button'
                                    value='Reject'
                                    disabled={jobRequest.status === 'REJECTED'}
                                    onClick={() => this.updateRequest(jobRequest, this.props.selectedJob.id, 'REJECTED',)}
                                />
                            </div>
                        </div>
                    )

                })}
            </div>
        );
    }

}

export default JobRequests;
