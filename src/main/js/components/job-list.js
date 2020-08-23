import React from 'react';
import {ExperienceIcon, LocationIcon} from '../util/constants'
import '../../resources/css/job-card.css';

class JobList extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={'job-content'}>
                <div className={'headline'}>{this.props.job?.headline}</div>
                <div className={'location'}>
                    <LocationIcon/>
                    <span>{this.props.job?.location}</span>
                </div>
                <div className={'required-experience'}>
                    <ExperienceIcon/>
                    <span>{this.props.job?.requiredExperience}</span>
                </div>
                <p>Required Skills: {this.props.job?.requiredSkills}</p>
                {this.props.shouldShowFooter ?
                    <div className={'footer'}>
                        <input
                            className='btn btn-primary'
                            type='button'
                            value='Apply'
                            onClick={() => this.props.setSelectedJob(this.props.job.id)}
                        />
                    </div>
                    : null}
            </div>
        );
    }
}

export default JobList;
