import React from 'react';
import '../../resources/css/job-card.css';
import JobList from './job-list';
import CandidateForm from './candidate-form';

class JobComponent extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <React.Fragment>
                {this.props.selectedJob
                    ? <CandidateForm
                        setSelectedJob={this.props.setSelectedJob}
                        postJobRequest={this.props.postJobRequest}
                        selectedJob={this.props.selectedJob}
                        userId={this.props.userId}
                    />
                    : <div>
                        <h5>Job Listing</h5>
                        <div className={'job-card'}>
                            {this.props.jobs.map((job, index) => (
                                <JobList
                                    key={index}
                                    job={job}
                                    setSelectedJob={this.props.setSelectedJob}
                                    shouldShowFooter={true}
                                />)
                            )}
                        </div>
                    </div>
                }
            </React.Fragment>
        );
    }
}

export default JobComponent;
